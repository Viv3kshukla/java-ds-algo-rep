package com.javaxpert.javacollectionimpl;

import java.util.ArrayList;
import java.util.LinkedList;

public class Hmap<K,V> {
	public class Entry {
		K key;
		V value;
	}
	
	private int size = 0;
	private LinkedList<Entry> buckets[];
	
	public Hmap() {
		buckets = new LinkedList[4];
		for(int i = 0;i<4;i++) {
			buckets[i] = new LinkedList<Entry>();
		}
	}
	
	public void put(K key, V value) throws Exception {
		int bI = bucketIndex(key);
		int foundAt = find(bI,key);
		
		if (foundAt == -1) {
			Entry temp = new Entry();
			temp.key = key;
			temp.value = value;
			buckets[bI].addLast(temp);
			this.size++;
		}
		else {
			buckets[bI].get(foundAt).value = value;
		}
		
		double lambda = (this.size * 1.0) / this.buckets.length;
		
		if(lambda > 2.0) {
			rehash();
		}
		
	
	}
	
	private void rehash() throws Exception {
		LinkedList<Entry> obj[] = buckets;
		buckets = new LinkedList[obj.length * 2];
		for(int i=0;i<obj.length;i++) {
			buckets[i] = new LinkedList<>();
		}
		
		size = 0;
		for(int i=0;i<obj.length;i++) {
			for(int j=0;j<obj[i].size();j++) {
				put(obj[i].get(j).key,obj[i].get(j).value);
			}
		}
	}
	
	public ArrayList<K> keyset() throws Exception {
		ArrayList<K> arr = new ArrayList<K>();
		for(int i=0;i<buckets.length;i++) {
			for(int j=0;j<buckets[i].size();j++) {
				arr.add(buckets[i].get(j).key);
			}
		}
		return arr;
	}
	
	
	public ArrayList<V> valueset() throws Exception {
		ArrayList<V> arr = new ArrayList<V>();
		for(int i=0;i<buckets.length;i++) {
			for(int j=0;j<buckets[i].size();j++) {
				arr.add(buckets[i].get(j).value);
			}
		}
		return arr;
	}
	
	
	public boolean containsKey(K key) throws Exception {
		int bI = bucketIndex(key);
		int foundAt = find(bI,key);
		if(foundAt == -1) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public V remove(K key) throws Exception {
		int bI = bucketIndex(key);
		int foundAt = find(bI,key);
		if(foundAt == -1) {
			return null;
		}
		else {
			this.size--;
			return buckets[bI].remove(foundAt).value;	
		}
	}
	
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	public int size() {
		return this.size;
	}
	
	
	public int find(int bI,K key) throws Exception{
		for(int i=0;i<buckets[bI].size();i++) {
			if(key.equals(buckets[bI].get(i).key)) {
				return i;
			}
		}
		return -1;
	}
	
	public int bucketIndex(K key) throws Exception {
		int bI = key.hashCode();
		return Math.abs(bI % buckets.length);
	}
	
}
