package StreamList;

public class StreamList {
    Element firstElement;
    Element lastElement;
    int size;

    void insertTelephoneNumber(Element insertable){
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
}
