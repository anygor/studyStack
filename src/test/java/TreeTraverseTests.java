import LinkedList.LinkedList;
import org.junit.Test;

import BinaryTree.*;

public class TreeTraverseTests {
    private void fillTree(BinaryTree tree){
        tree.add(5);
        tree.add(2);
        tree.add(1);
        tree.add(8);
        tree.add(4);
    }

    @Test
    public void preorderTraverseTest(){
        BinaryTree tree = new BinaryTree();
        fillTree(tree);
        LinkedList<Integer> traversetree = tree.preOrderTraversal();
        for(int i = 0; traversetree.peekFront() != null; i++){
            System.out.println(traversetree.popFront());
        }
    }
}
