import LinkedList.LinkedList;
import org.junit.Test;

import Tree.*;

import static org.junit.Assert.*;

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
        LinkedList<Integer> traversetree = tree.preorderTraversal();
        for(int i = 0; traversetree.peekFront() != null; i++){
            System.out.println(traversetree.popFront());
        }
    }
}
