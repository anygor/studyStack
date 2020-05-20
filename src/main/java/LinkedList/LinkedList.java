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

    public void pushAtIndex(T value, int index){
        if (!isNotEmpty() || index == 0) {
            pushFront(value);
        }
        else if(index > size - 1) {
            System.out.println("List won't have this index, pushing to the end");
            pushBack(value);
        }
        else {
            Element<T> newElement = new Element<T>(value);
            Element<T> tmp = head;
            int step = 0;
            while(step < index - 1) {
                tmp = tmp.getNext();
                step++;
            }
            newElement.setNext(tmp.getNext());
            newElement.getNext().setPrev(newElement);
            newElement.setPrev(tmp);
            newElement.getPrev().setNext(newElement);
            tmp.setNext(newElement);
            size++;
        }
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

    public T peekFront(){
        if (isNotEmpty()) {
            return head.getValue();
        }
        else return null;
    }

    public T peekBack(){
        if(isNotEmpty()){
            return tail.getValue();
        }
        else return null;
    }

    public void clear() { while (isNotEmpty()) popBack(); }

}
