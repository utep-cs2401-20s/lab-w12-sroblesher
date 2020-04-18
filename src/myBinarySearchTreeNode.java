class myBinarySearchTreeNode{
  int myValue;
  myBinarySearchTreeNode left;
  myBinarySearchTreeNode right;
    
  myBinarySearchTreeNode(int inValue){
    // created a new node with empty child pointers
    this.myValue = inValue;
    this.left = null;
    this.right = null;
  }
  
  myBinarySearchTreeNode(int[] A){
    // creates a new Binary Search Tree rooted at the first value in the array
    /// by inserting elements into the tree in the order they are given in A.

    if (A.length == 0) return;

    myValue = A[0];
    left = null;
    right = null;

    for (int i = 1; i < A.length; i++) {
      insert(A[i]);
    }
  }
  
  public void insert(int inValue){
    // This method takes a new integer as input and decides 
    // if it should be place: 
    //    * as the left child,
    //    * as the right child, 
    //    * in the left subtree,
    //    * or in the right subtree.
    // If the value already exists in the tree, no action is taken. 
    if (myValue == inValue) System.out.println("Value not inserted because it's a DUPLICATE");

    if (myValue < inValue) {
      //System.out.println("X");
      if (right == null) {
        myBinarySearchTreeNode a = new myBinarySearchTreeNode(inValue);
        right = a;
      }
      else right.insert(inValue);
    }
    else if (myValue > inValue) {
      //System.out.println("XX");
      if (left == null) {
        myBinarySearchTreeNode a = new myBinarySearchTreeNode(inValue);
        left = a;
      }
      else left.insert(inValue);
    }
  }
  
  public int height(){
     // This method recursively calculates the height of the entire (sub)tree.
     // This method will take O(n) time
    int leftH = 0;
    int rightH = 0;

    if (left != null) leftH = left.height() + 1;
    if (right != null) rightH = right.height() + 1;

    return (leftH >= rightH)? leftH: rightH;
  }
  
  public int depth(int search){
     // This method recursively calculates the depth of a given search value. 
     // If the given value is not in the tree, this method returns -1. 
     // Note that if the tree is a proper BST, this method should complete in O(log n) time.
     // Additionally, remember that the depth is the number of nodes on the path from a node to the root 
     // (i.e. the number of the recursive calls).

    if (myValue == search) return 0;

    if (myValue < search) {
       if (right == null) {
         System.out.println("WARNING: value given was not found in the tree");
          return -1;
       }
       if (right.depth(search) == -1) return -1;
       return right.depth(search) + 1;
    }

    if (myValue > search) {
      if (left == null) {
        System.out.println("WARNING: value given was not found in the tree");
        return -1;
      }
      if (left.depth(search) == -1) return -1;
      return left.depth(search) + 1;
    }

    return 0;
  }

  public int size(){
    int a = 1;

    if (left != null) a += left.size();
    if (right != null) a += right.size();

    return a;
  }
  
  // Utility function included so you can debug your solution. 
  public void print() { print(""); }
  private void print(String prefix) {
    System.out.println(prefix + myValue);
    prefix = prefix.replace('\u251C', '\u2502');
    prefix = prefix.replace('\u2514', ' ');
    if(left != null) left.print(prefix + "\u251C ");
    if(right != null) right.print(prefix + "\u2514 ");
  }
  
} 
