package RedBlackTree;

public class Element {
    int red = 0;
    int black = 1;

    int key;

    Element parent;
    Element left;
    Element right;

    int numLeft;
    int numRight;

    Color color;

    public Element(){
        color = Color.BLACK;
    }

    public Element(int red) {
        this();
        this.red = red;
    }
}
