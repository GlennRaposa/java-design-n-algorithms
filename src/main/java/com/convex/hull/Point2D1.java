package com.convex.hull;

import java.util.Comparator;

public class Point2D1 implements Comparable<Point2D1> {

	public final Comparator<Point2D1> POLAR_ORDER = new PolarOrder();
	private final double x;
	private final double y;

	public Point2D1(double x, double y) {
		this.x = x;
		this.y = y;
	}

	// figures out if p1 -> p2 -> p3 are counterclockwise
	public int ccw(Point2D1 a, Point2D1 b, Point2D1 c) {
		// computing slopes of the lines
		double area = ((b.x - a.x) * (c.y - a.y) - (c.x - a.x) * (b.y - a.y));
		if (area < 0) {
			return -1;
		}
		else if (area > 0) {
			return +1;
		}
		else {
			return 0;
		}
	}

	public int compareTo(Point2D1 that) {
		if (this.y > that.y) {
			return +1;
		}
		if (this.y < that.y) {
			return -1;
		}
		if (this.x > that.x) {
			return +1;
		}
		if (this.x < that.x) {
			return -1;
		}
		return 0;
	}

	private class PolarOrder implements Comparator<Point2D1> {
		public int compare(Point2D1 q1, Point2D1 q2) {

			double dx1 = q1.x - x;
			double dy1 = q1.y - y;

			double dx2 = q2.x - x;
			double dy2 = q2.y - y;

			if (dy1 >= 0 && dy2 < 0) {
				return -1; // clockwise
			}
			else if (dy2 >= 0 && dy1 < 0) {
				return +1; // counter clock wise
			}
			if (dy1 == 0 && dy2 == 0) {
				// 3-collinear and horizontal
				if (dx1 >= 0 && dx2 < 0) {
					return -1;
				}
				else if (dx2 >= 0 && dx1 < 0) {
					return -1;
				}
				else {
					return 0;
				}

			}
			else
				return -ccw(Point2D1.this, q1, q2); // both above or below

		}
	}

	public boolean equals(Object other) {
		if (other == this)
			return true;
		if (other == null)
			return false;
		if (other.getClass() != this.getClass())
			return false;
		Point2D1 that = (Point2D1) other;
		return this.x == that.x && this.y == that.y;
	}

	public String toString() {
		return "(" + x + ", " + y + ")";
	}

	public int hashCode() {
		int hashX = ((Double) x).hashCode();
		int hashY = ((Double) y).hashCode();
		return 31 * hashX + hashY;
	}

}
