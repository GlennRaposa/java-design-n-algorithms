package com.graph.binarytree.algorithms.notsoimp;


import java.util.Stack;

import javax.swing.tree.TreeNode;
/*
 * Graph Depth First Traversal PerOrder
 * Binary Tree PerOrder
 */
public class InOrderTraversal {

	/*
	 *   ---- Diagram ----
	 *           40
	 *         /    \ 
	 *       20      60
	 *      /  \     /  \
	 *     10  30   50  70
	 *     10,20,30,40,50,60,70
	 */
	
	public static TreeNode createBinaryTree(){
		
		TreeNode rootNode = new TreeNode(40);
		TreeNode node20 = new TreeNode(20);
		TreeNode node10 = new TreeNode(10);
		TreeNode node30 = new TreeNode(30);
		TreeNode node60 = new TreeNode(60);
		TreeNode node50 = new TreeNode(50);
		TreeNode node70 = new TreeNode(70);
		
		rootNode.left = node20;
		rootNode.right = node60;
		
		node20.left = node10;
		node20.right = node30;
		
		node60.left = node50;
		node60.right = node70;
		
		return rootNode;
		
		
	}
	
	public static class TreeNode{
		int data;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int data){
			this.data = data;
		}
	}
	
	//Recursive  
	//InOrder <left><root><right>
	public void InOrder(TreeNode root){
		
		if(root != null){
			InOrder(root.left);
			
			//Visit the node by Print the node Data
			System.out.printf("%d %n", root.data);
			
			InOrder(root.right);
		}
	}
	
    //FOR ITERATIVE SOLUTION 
	//http://www.java2blog.com/2014/07/binary-tree-inorder-traversal-in-java.html
	
	public static void main(String args[]){
		
		InOrderTraversal inOrder = new InOrderTraversal();
		inOrder.InOrder(createBinaryTree());
		
	}
	
}
