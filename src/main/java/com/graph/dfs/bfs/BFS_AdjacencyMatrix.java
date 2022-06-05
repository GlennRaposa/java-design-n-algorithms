package com.graph.dfs.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue; 

/*
 * Reference : http://www.java2blog.com/2015/12/breadth-first-search-in-java.html
 */
public class BFS_AdjacencyMatrix {
	
Queue<Node> queue = new LinkedList<Node>();

//Root NODE 
static ArrayList<Node> nodes = new ArrayList<Node>();
	
	//Node
	static class Node{
		int data;
		boolean visited;
		
		Node(int data){
			this.data = data; 
		}
	}
	

	// Find neighbors of node using adjacency matrix 
	// If adjacency_matrix[i][j]==1, then nodes at index i and index j are connected
	public ArrayList<Node> findNeighbours(int adjacency_matrix[][],Node x){
		int nodeindex = -1;
		
		ArrayList<Node> neighbours = new ArrayList<Node>();
		
		//Is Node Present in ROOT-Nodes-Tree Structure
		for(int i = 0; i<nodes.size(); i++){
			if(nodes.get(i).equals(x)){
				nodeindex = i;
				break;
			}	
		}	
		
		if(nodeindex != -1){
			for(int j = 0; j<adjacency_matrix[nodeindex].length;j++){
				
				if(adjacency_matrix[nodeindex][j] == 1){
					neighbours.add(nodes.get(j));
				}	
				
			}				
		}
		
		return neighbours;
	}
	
	public void bfsUsingStack(int adjacency_matrix[][],Node node){

		queue.add(node);
		node.visited = true;
		
		while(!queue.isEmpty()){
			
			Node element = queue.remove();
			System.out.println(element.data+"\t");
			
			ArrayList<Node> neighbours = findNeighbours(adjacency_matrix, element);
			for(int i = 0; i<neighbours.size(); i++){
				Node n = neighbours.get(i);
				if(n != null && !n.visited){
					queue.add(n);
					n.visited = true;
				}	
			}	
		}	
		
	}	
	
	public static void main(String args[]){
		Node node40 = new Node(40);
		Node node10 = new Node(10);
		Node node20 = new Node(20);
		Node node30 = new Node(30);
		Node node60 = new Node(60);
		Node node50 = new Node(50);
		Node node70 = new Node(70);
		
		nodes.add(node40);
		nodes.add(node10);
		nodes.add(node20);
		nodes.add(node30);
		nodes.add(node60);
		nodes.add(node50);
		nodes.add(node70);
		
		int adjacency_matrix[][] = { 
				{0,1,1,0,0,0,0}, // Node 1: 40 
				{0,0,0,1,0,0,0}, // Node 2 :10 
				{0,1,0,1,1,1,0}, // Node 3: 20 
				{0,0,0,0,1,0,0}, // Node 4: 30 
				{0,0,0,0,0,0,1}, // Node 5: 60 
				{0,0,0,0,0,0,1}, // Node 6: 50 
				{0,0,0,0,0,0,0}, // Node 7: 70 
			};
		
		BFS_AdjacencyMatrix bfsExample = new BFS_AdjacencyMatrix(); 
		System.out.println("The DFS traversal of the graph using stack "); 
		bfsExample.bfsUsingStack(adjacency_matrix, node40); 
		System.out.println();
	}
}
