package Stack;

import java.io.*;

public class StackHelper {

    BufferedReader in;
    BufferedWriter out;

    public void takeFromFile(Stack<String> stack){
        try {
            in = new BufferedReader(new FileReader("src/main/resources/data.txt"));
            String buffer;
            while((buffer = in.readLine()) != null)
                stack.push(buffer);
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void putToFile(Stack<String> stack) {
        try {
            out = new BufferedWriter(new PrintWriter(new FileOutputStream("src/main/resources/data.txt", false)));
            while (stack.isNotEmpty()) {
                out.write(stack.pop());
                out.flush();
                out.write("\n");
                out.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isElementInStack(Stack<String> stack, String element){
        Stack<String> tmpStack = new Stack<String>();
        while(stack.isNotEmpty()){
            tmpStack.push(stack.pop());
            if (tmpStack.peek().equals(element)){
                while(tmpStack.isNotEmpty()){
                    stack.push(tmpStack.pop());
                }
                return true;
            }
        }
        while(tmpStack.isNotEmpty()){
            stack.push(tmpStack.pop());
        }
        return false;
    }
}
