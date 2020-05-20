import LinkedList.LinkedList;
import org.junit.Test;
import static org.junit.Assert.*;

public class ListInsertionTests {
    @Test
    public void frontBackTest(){
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.pushBack(5);
        list.pushFront(10);
        Integer expected = 5;
        assertEquals(expected, list.popBack());
        expected = 10;
        assertEquals(expected, list.popFront());
    }
}
