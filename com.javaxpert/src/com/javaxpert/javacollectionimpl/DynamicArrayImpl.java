package com.javaxpert.javacollectionimpl;

public class DynamicArrayImpl {
	
	private int size,capacity;
	private int [] elements;
	
	public DynamicArrayImpl() {
		size = 0;
		capacity = 1;
		elements = new int[capacity];
	}
	
	public void add(int element) {
		if(size == capacity) {
			increaseCapacity();
		}
		elements[size++] = element;
	}
	
	public int get(int index) {
		return elements[index];
	}
	
	public void set(int index,int element) {
		elements[index] = element;
	}
	
	private void increaseCapacity() {
		int [] temp = new int[++capacity];
		copyArray(temp,elements);
		elements = temp;
	}
	
	public void copyArray(int [] first, int [] second) {
		for(int i=0;i<second.length;i++) {
			first[i] = second[i];
		}
	}
	
	public int size() {
		return elements.length;
	}
	
}

class DynamicArrayTest {
	public static void main(String args[]) {
		DynamicArrayImpl vec = new DynamicArrayImpl();
		vec.add(2);
		vec.add(3);
		int size = vec.size();
		for(int i=0;i<size;i++) {
			System.out.println(vec.get(i));
		}
		
	}
}


