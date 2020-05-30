package Matrix;

import java.util.Scanner;

public class MatrixMenu {
    public static void menu(){
        System.out.println("This is your matrix management tool");
        System.out.println("The basic size of this matrix is 3");
        System.out.println("Type reinitialize to reinitialize a matrix with different size");
        System.out.println("Type help to see available commands");
        System.out.println("Type quit to finish program");
        Matrix matrix = new Matrix(3);
        String command;
        String executableString;
        Scanner scanner = new Scanner(System.in);

        loop:
        while (true) {
            System.out.println("Digit a command:");
            command = scanner.nextLine();
            switch (command) {
                case "help": {
                    System.out.println("add - to set value at certain index");
                    System.out.println("get - to get value at certain index");
                    System.out.println("reinitialize - to reset matrix and change its size");
                    System.out.println("randomize - to fill matrix with random numbers");
                    System.out.println("clear - to delete all values from the matrix");
                    break;
                }
                case "add": {
                    System.out.println("Type coordinates");
                    System.out.println("x: ");
                    int x = Integer.parseInt(scanner.nextLine());
                    scanner = new Scanner(System.in);
                    System.out.println("y: ");
                    int y = Integer.parseInt(scanner.nextLine());
                    scanner = new Scanner(System.in);
                    System.out.println("Value to add: ");
                    executableString = scanner.nextLine();
                    scanner = new Scanner(System.in);
                    matrix.add(x, y, Integer.parseInt(executableString));
                    break;
                }
                case "get": {
                    System.out.println("Type coordinates");
                    System.out.println("x: ");
                    int x = Integer.parseInt(scanner.nextLine());
                    scanner = new Scanner(System.in);
                    System.out.println("y: ");
                    int y = Integer.parseInt(scanner.nextLine());
                    scanner = new Scanner(System.in);
                    System.out.println(matrix.get(x, y));
                    break;
                }
                case "reinitialize" : {
                    System.out.println("Set the new size: ");
                    int size = Integer.parseInt(scanner.nextLine());
                    scanner = new Scanner(System.in);
                    matrix = new Matrix(size);
                    System.out.println("Reinitialized");
                    break;
                }
                case "randomize": {
                    matrix.randomize();
                    System.out.println("Randomized");
                    break;
                }
                case "print": {
                    matrix.printMatrix();
                    break;
                }
                case "clear":{
                    matrix.clear();
                    break;
                }
                case "quit": {
                    System.out.println("Goodbye");
                    break loop;
                }
                default:{
                    System.out.println("Invalid command");
                    break;
                }
            }
        }
    }
}
