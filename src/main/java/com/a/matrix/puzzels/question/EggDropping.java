package com.a.matrix.puzzels.question;
/*
 * 
 * https://www.youtube.com/watch?v=3hcaVyX00_4
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/EggDropping.java
 * http://www.geeksforgeeks.org/dynamic-programming-set-11-egg-dropping-puzzle/
 * 
 * The problem is not actually to find the critical floor, but merely to decide floors from which eggs should be 
 * dropped so that total number of trials are minimized.
 * 
 * When we drop an egg from a floor f, there can be two cases (1) The egg breaks (2) The egg doesn’t break.
 * 
 * 1) If the egg breaks after dropping from fth floor, then we only need to check for floors lower than f with remaining eggs; 
 *   so the problem reduces to f-1 floors and n-1 eggs
   2) If the egg doesn’t break after dropping from the fth floor, then we only need to check for floors higher than f; 
      so the problem reduces to k-f floors and n eggs.
      
   Since we need to minimize the number of trials in worst case, we take the maximum of two cases. 
   We consider the max of above two cases for every floor and choose the floor which yields minimum number of trials.

   int solution[][] = new int[egg+1][floor+1]
   C[i] = optimal solution
    
   C[i] = case1 : egg is dropped from floor 1 and breaks set first row with each floor count   
          case2 : 1+ Math.Max(T[e-1][K-1], T[e][f-k]);
                  where Ci..k  and Ck+1...j
 */
public class EggDropping {
	
	public static void main(String args[]){
		EggDropping eggDropping = new EggDropping();
        int eggs = 2, floors = 10;
        System.out.println("Minimum number of trials in worst case with "+eggs+"  eggs and "+floors+
                 " floors is "+eggDropping.calculate(eggs, floors));  
	}
	
	public int calculate(int eggs,int floors){
		int solution[][] = new int[eggs+1][floors+1];
		int c=0;
		//case1:
		for(int i =0; i<=floors; i++){
			solution[1][i] = i;
		}
		
		for(int e=2; e<=eggs; e++){
			for(int f=1; f<=floors; f++){
				solution[e][f] = Integer.MAX_VALUE;
		        for(int k=1; k<=f; k++){
		        	c = 1+Math.max(solution[e-1][k-1], solution[e][f-k]);
		        	if(c<solution[e][f]){
		        		solution[e][f] = c;
		        	}
		        }
			}
		}
		return solution[eggs][floors];
	}
	
	
	/*// Just added for reference
	 public int calculateRecursive(int eggs, int floors){
        if(eggs == 1){
            return floors;
        }
        if(floors == 0){
            return 0;
        }
        int min = 1000;
        for(int i=1; i <= floors; i++){
            int val = 1 + Math.max(calculateRecursive(eggs-1, i-1),calculateRecursive(eggs, floors-i));
            if(val < min){
                min = val;
            }
        }
        return min;
    }
	 */
}
