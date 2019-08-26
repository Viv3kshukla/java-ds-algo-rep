package com.javaxpert.geeksforgeeks.microsoft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Problem Link: 
 * https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1
 */


class Node<T> {
	T data;
	Node next;
	
	Node(T data) {
		this.data = data;
	}
}


class LinkedList<T> {
	Node head;
	
	public void append(T data) {
		if (head == null) {
			head = new Node(data);
			return;
		}
		
		Node current = head;
		while(current.next != null) {
			current = current.next;
		}
		
		current.next = new Node(data);
		
	}
	
	public void prepend(T data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}
	
	public Node findNode(T data) {
		Node current = head;
		while(current != null) {
			if (current.data.equals(data)) {
				break;
			}
			current = current.next;
		}
		return current;
	}
	
	public void deleteNode(Node current) {
		current.data = current.next.data;
		current.next = current.next.next;
	}
	
	public void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	
}

public class DeletePointerWithoutHead {
	public static void main(String args[]) throws IOException {
		String input;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<String> list = new LinkedList<String>();
		input = br.readLine();
		int n = Integer.parseInt(input);
		for (int i = 0;i < n; i++) {
			input = br.readLine();
			list.append(input.trim());
		}
		
		list.printList();
		System.out.println("enter value to delete element");
		input = br.readLine();
		list.deleteNode(list.findNode(input));
		list.printList();
		
	}
}
