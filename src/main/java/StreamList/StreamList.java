package StreamList;

public class StreamList {
    Element firstElement;
    Element lastElement;
    int size;

    public void insertTelephoneNumber(Element insertable){
        Element tmp = firstElement.nextTelephoneNumber;
        if (tmp.telephoneNumber.getNumber() > insertable.telephoneNumber.getNumber()) {
            insertable.nextTelephoneNumber = tmp;
            insertable.previousTelephoneNumber = firstElement;
            tmp.previousTelephoneNumber = insertable;
            firstElement.nextTelephoneNumber = insertable;
        }
        while (tmp.nextTelephoneNumber != lastElement) {
            if (tmp.telephoneNumber.getNumber() > insertable.telephoneNumber.getNumber()){
                insertable.previousTelephoneNumber = tmp.previousTelephoneNumber;
                insertable.nextTelephoneNumber = tmp;
                tmp.previousTelephoneNumber.nextTelephoneNumber = insertable;
                tmp.nextTelephoneNumber.previousTelephoneNumber = insertable;
            }
            else {
                tmp = tmp.nextTelephoneNumber;
            }
        }
        if (tmp.telephoneNumber.getNumber() > insertable.telephoneNumber.getNumber()){
            insertable.previousTelephoneNumber = tmp.previousTelephoneNumber;
            insertable.nextTelephoneNumber = tmp;
            tmp.previousTelephoneNumber.nextTelephoneNumber = insertable;
            tmp.nextTelephoneNumber.previousTelephoneNumber = insertable;
        }
        tmp.nextTelephoneNumber = insertable;
        insertable.nextTelephoneNumber = lastElement;
        insertable.previousTelephoneNumber = tmp;
        lastElement = insertable;
    }

    public void insertSecondName(Element insertable){
        Element tmp = firstElement.nextSecondName;
        if (StringComparator.firstOfTwoStringsIsHigherInAlphabeticalOrder(tmp.secondName.getSecondName(), insertable.secondName.getSecondName())) {
            insertable.nextSecondName = tmp;
            insertable.previousSecondName = firstElement;
            tmp.previousSecondName = insertable;
            firstElement.nextSecondName = insertable;
        }
        while (tmp.nextSecondName != lastElement) {
            if (StringComparator.firstOfTwoStringsIsHigherInAlphabeticalOrder(tmp.secondName.getSecondName(), insertable.secondName.getSecondName())){
                insertable.previousSecondName = tmp.previousSecondName;
                insertable.nextSecondName = tmp;
                tmp.previousSecondName.nextSecondName = insertable;
                tmp.nextSecondName.previousSecondName = insertable;
            }
            else {
                tmp = tmp.nextSecondName;
            }
        }
        if (StringComparator.firstOfTwoStringsIsHigherInAlphabeticalOrder(tmp.secondName.getSecondName(), insertable.secondName.getSecondName())){
            insertable.previousSecondName = tmp.previousSecondName;
            insertable.nextSecondName = tmp;
            tmp.previousSecondName.nextSecondName = insertable;
            tmp.nextSecondName.previousSecondName = insertable;
        }
        tmp.nextSecondName = insertable;
        insertable.nextSecondName = lastElement;
        insertable.previousSecondName = tmp;
        lastElement = insertable;
    }

    public void removeElement(Element element){
        Element previousTelephoneElement = element.previousTelephoneNumber;
        Element nextTelephoneElement = element.nextTelephoneNumber;

        previousTelephoneElement.nextTelephoneNumber = nextTelephoneElement;
        nextTelephoneElement.previousTelephoneNumber = previousTelephoneElement;

        Element previousSecondNameElement = element.previousSecondName;
        Element nextSecondNameElement = element.nextSecondName;

        previousSecondNameElement.nextSecondName = nextSecondNameElement;
        nextSecondNameElement.previousSecondName = previousSecondNameElement;

        size--;

        element = null; // java will free memory of this element with no pointers as soon as garbage collector will go for it
    }

    public boolean isEmpty() {
        return firstElement.telephoneNumber == null && firstElement.secondName == null;
    }

    public void addElement(String name, long number){
        Element element = new Element(name, number);
        if (isEmpty()) {
            firstElement = element;
        }
        insertTelephoneNumber(element);
        insertSecondName(element);
        size++;
    }

    public Element findByTelephoneNumber(long number){
        if (isEmpty()) {
            System.out.println("List is empty");
            return null;
        }

        Element tmp = firstElement;
        boolean found = false;
        while (tmp != lastElement){
            if(tmp.telephoneNumber.getNumber() == number) {
                found = true;
                break;
            }
            else tmp = tmp.nextTelephoneNumber;
        }
        if (found) {
            return tmp;
        }
        else {
            System.out.println("No such element");
            return null;
        }
    }

    public Element findBySecondName(String name){
        if (isEmpty()) {
            System.out.println("List is empty");
            return null;
        }

        Element tmp = firstElement;
        boolean found = false;
        while (tmp != lastElement){
            if(tmp.secondName.getSecondName().equals(name)) {
                found = true;
                break;
            }
            else tmp = tmp.nextSecondName;
        }
        if (found) {
            return tmp;
        }
        else {
            System.out.println("No such element");
            return null;
        }
    }

    public void removeBySecondName(String name){
        if(isEmpty()) System.out.println("List is empty");
        else{
            Element tmp = firstElement;
            boolean found = false;
            while(tmp != lastElement) {
                if(tmp.secondName.getSecondName() == name){
                    found = true;
                    break;
                }
                else tmp = tmp.nextSecondName;
            }
            if(found){
                removeElement(tmp);
                System.out.println("Removed element successfully");
            }
            else {
                System.out.println("Element not found");
            }
        }
    }

    public void removeByTelephoneNumber(long number){
        if(isEmpty()) System.out.println("List is empty");
        else{
            Element tmp = firstElement;
            boolean found = false;
            while(tmp != lastElement) {
                if(tmp.telephoneNumber.getNumber() == number){
                    found = true;
                    break;
                }
                else tmp = tmp.nextSecondName;
            }
            if(found){
                removeElement(tmp);
                System.out.println("Removed element successfully");
            }
            else {
                System.out.println("Element not found");
            }
        }
    }

}
