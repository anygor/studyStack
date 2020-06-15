import org.junit.Test;

import StreamList.*;

import static org.junit.Assert.*;

public class StreamListAdditionTests {

    @Test
    public void checkOutStreamList(){
        StreamList list = new StreamList();
        list.addElement("Alesha", 1488);
        list.addElement("Petya", 1337);
        list.addElement("Misha", 146282);
        //System.out.println("стоп кран");
        assertTrue(true);
    }
}
