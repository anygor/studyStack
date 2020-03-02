package Queue;

import java.io.*;

public class QueueHelper {
    BufferedReader in;
    BufferedWriter out;

    public void takeFromFile(Queue<String> queue){
        try {
            in = new BufferedReader(new FileReader("src/main/resources/data.txt"));
            String buffer;
            while(((buffer = in.readLine()) != null)){
                queue.add(buffer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void putToFile(Queue<String> queue){
        try {
            out = new BufferedWriter(new PrintWriter(new FileOutputStream("src/main/resources/data.txt"), false));
            while(queue.isNotEmpty()){
                out.write(queue.pop());
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

    public void printQueue(Queue<String> queue){
        Queue<String> printable = new Queue<String>();
        if(queue.isNotEmpty()) {
            while(queue.isNotEmpty()){
                System.out.println(queue.peek());
                printable.add(queue.pop());
            }
            while (printable.isNotEmpty()) {
                queue.add(printable.pop());
            }
        }
        else
            System.out.println("Queue is empty");
    }
}
