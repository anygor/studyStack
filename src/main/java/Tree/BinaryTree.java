package Tree;

import LinkedList.LinkedList;

public class BinaryTree {

    Element root;

    private Element addRecursive(Element current, int value) {
        if (current == null) {
            return new Element(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    public void add(int value) {
        root = addRecursive(root, value);
    }

    private boolean containsNodeRecursive(Element current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.value) {
            return true;
        }
        return value < current.value
                ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }

    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }

    private Element deleteRecursive(Element current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.value) {
            if (current.left == null && current.right == null) {
                return null;
            }
            if (current.right == null) {
                return current.left;
            }

            if (current.left == null) {
                return current.right;
            }
            int smallestValue = findSmallestValue(current.right);
            current.value = smallestValue;
            current.right = deleteRecursive(current.right, smallestValue);
            return current;
        }
        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }
        current.right = deleteRecursive(current.right, value);
        return current;
    }

    private int findSmallestValue(Element root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }

    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    public LinkedList<Integer> preOrderTraversal(){
        LinkedList<Integer> list = new LinkedList<Integer>();
        preOrderTraversalInternal(list, root);
        return list;
    }

    private void preOrderTraversalInternal(LinkedList<Integer> list, Element currentNode){
        if(currentNode != null) {
            list.pushFront(currentNode.value);
            preOrderTraversalInternal(list, currentNode.left);
            preOrderTraversalInternal(list, currentNode.right);
        }
    }

    public LinkedList<Integer> inOrderTraversal(){
        LinkedList<Integer> list = new LinkedList<Integer>();
        inOrderTraversalInternal(list, root);
        return list;
    }

    private void inOrderTraversalInternal(LinkedList<Integer> list, Element currentNode){
        if(currentNode != null) {
            inOrderTraversalInternal(list, currentNode.left);
            list.pushFront(currentNode.value);
            inOrderTraversalInternal(list, currentNode.right);
        }
    }

    public LinkedList<Integer> postOrderTraversal(){
        LinkedList<Integer> list = new LinkedList<Integer>();
        postOrderTraversalInternal(list, root);
        return list;
    }

    private void postOrderTraversalInternal(LinkedList<Integer> list, Element currentNode){
        if(currentNode != null) {
            postOrderTraversalInternal(list, currentNode.left);
            postOrderTraversalInternal(list, currentNode.right);
            list.pushFront(currentNode.value);
        }
    }
}