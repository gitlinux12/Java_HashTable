package com.hashtable;

import java.util.Hashtable;

public class HashTable<Key, Value> {
	LinkedList<Key, Value>[] hashArray;
	int capacity = 23;
	
	
	public HashTable() {
		hashArray = new LinkedList[capacity];
		for(int index = 0; index < capacity; index++) {
			hashArray[index] = new LinkedList<Key, Value>(); 
		}
	}
	
	public int hashFunction(Key key) {
		return (key.hashCode() % capacity) >= 0 ? (key.hashCode() % capacity) : -(key.hashCode() % capacity);
	}
	
	
	public void put(Key key, Value value) {
		hashArray[hashFunction(key)].put(key, value);
	}
	
	
	public boolean containsKey(Key key) {
		return hashArray[hashFunction(key)].containsKey(key);
	}

	public Value get(Key key) {
		return hashArray[hashFunction(key)].get(key);
	}
	
	public Entry<Key, Value>[] all() {
		Entry<Key, Value>[] result = new Entry[size()];
		int count = 0;
		for(int index = 0; index < capacity; index++) {
			Entry<Key, Value>[] tempEntries = hashArray[index].all();
			for(Entry entry : tempEntries) {
				result[count] = entry;
				count++;
			}
		}
		return result;
	}
	
	public boolean isEmpty() {
		for(int index = 0; index < capacity; index++) if (!hashArray[index].isEmpty()) return false;
		return true;
	}
	public int size() {
		int count = 0;
		for(int index = 0; index < capacity; index++) count += hashArray[index].size();
		return count;
	}
	
	public static void main(String[] args) {
		String sentence = "To be or not to be";
		HashTable<String, Integer> frequencyOfWords = new HashTable<String, Integer>();
		String[] words = sentence.split(" ");
		for(String word : words) 
			if (frequencyOfWords.containsKey(word)) {
				Integer frequencyOfWord = frequencyOfWords.get(word);
				frequencyOfWord++;
				frequencyOfWords.put(word, frequencyOfWord);
			} else frequencyOfWords.put(word, 1);
		for(Entry entry : frequencyOfWords.all()) {
			System.out.println("Frequency of \""+entry.key+"\" in sentence is "+entry.value);
		}	
	}
}
