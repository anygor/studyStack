import AVLTree.AVLTree;
import org.junit.Test;

import static org.junit.Assert.*;

public class AVLTreeTests {
    @Test
    public void AVLTreeMainTest(){
        AVLTree tree = new AVLTree();
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);
        tree.add(6);
        tree.add(7);
        tree.remove(7);
        tree.remove(6);
        tree.remove(5);
        assertEquals(3, tree.getRootKey());
    }
}
