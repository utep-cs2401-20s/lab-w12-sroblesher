import static org.junit.jupiter.api.Assertions.*;

class myBinarySearchTreeNodeTester {

    /*1st test case: Tests "insert" method by creating BST and then
    * comparing the expected node with assertEquals or using assertNull when expecting
    * a node position to be NULL */
    //STATUS: PASSED
    @org.junit.jupiter.api.Test
    void insert() {
        int[] a = {10,8,12,11,3};
        myBinarySearchTreeNode tree = new myBinarySearchTreeNode(a);
        tree.print();

        //LEFT SIDE OF THE TREE
        assertEquals(10, tree.myValue);
        assertEquals(8, tree.left.myValue);
        assertEquals(3, tree.left.left.myValue);
        assertNull(tree.left.left.left);
        assertNull(tree.left.left.right);
        assertNull(tree.left.right);
        //RIGHT SIDE OF THE TREE
        assertEquals(12, tree.right.myValue);
        assertEquals(11, tree.right.left.myValue);
        assertNull(tree.right.left.left);
        assertNull(tree.right.left.right);
        assertNull(tree.right.right);
    }

    /*2nd test case: Checks if "height" method works properly. The tree to be tested
    * isn't a COMPLETE or PERFECT tree, therefore the right side of a node could have
    * greater height than in the left side of the tree*/
    //STATUS: PASSED
    @org.junit.jupiter.api.Test
    void height() {
        int[] a = {10,8,11,12,9,7,6,3};
        myBinarySearchTreeNode tree = new myBinarySearchTreeNode(a);
        tree.print();
        assertEquals(4, tree.height());
    }

    /*3rd test case: This tests method "depth", specifically when the node that is
    * required to find it's depth is STRICTLY in the tree, so there is no worries
    * about the result being -1*/
    //STATUS: PASSED
    @org.junit.jupiter.api.Test
    void depth1() {
        int[] a = {10,3,8,11,12,9,7,5};
        myBinarySearchTreeNode tree = new myBinarySearchTreeNode(a);
        tree.print();
        assertEquals(3, tree.depth(9));
    }

    /*4th test case: Checks the edge case when the value of the node that is required to find
    * it's depth IS NOT in the tree, therefore the result MUST be -1, and finally it should print
    * a message in the Console that shows why the outputs is -1*/
    //STATUS: PASSED
    @org.junit.jupiter.api.Test
    void depth2() {
        int[] a = {10,8,12,19,7};
        myBinarySearchTreeNode tree = new myBinarySearchTreeNode(a);
        tree.print();
        assertEquals(-1, tree.depth(1000));
    }

    /*5th test case: This tests the "size" method, which traverses the full tree and
    * counts each node to find the total amount of nodes/values in the tree.
    * Note that: the output is the length of the array passed as a parameter
    * when first constructing the tree*/
    //STATUS: PASSED
    @org.junit.jupiter.api.Test
    void size() {
        int[] a = {10,8,11,12,9,7};
        myBinarySearchTreeNode tree = new myBinarySearchTreeNode(a);
        tree.print();
        assertEquals(6, tree.size());
    }
}