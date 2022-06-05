package com.graph.binarytree.algorithms;
//http://www.geeksforgeeks.org/check-whether-binary-tree-full-binary-tree-not/
/*
To check whether a binary tree is a full binary tree we need to test the following cases:-
1) If a binary tree node is NULL then it is a full binary tree.
2) If a binary tree node does have empty left and right sub-trees, then it is a full binary tree by definition
3) If a binary tree node has left and right sub-trees, then it is a part of a full binary tree by definition. In this case recursively check if the left and right sub-trees are also binary trees themselves.
4) In all other combinations of right and left sub-trees, the binary tree is not a full binary tree.
 */
public class IsFullBinaryTree {
	// Java program to check if binay tree is full or not
	 
	    Node root;
	      
	    /* this function checks if a binary tree is full or not */
	    boolean isFullTree(Node node)
	    {
	        // if empty tree
	        if(node == null)
	        return true;
	          
	        // if leaf node
	        if(node.left == null && node.right == null )
	            return true;
	          
	        // if both left and right subtrees are not null
	        // the are full
	        if((node.left!=null) && (node.right!=null))
	            return (isFullTree(node.left) && isFullTree(node.right));
	          
	        // if none work
	        return false;
	    }
	  
	      
	    // Driver program
	    public static void main(String args[]) 
	    {
	    	IsFullBinaryTree tree = new IsFullBinaryTree();
	        tree.root = new Node(10);
	        tree.root.left = new Node(20);
	        tree.root.right = new Node(30);
	        tree.root.left.right = new Node(40);
	        tree.root.left.left = new Node(50);
	        tree.root.right.left = new Node(60);
	        tree.root.left.left.left = new Node(80);
	        tree.root.right.right = new Node(70);
	        tree.root.left.left.right = new Node(90);
	        tree.root.left.right.left = new Node(80);
	        tree.root.left.right.right = new Node(90);
	        tree.root.right.left.left = new Node(80);
	        tree.root.right.left.right = new Node(90);
	        tree.root.right.right.left = new Node(80);
	        tree.root.right.right.right = new Node(90);
	          
	        if(tree.isFullTree(tree.root))
	            System.out.print("The binary tree is full");
	        else
	            System.out.print("The binary tree is not full"); 
	    }
	  
}

  
