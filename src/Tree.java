import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Tree {

    NodeForTree root;

    public void add(int value) {
        root = addRecursive(root, value);
    }

    public void show(NodeForTree currentNode){
        System.out.println(currentNode);
        if (currentNode.right != null){
            show(currentNode.right);
        }
        if (root.left != null){
            show(currentNode.left);
        }
    }

    private NodeForTree addRecursive(NodeForTree current, int value) {

        if (current == null) {
            return new NodeForTree(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        }

        return current;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int getSize() {
        return getSizeRecursive(root);
    }

    private int getSizeRecursive(NodeForTree current) {
        return current == null ? 0 : getSizeRecursive(current.left) + 1 + getSizeRecursive(current.right);
    }

    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }

    private boolean containsNodeRecursive(NodeForTree current, int value) {
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

    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    private NodeForTree deleteRecursive(NodeForTree current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.value) {
            // Case 1: no children
            if (current.left == null && current.right == null) {
                return null;
            }

            // Case 2: only 1 child
            if (current.right == null) {
                return current.left;
            }

            if (current.left == null) {
                return current.right;
            }

            // Case 3: 2 children
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

    private int findSmallestValue(NodeForTree root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }

    public void traverseInOrder(NodeForTree nodeForTree) {
        if (nodeForTree != null) {
            traverseInOrder(nodeForTree.left);
            visit(nodeForTree.value);
            traverseInOrder(nodeForTree.right);
        }
    }

    public void traversePreOrder(NodeForTree nodeForTree) {
        if (nodeForTree != null) {
            visit(nodeForTree.value);
            traversePreOrder(nodeForTree.left);
            traversePreOrder(nodeForTree.right);
        }
    }

    public void traversePostOrder(NodeForTree nodeForTree) {
        if (nodeForTree != null) {
            traversePostOrder(nodeForTree.left);
            traversePostOrder(nodeForTree.right);
            visit(nodeForTree.value);
        }
    }

    public void traverseLevelOrder() {
        if (root == null) {
            return;
        }

        Queue<NodeForTree> nodeForTrees = new LinkedList<>();
        nodeForTrees.add(root);

        while (!nodeForTrees.isEmpty()) {

            NodeForTree nodeForTree = nodeForTrees.remove();

            System.out.print(" " + nodeForTree.value);

            if (nodeForTree.left != null) {
                nodeForTrees.add(nodeForTree.left);
            }

            if (nodeForTree.right != null) {
                nodeForTrees.add(nodeForTree.right);
            }
        }
    }

    public void traverseInOrderWithoutRecursion() {
        Stack<NodeForTree> stack = new Stack<>();
        NodeForTree current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            NodeForTree top = stack.pop();
            visit(top.value);
            current = top.right;
        }
    }

    public void traversePreOrderWithoutRecursion() {
        Stack<NodeForTree> stack = new Stack<>();
        NodeForTree current = root;
        stack.push(root);

        while (current != null && !stack.isEmpty()) {
            current = stack.pop();
            visit(current.value);

            if (current.right != null)
                stack.push(current.right);

            if (current.left != null)
                stack.push(current.left);
        }
    }

    public void traversePostOrderWithoutRecursion() {
        Stack<NodeForTree> stack = new Stack<>();
        NodeForTree prev = root;
        NodeForTree current = root;
        stack.push(root);

        while (current != null && !stack.isEmpty()) {
            current = stack.peek();
            boolean hasChild = (current.left != null || current.right != null);
            boolean isPrevLastChild = (prev == current.right || (prev == current.left && current.right == null));

            if (!hasChild || isPrevLastChild) {
                current = stack.pop();
                visit(current.value);
                prev = current;
            } else {
                if (current.right != null) {
                    stack.push(current.right);
                }
                if (current.left != null) {
                    stack.push(current.left);
                }
            }
        }
    }

    private void visit(int value) {
        System.out.print(" " + value);
    }
}