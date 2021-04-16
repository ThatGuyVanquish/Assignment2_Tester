import java.io.Console;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class tests {

    private static final Stack wrongPointers= new Stack(); // So far only used to test for wrong parent pointers
    public static void main(String[] args) {
        //test_Array_Insert();
        //test_Array_Search();
        //test_Array_Delete();
        //test_Array_Minimum();
        //test_Array_Maximum();
        //test_Array_Successor();
        //test_Array_Predecessor();
        //test_Array_Backtrack();
        //test_SortedArray_Insert();
        //test_SortedArray_Search();
        //test_SortedArray_Delete();
        //test_SortedArray_Minimum();
        //test_SortedArray_Maximum();
        //test_SortedArray_Successor();
        //test_SortedArray_Predecessor();
        //test_SortedArray_Backtrack();
        //test_BST_Insert();
        //test_BST_Search();
        //test_BST_Delete();
        //run_All_Tests();
        //run_Array_Tests();
        //run_SortedArray_Tests();
        //run_BST_Tests();
        //testBST();
    }
    public static void run_All_Tests(){
        run_Array_Tests();
        run_SortedArray_Tests();
        run_BST_Tests();
    }
    public static void run_Array_Tests(){
        System.out.println("running array tests");
        System.out.println("insert");
        test_Array_Insert();
        System.out.println("search");
        test_Array_Search();
        System.out.println("delete");
        test_Array_Delete();
        System.out.println("minimum");
        test_Array_Minimum();
        System.out.println("maximum");
        test_Array_Maximum();
        System.out.println("successor");
        test_Array_Successor();
        System.out.println("predecessor");
        test_Array_Predecessor();
        System.out.println("backtrack");
        test_Array_Backtrack();
    }
    public static void run_SortedArray_Tests(){
        System.out.println("running sorted array tests");
        System.out.println("insert");
        test_SortedArray_Insert();
        System.out.println("search");
        test_SortedArray_Search();
        System.out.println("delete");
        test_SortedArray_Delete();
        System.out.println("minimum");
        test_SortedArray_Minimum();
        System.out.println("maximum");
        test_SortedArray_Maximum();
        System.out.println("successor");
        test_SortedArray_Successor();
        System.out.println("predecessor");
        test_SortedArray_Predecessor();
        System.out.println("backtrack");
        test_SortedArray_Backtrack();
    }
    public static void run_BST_Tests(){

    }
    public static void test_Array_Insert(){
        boolean passed = true;
        BacktrackingArray array1 = new BacktrackingArray(new Stack(),17);
        BacktrackingArray array2 = new BacktrackingArray(new Stack(),3);
        BacktrackingArray array3 = new BacktrackingArray(new Stack(),0);
        BacktrackingArray[] b = {array1,array2,array3};
        int[] arr1 = {3,5,1,8,23,6,92,34,2,9};
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
               System.out.println();
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
    private static boolean isArrayEquals(BacktrackingSortedArray array,int[] arr, int size){
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
    private static void InsertToArray(BacktrackingSortedArray array,int[] arr,int size){
        for(int i = 0;i < size;i++){
            array.insert(arr[i]);
        }
    }
    public static void test_Array_Search() {
        boolean passed = true;
        BacktrackingArray array1 = new BacktrackingArray(new Stack(), 17);
        BacktrackingArray array2 = new BacktrackingArray(new Stack(), 3);
        BacktrackingArray array3 = new BacktrackingArray(new Stack(), 0);
        BacktrackingArray[] b = {array1, array2, array3};
        int[] arr1 = {3, 5, 1, 8, 23, 6, 92, 34, 2, 9};
        int[] arr2 = {3, 4, 2};
        int[] arr3 = {};
        int[][] d = {arr1, arr2, arr3};
        int size1 = 6, size2 = 3, size3 = 0;
        int[][] inputs = {{5, 4, 8, 34}, {2, 6, 4}, {1}};
        int[][] outputs = {{1, -1, 3, -1}, {2, -1, 1}, {-1}};
        int[] sizes = {size1, size2, size3};
        for (int i = 0; i < b.length; i++) {
            InsertToArray(b[i], d[i], sizes[i]);
            for (int j = 0; j < inputs[i].length; j++) {
                if (b[i].search(inputs[i][j]) != outputs[i][j]) {
                    passed = false;
                    System.out.println("failed on search, expected: " + outputs[i][j] + " actual: " + b[i].search(inputs[i][j]));
                }
            }
        }
        if (passed) System.out.println("passed all tests");
    }
    public static void test_Array_Delete(){
        boolean passed = true;
        BacktrackingArray array1 = new BacktrackingArray(new Stack(), 17);
        BacktrackingArray array2 = new BacktrackingArray(new Stack(), 3);
        BacktrackingArray array3 = new BacktrackingArray(new Stack(), 0);
        BacktrackingArray[] b = {array1, array2, array3};
        int[] arr1 = {3, 5, 1, 8, 23, 6, 92, 34, 2, 9};
        int[] arr2 = {3, 4, 2};
        int[] arr3 = {};
        int[][] d = {arr1, arr2, arr3};
        int size1 = 6, size2 = 3, size3 = 0;
        int[][] inputs = {{5, 4, -1, 34}, {2, 6, 4}, {0}};
        int[] out1 = {3, 5, 1, 8, 23};
        int[] out2 = {3, 5, 1, 8};
        int[] out3 = {3, 4};
        Object[][] outputs = {{out1, out2,-1, -1}, {out3, -1, -1}, {-1}};
        int[] sizes = {size1, size2, size3};
        for (int i = 0; i < b.length; i++) {
            InsertToArray(b[i], d[i], sizes[i]);
            for (int j = 0; j < inputs[i].length; j++) {
                try {
                    b[i].delete(inputs[i][j]);
                    if(outputs[i][j].toString().equals("-1")){
                        passed = false;
                        System.out.print("failed on delete, expected to throw an exception, actual: ");
                        b[i].print();
                        System.out.println();
                    }
                    else if(!isArrayEquals(b[i],(int[])outputs[i][j],--sizes[i])){
                        passed = false;
                        System.out.print("failed on delete, expected: " + Arrays.toString((int[])outputs[i][j]) + " actual: ");
                        b[i].print();
                        System.out.println();
                    }
                }
                catch (Exception e) {
                    if (-1 != (int) outputs[i][j]) {
                        passed = false;
                        System.out.println("failed on delete, expected: " + Arrays.toString((int[])outputs[i][j]) + " actual: " + e.getMessage());
                    }
                }
            }
        }
        if (passed) System.out.println("passed all tests");
    }
    public static void test_Array_Minimum(){
        boolean passed = true;
        BacktrackingArray array1 = new BacktrackingArray(new Stack(), 17);
        BacktrackingArray array2 = new BacktrackingArray(new Stack(), 3);
        BacktrackingArray array3 = new BacktrackingArray(new Stack(), 0);
        BacktrackingArray[] b = {array1, array2, array3};
        int[] arr1 = {3, 5, 1, 8, 23, 6, 92, 34, 2, 9};
        int[] arr2 = {3, 4, 2};
        int[] arr3 = {};
        int[][] d = {arr1, arr2, arr3};
        int size1 = 6, size2 = 3, size3 = 0;
        int[] outputs = {2,2,-1};
        int[] sizes = {size1, size2, size3};
        for (int i = 0; i < b.length; i++) {
            InsertToArray(b[i], d[i], sizes[i]);
            try {
                if(b[i].minimum() != outputs[i]){
                    passed = false;
                    if(outputs[i] == -1){
                        System.out.println("failed on minimum, expected to throw an exception, actual: " + b[i].minimum());
                    }
                    else {
                        System.out.println("failed on minimum, expected: " + outputs[i] + " actual: " + b[i].minimum());
                    }
                }
            }
            catch (Exception e){
                if(outputs[i] != -1) {
                    passed = false;
                    System.out.println("failed on minimum expected: " + outputs[i] + " actual: "+ e.getMessage());
                }
            }
        }
        if (passed) System.out.println("passed all tests");
    }
    public static void test_Array_Maximum(){
        boolean passed = true;
        BacktrackingArray array1 = new BacktrackingArray(new Stack(), 17);
        BacktrackingArray array2 = new BacktrackingArray(new Stack(), 3);
        BacktrackingArray array3 = new BacktrackingArray(new Stack(), 0);
        BacktrackingArray[] b = {array1, array2, array3};
        int[] arr1 = {3, 5, 1, 8, 23, 6, 92, 34, 2, 9};
        int[] arr2 = {3, 4, 2};
        int[] arr3 = {};
        int[][] d = {arr1, arr2, arr3};
        int size1 = 6, size2 = 3, size3 = 0;
        int[] outputs = {4,1,-1};
        int[] sizes = {size1, size2, size3};
        for (int i = 0; i < b.length; i++) {
            InsertToArray(b[i], d[i], sizes[i]);
            try {
                if(b[i].maximum() != outputs[i]){
                    passed = false;
                    if(outputs[i] == -1){
                        System.out.println("failed on maximum, expected to throw an exception, actual: " + b[i].maximum());
                    }
                    else {
                        System.out.println("failed on maximum, expected: " + outputs[i] + " actual: " + b[i].maximum());
                    }
                }
            }
            catch (Exception e){
                if(outputs[i] != -1) {
                    passed = false;
                    System.out.println("failed on maximum expected: " + outputs[i] + " actual: "+ e.getMessage());
                }
            }
        }
        if (passed) System.out.println("passed all tests");
    }
    public static void test_Array_Successor(){
        boolean passed = true;
        BacktrackingArray array1 = new BacktrackingArray(new Stack(), 17);
        BacktrackingArray array2 = new BacktrackingArray(new Stack(), 3);
        BacktrackingArray array3 = new BacktrackingArray(new Stack(), 0);
        BacktrackingArray[] b = {array1, array2, array3};
        int[] arr1 = {3, 5, 1, 8, 23, 6, 92, 34, 2, 9};
        int[] arr2 = {3, 4, 2};
        int[] arr3 = {};
        int[][] d = {arr1, arr2, arr3};
        int size1 = 6, size2 = 3, size3 = 0;
        int[] inputs = {4,0,0};
        int[] outputs = {-1,1,-1};
        int[] sizes = {size1, size2, size3};
        for (int i = 0; i < b.length; i++) {
            InsertToArray(b[i], d[i], sizes[i]);
            try {
                if(b[i].successor(inputs[i]) != outputs[i]){
                    passed = false;
                    if(outputs[i] == -1){
                        System.out.println("failed on successor, expected to throw an exception, actual: " + b[i].successor(inputs[i]));
                    }
                    else {
                        System.out.println("failed on successor, expected: " + outputs[i] + " actual: " + b[i].successor(inputs[i]));
                    }
                }
            }
            catch (Exception e){
                if(outputs[i] != -1) {
                    passed = false;
                    System.out.println("failed on successor, expected: " + outputs[i] + " actual: "+ e.getMessage());
                }
            }
        }
        if (passed) System.out.println("passed all tests");
    }
    public static void test_Array_Predecessor(){
        boolean passed = true;
        BacktrackingArray array1 = new BacktrackingArray(new Stack(), 17);
        BacktrackingArray array2 = new BacktrackingArray(new Stack(), 3);
        BacktrackingArray array3 = new BacktrackingArray(new Stack(), 0);
        BacktrackingArray[] b = {array1, array2, array3};
        int[] arr1 = {3, 5, 1, 8, 23, 6, 92, 34, 2, 9};
        int[] arr2 = {3, 4, 2};
        int[] arr3 = {};
        int[][] d = {arr1, arr2, arr3};
        int size1 = 6, size2 = 3, size3 = 0;
        int[] inputs = {2,0,0};
        int[] outputs = {-1,2,-1};
        int[] sizes = {size1, size2, size3};
        for (int i = 0; i < b.length; i++) {
            InsertToArray(b[i], d[i], sizes[i]);
            try {
                if(b[i].predecessor(inputs[i]) != outputs[i]){
                    passed = false;
                    if(outputs[i] == -1){
                        System.out.println("failed on predecessor, expected to throw an exception, actual: " + b[i].predecessor(inputs[i]));
                    }
                    else {
                        System.out.println("failed on predecessor, expected: " + outputs[i] + " actual: " + b[i].predecessor(inputs[i]));
                    }
                }
            }
            catch (Exception e){
                if(outputs[i] != -1) {
                    passed = false;
                    System.out.println("failed on predecessor, expected: " + outputs[i] + " actual: "+ e.getMessage());
                }
            }
        }
        if (passed) System.out.println("passed all tests");
    }
    public static void test_Array_Backtrack(){
        boolean passed = true;
        BacktrackingArray array1 = new BacktrackingArray(new Stack(), 17);
        BacktrackingArray array2 = new BacktrackingArray(new Stack(), 3);
        BacktrackingArray array3 = new BacktrackingArray(new Stack(), 0);
        BacktrackingArray[] b = {array1, array2, array3};
        int[] arr1 = {3, 5, 1, 8, 23,6};
        int[] arr2 = {3, 4, 2};
        int[] arr3 = {};
        int[][] d = {arr1, arr2, arr3};
        int size1 = 6, size2 = 3, size3 = 0;
        int[][] inputs = {{1,0}, {1}, {}};
        int[] sizes = {size1, size2, size3};
        for (int i = 0; i < b.length; i++) {
            InsertToArray(b[i], d[i], sizes[i]);
            for (int j = 0; j < inputs[i].length; j++) {
                try {
                    if(inputs[i][j] == 1) {
                        b[i].delete(inputs[i][j]);
                        b[i].backtrack();
                        if(!isArrayEquals(b[i],d[i],sizes[i])){
                            passed = false;
                            System.out.print("failed in backtrack(Delete), expected: " + Arrays.toString(d[i]) + " actual: ");
                            b[i].print();
                            System.out.println();
                        }
                    }
                    else{
                        b[i].insert(inputs[i][j]);
                        b[i].backtrack();
                        if(!isArrayEquals(b[i],d[i],sizes[i])) {
                            passed = false;
                            System.out.print("failed in backtrack(Insert), expected: " + Arrays.toString(d[i]) + " actual: ");
                            b[i].print();
                            System.out.println();
                        }
                    }
                }
                catch (Exception e) {
                    passed = false;
                    if(inputs[i][j] == 1) {
                        System.out.println("failed on delete, expected: no exception, " + "actual: " + e.getMessage());
                    }
                    else{
                        System.out.println("failed on insert, expected: no exception, " + "actual: " + e.getMessage());
                    }
                }
            }
        }
        if (passed) System.out.println("passed all tests");
    }
    public static void test_SortedArray_Insert(){
        boolean passed = true;
        BacktrackingSortedArray array1 = new BacktrackingSortedArray(new Stack(),17);
        BacktrackingSortedArray array2 = new BacktrackingSortedArray(new Stack(),3);
        BacktrackingSortedArray array3 = new BacktrackingSortedArray(new Stack(),0);
        BacktrackingSortedArray[] b = {array1,array2,array3};
        int[] arr1 = {1,2,3,5,6,8,9,23,34,92};
        int[] arr2 = {2,3,4};
        int[] arr3 = {};
        int[][] d = {arr1,arr2,arr3};
        int size1 = 6,size2 = 3,size3 = 0;
        int[] sizes = {size1,size2,size3};
        for(int i = 0;i < b.length;i++){
            InsertToArray(b[i],d[i],sizes[i]);
            if(!isArrayEquals(b[i],d[i],sizes[i])){
                passed = false;
                System.out.print("failed in insertion to sorted array ");
                b[i].print();
                System.out.println();
            }
        }
        if(passed) System.out.println("passed all tests");
    }
    public static void test_SortedArray_Search(){
        boolean passed = true;
        BacktrackingSortedArray array1 = new BacktrackingSortedArray(new Stack(),17);
        BacktrackingSortedArray array2 = new BacktrackingSortedArray(new Stack(),3);
        BacktrackingSortedArray array3 = new BacktrackingSortedArray(new Stack(),0);
        BacktrackingSortedArray[] b = {array1,array2,array3};
        int[] arr1 = {1,2,3,5,6,8,9,23,34,92};
        int[] arr2 = {2,3,4};
        int[] arr3 = {};
        int[][] d = {arr1,arr2,arr3};
        int size1 = 6,size2 = 3,size3 = 0;
        int[][] inputs = {{5, 4, 8, 34}, {2, 6, 4}, {1}};
        int[][] outputs = {{3, -1, 5, -1}, {0, -1, 2}, {-1}};
        int[] sizes = {size1, size2, size3};
        for (int i = 0; i < b.length; i++) {
            InsertToArray(b[i], d[i], sizes[i]);
            for (int j = 0; j < inputs[i].length; j++) {
                if (b[i].search(inputs[i][j]) != outputs[i][j]) {
                    passed = false;
                    System.out.println("failed on search, expected: " + outputs[i][j] + " actual: " + b[i].search(inputs[i][j]));
                }
            }
        }
        if (passed) System.out.println("passed all tests");
    }
    public static void test_SortedArray_Delete(){
        boolean passed = true;
        BacktrackingSortedArray array1 = new BacktrackingSortedArray(new Stack(),17);
        BacktrackingSortedArray array2 = new BacktrackingSortedArray(new Stack(),3);
        BacktrackingSortedArray array3 = new BacktrackingSortedArray(new Stack(),0);
        BacktrackingSortedArray[] b = {array1,array2,array3};
        int[] arr1 = {1,2,3,5,6,8,9,23,34,92};
        int[] arr2 = {2,3,4};
        int[] arr3 = {};
        int[][] d = {arr1,arr2,arr3};
        int size1 = 6,size2 = 3,size3 = 0;
        int[][] inputs = {{5, 4, -1, 34}, {2, 6, 4}, {0}};
        int[] out1 = {1, 2, 3, 5, 6};
        int[] out2 = {1,2,3,5};
        int[] out3 = {2,3};
        Object[][] outputs = {{out1, out2,-1, -1}, {out3, -1, -1}, {-1}};
        int[] sizes = {size1, size2, size3};
        for (int i = 0; i < b.length; i++) {
            InsertToArray(b[i], d[i], sizes[i]);
            for (int j = 0; j < inputs[i].length; j++) {
                try {
                    b[i].delete(inputs[i][j]);
                    if(outputs[i][j].toString().equals("-1")){
                        passed = false;
                        System.out.print("failed on delete, expected to throw an exception, actual: ");
                        b[i].print();
                        System.out.println();
                    }
                    else if(!isArrayEquals(b[i],(int[])outputs[i][j],--sizes[i])){
                        passed = false;
                        System.out.print("failed on delete, expected: " + Arrays.toString((int[])outputs[i][j]) + " actual: ");
                        b[i].print();
                        System.out.println();
                    }
                }
                catch (Exception e) {
                    if (-1 != (int) outputs[i][j]) {
                        passed = false;
                        System.out.println("failed on delete, expected: " + Arrays.toString((int[])outputs[i][j]) + " actual: " + e.getMessage());
                    }
                }
            }
        }
        if (passed) System.out.println("passed all tests");
    }
    public static void test_SortedArray_Minimum(){
        boolean passed = true;
        BacktrackingSortedArray array1 = new BacktrackingSortedArray(new Stack(),17);
        BacktrackingSortedArray array2 = new BacktrackingSortedArray(new Stack(),3);
        BacktrackingSortedArray array3 = new BacktrackingSortedArray(new Stack(),0);
        BacktrackingSortedArray[] b = {array1,array2,array3};
        int[] arr1 = {1,2,3,5,6,8,9,23,34,92};
        int[] arr2 = {2,3,4};
        int[] arr3 = {};
        int[][] d = {arr1,arr2,arr3};
        int size1 = 6,size2 = 3,size3 = 0;
        int[] outputs = {0,0,-1};
        int[] sizes = {size1, size2, size3};
        for (int i = 0; i < b.length; i++) {
            InsertToArray(b[i], d[i], sizes[i]);
            try {
                if(b[i].minimum() != outputs[i]){
                    passed = false;
                    if(outputs[i] == -1){
                        System.out.println("failed on minimum, expected to throw an exception, actual: " + b[i].minimum());
                    }
                    else {
                        System.out.println("failed on minimum, expected: " + outputs[i] + " actual: " + b[i].minimum());
                    }
                }
            }
            catch (Exception e){
                if(outputs[i] != -1) {
                    passed = false;
                    System.out.println("failed on minimum expected: " + outputs[i] + " actual: "+ e.getMessage());
                }
            }
        }
        if (passed) System.out.println("passed all tests");
    }
    public static void test_SortedArray_Maximum(){
        boolean passed = true;
        BacktrackingSortedArray array1 = new BacktrackingSortedArray(new Stack(),17);
        BacktrackingSortedArray array2 = new BacktrackingSortedArray(new Stack(),3);
        BacktrackingSortedArray array3 = new BacktrackingSortedArray(new Stack(),0);
        BacktrackingSortedArray[] b = {array1,array2,array3};
        int[] arr1 = {1,2,3,5,6,8,9,23,34,92};
        int[] arr2 = {2,3,4};
        int[] arr3 = {};
        int[][] d = {arr1,arr2,arr3};
        int size1 = 6,size2 = 3,size3 = 0;
        int[] outputs = {5,2,-1};
        int[] sizes = {size1, size2, size3};
        for (int i = 0; i < b.length; i++) {
            InsertToArray(b[i], d[i], sizes[i]);
            try {
                if(b[i].maximum() != outputs[i]){
                    passed = false;
                    if(outputs[i] == -1){
                        System.out.println("failed on maximum, expected to throw an exception, actual: " + b[i].maximum());
                    }
                    else {
                        System.out.println("failed on maximum, expected: " + outputs[i] + " actual: " + b[i].maximum());
                    }
                }
            }
            catch (Exception e){
                if(outputs[i] != -1) {
                    passed = false;
                    System.out.println("failed on maximum expected: " + outputs[i] + " actual: "+ e.getMessage());
                }
            }
        }
        if (passed) System.out.println("passed all tests");
    }
    public static void test_SortedArray_Successor(){
        boolean passed = true;
        BacktrackingSortedArray array1 = new BacktrackingSortedArray(new Stack(),17);
        BacktrackingSortedArray array2 = new BacktrackingSortedArray(new Stack(),3);
        BacktrackingSortedArray array3 = new BacktrackingSortedArray(new Stack(),0);
        BacktrackingSortedArray[] b = {array1,array2,array3};
        int[] arr1 = {1,2,3,5,6,8,9,23,34,92};
        int[] arr2 = {2,3,4};
        int[] arr3 = {};
        int[][] d = {arr1,arr2,arr3};
        int size1 = 6,size2 = 3,size3 = 0;
        int[] inputs = {4,0,0};
        int[] outputs = {5,1,-1};
        int[] sizes = {size1, size2, size3};
        for (int i = 0; i < b.length; i++) {
            InsertToArray(b[i], d[i], sizes[i]);
            try {
                if(b[i].successor(inputs[i]) != outputs[i]){
                    passed = false;
                    if(outputs[i] == -1){
                        System.out.println("failed on successor, expected to throw an exception, actual: " + b[i].successor(inputs[i]));
                    }
                    else {
                        System.out.println("failed on successor, expected: " + outputs[i] + " actual: " + b[i].successor(inputs[i]));
                    }
                }
            }
            catch (Exception e){
                if(outputs[i] != -1) {
                    passed = false;
                    System.out.println("failed on successor, expected: " + outputs[i] + " actual: "+ e.getMessage());
                }
            }
        }
        if (passed) System.out.println("passed all tests");
    }
    public static void test_SortedArray_Predecessor(){
        boolean passed = true;
        BacktrackingSortedArray array1 = new BacktrackingSortedArray(new Stack(),17);
        BacktrackingSortedArray array2 = new BacktrackingSortedArray(new Stack(),3);
        BacktrackingSortedArray array3 = new BacktrackingSortedArray(new Stack(),0);
        BacktrackingSortedArray[] b = {array1,array2,array3};
        int[] arr1 = {1,2,3,5,6,8,9,23,34,92};
        int[] arr2 = {2,3,4};
        int[] arr3 = {};
        int[][] d = {arr1,arr2,arr3};
        int size1 = 6,size2 = 3,size3 = 0;
        int[] inputs = {0,1,0};
        int[] outputs = {-1,0,-1};
        int[] sizes = {size1, size2, size3};
        for (int i = 0; i < b.length; i++) {
            InsertToArray(b[i], d[i], sizes[i]);
            try {
                if(b[i].predecessor(inputs[i]) != outputs[i]){
                    passed = false;
                    if(outputs[i] == -1){
                        System.out.println("failed on predecessor, expected to throw an exception, actual: " + b[i].predecessor(inputs[i]));
                    }
                    else {
                        System.out.println("failed on predecessor, expected: " + outputs[i] + " actual: " + b[i].predecessor(inputs[i]));
                    }
                }
            }
            catch (Exception e){
                if(outputs[i] != -1) {
                    passed = false;
                    System.out.println("failed on predecessor, expected: " + outputs[i] + " actual: "+ e.getMessage());
                }
            }
        }
        if (passed) System.out.println("passed all tests");
    }
    public static void test_SortedArray_Backtrack(){
        boolean passed = true;
        BacktrackingSortedArray array1 = new BacktrackingSortedArray(new Stack(),17);
        BacktrackingSortedArray array2 = new BacktrackingSortedArray(new Stack(),3);
        BacktrackingSortedArray array3 = new BacktrackingSortedArray(new Stack(),0);
        BacktrackingSortedArray[] b = {array1,array2,array3};
        int[] arr1 = {1,2,3,5,6,8,9,23,34,92};
        int[] arr2 = {2,3,4};
        int[] arr3 = {};
        int[][] d = {arr1,arr2,arr3};
        int size1 = 6,size2 = 3,size3 = 0;
        int[][] inputs = {{1,0}, {1}, {}};
        int[] sizes = {size1, size2, size3};
        for (int i = 0; i < b.length; i++) {
            InsertToArray(b[i], d[i], sizes[i]);
            for (int j = 0; j < inputs[i].length; j++) {
                try {
                    if(inputs[i][j] == 1) {
                        b[i].delete(inputs[i][j]);
                        b[i].backtrack();
                        if(!isArrayEquals(b[i],d[i],sizes[i])){
                            passed = false;
                            System.out.print("failed in backtrack(Delete), expected: " + Arrays.toString(d[i]) + " actual: ");
                            b[i].print();
                            System.out.println();
                        }
                    }
                    else{
                        b[i].insert(inputs[i][j]);
                        b[i].backtrack();
                        if(!isArrayEquals(b[i],d[i],sizes[i])) {
                            passed = false;
                            System.out.print("failed in backtrack(Insert), expected: " + Arrays.toString(d[i]) + " actual: ");
                            b[i].print();
                            System.out.println();
                        }
                    }
                }
                catch (Exception e) {
                    passed = false;
                    if(inputs[i][j] == 1) {
                        System.out.println("failed on delete, expected: no exception, " + "actual: " + e.getMessage());
                    }
                    else{
                        System.out.println("failed on insert, expected: no exception, " + "actual: " + e.getMessage());
                    }
                }
            }
        }
        if (passed) System.out.println("passed all tests");
    }
    public static void test_BST_Insert(){
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
        if (!isEquals(tree,"3 2 0 1 6 5 4 8 7 9","0 1 2 3 4 5 6 7 8 9"))
            System.out.println("Bad insertion, wrong population of nodes in BST");
    }
    public static void test_BST_Search(){
        BacktrackingBST tree = new BacktrackingBST(new Stack(), new Stack());
        BacktrackingBST.Node[] nodes = {
            new BacktrackingBST.Node(3, null),
            new BacktrackingBST.Node(6, null),
            new BacktrackingBST.Node(2, null),
            new BacktrackingBST.Node(5, null),
            new BacktrackingBST.Node(4, null),
            new BacktrackingBST.Node(8, null),
            new BacktrackingBST.Node(9, null),
            new BacktrackingBST.Node(7, null),
            new BacktrackingBST.Node(0, null),
            new BacktrackingBST.Node(1, null)};
        for (BacktrackingBST.Node node:nodes) tree.insert(node);
        BacktrackingBST.Node notInTree = new BacktrackingBST.Node(50, null);
        boolean passed = true;
        for (BacktrackingBST.Node node: nodes) {
            try {
                if (tree.search(node.getKey()) == null)
                    {
                        System.out.println("failed in search, nodes not inserted to tree properly via insert method");
                        passed = false;
                    }
            }
            catch (Exception e) {
                System.out.println("failed on search, expected: no exception, got " + e.getMessage());
            }
        }
        try {
            if (tree.search(notInTree.getKey()) != null) {
                System.out.println("failed in search, got a pointer to a node that should not exist in the tree");
                passed = false;
            }
        }
        catch (Exception e) {
            System.out.println("failed on search, exception thrown instead of returning null if node not found. expected: no exception, got " + e.getMessage());
        }
        /* Check for same node in memory, not necessarily needed therefore commented out
        BacktrackingBST.Node differentFive = new BacktrackingBST.Node(5, "bad node");
        if (specialSauce(differentFive, tree)) {
            System.out.println("failed in search, got a pointer to a node of the same key but not the same node in memory");
            passed = false
        }*/
        if (passed) System.out.println("passed all tests");
    }

    private static boolean specialSauce(BacktrackingBST.Node node, BacktrackingBST tree) {
        return (node == tree.search(node.getKey()));
    }

    public static void test_BST_Delete(){
        boolean passed = true;
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
        try {
            if (!isEquals(tree, "3 2 0 1 6 5 4 8 7 9", "0 1 2 3 4 5 6 7 8 9")) {
                System.out.println("Bad insertion, wrong population of nodes in BST");
                passed = false;
            }
            tree.delete(keyFour);
            if (!isEquals(tree, "3 2 0 1 6 5 8 7 9", "0 1 2 3 5 6 7 8 9")) {
                System.out.println("failed on delete(4), case of node deletion when node is a leaf");
                passed = false;
            }
            tree.delete(keyTwo);
            if (!isEquals(tree, "3 0 1 6 5 8 7 9", "0 1 3 5 6 7 8 9")) {
                System.out.println("failed on delete(2), case of node deletion with a single child");
                passed = false;
            }
            tree.delete(keyEight);
            if (!isEquals(tree, "3 0 1 6 5 9 7", "0 1 3 5 6 7 9")) {
                System.out.println("failed on delete(8), case of node deletion with two children, when successor has no children of it's own");
                passed = false;
            }
            tree.insert(keyEight); // forcing 7 successor of 6 to have 1 child
            tree.delete(keySix);
            if (!isEquals(tree, "3 0 1 7 5 9 8", "0 1 3 5 7 8 9")) {
                System.out.println("failed on delete(6), case of node deletion with two children, when successor has a right child");
                passed = false;
            }
        }
        catch (Exception e) {
            System.out.println("failed on delete, expected: no exception, got " + e.getMessage());
        }
        if (passed) System.out.println("passed all tests");
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
    
    private static boolean correctInsert(BacktrackingBST.Node node, BacktrackingBST tree) {
        /*if (node.getParent() == null && node != tree.getRoot()) {
            System.out.println("Node's parent field wasn't updated properly");
            return false;
        }
        if (node.getParent() != null) {
            BacktrackingBST.Node currentNode = tree.search(node.getParent().getKey());
            if (currentNode == null) {
                System.out.println("Wrong pointer for " + node.getKey() + "'s parent (I.E. It's not in the tree, check parent pointer change is correct");
                return false;
            } else if (currentNode.left != node && currentNode.right != node) {
                System.out.println("Wrong child pointer for " + node.getKey() + "'s parent left or right child, meaning node wasn't inserted properly");
            }
        }
        System.out.println("passed");*/
        return true;
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
