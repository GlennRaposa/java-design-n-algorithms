package com.javadatastructure;

import java.util.Arrays;

public class MyStack<E> {
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements = new Object[DEFAULT_CAPACITY];
    
    public E pop(){
    	E e = (E)elements[--size];
    	elements[size] = null;
    	return e;
    }
    
    public void push(E e){
    	if(size == elements.length){
    		ensureCapacity();
    	}
    	elements[size++] = e;
    }
    
    private void ensureCapacity(){
    	int newSize = elements.length*2;
    	elements = Arrays.copyOf(elements, newSize);
    }

	public static void main(String args[]){
		MyStack<Integer> myStack = new MyStack<Integer>(); 
		myStack.push(1);
		myStack.push(2);
		myStack.push(3);
		myStack.push(4);
		
		System.out.println("POP :: "+myStack.pop());
		System.out.println("STACK SIZE ::"+myStack.pop());
		System.out.println("STACK SIZE ::"+Arrays.toString(myStack.elements));
	}
	
}
