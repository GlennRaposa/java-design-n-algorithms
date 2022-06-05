package a.com.interesting.dynamic.programming;

import java.util.HashSet;

/*
 * http://www.geeksforgeeks.org/longest-consecutive-subsequence/
1) Create an empty hash.
2) Insert all array elements to hash.
3) Do following for every element arr[i]
....a) Check if this element is the starting point of a 
       subsequence.  To check this, we simply look for
       arr[i] - 1 in hash, if not found, then this is
       the first element a subsequence.  
    
       If this element is a first element, then count 
       number of elements in the consecutive starting 
       with this element.

       If count is more than current res, then update    
       res.
 */
public class findLongestConseqSubseqUENCE {

	// Returns length of the longest consecutive subsequence
    static int findLongestConseqSubseq(int arr[],int n)
    {
        HashSet<Integer> S = new HashSet<Integer>();
        int answer = 0;
 
        // Hash all the array elements
        for (int i=0; i<n; ++i)
            S.add(arr[i]);
 
        // check each possible sequence from the start
        // then update optimal length
        for (int i=0; i<n; ++i)
        {
            // if current element is the starting
            // element of a sequence
            if (!S.contains(arr[i]-1))
            {
                // Then check for next elements in the
                // sequence
                int j = arr[i];
                while (S.contains(j)){
                    j++;
                }   
 
                // update  optimal length if this length
                // is more
                System.out.println("J="+j+" arr[i]="+arr[i]);
                if (answer<j-arr[i]){
                    answer = j-arr[i];
                }
                /* Order of how it setting answer
                 *  J=5 arr[i]=1
					J=11 arr[i]=9
					J=21 arr[i]=20
					Length of the Longest consecutive subsequence is 4
                 */
            }
        }
        return answer;
    }
    
    // Testing program
    public static void main(String args[])
    {
        int arr[] =  {1, 9, 3, 10, 4, 20, 2};
        int n = arr.length;
        System.out.println("Length of the Longest consecutive subsequence is " +
                           findLongestConseqSubseq(arr,n));
    }
}
