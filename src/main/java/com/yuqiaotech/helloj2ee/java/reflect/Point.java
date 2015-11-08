package com.yuqiaotech.helloj2ee.java.reflect;

public class Point {
	int x;
	int y;

	public Point() {
	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public double getDistant() {
		return getDistant(0, 0);
	}

	public double getDistant(int x, int y) {
		int x1 = this.x - x;
		int y1 = this.y - y;
		return Math.sqrt(x1 * x1 + y1 * y1);
	}

	public String toString() {
		return "x=" + x + ",y=" + y;
	}
}