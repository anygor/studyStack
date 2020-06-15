package AVLTree;

public class Element {
    int key;
    int height;
    Element left;
    Element right;

    public Element(int key) {
        this.key = key;
        height = 1;
    }

    public int balanceFactor(){
        int rh;
        int lh;
        if (right == null) rh = 0;
        else rh = right.height;
        if (left == null) lh = 0;
        else lh = left.height;
        return rh - lh;
    }

    void adjustHeight(){
        int lh, rh;
        if (left == null) {
            lh = 0;
        }
        else lh = left.height;
        if (right == null) {
            rh = 0;
        }
        else rh = right.height;
        if (lh > rh) {
            height = lh + 1;
        }
        else height = rh + 1;
    }
}
