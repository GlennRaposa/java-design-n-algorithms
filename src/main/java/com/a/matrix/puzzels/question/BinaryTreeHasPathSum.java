package com.a.matrix.puzzels.question;

import java.util.Arrays;
import java.util.LinkedList;


/*
 Given a binary tree and a sum, determine if the tree has a root-to-leaf path such 
 that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 
   			  5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
 */
//NEED TO GET THIS TO WORK
public class BinaryTreeHasPathSum {

	public static void main(String args[]){
		TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(4);
		TreeNode n3 = new TreeNode(8);
		TreeNode n4 = new TreeNode(11);
		TreeNode n5 = new TreeNode(13);
		TreeNode n6 = new TreeNode(4);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(2);
		TreeNode n9 = new TreeNode(1);
		
		n1.left = n2;
		n1.right = n3;
		n3.left = n4;
		n4.left = n7;
		n4.right = n8;
		
		n3.left = n5;
		n3.right = n6;
		
		n6.right = n9;
		
		
		BinaryTreeHasPathSum ps = new BinaryTreeHasPathSum();
		System.out.println(ps.hasPathSumRecursive(n1, 22)); 
		
	}
	
	  public boolean hasPathSumRecursive(TreeNode root, int sum) {
			if (root == null)
				return false;
			if (root.val == sum && (root.left == null && root.right == null))
				return true;
		 
			return hasPathSum(root.left, sum - root.val)
					|| hasPathSum(root.right, sum - root.val);
		}
	
	
	  public boolean hasPathSum(TreeNode root, int sum) {
	        if(root == null) return false;
	 
	        LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
	        LinkedList<Integer> values = new LinkedList<Integer>();
	 
	        nodes.add(root);
	        values.add(root.val);
	 
	        while(!nodes.isEmpty()){
	            TreeNode curr = nodes.poll();
	            int sumValue = values.poll();
	 
	            if(curr.left == null && curr.right == null && sumValue==sum){
	                return true;
	            }
	 
	            if(curr.left != null){
	                nodes.add(curr.left);
	                values.add(sumValue+curr.left.val);
	            }
	 
	            if(curr.right != null){
	                nodes.add(curr.right);
	                values.add(sumValue+curr.right.val);
	            }
	        }
	        return false;
	    }
	
	  
	
	
}

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(int val){
		this.val = val;
		left = null;
		right = null;
	}
}
