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
        return right.height - left.height;
    }

    void adjustHeight(){
        int lh = left.height;
        int rh = right.height;
        if (lh > rh) {
            height = lh + 1;
        }
        else height = rh + 1;
    }
}
