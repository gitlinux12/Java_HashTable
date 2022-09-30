package com.hashtable;

public class LinkedList<Key, Value> {
	MyMapNode<Key, Value> head;
	
	LinkedList(){
		head = null;
	}
	
	/**
	 * put data with key value pair to the linked list
	 * key will be unique in list
	 * it will check linked list already contains data with key or not 
	 * if contains then it will update that data otherwise create new data with new key
	 * data with key value pair will wrap in MyMapNode 
	 * 
	 * @param key
	 * @param value
	 */
	public void put(Key key, Value value) {
		MyMapNode<Key, Value> newNode = new MyMapNode<Key, Value>(key, value);
		if(isEmpty()) {
			head = newNode;
			return;
		}
		if(head.key.equals(key)) {
			newNode.next = head.next;
			head = newNode;
			return;
		}
		MyMapNode<Key, Value> currentNode = head;
		while(currentNode.next != null) {
			if(currentNode.next.key.equals(key)) {
				newNode.next = currentNode.next.next;
				currentNode.next = newNode;
				return;
			}
			currentNode = currentNode.next;
		}
		currentNode.next = newNode;
	}
	
	/**
	 * check linked list has data with key or not
	 * 
	 * @param key
	 * @return true if contains key otherwise false
	 */
	public boolean containsKey(Key key) {
		if(isEmpty()) return false;
		if(head.key.equals(key)) return true;
		MyMapNode<Key, Value> currentNode = head;
		while(currentNode.next != null) {
			if(currentNode.next.key.equals(key)) return true;
			currentNode = currentNode.next;
		}
		return false;
	}
	
	/**
	 * get value in linked list which has pair with key
	 * 
	 * @param key
	 * @return {@value}
	 */
	public Value get(Key key) {
		if(isEmpty()) return null;
		if(head.key.equals(key)) return head.value;
		MyMapNode<Key, Value> currentNode = head;
		while(currentNode.next != null) {
			if(currentNode.next.key.equals(key)) return currentNode.next.value;
			currentNode = currentNode.next;
		}
		return null;
	}
	
	/**
	 * take data of each node and wrap it with entry class and return array of entry
	 * 
	 * @return entries
	 */
	public Entry<Key, Value>[] all() {
		Entry<Key, Value>[] result = new Entry[size()];
		MyMapNode<Key, Value> currentNode = head;
		int index = 0;
		while(currentNode != null) {
			result[index] = new Entry<Key, Value>(currentNode.key, currentNode.value);
			currentNode = currentNode.next;
			index++;
		}
		return result;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	/**
	 * Return how many number of nodes in linked list
	 * 
	 * @return count of nodes
	 */
	public int size() {
		int count = 0;
		MyMapNode<Key, Value> currentNode = head;
		while(currentNode != null) {
			count++;
			currentNode = currentNode.next;
		}
		return count;
	}
	
	public String toString() {
		if(!isEmpty())	return head.toString();
		else return "null";
	}
}