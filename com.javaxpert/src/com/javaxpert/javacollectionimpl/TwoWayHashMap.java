package com.javaxpert.javacollectionimpl;

import java.io.Serializable;
import java.util.Hashtable;
import java.util.Map;

public class TwoWayHashMap<K,V> implements Serializable{

	/**
	 * Two Way Hash Map to get Key from Value and vice-versa
	 */
	private static final long serialVersionUID = 1L;
	
	protected Map<K,V> forwardMap = new Hashtable<K,V>();
	protected Map<V,K> backwardMap = new Hashtable<V,K>();
	
	public synchronized void put(K key, V value) {
		forwardMap.put(key, value);
		backwardMap.put(value, key);
	}
	
	public synchronized V getValue(K key) {
		return forwardMap.get(key);
	}
	
	public synchronized K getKey(V value) {
		return backwardMap.get(value);
	}
	
	
}
