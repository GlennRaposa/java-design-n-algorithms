package a.com.interesting.dynamic.programming;
/*
  http://www.gorecursion.com/algorithm/2016/11/20/1d-dynamic3.html
  https://www.youtube.com/watch?v=NqqAhSgYBm4
  
  DP solution from bottom up approach
  we can have Two case we rob the house or dont rob the house
  if no house throw --> if one house return that one -> two house max of house0 and house1
  start loop at 2 (second house) 
  if we rob the house we get value  = num[i] + fn[i-2] and go back two steps on the tree
  if we dont rob the house we go = fn[i-1] move one step back 
  NOW we take Math.max(opt1, opt2)
 
 */
public class HouseRobberDP {
	
     //TimeComplexity O(N)

	private static int robHouseDP(int[] nums){
		if(nums.length == 0){
			return 0;
		}
		if(nums.length == 1){
			return nums[0];
		}

		int[] fn = new int[nums.length];
		fn[0] = nums[0];
		fn[1] = Math.max(nums[0], nums[1]);
		
		for(int i=2; i<nums.length; i++){
			int opt1 = nums[i] + fn[i-2];
			int opt2 = fn[i-1];
			//Add weight of each subtree structure tree
			fn[i] = Math.max(opt1, opt2);
		}
	    return fn[nums.length-1];	
		
	}
	
	public static void main(String args[]){
		int[] arr= {1,3,2,2,4};
		
		/*          0
		          /   \ 
	             2	    1
	           /  \   /  \
	          4   3  3    2
	                 \   / \
	                  4  4  3
	     */
		
		System.out.println("Me ::"+robHouseDP(arr));

	}           
}
