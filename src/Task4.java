public class Task4 {
    public static void main(String[] args){
        Tree tree = new Tree();
        for (int i = 0; i < 10; i++){
            tree.add(i);
        }

        tree.show(tree.root);
    }
}
