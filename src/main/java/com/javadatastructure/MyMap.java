package com.javadatastructure;

import java.util.Arrays;

public class MyMap<K,V>{

	private int size;
	private static final int DEFAULT_CAPCAITY = 10;
	private MyEntry<K,V>[] myEntry = new MyEntry[DEFAULT_CAPCAITY];
	
	public V get(K key){
		for(int i =0; i<size; i++){
			if(myEntry[i] != null && myEntry[i].getKey().equals(key)){
				return myEntry[i].getValue();
			}
		}
		return null;
	}
	
	
	public void put(K key, V value){
		boolean insert = true;
		for(int i =0; i<size; i++){
			if(myEntry[i] != null && myEntry[i].getKey().equals(key)){
				 myEntry[i].setValue(value);
				 insert = false;		 
			}
		}
		
		if(insert){
			ensureCapacity();
			myEntry[size++] = new MyEntry<K,V>(key,value);
			
		}
	}
	
	public MyEntry<K,V> remove(K key){
		MyEntry<K,V> tempMyEntry = null;
		for(int i =0; i<size; i++){
			if(myEntry[i] != null && myEntry[i].getKey().equals(key)){
				 tempMyEntry = myEntry[i];
				 myEntry[i] = null;	 
				 int temp = i;
				 size --;
				 
				 while(temp < size){
					 myEntry[temp] = myEntry[temp+1];
					 temp++;
				 }
			}
		}
		return tempMyEntry;
	}
	
	public void ensureCapacity(){
		int newSize = myEntry.length*2;
		myEntry = Arrays.copyOf(myEntry, newSize);
	}
	
	
	public static void main(String args[]){
		MyMap<Integer, String> map = new MyMap<Integer, String>();
		map.put(1, "ONE");
		map.put(2, "TWO");
		map.put(3, "THREE");
		
		System.out.println("GET SIZE:: "+map.size);
		System.out.println("GET VALUE:: "+map.get(2));
		map.put(2, "TWENTY");
		System.out.println("GET UPDT_VALUE:: "+map.get(2));
		System.out.println("REMOVE ENTRY:: "+map.remove(2).getKey());
		System.out.println("GET SIZE_UPDT:: "+map.size);
		System.out.println("GET 2 AFTER REMOVAL:: "+map.get(2));
	}
	
}


class MyEntry<K,V>{
	private final K key;
	private V value;
	
	public MyEntry(K key, V value){
		this.key = key;
		this.value = value;
	}
	
	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public K getKey() {
		return key;
	}
	
}
