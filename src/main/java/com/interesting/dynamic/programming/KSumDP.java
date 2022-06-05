package a.com.interesting.dynamic.programming;
/*
 https://www.youtube.com/watch?v=Gych0fusTcc
 http://www.gorecursion.com/algorithm/2016/11/22/3d-dynamic1.html
 Given n distinct positive integers, integer k (k <= n) and a number target.

 Find k numbers where sum is target. Calculate how many solutions there are?

 Example Given [1,2,3,4], k = 2, target = 5.

 There are 2 solutions: [1,4] and [2,3].
 */
public class KSumDP {
	//DP O(n x k x target) time complexity
	// DP O(n x k x target) time complexity
	
	private static int dpV1(int A[], int k, int target) {
	    int[][][] fn = new int[k+1][A.length+1][target+1];
	    
	    for (int i = 0; i <= A.length; i++){
	        fn[0][i][0] = 1;
	    }    

	    for (int i = 1; i <= k; i++) {
	        for (int j = 1; j <= A.length; j++) {
	            for (int t = 1; t <= target; t++) {
	                fn[i][j][t] = fn[i][j-1][t];
	                int use = t - A[j-1];
	                if (use >= 0)
	                    fn[i][j][t] += fn[i-1][j-1][use];
	            }
	        }
	    }
	    return fn[k][A.length][target];
	}
	
	public static void main(String args[]){
		int[] arr = {1,2,3,4}; 
		int k = 2; 
		int target = 5;
		
		System.out.println(dpV1(arr, k,target));
		
	}
	
}
