package StreamList;

public class Element {
    TelephoneNumber telephoneNumber;
    SecondName secondName;

    Element nextTelephoneNumber;
    Element nextSecondName;
    Element previousTelephoneNumber;
    Element previousSecondName;

    public Element(String name, long number){
        telephoneNumber = new TelephoneNumber(number);
        secondName = new SecondName(name);
    }
}
