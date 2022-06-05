package com.linkedlist;

import java.util.HashMap;

/*
Input Linked List : 1->2->2->4->3->3->2
sOutput : 1->2->4->3
Approach:

Cre�ate a Hash Table
Take two pointers, prevNode and CurrNode.
PrevNode will point to the head of the linked list and currNode will point to the head.next.

Now navigate through the linked list.
Check every node data is present in the HashTable.
if yes then delete that node using pre�vN�ode and currNode.
If No, then insert that node data into the linked list
Return the head of the list

*/

public class RemoveDupFromUnsortedArray {
	   public Node removeDup(Node head){
	        HashMap<Integer, Integer> ht = new HashMap<Integer, Integer>();
	        if(head==null){
	            return null;
	        }
	        Node currNode = head.next;
	        Node prevNode = head;
	        Node temp; //keeping it so that last node would be eligible for garbage collection
	        ht.put(head.data, 1);
	        while(currNode!=null){
	            int data = currNode.data;
	            if(ht.containsKey(data)){
	                prevNode.next = currNode.next;
	                temp= currNode;
	                currNode = currNode.next;
	                temp.next = null;
	            }else{
	                ht.put(data, 1);
	                prevNode = currNode;
	                currNode = currNode.next;
	            }
	        } return head;
	    }
	    public void display(Node head){
	        Node n=head;
	        while(n!=null){
	            System.out.print("->" + n.data);
	            n=n.next;
	        }
	    }
	    public static void main(String args[]){
	        Node n = new Node(1);
	        n.next = new Node(2);
	        n.next.next = new Node(2);
	        n.next.next.next = new Node(3);
	        n.next.next.next.next = new Node(4);
	        n.next.next.next.next.next = new Node(4);
	        n.next.next.next.next.next.next = new Node(2);
	        System.out.print("Original List : ");
	        RemoveDupFromUnsortedArray rm = new RemoveDupFromUnsortedArray();
	        rm.display(n);
	        System.out.print("\n Updated List: ");
	        Node x =rm.removeDup(n);
	        rm.display(x);
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



