package alok.test.algo.lru;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class OwnLRU {

	final int size;
	final Map<Integer, String> cache = new HashMap<>();
	final Queue<Integer> queue = new LinkedList<>();
	final MyDatabase db = new MyDatabase();
	
	public OwnLRU(int i) {
		this.size = i;
	}

	public String getRecord(int i) {
	
		String value = null;
		if (cache.containsKey(i)) {
			System.out.println(i + " getting from cache");
			value = cache.get(i);
			queue.remove(i);
			queue.add(i);
		} else {
			value = db.getRecord(i);
			
			if (value != null) {
				if (queue.size() == size) {
					System.out.println(cache.remove(queue.remove()) + " removed from cache");
					System.out.println("Cache is full");
				}
				queue.add(i);
				cache.put(i, value);
				System.out.println(i + " added in cache");
			}
		}
	
		return value;
	}
}

class MyDatabase {
	String[] data;

	public MyDatabase() {
		data = new String[100];
		for (int i = 0; i < 100; i++)
			data[i] = "Record " + i;
	}

	public String getRecord(final int i) {
		System.out.println("\t[DB Read] " + i);
		if (i < 100) {
			return data[i];
		}

		return null;
	}
}

public class MyOwnLRU {

	public static void main(String[] args) {
		OwnLRU cache = new OwnLRU(10);
		
		System.out.println(cache.getRecord(1));
		System.out.println(cache.getRecord(2));
		System.out.println(cache.getRecord(3));
		System.out.println(cache.getRecord(4));
		System.out.println(cache.getRecord(1));
		System.out.println(cache.getRecord(5));
		System.out.println(cache.getRecord(6));
		System.out.println(cache.getRecord(7));
		System.out.println(cache.getRecord(8));
		System.out.println(cache.getRecord(9));
		System.out.println(cache.getRecord(1));
		System.out.println(cache.getRecord(1));
		System.out.println(cache.getRecord(10));
		System.out.println(cache.getRecord(10));
		System.out.println(cache.getRecord(11));
		System.out.println(cache.getRecord(12));
		System.out.println(cache.getRecord(1));
		System.out.println(cache.getRecord(2));	
	}

}