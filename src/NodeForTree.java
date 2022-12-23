public class NodeForTree {
    int value;
    NodeForTree left;
    NodeForTree right;

    NodeForTree(int value) {
        this.value = value;
        right = null;
        left = null;
    }

    @Override
    public String toString(){
        String leftValue = (left == null) ? "None" : Integer.toString(left.value);
        String rightValue = (right == null) ? "None" : Integer.toString(right.value);
        return String.format("Current value - %d; left - %s; right - %s", value, leftValue, rightValue);
    }
}