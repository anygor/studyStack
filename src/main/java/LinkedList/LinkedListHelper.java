package LinkedList;

import java.io.*;

public class LinkedListHelper {
    BufferedReader in;
    BufferedWriter out;

    public void takeFromFile(LinkedList<String> linkedList){
        try {
            in = new BufferedReader(new FileReader("src/main/resources/data.txt"));
            String buffer;
            while(((buffer = in.readLine()) != null)){
                linkedList.pushFront(buffer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void putToFile(LinkedList<String> linkedList){
        try {
            out = new BufferedWriter(new PrintWriter(new FileOutputStream("src/main/resources/data.txt"), false));
            while(linkedList.isNotEmpty()){
                out.write(linkedList.popBack());
                out.flush();
                out.write('\n');
                out.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void printList(LinkedList<String> linkedList){
        LinkedList<String> printable = new LinkedList<String>();
        if(linkedList.isNotEmpty()) {
            while(linkedList.isNotEmpty()){
                System.out.println(linkedList.peekBack());
                printable.pushFront(linkedList.popBack());
            }
            while (printable.isNotEmpty()) {
                linkedList.pushFront(printable.popBack());
            }
        }
        else
            System.out.println("List is empty");
    }
}
