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
}
