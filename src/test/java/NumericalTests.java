import org.junit.Test;

import Stack.*;

import static org.junit.Assert.*;

public class NumericalTests {
    private double expectedDouble;
    private double actualDouble;

    private void fillStack(Stack<String> stack){
        stack.push("15");
        stack.push("-2");
        stack.push("31");
        stack.push("5");
    }

    @Test
    public void maxValueTest(){
        Stack<String> stack = new Stack<String>();
        fillStack(stack);
        expectedDouble = 31;
        actualDouble = new StackHelper().maxElement(stack);
        assertEquals(expectedDouble, actualDouble, 0);
    }

    @Test
    public void minValueTest(){
        Stack<String> stack = new Stack<String>();
        fillStack(stack);
        expectedDouble = -2;
        actualDouble = new StackHelper().minElement(stack);
        assertEquals(expectedDouble, actualDouble, 0);
    }

    @Test
    public void sumTest(){
        Stack<String> stack = new Stack<String>();
        fillStack(stack);
        expectedDouble = 49;
        actualDouble = new StackHelper().sumOfElements(stack);
        assertEquals(expectedDouble, actualDouble, 0);
    }

    @Test
    public void changeElementTest(){
        Stack<String> stack = new Stack<String>();
        Double[] arr = new Double[5];
        Double[] eqArr = new Double[5];
        for (int i = 0; i < 5; i++) {
            eqArr[i] = (double) i + 1;
            stack.push(eqArr[i].toString());
        }
        new StackHelper().changeElement(stack, "3.0", "10.0");
        eqArr[2] = 10.0;
        for (int i = 4; i >= 0; i--){
            arr[i] = Double.parseDouble(stack.pop());
        }
        assertArrayEquals(arr, eqArr);
    }

    @Test
    public void isElementInStackTest(){
        Stack<String> stack = new Stack<String>();
        stack.push("15");
        boolean right = new StackHelper().isElementInStack(stack, "15");
        boolean wrong = new StackHelper().isElementInStack(stack, "15.0");
        assertEquals(right, !wrong);
    }
}
