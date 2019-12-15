package com.javaxpert.dsalgoimpl.stack;

import java.util.Scanner;

class Stack<T> {
	
	class Node<T> {
		T data;
		Node<T> next;
		
		Node(T data) {
			this.data = data;
			next = null;
		}
	}
	
	private Node<T> top;
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public T peek() {
		return top.data;
	}
	
	public void push(T data) {
		Node<T> node = new Node<T>(data);
		node.next = top;
		top = node;
	}
	
	public T pop() {
		T data = top.data;
		top = top.next;
		return data;
	}
	
}


public class StackClassRunner {

	public static void main(String args[] ) {
		
		Stack<String> st = new Stack<String>();
		Scanner scan = new Scanner(System.in);
		
		String input =  scan.next();
		st.push(input);
		input = scan.next();
		st.push(input);
		
		System.out.println("top of stack is " + st.peek());
		
		System.out.println("removed element is " + st.pop());
		
		System.out.println("top of stack is " + st.peek());
		
		System.out.println("is stack empty " + st.isEmpty());
		
		
	}
	
	
}
