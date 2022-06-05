 package com.linkedlist;
//http://algorithms.tutorialhorizon.com/reverse-a-linked-list/

public class ReverseLinkedList {

	private static class Node {
		private int data;
		private Node next;

		@SuppressWarnings("unused")
		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public static Node reverse(Node head){
		Node curr = head;
		Node next = null;
		Node prev = null;
		
		while(curr != null){
			next = curr.next; //Assign next value to temp variable so we dont loss next value
			curr.next = prev; // Next value will be equal to previus value. in first case will be null 
			prev = curr; // set current into previous 
			curr = next; // to keep iteration going to next node  
		}
		head = prev;
		System.out.println("\n Reverse Through Iteration");
		return head;
	}
	
	
	public static void main (String[] args) throws java.lang.Exception
	{
		Node head = new Node(5);
		head.next = new Node(10);
		head.next.next = new Node(15);
		head.next.next.next = new Node(20);
		head.next.next.next.next = new Node(25);
		head.next.next.next.next.next = new Node(30);

		Node curr = reverse(head);
		while(curr!=null){
			System.out.println("Node Date ::"+curr.data);
			curr = curr.next;
		}
	}

}

