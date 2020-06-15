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
        assertEquals(3, tree.getRoot());
    }
}
