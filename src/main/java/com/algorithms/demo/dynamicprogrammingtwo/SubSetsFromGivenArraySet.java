package com.algorithms.demo.dynamicprogrammingtwo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//http://www.gorecursion.com/algorithm/2016/11/19/recursion-tree1.html
//https://www.youtube.com/watch?v=rxitBSy8pZ0&t=5s
/*
 * 
 */
public class SubSetsFromGivenArraySet {

	private static class Node {
	    ArrayList<Integer> one;
	    int idx;
	    Node() {one = new ArrayList<Integer>();}
	    Node(int i) { idx = i; }
	}
	
	
	private static List<List<Integer>> nonRecursiveDfs(int[] nums) {
	    Stack<Node> st = new Stack<Node>();
	    List<List<Integer>> all = new ArrayList<>();
	    st.push(new Node());
	    while (!st.isEmpty()) {
	        Node n = st.pop();
	        if (n.idx == nums.length) {
	            all.add(n.one);
	        } else {
	            Node n1 = new Node(n.idx+1);
	            n1.one = new ArrayList<Integer>(n.one);
	            n1.one.add(nums[n.idx]);
	            n.idx++;
	            st.push(n);
	            st.push(n1);
	        }
	    }
	    return all;
	}
	
	public static void main(String[] args) {
		int[] A = { 1,2,3};
		System.out.println("\nFrom DP: " + nonRecursiveDfs(A) );
	}
}
