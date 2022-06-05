package com.graph.binarytree.algorithms;

import java.util.LinkedList;
import java.util.Queue;
/*
	http://www.makeinjava.com/find-maximum-width-binary-tree-using-bfs-example/
    
    We will use breadth first search or level order traversal to iterate through the binary tree.

 */
public class HeightInBinaryTree {
	

	public static void  maxHeightOfBTree(Node root) {
		if (root == null) {
			System.out.println("Tree is empty");
			return ;
		}
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(root);
		//level delimiter
		queue.offer(null);

		int level = 0;
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			//Level change
			if (null == node) {
				if (!queue.isEmpty()) {
					//level delimiter
					queue.offer(null);
				}
				level ++;
			} else {
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
		}
		System.out.printf("level %d \n",level);
		return;
	}	
	
	/*
		Recursion:
		Get the height of left sub tree, say leftHeight
		Get the height of right sub tree, say rightHeight
		Take the Max(leftHeight, rightHeight) and add 1 for the root and return
		Call recur�sively.
	 */
	/*public int treeHeightRecursion(Node root){
		if(root==null)return 0;
		return (1+ Math.max(treeHeightRecursion(root.left),treeHeightRecursion(root.right)));
	}*/
	
	public static void main (String[] args) throws java.lang.Exception
	{
		Node root = new Node(100);
		root.left = new Node(50);
		root.right = new Node(150);
		root.left.left = new Node(25);
		root.left.right = new Node(75);
		root.right.left = new Node(125);
		root.right.right = new Node(175);
		root.right.left.left = new Node(120);
		root.right.left.right = new Node(140);

		WidthOfBinaryTree i  = new WidthOfBinaryTree();
		maxHeightOfBTree(root);
	}

}

