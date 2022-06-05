package com.javadatastructure;

import java.util.LinkedList;
import java.util.Queue;

public class StackImplWith2Queues {
	
	Queue<Integer> queue1 = null;
	Queue<Integer> queue2 = null;
	
	//Push all values from queue1 to queue2 so current insert value is on top in queue1
	//then copy all queue2 value back to queue1
	StackImplWith2Queues(){
		queue1 = new LinkedList<Integer>();
		queue2 = new LinkedList<Integer>();
	}

	public void push(int element){
		if(queue1.isEmpty()){
			queue1.add(element);
		}else{
			int queue1Size = queue1.size();
			for(int i=0;i<queue1Size;i++){
				queue2.add(queue1.remove());
			}
			
			queue1.add(element);
			
			for(int k=0;k<queue1Size;k++){
				queue1.add(queue2.remove());
			}
		}
		
	}
	
	public int pop() throws Exception{
		if(queue1.isEmpty()){
			throw new Exception("Stack is empty");
		}
		return	queue1.remove();
	}
	
	public static void main(String args[]) throws Exception{
		StackImplWith2Queues stackqueues = new StackImplWith2Queues();
		stackqueues.push(20);
		stackqueues.push(40);
		stackqueues.push(70);
		stackqueues.push(50);
		stackqueues.push(90);
		stackqueues.push(110);
		stackqueues.push(30);
		System.out.println("Remove Element :"+stackqueues.pop());
		stackqueues.push(170);
		System.out.println("Remove Element :"+stackqueues.pop());
	}
}
