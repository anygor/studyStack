import org.junit.Test;

import Stack.*;

import static org.junit.Assert.*;

public class InsertionTests {
    private double expectedDouble;
    private double actualDouble;

    @Test
    public void zeroInsertTest(){
        Stack<Double> stack = new Stack<Double>();
        stack.push(0.0);
        expectedDouble = 0;
        actualDouble = stack.pop();
        assertEquals(expectedDouble, actualDouble, 0);
    }

    @Test
    public void noInsertTest(){
        Stack<Double> stack = new Stack<Double>();
        assertNull(stack.pop());
    }

    @Test
    public void insertOrderTest(){
        double[] arrFirst = new double[5];
        double[] arrSecond = new double[5];
        Stack<Double> stack = new Stack<Double>();
        for (int i = 0; i < 5; i++) {
            arrFirst[i] = (double) i + 1;
            stack.push(arrFirst[i]);
        }
        for (int i = arrSecond.length - 1; i >= 0; i--) {
            arrSecond[i] = stack.pop();
        }
        assertArrayEquals(arrFirst, arrSecond, 0.0);
    }

    @Test
    public void clearTest(){
        double[] arr = new double[10];
        Stack<Double> stack = new Stack<Double>();
        for (int i = 0; i < 10; i++) {
            arr[i] = (double) i + 1;
            stack.push(arr[i]);
        }
        stack.clear();
        assertNull(stack.pop());
    }
}
