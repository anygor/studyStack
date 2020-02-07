package Stack;

import java.util.Scanner;

public class StackMenu {
    public static void menu(){
        Stack<String> stack = new Stack<String>();   // Type is changed here
        String command;
        String insert;

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
                    insert = scanner.nextLine();
                    scanner = new Scanner(System.in);
                    stack.push(insert);
                    System.out.println("Pushed " + " to your stack");
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
