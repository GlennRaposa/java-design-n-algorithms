package com.linkedlist;

//IDESERVE : https://www.youtube.com/watch?v=gmfi2NMJJmc
//Have Four Node Variables 
// OddHead = null 
// Evenhead = null
// lastEven = null
// LastOdd = null

public class OddEvenSort {

	private static class Node {
		private int value;
		private Node next;

		@SuppressWarnings("unused")
		Node(int value) {
			this.value = value;
			this.next = null;
		}
	}

	public static Node oddEvenList(Node head) {
	   /*
	    		Given a linked list, re-arrange nodes in such a way that even and odd valued nodes are separated. Re-arrangement should be in such a way that the order of even and odd elements among themselves should remain same. Even elements should be placed first.

			// if ‘current’ is even node: 
			if (evenHead == null):
			        evenHead = lastEven = current;
			else:
			        lastEven.next = current;
			        lastEven = current;
			
			// if ‘current’ is odd node:
			if (oddHead == null):
			        oddHead = lastOdd = current;
			else:
			        lastOdd.next = current;
			        lastOdd = current;
			
			//SECOND PART OF THE ALGORITHM TO JOIN THE EVEN LIST TO THE ODD LIST 
			if (evenHead != null):
			        head = evenHead;
			
			if (lastEven != null):
			        lastEven.next = oddHead;
			
			if (lastOdd != null):
			        lastOdd.next = null;
			
			Time Complexity: O(n)
			Space Complexity: O(1)
	    */
		
		return null;
	}

	public static void main(String args[]) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);

		head = oddEvenList(head);
		Node curr = head;
		while (curr != null) {
			System.out.println("Current node value:" + curr.value);
			curr = curr.next;
		}
	}
}
