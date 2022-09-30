package com.hashtable;

public class Entry<Key, Value> {
	public Key key;
	public Value value;
	
	Entry(Key key, Value value) {
		this.key = key;
		this.value = value;
	}
}
