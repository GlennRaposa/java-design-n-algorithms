package com.a.dynamic.programming;
/*
 * Objective:  Suppose you’re managing construction of billboards on the Rocky & Bullwinkle Memorial Highway, 
 * a heavily traveled stretch of road that runs westeast for M miles. 
 * The possible sites for billboards are given by num­bers x1 < x2 < · · · < xn, 
 * each in the inter­val [0, M], spec­i­fy­ing their posi­tion in miles mea­sured from the west­ern end of the road. 
 * If you place a bill­board at posi­tion xi , you receive a rev­enue of ri > 0.
 * 
 * http://algorithms.tutorialhorizon.com/dynamic-programming-highway-billboard-problem/
 * 
 * "MR(i)  is Maximum Revenue generated for i miles in highway"

	Now for each mile in highway, we need to check whether this mile has option for any bill­board, 
	if not then maximum revenue generated till that mile would be same as maximum revenue generated till one mile before.
	
	But if that mile has option for billboard then we have 2 options
	
	   Either we will place the billboard (ignore the billboards in previous 5 miles) and add the revenue of billboard placed.
	   OR we will ignore the billboard
	   So we will choose the option which will gen­er­ate the max­i­mum revenue.
	
	MR(i) = Max{MR(i-6) + Revenue[i], MR[i-1]}
	
	
	int[] x = {6, 7, 12, 13, 14};
	int[] revenue = {5, 6, 5, 3, 1};
	int distance = 20;
	int milesRestriction = 5;

	Output: Maximum revenue can be generated :10 ( x1 and x3 billboard will be placed)
 */
public class HighwayBillboard {

    public int maxRevenue(int[] billboard, int[] revenue, int distance, int milesRes) {

        int[] MR = new int[distance + 1];
        //Next billboard which can be used will start from index 0 in billboard[]
        int nextBillBoard = 0;
        //example if milesRes = 5 miles then any 2 bill boards has to be more than
        //5 miles away so actually we can put at 6th mile so we can add one mile milesRes
        milesRes = milesRes + 1; // actual minimum distance can be between 2 billboards
        MR[0] = 0;

        for (int i = 1; i <= distance; i++) {
            //check if all the billboards are not already placed
            if(nextBillBoard < billboard.length){
                //check if we have billboard for that particular mile
                //if not then copy the optimal solution from i-1th mile
                if (billboard[nextBillBoard] != i) {
                    //we do not have billboard for this particular mile
                    MR[i] = MR[i - 1];
                } else {
                    //we do  have billboard for this particular mile
                    //now we have 2 options, either place the billboard or ignore it
                    //we will choose the optimal solution
                    if(i>=milesRes){
                        MR[i] = Math.max(MR[i - milesRes] + revenue[nextBillBoard], MR[i - 1]);
                    }else{
                        //there are no billboard placed prior to ith mile
                        //we will just place the billboard
                        MR[i] = revenue[nextBillBoard];
                    }

                    nextBillBoard++;
                }
            }else{
                //All the billboards are already placed
                //for rest of the distance copy the previous optimal solution
                MR[i] = MR[i - 1];
            }

        }

        //System.out.println(Arrays.toString(MR));
        return MR[distance];
    }


    public static void main(String[] args) {
        int[] x = {6, 7, 12, 13, 14};
        int[] revenue = {5, 6, 5, 3, 1};
        int distance = 20;
        int milesRestriction = 5;

        HighwayBillboard h = new HighwayBillboard();
        int result = h.maxRevenue(x, revenue, distance, milesRestriction);
        System.out.println("Maximum revenue can be generated :" + result);
    }
}
