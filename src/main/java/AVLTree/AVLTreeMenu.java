package AVLTree;

import java.util.Scanner;

public class AVLTreeMenu {
    public static void menu(){
        System.out.println("This is your AVL tree management tool");
        System.out.println("Type help to see available commands");
        System.out.println("Type quit to finish program");
        AVLTree tree = new AVLTree();
        String command;
        String executableString;
        Scanner scanner = new Scanner(System.in);
        loop:
        while(true) {
            System.out.println("Digit a command");
            command = scanner.nextLine();
            switch (command) {
                case "help": {
                    System.out.println("I will help, but I don't work for free. Let's  talk about my reward");
                    break;
                }
                case "add": {
                    System.out.println("Type a value you want to add");
                    executableString = scanner.nextLine();
                    tree.add(Integer.parseInt(executableString));
                    System.out.println("Successfully added " + executableString + " to your tree");
                    break;
                }
                case "delete": {
                    System.out.println("Type a value you want to delete");
                    executableString = scanner.nextLine();
                    tree.remove(Integer.parseInt(executableString));
                    System.out.println("Deletion successfully complete");
                    break;
                }
                case "root" : {
                    System.out.println(tree.getRootKey());
                    break;
                }
                case "quit": {
                    System.out.println("Got it, bye");
                    break loop;
                }
                default: {
                    System.out.println("Invalid command, try again");
                    break;
                }
            }
        }
    }
}
