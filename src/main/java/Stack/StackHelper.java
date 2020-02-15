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

    public void changeElement(Stack<String> stack, String element, String value){
        if(!isElementInStack(stack, element)) {
            System.out.println("There is no such element in stack");
        }
        else {
            Stack<String> tmpStack = new Stack<String>();
            String tmpElement = stack.peek();
            while(stack.isNotEmpty() && !tmpElement.equals(element)) {
                tmpStack.push(stack.pop());
                tmpElement = tmpStack.peek();
            }
            tmpStack.pop();
            stack.push(value);
            while(tmpStack.isNotEmpty()) {
                stack.push(tmpStack.pop());
            }
        }
    }

    public void printStack(Stack<String> stack){
        if(stack.isNotEmpty()){
            Stack<String> tmpStack = new Stack<String>();
            System.out.print("Bot -> ");
            while(stack.isNotEmpty()){
                tmpStack.push(stack.pop());
            }
            String element;
            while(tmpStack.isNotEmpty()){
                element = tmpStack.pop();
                System.out.print(element + ' ');
                stack.push(element);
            }
            System.out.println(" <- Top");
        }
        else{
            System.out.println("Stack is empty");
        }
    }

    public double maxElement(Stack<String> stack){
        if(stack.isNotEmpty()){
            Stack<String> tmpStack = new Stack<String>();
            String top = stack.pop();
            tmpStack.push(top);
            double max = Double.parseDouble(top);
            double tmp;
            while(stack.isNotEmpty()){
                top = stack.pop();
                tmpStack.push(top);
                tmp = Double.parseDouble(top);
                if(tmp > max){
                    max = tmp;
                }
            }
            while(tmpStack.isNotEmpty()){
                stack.push(tmpStack.pop());
            }
            return max;
        }
        else {
            System.out.println("Stack is empty");
            return 0;
        }
    }

    public double minElement(Stack<String> stack){
        if(stack.isNotEmpty()){
            Stack<String> tmpStack = new Stack<String>();
            String top = stack.pop();
            tmpStack.push(top);
            double min = Double.parseDouble(top);
            double tmp;
            while (stack.isNotEmpty()){
                top = stack.pop();
                tmpStack.push(top);
                tmp = Double.parseDouble(top);
                if(tmp < min){
                    min = tmp;
                }
            }
            while(tmpStack.isNotEmpty()){
                stack.push(tmpStack.pop());
            }
            return min;
        }
        else{
            System.out.println("Stack is empty");
            return 0;
        }
    }

    public double sumOfElements(Stack<String> stack){
        if(stack.isNotEmpty()){
            Stack<String> tmpStack = new Stack<String>();
            String top;
            double sum = 0;
            while(stack.isNotEmpty()){
                top = stack.pop();
                tmpStack.push(top);
                sum += Double.parseDouble(top);
            }
            while(tmpStack.isNotEmpty()){
                stack.push(tmpStack.pop());
            }
            return sum;
        }
        else{
            System.out.println("Stack is empty");
            return 0;
        }
    }
}
