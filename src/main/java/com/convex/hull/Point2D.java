package com.convex.hull;
//http://www.sanfoundry.com/java-program-implement-graham-scan-algorithm-find-convex-hull/

import java.util.Comparator;

class Point2D implements Comparable<Point2D>
{
    public final Comparator<Point2D> POLAR_ORDER = new PolarOrder();
 
    private final double x; // x coordinate
    private final double y; // y coordinate
 
    public Point2D(double x, double y)
    {
        if (Double.isInfinite(x) || Double.isInfinite(y))
            throw new IllegalArgumentException("Coordinates must be finite");
        if (Double.isNaN(x) || Double.isNaN(y))
            throw new IllegalArgumentException("Coordinates cannot be NaN");
        if (x == 0.0)
            x = 0.0; // convert -0.0 to +0.0
        if (y == 0.0)
            y = 0.0; // convert -0.0 to +0.0
        this.x = x;
        this.y = y;
    }
 
    // Figures out if p1 --> p2 --> p3 is a counter clockwise turn
    public static int ccw(Point2D a, Point2D b, Point2D c)
    {   //computing slopes of the lines
        double area2 = (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
        if (area2 < 0)
            return -1;  //clockwise
        else if (area2 > 0)
            return +1;  //counterclockwise
        else
            return 0;   //collinear
    }
 
    public int compareTo(Point2D that)
    {
        if (this.y < that.y)
            return -1;
        if (this.y > that.y)
            return +1;
        if (this.x < that.x)
            return -1;
        if (this.x > that.x)
            return +1;
        return 0;
    }
 
 
    private class PolarOrder implements Comparator<Point2D>
    {   //computing slopes of the lines 
        public int compare(Point2D q1, Point2D q2)
        {
            double dx1 = q1.x - x;
            double dy1 = q1.y - y;
            double dx2 = q2.x - x;
            double dy2 = q2.y - y;
            
            if (dy1 >= 0 && dy2 < 0)
                return -1; // q1 above; q2 below  //clockwise - https://www.youtube.com/watch?v=0HZaRu5IupM
            else if (dy2 >= 0 && dy1 < 0)  
                return +1; // q1 below; q2 above  //counterClockWise
            else if (dy1 == 0 && dy2 == 0)
            { // 3-collinear and horizontal     
                if (dx1 >= 0 && dx2 < 0)
                    return -1;
                else if (dx2 >= 0 && dx1 < 0)
                    return +1;
                else
                    return 0;
            } else
                return -ccw(Point2D.this, q1, q2); // both above or below
        }
    }
 
 
    public boolean equals(Object other)
    {
        if (other == this)
            return true;
        if (other == null)
            return false;
        if (other.getClass() != this.getClass())
            return false;
        Point2D that = (Point2D) other;
        return this.x == that.x && this.y == that.y;
    }
 
    public String toString()
    {
        return "(" + x + ", " + y + ")";
    }
 
    public int hashCode()
    {
        int hashX = ((Double) x).hashCode();
        int hashY = ((Double) y).hashCode();
        return 31 * hashX + hashY;
    }
 
}
 
