package com.graph.binarytree.algorithms.notsoimp;

import java.util.Stack;

import javax.swing.tree.TreeNode;
/*
 * Graph Depth First Traversal PerOrder
 * Binary Tree PerOrder
 */
public class PreOrderTraversal {

	/*
	 *   ---- Diagram ----
	 *           40
	 *         /    \ 
	 *       20      60
	 *      /  \     /  \
	 *     10  30   50  70
	 *     output : 40,20,10,30,60,50,70
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
	//PreOrder <root><left><right>
	public void preOrder(TreeNode root){
		
		if(root != null){
			//Visit the node by Print the node Data
			System.out.printf("%d %n", root.data);
			
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	
	//Iterative 
	//preOrder <root><left><right>
	//Put it in a stack and Pop it 
	public void preOrderIterative(TreeNode root){
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		
		while(!stack.isEmpty()){
			TreeNode n = stack.pop();
			System.out.printf("%d", n.data);
			
		    if(n.right != null){
		    	stack.push(n.right);
		    }
		    if(n.left != null){
		    	stack.push(n.left);
		    }
					
		}
	}
	
	
	public static void main(String args[]){
		
		PreOrderTraversal preOrder = new PreOrderTraversal();
		//preOrder.preOrder(createBinaryTree());
		preOrder.preOrder(createBinaryTree());
		
	}
	
}
