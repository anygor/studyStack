package Stack;

public class Stack<T> {
    private Element<T> top;
    private int size = 0;
    private boolean isNotEmpty(){
        return size != 0;
    }

    public Stack(){
        top = new Element<T>();
    }

    void push(T value){
        Element<T> tmp = new Element<>(value); // generified
        tmp.setPrev(top);
        top = tmp;
        size++;
    }

    public T peek(){
        if(isNotEmpty()) {
            return top.getValue();
        }
        else return null;
    }

    public T pop(){
        if (isNotEmpty()){
            T tmpValue = top.getValue();
            top = top.getPrev();
            size--;
            return tmpValue;
        }
        else return null;
    }

    public void clear(){
        while(isNotEmpty()){
            pop();
        }
    }
}
