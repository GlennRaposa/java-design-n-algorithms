package com.linkedlist;

/*
 * http://www.java2blog.com/2014/07/find-nth-element-from-end-of-linked-list.html
 * Assumption:

	We do not know size of linkedlist otherwise we can directly iterate and find (length-n)th node
	Algorithm for this problem would be :
	
	Use two pointer firstPtr and secondPtr and initialize both to head of linkedlist
	Move firstPtr by n-1 nodes.
	Increment firstPtr and secondPtr until firstPtr.next not equal to null.
	SecondPtr will be at nth from end node.
 * 
 */
public class FindNthElementInLinkedList {
	 public Node nthFromLastNode(Node head,int n)
	 {
	  Node firstPtr=head;
	  Node secondPtr=head;
	  
	  for (int i = 0; i < n; i++) {
	   firstPtr=firstPtr.next;
	   
	  }
	  
	  while(firstPtr!=null)
	  {
	   firstPtr=firstPtr.next;
	   secondPtr=secondPtr.next;
	  }
	  
	  return secondPtr;
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
