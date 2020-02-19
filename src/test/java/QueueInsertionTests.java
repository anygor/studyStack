import org.junit.Test;

import Queue.*;

import static org.junit.Assert.*;

public class QueueInsertionTests {
    @Test
    public void addRemoveTest(){
        Queue<Integer> test = new Queue<Integer>();
        test.add(2);
        Integer expected = 2;
        assertEquals(expected, test.pop());
    }

    @Test
    public void returnFirstOfTwoAddedElementsTest(){
        Queue<Integer> test = new Queue<Integer>();
        test.add(10);
        test.add(5);

        Integer expected = 10;
        Integer actual = test.pop();

        assertEquals(expected, actual);
    }
}
