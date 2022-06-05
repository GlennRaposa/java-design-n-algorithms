package com.graph.binarytree.algorithms;
//http://www.ideserve.co.in/learn/lowest-common-ancestor-binary-tree
/*
 Algorithm/Insights

  1. Traverse the tree in bottom up approach.
  2. If a node ( A or B ) is found, return it to its parent.
  3. Parent will check if it was able to get nodes from both of its child.
  4. If yes, then Parent is LCA.
  5. If no, Parent will return NULL if none of its child returned A or B ELSE will return not NULL node.

*/
public class LowestCommonAncestor {
	
    public Node LCA(Node curr, Node a, Node b){
    	if(curr == null){
    		return null;
    	}
    	
    	if(curr == a || curr == b){
    		return curr;
    	}
    	
    	Node left = LCA(curr.left, a, b);
    	Node right = LCA(curr.right, a, b);
    	
    	if(left != null && right != null){
    		return curr;
    	}
    	
    	if(left == null){
    		return right;
    	}else if (right == null){
    		return left;
    	}
    	
    	return curr;
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(7);
		Node node7 = new Node(8);
		
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node5.left = node6;
		node5.right = node7;

		LowestCommonAncestor i  = new LowestCommonAncestor();
		Node node = i.LCA(node1, node4, node7);
		System.out.println("Maximum Width of a binary Tree is : " +node.data);
	}
}
