package com.convex.hull;
// http://www.sanfoundry.com/java-program-implement-graham-scan-algorithm-find-convex-hull/

import java.util.Arrays;
import java.util.Stack;
//TIME COMPLEXITY O(Nlog N)
public class GrahamScan
{
    private Stack<Point2D> hull = new Stack<Point2D>();
 
    public GrahamScan(Point2D[] pts)
    {
        // defensive copy
        int N = pts.length;
        
        Point2D[] points = new Point2D[N];
        
        for (int i = 0; i < N; i++){
            points[i] = pts[i];
        }
        //1. Choose p with the smallest Y coordinates
        Arrays.sort(points);  // quick sort
        
        //2. Sort the points with polar angle with p[0]
        Arrays.sort(points, 1, N, points[0].POLAR_ORDER);
        
        //3. consider points in order; discard unless it create a ccw turn 
        //Sweep/move counter clock wise  --> Left turns are what we need --> right turns are bad --> when we hit a right turn 
        //we have to use backtracking on a few points 
        hull.push(points[0]); // p[0] is first extreme point
        int k1;
        for (k1 = 1; k1 < N; k1++){
            if (!points[0].equals(points[k1]))
                break;
        }    
        if (k1 == N)
            return; // all points equal
 
        int k2;
        for (k2 = k1 + 1; k2 < N; k2++){
        	//Counter clock wise turn CCW() compares three points to
        	//https://www.youtube.com/watch?v=0HZaRu5IupM
            if (Point2D.ccw(points[0], points[k1], points[k2]) != 0)
                break;
        }    
        hull.push(points[k2 - 1]); // points[k2-1] is second extreme point
        System.out.println("K2="+k2+" hull:"+hull); 
        
        for (int i = k2; i < N; i++)
        {
            Point2D top = hull.pop(); //BackTracking - discard points that would create clockwise turns
            while (Point2D.ccw(hull.peek(), top, points[i]) <= 0)
            {
                top = hull.pop();  //BackTracking - discard points that would create clockwise turns
            }
            hull.push(top);
            hull.push(points[i]);
        }
 
        assert isConvex();
    }
 
 
    private boolean isConvex()
    {
        int N = hull.size();
        if (N <= 2)
            return true;
 
        Point2D[] points = new Point2D[N];
        int n = 0;
        for (Point2D p : hull())
        {
            points[n++] = p;
        }
 
        for (int i = 0; i < N; i++)
        {
            if (Point2D
                    .ccw(points[i], points[(i + 1) % N], points[(i + 2) % N]) <= 0)
            {
                return false;
            }
        }
        return true;
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
    
    //Method Just to print out results - Not relevant for Computation 
    public Iterable<Point2D> hull()
    {
        Stack<Point2D> s = new Stack<Point2D>();
        for (Point2D p : hull)
            s.push(p);
        return s;
    }

}

