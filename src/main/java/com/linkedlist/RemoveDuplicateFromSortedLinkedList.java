package com.linkedlist;
/*
 * http://www.makeinjava.com/remove-duplicate-nodes-sorted-singly-linked-list-java-example/
 * Start the iterating linked list from head
	Compare head element 1 with next element 2
	Check 1 == 2 ? They are not equals.
	Let move ahead in linked list
	Compare element 2 [Second node] with element 2 [Third node]
	Check 2 == 2?  Yes, these are duplication nodes.
	Let us remove the element 2 [Third node] from linked list
	Save the reference of element 3 (fourth node)
	nextNode = head.next.next
	Delete element 2 at Third position
	head.next = null
	Now connect element 2 [Second position] with element 3 (fourth position)
	head.next = nextNode
	We have removed element 2 [Earlier Third node] from linked list
	Now go ahead with iteration to remove rest of duplicate elements
	We will remove duplicated element 3 from linked list in similar way
	We have shown the removal of duplicate elements in Fig 2.
 */
public class RemoveDuplicateFromSortedLinkedList {

	private static class Node {
		private int data;
		private Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public static Node removeDuplicates(Node head) {
		// first node to be inserted
		if (null == head) {
			System.out.println("Linked list is empty");
			return null;
		}

		Node curr = head;
		Node nextNode = null;
		while (curr.next != null) {
			// check for duplicates
			// E.g 1->2->2->3
			if (curr.data == curr.next.data) {
				nextNode = curr.next.next;
				// deleting next node...
				// let gc take care of it
				curr.next = null;
				curr.next = nextNode;
			} else {
				// no duplicate..move to next node
				curr = curr.next;
			}
		}
		return head;
	}

	public static void main(String[] args) {

		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(2);
		head.next.next.next = new Node(3);
		head.next.next.next.next = new Node(3);
		head.next.next.next.next.next = new Node(9);

		Node curr = removeDuplicates(head);
		while (curr != null) {
			System.out.println("Current node value:" + curr.data);
			curr = curr.next;
		}
	}
}
