package com.hashtable;

public class MyMapNode<Key, Value> {
	public Key key;
	public Value value;
	public MyMapNode<Key, Value> next;
	
	MyMapNode(Key key, Value value) {
		this.key = key;
		this.value = value;
	}
	
	public String toString() {
		return "[ "+key+" : "+value+" => "+next+" ]";
	}
}