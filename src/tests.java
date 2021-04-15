import java.util.Scanner;

public class tests {

    private static final Stack wrongPointers= new Stack(); // So far only used to test for wrong parent pointers
    public static void main(String[] args) {
        testBST();
    }
    public static void run_All_Tests(){
        run_Array_Tests();
        run_SortedArray_Tests();
        run_BST_Tests();
    }
    public static void run_Array_Tests(){

    }
    public static void run_SortedArray_Tests(){

    }
    public static void run_BST_Tests(){

    }
    public static void test_Array_Insert(){
        boolean passed = true;
        BacktrackingArray array1 = new BacktrackingArray(new Stack(),17);
        BacktrackingArray array2 = new BacktrackingArray(new Stack(),3);
        BacktrackingArray array3 = new BacktrackingArray(new Stack(),0);
        BacktrackingArray[] b = {array1,array2,array3};
        int[] arr1 = {3,5,1,8,23,6,92,34,2,1};
        int[] arr2 = {3,4,2};
        int[] arr3 = {};
        int[][] d = {arr1,arr2,arr3};
        int size1 = 6,size2 = 3,size3 = 0;
        int[] sizes = {size1,size2,size3};
        for(int i = 0;i < b.length;i++){
            InsertToArray(b[i],d[i],sizes[i]);
            if(!isArrayEquals(b[i],d[i],sizes[i])){
               passed = false;
               System.out.print("failed in insertion to array ");
               b[i].print();
            }
        }
        if(passed) System.out.println("passed all tests");
    }
    private static boolean isArrayEquals(BacktrackingArray array,int[] arr, int size){
        for(int i = 0;i < size;i++){
            if(arr[i] != array.get(i)) return false;
        }
        return true;
    }
    private static void InsertToArray(BacktrackingArray array,int[] arr,int size){
        for(int i = 0;i < size;i++){
            array.insert(arr[i]);
        }
    }

    public static void test_Array_Search(){
        BacktrackingArray array1 = new BacktrackingArray(new Stack(),17);
        BacktrackingArray array2 = new BacktrackingArray(new Stack(),3);
        BacktrackingArray array3 = new BacktrackingArray(new Stack(),0);
        int[] arr = {};
    }
    public static void test_Array_Delete(){

    }
    public static void test_Array_Minimum(){

    }
    public static void test_Array_Maximum(){

    }
    public static void test_Array_Successor(){

    }
    public static void test_Array_Predecessor(){

    }
    public static void test_Array_Backtrack(){

    }
    public static void test_SortedArray_Insert(){

    }
    public static void test_SortedArray_Search(){

    }
    public static void test_SortedArray_Delete(){

    }
    public static void test_SortedArray_Minimum(){

    }
    public static void test_SortedArray_Maximum(){

    }
    public static void test_SortedArray_Successor(){

    }
    public static void test_SortedArray_Predecessor(){

    }
    public static void test_SortedArray_Backtrack(){

    }
    public static void test_BST_Insert(){

    }
    public static void test_BST_Search(){

    }
    public static void test_BST_Delete(){

    }
    public static void test_BST_Minimum(){

    }
    public static void test_BST_Maximum(){

    }
    public static void test_BST_Successor(){

    }
    public static void test_BST_Predecessor(){

    }
    public static void test_BST_Backtrack(){

    }
    public static void test_BST_Retrack(){

    }


    public static void testBST(){
        BacktrackingBST tree = new BacktrackingBST(new Stack(), new Stack());
        BacktrackingBST.Node keyThree = new BacktrackingBST.Node(3, null);
        BacktrackingBST.Node keySix = new BacktrackingBST.Node(6, null);
        BacktrackingBST.Node keyTwo = new BacktrackingBST.Node(2, null);
        BacktrackingBST.Node keyFive = new BacktrackingBST.Node(5, null);
        BacktrackingBST.Node keyFour = new BacktrackingBST.Node(4, null);
        BacktrackingBST.Node keyEight = new BacktrackingBST.Node(8, null);
        BacktrackingBST.Node keyNine = new BacktrackingBST.Node(9, null);
        BacktrackingBST.Node keySeven = new BacktrackingBST.Node(7, null);
        BacktrackingBST.Node keyZero = new BacktrackingBST.Node(0, null);
        BacktrackingBST.Node keyOne = new BacktrackingBST.Node(1, null);
        tree.insert(keyThree);
        tree.insert(keySix);
        tree.insert(keyTwo);
        tree.insert(keyFive);
        tree.insert(keyFour);
        tree.insert(keyEight);
        tree.insert(keyNine);
        tree.insert(keySeven);
        tree.insert(keyZero);
        tree.insert(keyOne);

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
    public static boolean isEquals(BacktrackingBST b,String p,String i){// get tree and it supposed PreOrder and InOrder scans, return true if it fits
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
       /* if (node.getParent() != null && node.getParent() != nodesParent) {
            wrongPointers.push("Node " + node.getKey() + "'s parent is not " + nodesParent.getKey());
            kavim();
        }
        if (node.left != null) correctParent(node.left, node);
        if (node.right != null) correctParent(node.right, node);*/
    }
}
