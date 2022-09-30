package com.hashtable;

public class MyMapNode<Key, Value> {
	public Key key;
	public Value value;
	public MyMapNode<Key, Value> next;
	
	/**
	 * Create My Map Node with key value pair data
	 * 
	 * @param key
	 * @param value
	 */
	MyMapNode(Key key, Value value) {
		this.key = key;
		this.value = value;
	}
	
	public String toString() {
		return "[ "+key+" : "+value+" => "+next+" ]";
	}
}