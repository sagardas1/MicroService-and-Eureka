package com.shopingCart.mathUtills;

public class MathUtills {

	
	public int add(int a,int b) {
		return a+b;
	}
	
	public int sub(int a,int b) {
		if(a>b) {return a-b;}else return b-a;
	}
	
	public int multi(int a,int b) {
		return a*b;
	}
	
	
	public int div(int a,int b) {
		return a/b;
	}
	
	public int modulo(int a,int b) {
		return a%b;
	}
	public double computeCircleArea(int radius) {
		return Math.PI*radius*radius;
	}
}

