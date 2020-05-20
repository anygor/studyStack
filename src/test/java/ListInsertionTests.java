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

    @Test
    public void indexInsertionTest(){
        LinkedList<String> list = new LinkedList<String>();
        list.pushFront("0");
        list.pushBack("2");
        list.pushAtIndex("1", 1);
        assertEquals("1", list.peekAtIndex(1));
    }

    @Test
    public void indexPushOnlyTest(){
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.pushAtIndex(0, 0);
        list.pushAtIndex(2, 1);
        list.pushAtIndex(1, 1);
        Integer expected = 2;
        assertEquals(expected, list.popBack());
        expected = 1;
        assertEquals(expected, list.popBack());
        expected = 0;
        assertEquals(expected, list.popBack());
    }
}
