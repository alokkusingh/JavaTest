package alok.test.algo.lru;

import java.util.LinkedHashMap;
import java.util.Map;

class LRU {
	private final int limit;
	private Map<Integer, String> lruContainer;
	private Database db = new Database();

	public LRU(final int limit) {
		this.limit = limit;
		lruContainer = new LinkedHashMap<Integer, String>(limit + 1, 1, true) {
			private static final long serialVersionUID = 1L;

			@Override
			protected boolean removeEldestEntry(Map.Entry eldest) {
				System.out.println("\tEldest:" + eldest.getKey() + "-->" + eldest.getValue());
				return size() > limit;
			}
		};
	}

	public String getRecord(final int i) {
		String data = null;

		if (lruContainer.containsKey(i)) {
			return lruContainer.get(i);
		}
		
		data = db.getRecord(i);
		lruContainer.put(i, data);
		System.out.println("\tContainer size after adding in LRU container: " + lruContainer.size());

		return data;
	}

}

class Database {
	String[] data;

	public Database() {
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

public class MyLRU {

	public static void main(String[] args) {
		LRU cache = new LRU(10);
		
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
