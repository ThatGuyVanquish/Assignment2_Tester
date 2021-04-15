
public class tests {

    private static final Stack wrongPointers= new Stack(); // So far only used to test for wrong parent pointers

    public static void main(String[] args) {
        testBST();
    }

    public static void testBST(){
        BacktrackingBST tree = new BacktrackingBST(new Stack(), new Stack());
        tree.insert(new BacktrackingBST.Node(3, null));
        tree.insert(new BacktrackingBST.Node(6, null));
        tree.insert(new BacktrackingBST.Node(2, null));
        tree.insert(new BacktrackingBST.Node(5, null));
        tree.insert(new BacktrackingBST.Node(4, null));
        tree.insert(new BacktrackingBST.Node(8, null));
        tree.insert(new BacktrackingBST.Node(9, null));
        tree.insert(new BacktrackingBST.Node(7, null));
        tree.insert(new BacktrackingBST.Node(0, null));
        tree.insert(new BacktrackingBST.Node(1, null));

        isEquals(tree,"3 2 0 1 6 5 4 8 7 9","0 1 2 3 4 5 6 7 8 9");
        kavim();
        tree.backtrack();
        if(!isEquals(tree,"3 2 0 6 5 4 8 7 9","0 2 3 4 5 6 7 8 9")){
            System.out.println("problem with backtracking: insert(1)");
        }
        kavim();
        tree.backtrack();
        if(!isEquals(tree,"3 2 6 5 4 8 7 9","2 3 4 5 6 7 8 9")){
            System.out.println("problem with backtracking: insert(0)");
        }
        kavim();
        tree.retrack();
        if(!isEquals(tree,"3 2 0 6 5 4 8 7 9","0 2 3 4 5 6 7 8 9")){
            System.out.println("problem with retracking: insert(0)");
        }
        kavim();
        tree.delete(tree.search(8));
        if(!isEquals(tree,"3 2 0 6 5 4 9 7","0 2 3 4 5 6 7 9")){
            System.out.println("problem with deleting: delete(8)");
        }
        kavim();
        tree.backtrack();
        if(!isEquals(tree,"3 2 0 6 5 4 8 7 9","0 2 3 4 5 6 7 8 9")){
            System.out.println("problem with backtracking: delete(8)");
        }
        kavim();
        tree.retrack();
        if(!isEquals(tree,"3 2 0 6 5 4 9 7","0 2 3 4 5 6 7 9")){
            System.out.println("problem with retracking: delete(8)");
        }
        kavim();
        tree.backtrack();
        if(!isEquals(tree,"3 2 0 6 5 4 8 7 9","0 2 3 4 5 6 7 8 9")){
            System.out.println("problem with backtracking: delete(8)");
        }
        kavim();
        tree.delete(tree.search(3));
        if(!isEquals(tree,"4 2 0 6 5 8 7 9","0 2 4 5 6 7 8 9")){
            System.out.println("problem with deleting: delete(3)");
        }
        kavim();
        tree.backtrack();
        if(!isEquals(tree,"3 2 0 6 5 4 8 7 9","0 2 3 4 5 6 7 8 9")){
            System.out.println("problem with backtracking: delete(3)");
        }
        kavim();
        tree.backtrack();
        if(!isEquals(tree,"3 2 6 5 4 8 7 9","2 3 4 5 6 7 8 9")){
            System.out.println("problem with backtracking: insert(0)");
        }
        kavim();
        tree.backtrack();
        if(!isEquals(tree,"3 2 6 5 4 8 9","2 3 4 5 6 8 9")){
            System.out.println("problem with backtracking: insert(7)");
        }
        kavim();
        tree.delete(tree.search(5));
        if(!isEquals(tree,"3 2 6 4 8 9","2 3 4 6 8 9")){
            System.out.println("problem with deleting: delete(5)");
        }
        kavim();
        tree.backtrack();
        if(!isEquals(tree,"3 2 6 5 4 8 9","2 3 4 5 6 8 9")){
            System.out.println("problem with backtracking: delete(5)");
        }
        kavim();
        tree.retrack();
        if(!isEquals(tree,"3 2 6 4 8 9","2 3 4 6 8 9")){
            System.out.println("problem with retracking: delete(5)");
        }
        kavim();
        tree.delete(tree.search(6));
        if(!isEquals(tree,"3 2 8 4 9","2 3 4 8 9")){
            System.out.println("problem with deleting: delete(6)");
        }
        kavim();
        tree.delete(tree.search(8));
        if(!isEquals(tree,"3 2 9 4","2 3 4 9")){
            System.out.println("problem with deleting: delete(8)");
        }
        kavim();
        tree.delete(tree.search(9));
        if(!isEquals(tree,"3 2 4","2 3 4")){
            System.out.println("problem with deleting: delete(9)");
        }
        kavim();
        tree.backtrack();
        if(!isEquals(tree,"3 2 9 4","2 3 4 9")){
            System.out.println("problem with backtracking: delete(9)");
        }
        kavim();
        tree.backtrack();
        if(!isEquals(tree,"3 2 8 4 9","2 3 4 8 9")){
            System.out.println("problem with backtracking: delete(8)");
        }
        kavim();
        tree.backtrack();
        if(!isEquals(tree,"3 2 6 4 8 9","2 3 4 6 8 9")){
            System.out.println("problem with backtracking: delete(6)");
        }
        kavim();
        tree.retrack();
        if(!isEquals(tree,"3 2 8 4 9","2 3 4 8 9")){
            System.out.println("problem with retracking: delete(6)");
        }
        kavim();
        tree.retrack();
        if(!isEquals(tree,"3 2 9 4","2 3 4 9")){
            System.out.println("problem with retracking: delete(8)");
        }
        kavim();
        tree.retrack();
        if(!isEquals(tree,"3 2 4","2 3 4")){
            System.out.println("problem with retracking: delete(9)");
        }
        kavim();
        tree.backtrack();
        if(!isEquals(tree,"3 2 9 4","2 3 4 9")){
            System.out.println("problem with backtracking: delete(9)");
        }
        kavim();
        tree.backtrack();
        if(!isEquals(tree,"3 2 8 4 9","2 3 4 8 9")){
            System.out.println("problem with backtracking: delete(8)");
        }
        kavim();
        tree.retrack();
        if(!isEquals(tree,"3 2 9 4","2 3 4 9")){
            System.out.println("problem with retracking: delete(8)");
        }
        kavim();
        tree.retrack();
        if(!isEquals(tree,"3 2 4","2 3 4")){
            System.out.println("problem with retracking: delete(9)");
        }
        kavim();
        tree.backtrack();
        if(!isEquals(tree,"3 2 9 4","2 3 4 9")){
            System.out.println("problem with backtracking: delete(9)");
        }
        kavim();
        tree.backtrack();
        if(!isEquals(tree,"3 2 8 4 9","2 3 4 8 9")){
            System.out.println("problem with backtracking: delete(8)");
        }
        kavim();
        correctParent(tree.getRoot());
        kavim();

    }
    public static void kavim(){
        System.out.println("-----------------------------------------------");
    }
    public static boolean isEquals(BacktrackingBST b,String p,String i){
        if(!PreOrder(b.getRoot()).strip().equals(p)){
            System.out.println("problem with PreOrder tree");
            System.out.println(PreOrder(b.getRoot()).strip());
        }
        if(!InOrder(b.getRoot()).strip().equals(i)){
            System.out.println("problem with InOrder tree");
            System.out.println(InOrder(b.getRoot()).strip());
        }
        else if(PreOrder(b.getRoot()).strip().equals(p)){
            System.out.println("passed");
        }
        return PreOrder(b.getRoot()).strip().equals(p) && InOrder(b.getRoot()).strip().equals(i);
    }
    private static String PreOrder(BacktrackingBST.Node node){
        String tree = "";
        if(node != null) {
            tree += node.getKey() + " ";
            tree += PreOrder(node.left);
            tree += PreOrder(node.right);
        }
        return tree;
    }
    private static String InOrder(BacktrackingBST.Node node){
        String tree = "";
        if(node != null) {
            tree += InOrder(node.left);
            tree += node.getKey() + " ";
            tree += InOrder(node.right);
        }
        return tree;
    }

    private static void correctParent(BacktrackingBST.Node root) {
        if (root.left != null) correctParent(root.left, root);
        if (root.right != null) correctParent(root.right, root);
        if (wrongPointers.isEmpty()) System.out.println("passed");
        else {
            while (!wrongPointers.isEmpty())
                System.out.println(wrongPointers.pop());
        }
    }
    private static void correctParent(BacktrackingBST.Node node,BacktrackingBST.Node nodesParent) {
        if (node.getParent() != null && node.getParent() != nodesParent) {
            wrongPointers.push("Node " + node.getKey() + "'s parent is not " + nodesParent.getKey());
            kavim();
        }
        if (node.left != null) correctParent(node.left, node);
        if (node.right != null) correctParent(node.right, node);
    }
}
