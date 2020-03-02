package Queue;

public class Element<T> {
    private T value;
    private Element<T> prev;
    private Element<T> next;

    public Element(){
        value = null;
        prev = null;
        next = null;
    }

    public Element(T value){
        this.value = value;
        prev = null;
        next = null;
    }

    public void setNext(Element<T> next) {
        this.next = next;
    }

    public void setPrev(Element<T> prev) {
        this.prev = prev;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Element(Element<T> prev) {
        this.prev = prev;
    }

    public Element<T> getNext() {
        return next;
    }

    public T getValue() {
        return value;
    }

    public Element<T> getPrev() {
        return prev;
    }
}
