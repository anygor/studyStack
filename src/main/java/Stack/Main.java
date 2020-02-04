package Stack;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Stack<Integer> stack = new Stack<Integer>();   // Type is changed here
        String command;
        int insert;

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
                    System.out.println("Digit a number, you want to push:");
                    insert = scanner.nextInt();
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
                case "takeFromFile":{
                    stack.takeFromFile();
                    break;
                }
                case "putToFile":{
                    stack.putToFile();
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
