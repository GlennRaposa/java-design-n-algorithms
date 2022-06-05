package com.javadatastructure;

import java.util.Arrays;

public class MyList<E> {
	
	private int size;
	private static final int DEFAULT_CAPACITY = 10;
	private Object elements[];
	
	public MyList(){
		elements = new Object[DEFAULT_CAPACITY];
	}
	
	public void add(E e){
		if(size == elements.length){
			ensureCapacity();
		}
		elements[size++] = e;
	}
	
	
	public void ensureCapacity(){
		int newSize = elements.length*2;
		elements = Arrays.copyOf(elements, newSize);
	}
	  
	@SuppressWarnings("unchecked")
	public E get(int index){
		return (E)elements[index];
	}
	
	
	@SuppressWarnings("unchecked")
	public E remove(int index){
		Object obj  = null;
		if(index < size){
			obj = elements[index];
			int temp = index;
			elements[index] = null;
			
			
			while(temp < size){
				elements[temp] = elements[temp+1];
				elements[temp+1] = null;
				temp++;
			}
		}
		
		size--;
		return (E)obj;
	}
	
	public static void main(String args[]){
		MyList<Integer> list = new MyList<Integer>();
		list.add(10);
		list.add(20);
		list.add(30);
		
		System.out.println("Get Value: "+list.get(2));
		System.out.println("Remove Value: "+list.remove(1));
		System.out.println("Get Size: "+list.size);
		
	}

}
