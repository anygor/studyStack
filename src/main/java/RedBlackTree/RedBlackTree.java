package RedBlackTree;

public class RedBlackTree {
    private Element nil = new Element();
    private Element root = nil;

    public RedBlackTree(){
        root.left = nil;
        root.right = nil;
        root.parent = nil;
    }

    private void leftRotate(Element x){
        leftRotateFix(x);
        Element y;
        y = x.right;
        x.right = y.left;

        if(!isNull(y.left))
            y.left.parent = x;
        y.parent = x.parent;

        if(isNull(x.parent))
            root = y;

        else if (x.parent.left == x)
            x.parent.left = y;

        else
            x.parent.right = y;

        y.left = x;
        x.parent = y;
    }

    private void leftRotateFix(Element x){
        if(isNull(x.left) && isNull(x.right.left)){
            x.numRight = 0;
            x.numLeft = 0;
            x.right.numLeft = 1;
        }
        else if (isNull(x.left) && !isNull(x.right.left)){
            x.numLeft = 0;
            x.numRight = 1 + x.right.left.numLeft +
                    x.right.left.numRight;
            x.right.numLeft = 2 + x.right.left.numLeft +
                    x.right.left.numRight;
        }
        else if (!isNull(x.left) && isNull(x.right.left)){
            x.numRight = 0;
            x.right.numLeft = 2 + x.left.numLeft + x.left.numRight;
        }
        else {
            x.numRight = 1 + x.right.left.numLeft + x.right.left.numRight;
            x.right.numLeft = 3 + x.left.numLeft + x.left.numRight + x.right.left.numLeft + x.right.left.numRight;
        }
    }

    private boolean isNull(Element node){
        return node == nil;
    }
}
