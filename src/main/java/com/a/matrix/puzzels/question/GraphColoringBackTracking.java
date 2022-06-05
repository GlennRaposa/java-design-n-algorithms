package com.a.matrix.puzzels.question;

import java.util.Arrays;
//https://developers.google.com/optimization/puzzles
//https://www.youtube.com/watch?v=miCYGGrTwFU&list=PLyEvk8ZeQDMU8n8zPfTKvnXjHUa4FnvhN&index=2
//http://www.geeksforgeeks.org/backttracking-set-5-m-coloring-problem/

/*combination O(m*n)  3 colors * 4 house [3 to the power of 4] = (3*3*3*3) = 9*3*3  -> (27*3) = 81
  81 tree nodes when broken down now we need to backtrack nodes and mark end combination

	 Algorithm
	 If all colors are assigned,
	    print vertex assigned colors
	 Else
	    a. Trying all possible colors, assign a color to the vertex
	    b. If color assignment is possible, recursivelty assign colors to next vertices
	    c. If color assignment is not possible, de-assign color, return False
 */
public class GraphColoringBackTracking {
	//number of Houses
	int[] nodes = {1,2,3,4};
	final int V = nodes.length;
	
    int color[];
	
	public static void main( String args[]){
		//int[] m = {0,1,2}; //Red=0, Green=1, Blue=2
		int m = 3; //hard_coding
		int[][] graph = 
			{
					{1,1,0,1},
					{1,1,1,1},
					{0,1,1,1},
					{1,1,1,1}
			};
		
		/*Adjency Matrix of 4 nodes (0,1,2,3) when drawn  
		      (0)---(1)
	           | \   |
	           |  \  |
	           |   \ |
	          (3)---(2)
	    */
		GraphColoringBackTracking graphme = new GraphColoringBackTracking();
		graphme.graphColoring(graph, m);
	}
	

	
	 /* This function solves the m Coloring problem using
	    Backtracking. It mainly uses graphColoringUtil()
	    to solve the problem. It returns false if the m
	    colors cannot be assigned, otherwise return true
	    and  prints assignments of colors to all vertices.
	    Please note that there  may be more than one
	    solutions, this function prints one of the
	    feasible solutions.*/
	 public boolean graphColoring(int graph[][], int m)
	 {
	     // Initialize all color values as 0. This
	     // initialization is needed correct functioning
	     // of isSafe()
	     color = new int[V];
	     for (int i = 0; i < V; i++){
	         color[i] = 0;
	     }    
	
	     // Call graphColoringUtil() for vertex 0
	     if (!graphColoringUtil(graph, m, color, 0))
	     {
	         System.out.println("Solution does not exist");
	         return false;
	     }
	
	     // Print the solution
	     System.out.println(Arrays.toString(color));
	     return true;
	 }
	
	public boolean isSafe(int v, int graph[][], int color[], int c) {
		for (int i = 0; i < v; i++){
			if (graph[v][i] == 1 && c == color[i]){
				return false;
			}
		}
		return true;
	}
	
	/* A recursive utility function to solve m
    coloring  problem */
	public boolean graphColoringUtil(int graph[][], int m,
	                           int color[], int v)
	 {
	     /* base case: If all vertices are assigned
	        a color then return true */
	     if (v == V)
	         return true;
	
	     /* Consider this vertex v and try different
	        colors */
	     for (int c = 1; c <= m; c++)
	     {
	         /* Check if assignment of color c to v
	            is fine*/
	         if (isSafe(v, graph, color, c))
	         {
	             color[v] = c;
	
	             /* recur to assign colors to rest
	                of the vertices */
	             if (graphColoringUtil(graph, m,
	                                   color, v + 1))
	                 return true;
	
	             /* If assigning color c doesn't lead
	                to a solution then remove it */
	             color[v] = 0;
	         }
	     }
	
	     /* If no color can be assigned to this vertex
	        then return false */
	     return false;
	 }

}
