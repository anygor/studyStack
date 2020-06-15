package AVLTree;

public class AVLTree {
    Element root;

    Element rotateRight(Element node){
        Element left = node.left;
        node.left = left.right;
        left.right = node;
        node.adjustHeight();
        left.adjustHeight();
        return left;
    }

    Element rotateLeft(Element node){
        Element right = node.right;
        node.right = right.left;
        right.left = node;
        node.adjustHeight();
        right.adjustHeight();
        return right;
    }

    Element balance(Element node){
        node.adjustHeight();
        if (node.balanceFactor() == 2) {
            if (node.right.balanceFactor() < 0){
                node.right = rotateRight(node.right);
            }
            return rotateLeft(node);
        }
        if (node.balanceFactor() == -2){
            if (node.left.balanceFactor() > 0) {
                node.left = rotateLeft(node.left);
            }
            return rotateRight(node);
        }
        return node;
    }

    public void add(int k){
        root = add(root, k);
    }

    private Element add(Element currentRoot, int k){
        if (currentRoot == null) {
            System.out.println("Tree is not initialized");
            currentRoot = new Element(k);
            return currentRoot;
        }
        else if (k < currentRoot.key){
            currentRoot.left = add(currentRoot.left, k);
        }
        else {
            currentRoot.right = add(currentRoot.right, k);
        }
        return balance(currentRoot);
    }

    private Element findMin(Element node){
        return node.left != null ? findMin(node.left) : node;
    }

    private Element removeMin(Element node){
        if(node.left == null)
            return node.right;
        node.left = removeMin(node.left);
        return balance(node);
    }

    private Element remove(Element currentRoot, int k){
        if (currentRoot == null) {
            System.out.println("Tree is not initialized");
            return null;
        }
        if (k < currentRoot.key) {
            currentRoot.left = remove(currentRoot.left, k);
        }
        else if (k > currentRoot.key) {
            currentRoot.right = remove(currentRoot.right, k);
        }
        else {
            Element left = currentRoot.left;
            Element right = currentRoot.right;
            currentRoot = null;
            if (right == null) return left;
            Element min = findMin(right);
            min.right = removeMin(right);
            min.left = left;
            return balance(min);
        }
        return balance(currentRoot);
    }

    public Element remove(int k){
        return remove(root, k);
    }

    public Element getRoot() {
        return root;
    }
}
