package com.graph.binarytree.algorithms;
//http://www.ideserve.co.in/learn/minimum-depth-of-a-binary-tree
/*
Approach
1: If root is null, return 0.
2: If root is a leaf, return 1.
3: If left node of root is not null, recursively call getMinDepth to get leftDepth, else set leftDepth to MAX_VALUE
4: If right node of root is not null, recursively call getMinDepth to get rightDepth, else set rightDepth to MAX_VALUE
5: Return 1 + min of leftDepth or rightDepth
 */
public class BinaryTreeMinDepth {
  
	private static int getMinDepth(Node root) {
		 
        if (root == null) {
            return 0;
        }
 
        if (root.left == null && root.right == null) {
            return 1;
        }
 
        int leftDepth = root.left != null ? getMinDepth(root.left) : Integer.MAX_VALUE;
        int rightDepth = root.right != null ? getMinDepth(root.right) : Integer.MAX_VALUE;
 
        return 1 + Math.min(leftDepth, rightDepth);
    }
	
	public static void main(String args[]){
		    Node root = new Node(1);
	        Node n2 = new Node(2);
	        Node n3 = new Node(3);
	        Node n4 = new Node(4);
	        Node n5 = new Node(5);
	        Node n6 = new Node(6);
	        Node n7 = new Node(7);
	        Node n8 = new Node(8);
	        Node n9 = new Node(9);
	        Node n10 = new Node(10);
	        Node n11 = new Node(11);
	 
	        root.left = n2;
	        root.right = n3;
	 
	        n2.left = n4;
	        n2.right = n5;
	 
	        n3.left = n6;
	        n3.right = n7;
	 
	        n4.right = n8;
	 
	        n5.right = n9;
	 
	        n7.right = n10;
	 
	        n8.left = n11;
	
	   System.out.println(getMinDepth(root));
	   
	   //MIN DEPTH SHOULD BE 3  -> node1 -> node3 -> node6
	}
	
}
