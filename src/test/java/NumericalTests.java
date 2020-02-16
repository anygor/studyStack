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
}
