package com.javaxpert.geeksforgeeks.microsoft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ListNode<T> {
	T data;
	ListNode<T> next;

	ListNode(T data) {
		this.data = data;
		this.next = null;
	}
}

class LList<T> {
	ListNode<T> head;

	LList() {
		head = null;
	}

	public void append(T data) {
		if (head == null) {
			head = new ListNode<T>(data);
		} else {
			ListNode<T> temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = new ListNode<T>(data);
		}
	}

	public void printList() {
		ListNode<T> temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

}

public class LinkedListCycleDetection {
	public static void main(String args[]) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		LList<String> list = new LList<String>();
		String arr[] = br.readLine().trim().split(" ");
		for(String s : arr) {
			list.append(s);
		}		
		
		list.printList();
		
	}

	
	
}
