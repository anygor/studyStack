package Queue;

import java.util.Scanner;

public class QueueMenu {
    public static void menu() {
        Queue<String> queue = new Queue<String>();
        String command;
        String executableString;

        Scanner scanner = new Scanner(System.in);

        System.out.println("This is your queue management tool");
        System.out.println("Type help to see available commands");
        System.out.println("Type quit to finish program");

        loop:
        while (true) {
            System.out.println("Digit a command:");
            command = scanner.nextLine();
            switch (command) {
                case "help": {
                    System.out.println("add - to add a certain value to your queue");
                    System.out.println("peek - to look at the tail for your queue");
                    System.out.println("pop - to return and remove tail of your queue");
                    System.out.println("takeFromFile - get values from data file to your queue");
                    System.out.println("putToFile - export queue to file");
                    System.out.println("clear - clear queue");
                    System.out.println("printQueue - to see elements from head to tail");
                    break;
                }
                case "add": {
                    System.out.println("Digit a value, you want to push:");
                    executableString = scanner.nextLine();
                    scanner = new Scanner(System.in);
                    queue.add(executableString);
                    System.out.println("Added " + executableString + " to your queue");
                    break;
                }
                case "peek": {
                    System.out.println("Current stack tail: " + queue.peek());
                    break;
                }
                case "pop":{
                    System.out.println("Your removed " + queue.pop() + " from your queue");
                    break;
                }
                case "clear":{
                    queue.clear();
                    System.out.println("Queue the stack");
                    break;
                }
                case "printQueue" : {
                    new QueueHelper().printQueue(queue);
                    break;
                }
                case "takeFromFile":{
                    new QueueHelper().takeFromFile(queue);
                    break;
                }
                case "putToFile":{
                    new QueueHelper().putToFile(queue);
                    queue.clear();
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
