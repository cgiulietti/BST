package BinarySearchTree;

import java.util.ArrayList;

public class BST<T extends Comparable<T>> {

   protected static class Node<T> {

      public T value;
      public Node<T> rightChild;
      public Node<T> leftChild;
      
      public Node(T value, Node<T> leftChild, Node<T> rightChild) {
         super();
         this.value = value;
         this.rightChild = rightChild;
         this.leftChild = leftChild;
      }
      
      @Override
      public String toString() {
         return value.toString();
      }
      
   }
   
   private Node<T> root = null;
   
   public void insert ( T value ){
      root = insertInTree( value, root );
   }
   
   public boolean lookup ( T value ){
      if (lookupInTree( value, root ) != null) return true;

      return false;
   }

   public void delete( T value ){
      root = deleteInTree(value, root);
   }
   
   public ArrayList<T> printInOrder(){
      return printTreeInOrder( root, new ArrayList<T>() );
   }
   
   public ArrayList<T> printPreOrder(){
      return printTreePreOrder( root, new ArrayList<T>() );
   }
   
   public ArrayList<T> printPostOrder(){
      return printTreePostOrder( root, new ArrayList<T>() );
   }
   
   public boolean isEqual( Node<T> root ){
	   return isSameSubtree(this.root, root);
   }
   
   public boolean isSubtree( Node<T> root ){
	   
	   Node<T> startingNode = lookupInTree(root.value, this.root);
	   
	   return isSameSubtree(startingNode, root);
   }

   public static <T extends Comparable<T>> boolean isBST( Node<T> root ){
	   return isBST(root,null,null);
   }
   
/* Internal methods */
   
   private Node<T> lookupInTree(T value, Node<T> root) {
      
      if ( root == null || root.value.equals(value)){ 
         return root;
      }
      
      if ( value.compareTo(root.value) > 0 ){
         return lookupInTree(value, root.rightChild);
      }else{
         return lookupInTree(value, root.leftChild);
      }
      
   }
   
   private Node<T> insertInTree(T value, Node<T> root) {

	   if ( root == null ){ 
		   return new Node<T>(value, null, null);
	   }

	   /* no duplicates allowed */
	   if ( value.compareTo(root.value) == 0 ){ 
		   return root;
	   }

	   if ( value.compareTo(root.value) > 0 ){
		   root.rightChild = insertInTree(value, root.rightChild);
	   }else{
		   root.leftChild = insertInTree(value, root.leftChild);
	   }

	   return root;
   }
   
   private Node<T> deleteInTree(T value, Node<T> root ) {
      
      if ( root == null ){ 
         return root;
      }
      
      if ( value.equals(root.value) ){
         
         if ( root.leftChild == null && root.rightChild == null ){
            /* it is a leaf */
            root = null;
         }else if ( root.leftChild == null && root.rightChild != null ){
            /* left child is empty */
            root = root.rightChild;
         }else if (root.leftChild != null && root.rightChild == null){
            /* right child is empty */
            root = root.leftChild;
         }else if (root.leftChild != null && root.rightChild != null){
        	 /* both children are not empty */
        	 Node<T> rightChild = new Node<T>(root.rightChild.value, root.rightChild.leftChild, root.rightChild.rightChild);
        	 root = root.leftChild;
        	 root.rightChild = insertSubtreeInMinimum(root.rightChild, rightChild);

         }
         
      }else{
         if ( value.compareTo(root.value) > 0 ){
            root.rightChild = deleteInTree(value, root.rightChild );
         }else {
            root.leftChild = deleteInTree(value, root.leftChild );
         }
      }
      
      return root;
   }
   
   private Node<T> insertSubtreeInMinimum(Node<T> subTree, Node<T> root) {
	   if ( root == null ){
		   return subTree;
	   }
	   
	   root.leftChild = insertSubtreeInMinimum(subTree, root.leftChild);
	   return root;
   }

   private ArrayList<T> printTreeInOrder( Node<T> root, ArrayList<T> result ) {
      if ( root == null ){ 
         return result;
      }
      
      result = printTreeInOrder(root.leftChild, result);
      result.add(root.value);
      result = printTreeInOrder(root.rightChild, result);
      
      return result;
      
   }
   
   private ArrayList<T>  printTreePreOrder( Node<T> root, ArrayList<T> result ) {
      if ( root == null ){ 
         return result;
      }
      
      result.add(root.value);
      
      result = printTreePreOrder(root.leftChild, result);
      result = printTreePreOrder(root.rightChild, result);
      
      return result;
   }
   
   private ArrayList<T>  printTreePostOrder( Node<T> root, ArrayList<T> result ) {
      if ( root == null ){ 
         return result;
      }
      
      result = printTreePostOrder(root.leftChild, result);
      result = printTreePostOrder(root.rightChild, result);
      result.add(root.value);
      
      return result;
   }
   
   private boolean isSameSubtree(Node<T> root1, Node<T> root2) {

	   if ( root1 == null || root2 == null ){
		   if ( root1 == null || root2 == null ){
			   return true;
		   }else{
			   return false;
		   }
	   }else if ( !root1.value.equals(root2.value) ){
		   return false;
	   }
	   
	   return isSameSubtree(root1.leftChild, root2.leftChild) && isSameSubtree(root1.rightChild, root2.rightChild);
	   
   }
   
   private static <T extends Comparable<T>> boolean isBST( Node<T> root, T min, T max ){
	   if ( root == null ) return true;
	   if ( (max != null && root.value.compareTo(max) > 0) || (min != null && root.value.compareTo(min) < 0) ) return false;
	   
	   return isBST(root.leftChild,min,root.value) && isBST(root.rightChild,root.value,max);
   }
}
