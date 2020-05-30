package Matrix;

import java.util.Vector;

public class Matrix {
    private int size;
    private Vector<Integer>[] rows;

    public Matrix(int size){
        this.size = size;
        rows = new Vector[size];
        for(int i = 0; i < size; i++) {
            rows[i] = new Vector<>(size);
        }
    }

    public void add(int x, int y, int value){
        if (x < 0 || x >= size || y < 0 || y >= size) {
            System.out.println("Out of bounds");
        }
        else rows[x].add(y, value);
    }

    public Integer get(int x, int y){
        if (x < 0 || x >= size || y < 0 || y >= size) {
            System.out.println("Out of bounds");
            return null;
        }
        else return rows[x].get(y);
    }

    public void printMatrix(){
        for(int i = 0; i < size; i++){
            System.out.print(i + ". ");
            for(int j = 0; j < size; j++){
                System.out.println(rows[i].get(j) + " ");
            }
        }
    }
}
