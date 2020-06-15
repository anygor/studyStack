package BinaryTree;

import LinkedList.LinkedList;
import LinkedList.LinkedListHelper;

import java.util.Scanner;

public class BinaryTreeMenu {
    public static void menu(){
        System.out.println("This is your binary tree management tool");
        System.out.println("Type help to see available commands");
        System.out.println("Type quit to finish program");
        BinaryTree tree = new BinaryTree();
        String command;
        String executableString;
        Scanner scanner = new Scanner(System.in);

        loop:
        while(true){
            System.out.println("Digit a command");
            command = scanner.nextLine();
            switch (command){
                case "help" : {
                    System.out.println("I will help, but I don't work for free. Let's  talk about my reward");
                    break;
                }
                case "add" : {
                    System.out.println("Type a value you want to add");
                    executableString = scanner.nextLine();
                    tree.add(Integer.parseInt(executableString));
                    System.out.println("Successfully added " + executableString + " to your tree");
                    break;
                }
                case "delete" : {
                    System.out.println("Type a value you want to delete");
                    executableString = scanner.nextLine();
                    if (tree.containsNode(Integer.parseInt(executableString))){
                        tree.delete(Integer.parseInt(executableString));
                        System.out.println("Deletion successfully complete");
                    }
                    else {
                        System.out.println("No such element");
                    }
                    break;
                }
                case "traverse" : {
                    System.out.println("Type traverse type - preorder, postorder or inorder");
                    executableString = scanner.nextLine();
                    LinkedList list;
                    switch (executableString){
                        case "preorder" : {
                            list = tree.preOrderTraversal();
                            new LinkedListHelper().printList(list);
                            break;
                        }
                        case "postorder" : {
                            list = tree.postOrderTraversal();
                            new LinkedListHelper().printList(list);
                            break;
                        }
                        case "inorder" : {
                            list = tree.inOrderTraversal();
                            new LinkedListHelper().printList(list);
                            break;
                        }
                        default:{
                            System.out.println("Error, traverse type not defined");
                            break;
                        }
                    }
                }
                case "quit" : {
                    System.out.println("Got it, bye");
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
