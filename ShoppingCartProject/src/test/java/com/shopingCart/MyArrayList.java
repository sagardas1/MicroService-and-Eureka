package com.shopingCart;

public class MyArrayList {

	private Object a[] = new Object[3];

	private int p = 0;

	public void add(Object obj) {

		if (p >= a.length) {
			increase();

		}
		a[p++] = obj;
	}

	public void increase() {

		Object temp[] = new Object[a.length + 3];

		for (int i = 0; i < a.length; i++) {
			temp[i] = a[i];
		}

		a = temp;
	}

	//size
	public int size() {
		return p;
	}

	// get object
	public Object get(int index) {
		if (index >= size()) {
			throw new IndexOutOfBoundsException();

		}
		return a[index];
	}
	
	
	public void add(Object obj,int index) {
		if(index>=size()) {
			throw new IndexOutOfBoundsException();
		}
		if(index>p) {
			increase();
			
		}
		
		
		for(int i=size()-1;i>= index;i--) {
			a[i+1]=a[i];
		}
		
		
		a[index ]=obj;
		
		p++;
	}
}
