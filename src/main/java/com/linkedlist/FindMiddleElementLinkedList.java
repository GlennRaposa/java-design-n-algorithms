package com.linkedlist;

/*
 * http://www.java2blog.com/2014/07/find-middle-element-of-linkedlist-in.html
 * find middle element in one traversal also using following algo:

   Use two pointer fastptr and slowptr and initialize both to head of linkedlist
   Move fastptr by two nodes and slowptr by one node in each iteration.
   When fastptr reaches end of nodes, the slowptr pointer will be  pointing to middle element.
 */
public class FindMiddleElementLinkedList {
	
	public Node findMiddleNode(Node head)
	 {
	 Node slowPointer, fastPointer; 
	 slowPointer = fastPointer = head; 
	 
	  while(fastPointer !=null) { 
	   fastPointer = fastPointer.next; 
	   if(fastPointer != null && fastPointer.next != null) { 
	    slowPointer = slowPointer.next; 
	    fastPointer = fastPointer.next; 
	   } 
	  } 
	 
	  return slowPointer; 
	 
	 }
	
	private static class Node {
		private int data;
		private Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
}
