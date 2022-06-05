package com.convex.hull;

import java.util.Arrays;
import java.util.Stack;

public class GrahamScan1 {
	
	private Stack<Point2D1> hull = new Stack<Point2D1>();
	
	public GrahamScan1(Point2D1[] pts){
		 int N = pts.length;
		//Todo
		//1. create temp array 
		Point2D1[] points = new Point2D1[pts.length]; 
		
		for(int i=0; i< N; i++){
			points[i] = pts[i];
		}
		
		//Sort that array to get the smallerst Y axis coordiantes
		Arrays.sort(points);
		
		//sorts the point with the polar angle at p[0]
		Arrays.sort(points,1,N,points[0].POLAR_ORDER);
		
		
		
		
		
		
		
	}

    public static void main(String[] args)
    {
        Point2D[] points = new Point2D[5];
        points[0] = new Point2D(1, 2);
        points[1] = new Point2D(2, 3);
        points[2] = new Point2D(3, 4);
        points[3] = new Point2D(4, 5);
        points[4] = new Point2D(5, 6);

        GrahamScan graham = new GrahamScan(points);
        System.out.println("The convex hull consists of following points: ");
        for (Point2D p : graham.hull()){
            System.out.println(p);
        }
 
    }
	
}
