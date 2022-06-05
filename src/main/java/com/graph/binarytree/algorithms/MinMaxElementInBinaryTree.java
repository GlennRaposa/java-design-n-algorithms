package com.graph.binarytree.algorithms;
/*
 http://www.makeinjava.com/find-minimum-maximum-element-binary-tree-recursive-java-example/

 IF BST THEN ITS EASY JUST RECURSIVE GOTO the END
  MIN : LEFT MOST NODE 
  MAX : RIGHT MOST NODE
  
 IF NOT BST  [IMPLEMENTATION BELOW] 
   Save CurrentNodeValue
   MAth.max(Math.max(leftNode, rightNode), currentNodeValue)  
 
 */
public class MinMaxElementInBinaryTree {
	public static int maxElementInBTree(Node root) {
		if (null == root)
			return Integer.MIN_VALUE;

		int currentNodeValue = root.data;
		int hLeftSub = maxElementInBTree(root.left);
		int hRightSub = maxElementInBTree(root.right);
		return Math.max(Math.max(hLeftSub, hRightSub), currentNodeValue);
	}

	public static int minElementInBTree(Node root) {
		if (null == root)
			return Integer.MAX_VALUE;

		int data = root.data;
		int left = minElementInBTree(root.left);
		int right = minElementInBTree(root.right);
		return Math.min(data, Math.min(left, right));
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		Node root = new Node(100);
		root.left = new Node(50);
		root.right = new Node(150);
		root.left.left = new Node(25);
		root.left.right = new Node(75);
		root.right.left = new Node(125);
		root.right.right = new Node(175);

		WidthOfBinaryTree i  = new WidthOfBinaryTree();
		System.out.println("MAX ::"+maxElementInBTree(root));
		System.out.println("MIN ::"+minElementInBTree(root));
	}
}
