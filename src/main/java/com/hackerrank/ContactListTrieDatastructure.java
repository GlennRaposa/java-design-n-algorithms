package com.hackerrank;

import java.util.HashMap;
import java.util.Map;

public class ContactListTrieDatastructure {
	
	//TRIE IMPLEMENTATION
	
	public  class TrieNode{
		Map<Character, TrieNode> children;
		boolean endOfWord;
		
		public TrieNode(){
			children = new HashMap<Character, TrieNode>();
			endOfWord = false;
		}
	}
	
	private  final TrieNode root = new TrieNode();
	
	//Insert - Iterative
	public  void insert(String word){
		TrieNode current = root;
		for(int i = 0; i<word.length(); i++){
			char ch = word.charAt(i);
			TrieNode node = current.children.get(ch);
			if(node == null){
				node = new TrieNode();
				current.children.put(ch, node);
			}
			current = node;
		}
		current.endOfWord = true;
	}
	
	//Search - iterative
	public  boolean search(String word){
		TrieNode current = root;
		for(int i = 0; i<word.length(); i++){
			char ch = word.charAt(i);
			TrieNode node = current.children.get(ch);
			if(node == null){
				return false;
			}
			current = node;
		}
		return current.endOfWord;
		
	}
	
	//GET Node
	public TrieNode getNode(String word){
		TrieNode current = root;
		for(int i = 0; i<word.length(); i++){
			char ch = word.charAt(i);
			TrieNode node = current.children.get(ch);
			if(node == null){
				return null;
			}else{
			   return node;
			}
		}
		return null;	
	}
	
	
    public static void main(String args[]){
    	ContactListTrieDatastructure trie = new ContactListTrieDatastructure();
    	trie.insert("gayle");
    	trie.insert("gary");
    	trie.insert("genna");
    	System.out.println(trie.search("gayle"));
    	System.out.println(trie.search("alex"));
    }

}
