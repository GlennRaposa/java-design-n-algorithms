package a.com.interesting.dynamic.programming;
//http://www.gorecursion.com/algorithm/2016/11/20/1d-dynamic2.html
/*
 * DP O(n) time complexity solution
 * With input is n, 1st step, we have n options, 
 * e.g. For is 3, we have 3 options: use 1,2 or 3 as root node. 
 * with each option, we got two new sub problem. 
 * How many way to form left sub-tree and right sub-tree. 
 * Once we solved left sub problem and right sub problem, the number of ways is production of L and R.
 */
public class UniqueBinarySearchTreeDP {
	
	public static int dp(int n){
		int[] fn = new int[n+1];
		fn[0] = 1; // Empty node
		fn[1] = 1; //1 node tree
		for(int i=2; i<=n;i++){
			for(int j=0; j<i; j++){
				fn[i] += fn[j] * fn[i-j-1];
			}
		}
		return fn[n];
	}
	
	public static void main(String args[]){
		System.out.println("Unique Binary Trees ::"+dp(3));
	}
}
