package Stack;

import java.util.Scanner;

public class StackMenu {
    public static void menu(){
        Stack<String> stack = new Stack<String>();   // Type is changed here
        String command;
        String executableString;

        Scanner scanner = new Scanner(System.in);

        System.out.println("This is your stack-management tool");
        System.out.println("Type help to see avaliable commands");
        System.out.println("Type quit to finish program");

        loop:
        while(true) {
            System.out.println("Digit a command:");
            command = scanner.nextLine();
            switch (command) {
                case "help": {
                    System.out.println("push - to add a certain number to your stack");
                    System.out.println("peek - to look at the top for your stack");
                    System.out.println("pop - to return and remove top of your stack");
                    System.out.println("takeFromFile - get numbers from data file to your stack");
                    break;
                }
                case "push": {
                    System.out.println("Digit a value, you want to push:");
                    executableString = scanner.nextLine();
                    scanner = new Scanner(System.in);
                    stack.push(executableString);
                    System.out.println("Pushed " + executableString + " to your stack");
                    break;
                }
                case "peek": {
                    System.out.println("Current stack top: " + stack.peek());
                    break;
                }
                case "pop":{
                    System.out.println("Your removed " + stack.pop() + " from your stack");
                    break;
                }
                case "clear":{
                    stack.clear();
                    System.out.println("Cleared the stack");
                    break;
                }
                case "isElementInStack" : {
                    System.out.println("Digit an element you want to check:");
                    executableString = scanner.nextLine();
                    scanner = new Scanner(System.in);
                    boolean found = new StackHelper().isElementInStack(stack, executableString);
                    if (found){
                        System.out.println("Element is in stack");
                    }
                    else System.out.println("No such element in stack");
                    break;
                }
                case "changeElement" : {
                    System.out.println("Digit an element you want to change");
                    executableString = scanner.nextLine();
                    String element = executableString;
                    System.out.println("Digit the new value of this element");
                    executableString = scanner.nextLine();
                    String value = executableString;
                    new StackHelper().changeElement(stack, element, value);
                    break;
                }
                case "takeFromFile":{
                    new StackHelper().takeFromFile(stack);
                    break;
                }
                case "putToFile":{
                    new StackHelper().putToFile(stack);
                    stack.clear();
                    break;
                }
                case "quit":{
                    System.out.println("Fare thee well");
                    break loop;
                }
                default:{
                    System.out.println("Invalid command, try again");
                    break;
                }
            }
        }
    }
}
