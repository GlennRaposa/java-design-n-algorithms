package com.graph.binarytree.algorithms;

//https://www.youtube.com/watch?v=VCTP81Ij-EM
//http://www.ideserve.co.in/learn/create-a-balanced-bst-from-a-sorted-array
/*
	Algorithm/Insights
	
	A BST is balanced if:
	Height of left subtree and right subtree of root differ by at most 1. Left and right subtrees are subtrees is balanced.
	
	Algorithm:
	1. Initialize start = 0, end = length of the array - 1
	2. Set mid = (start+end)/2
	3. Create a tree node with mid as root (lets call it A).
	4. Recursively do following steps:
	   a). Calculate mid of left subarray and make it root of left subtree of A.
	   b). Calculate mid of right subarray and make it root of right subtree of A.
 */

//NO WORKING BUT LOGIC IS CORRECT NEED TO DEBUG
public class CreateBinaryTreeFromSortedArray {
	
	
	public static void main (String[] args)
	{
	  int[] arr = { 3, 6, 8, 23, 48, 76, 89 };	
	  CreateBinaryTreeFromSortedArray c = new CreateBinaryTreeFromSortedArray();
	  Node node = c.createBST(arr, 0, arr.length-1);
	  c.InOrder(node);
	  
	}
	
	public Node createBST(int[] arr, int start, int end){
		
		if(arr == null || arr.length == 0 || start > end){
			return null; 
		}
		
		int mid = (int) Math.ceil(start+end/2);
		Node node = new Node(arr[mid]);

		node.left = createBST(arr, start, mid-1);
		node.right = createBST(arr, mid+1, end);
		
		return node;
	}
	
	
	//Recursive  
	//InOrder <left><root><right>
	public void InOrder(Node root){
		
		if(root != null){
			InOrder(root.left);
			
			//Visit the node by Print the node Data
			System.out.printf("%d %n", root.data);
			
			InOrder(root.right);
		}
	}
}
