package Stack;

public class Main {
    public static void main(String[] args){
        Stack<Double> stack = new Stack<Double>();
        stack.push(3.5);
        stack.push(11.0);
        stack.push(0.0);
        stack.clear();
        System.out.println(stack.pop());
    }
}
