package com.javadatastructure;

import java.util.Arrays;
import java.util.NoSuchElementException;
//http://cs.lmu.edu/~ray/notes/queues/
public class Queue<E> {
	
    private static final int DEFAULT_CAPACITY = 2;	
	private Object[] elements = new Object[DEFAULT_CAPACITY];
	private int size;
	private int head;
	private int tail;
	
	public void enqueue(E e){
		if(size == elements.length){
			ensureCapacity();
		}
		elements[tail] = e;
		tail = (tail+1) % elements.length; 
		size++;
	}

	public Object denqueue(){
		if(size == 0){
			throw new NoSuchElementException("Cannot remove from empty queue");
		}
		E e = (E)elements[head];
		elements[head] = null;
		head = (head+1) % elements.length; 
		size--;
		return e;
	}
	
    public Object peek() {
        if (size == 0) {
            throw new NoSuchElementException("Cannot peek into empty queue");
        }
        return elements[size-1];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int size() {
        return size;
    }
 
    private void ensureCapacity(){
    	int newSize = elements.length*2;
    	elements = Arrays.copyOf(elements, newSize);
    }
    
    public static void main(String args[]){
 /*   	Queue<Integer> queue = new Queue<Integer>();
    	queue.enqueue(10);
    	queue.enqueue(20);
    	queue.enqueue(30);
    	queue.enqueue(40);
    	
    	System.out.println("Queue ::"+queue.size);
    	System.out.println("Queue ::"+queue.denqueue());
    	System.out.println("Elements in Queue now-1 ::"+Arrays.toString(queue.elements));
    	System.out.println("Queue ::"+queue.denqueue());
    	System.out.println("Elements in Queue now-2 ::"+Arrays.toString(queue.elements));
    	System.out.println("Queue ::"+queue.size);
    	System.out.println("value of head ::"+queue.head+"   value of tail :: "+queue.tail);*/
    	
    	
    	System.out.println(20 % 20);
    	
    }
    
    
    
}
