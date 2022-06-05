package com.algorithms.demo.graph.binarytree.algorithms;
import java.util.LinkedList;
import java.util.Queue;
/*
    http://www.makeinjava.com/find-maximum-width-binary-tree-using-bfs-example/
    
    We will use breadth first search or level order traversal to iterate through the binary tree.

	Create variable maxWidth=0 for maximum width of binary tree
	Create variable to localWidth=0 for width at each level
	Insert root to queue
	Add null to the queue (level delimiter)
	Iterate through the Queue
	Pop node from queue & check for null
	We are at next level & compare localWidth of current level with maxWidth
	If localWidth is more than maxWidth then update maxWidth
	Reset localWidth to zero
	Add next level children (left and right child)
	Increment width of current level by 1 (localWidth++)
	Once we exit the loop, we will get the maximum width.
 */
public class WidthOfBinaryTree {
		
	public static void  maxWidthOfBTree(Node root) {
		if (root == null) {
			System.out.println("Tree is empty");
			return ;
		}
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(root);
		//level delimiter
		queue.offer(null);

		int maxWidth = 0;
		int level = 0;
		//default root level
		int localLevel = 0;
		int localWidth = 0;
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			//Level change
			//Case1: if null value
			if (null == node) {
				if (!queue.isEmpty()) {
					//level delimiter
					queue.offer(null);
				}
				
				if(localWidth > maxWidth) {
					maxWidth = localWidth;
					level = localLevel;
				}
				//Reset the levelwidth sum for next level calculation
				localWidth = 0;		
				localLevel ++;
			} else { //Case2 : IF NOT NULL VALUE 
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
				localWidth ++;
			}
		}
		System.out.printf("Max Width %d is at level %d \n",maxWidth,level);
		return;
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
		maxWidthOfBTree(root);
	}
	
}
