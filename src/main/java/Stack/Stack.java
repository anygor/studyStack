package Stack;

import java.io.*;

public class Stack<T> {
    private Element<T> top;
    private int size = 0;


    BufferedReader in;
    BufferedWriter out;

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

    public void takeFromFile(){
        try {
            in = new BufferedReader(new FileReader("src/main/resources/data.txt"));
            String buffer;
            while((buffer = in.readLine()) != null)
                this.push((T) buffer);
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void putToFile(){
        try{
            out = new BufferedWriter(new PrintWriter(new FileOutputStream("src/main/resources/data.txt", false)));
            while(this.isNotEmpty()){
                out.write((String)this.pop());
                out.flush();
            }
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
