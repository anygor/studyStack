package Stack;

public class Element<T> {
    private T value;
    private Element<T> prev;

    public Element(){
        value = null;
        prev = null;
    }

    public Element(T value){
        this.value = value;
        prev = null;
    }

    public Element<T> getPrev() {
        return prev;
    }

    public T getValue() {
        return value;
    }

    public void setPrev(Element<T> prev){
        this.prev = prev;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
