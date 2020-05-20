package LinkedList;

public class LinkedList<T> {
    private Element<T> head;
    private Element<T> tail;
    private int size = 0;

    boolean isNotEmpty() { return size != 0; }

    public LinkedList(){
        head = null;
        tail = head;
    }

    public void pushFront(T value){
        Element<T> tmp = new Element<T>(value);
        tmp.setPrev(null);
        if (head != null) {
            tmp.setNext(head);
            head.setPrev(tmp);
            head = tmp;
        }
        else {
            tmp.setNext(null);
            tail = tmp;
            head = tail;
        }
        size++;
    }

    public void pushBack(T value){
        Element<T> tmp = new Element<T>(value);
        tmp.setNext(null);
        if (tail != null) {
            tmp.setPrev(tail);
            tail.setNext(tmp);
            tail = tmp;
        }
        else {
            tmp.setPrev(null);
            head = tmp;
            tail = head;
        }
        size++;
    }

    public T popBack(){
        if (isNotEmpty()) {
            T value = tail.getValue();
            tail = tail.getPrev();
            size--;
            if (size == 0) head = null;
            return value;
        }
        else return null;
    }

    public T popFront(){
        if (isNotEmpty()) {
            T value = head.getValue();
            head = head.getNext();
            size--;
            if (size == 0) tail = null;
            return value;
        }
        else return null;
    }

    public void clear() { while (isNotEmpty()) popBack(); }

}
