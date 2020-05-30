package Matrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Matrix {
    private int size;
    private ArrayList<Element>[] rows;

    public Matrix(int size){
        this.size = size;
        rows = new ArrayList[size];
        for(int i = 0; i < size; i++) {
            rows[i] = new ArrayList(Collections.nCopies(size, null));
        }
    }

    public void add(int x, int y, int value){
        if (x < 0 || x >= size || y < 0 || y >= size) {
            System.out.println("Out of bounds");
        }
        else rows[x].add(y, new Element(x, y, value));
    }

    public Integer get(int x, int y){
        if (x < 0 || x >= size || y < 0 || y >= size) {
            System.out.println("Out of bounds");
            return null;
        }
        else return rows[x].get(y).getValue();
    }

    public void printMatrix(){
        for(int i = 0; i < size; i++){
            System.out.print(i + ". ");
            for(int j = 0; j < size; j++){
                System.out.print(rows[i].get(j) + " ");
            }
            System.out.println("\n");
        }
    }

    public void randomize(){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                rows[i].add(j, new Element(i, j, new Random().nextInt(1001)));
            }
        }
    }
}
