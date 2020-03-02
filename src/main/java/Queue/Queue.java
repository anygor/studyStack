package Queue;

public class Queue<T> {
    private Element<T> head;
    private Element<T> tail;
    private int size = 0;

    boolean isNotEmpty(){
        return size != 0;
    }

    public Queue(){
        head = null;
        tail = head;
    }

    public void add(T value){
        Element<T> tmp = new Element<>(value);
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

    public T pop(){
        if (isNotEmpty()) {
            T value = tail.getValue();
            tail = tail.getPrev();
            size--;
            if (size == 0) head = null;
            return value;
        }
        else return null;
    }

    public T peek(){
        if(isNotEmpty()){
            return tail.getValue();
        }
        else return null;
    }

    public void clear(){
        while(isNotEmpty()) pop();
    }
}
