package com.linkedlist;
//Java program to pairwise swap elements of a linked list
public class PairWiseSwapLinkedList {
	Node head; // head of list

	/* Linked list Node */
	private static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	Node pairWiseSwap(Node head) {
		Node temp = head;

		/* Traverse only till there are atleast 2 nodes left */
		while (temp != null && temp.next != null) {

			/* Swap the data */
			int k = temp.data;
			temp.data = temp.next.data;
			temp.next.data = k;
			temp = temp.next.next;
		}
		return head;
	}

	/* Driver program to test above functions */
	public static void main(String args[]) {
		PairWiseSwapLinkedList llist = new PairWiseSwapLinkedList();
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);

		Node curr = llist.pairWiseSwap(head);
		while (curr != null) {
			System.out.println("Current node value:" + curr.data);
			curr = curr.next;
		}

	}
}

