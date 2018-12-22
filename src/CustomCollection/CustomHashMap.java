package CustomCollection;

public class CustomHashMap<K, V> {
	/*
	 * 
	 * Utility class for every entry into hashmap *
	 */
	private Entry<K, V> table[];
	private Entry<K, V>previous=null;
	private Entry<K,V>current;

	static class Entry<K, V> {
		private K key;
		private V value;
		Entry<K, V> next;

		Entry() {
		}

		// Entry
		Entry(K key, V value) {
			this.key = key;
			this.value = value;
			this.next = null;
		}
	}

	CustomHashMap() {
		table = new Entry[10];
	}

	void put(K key,V value) {
		int hash=getHashCode(key);
		current=table[hash];
		if(table[hash]==null) {
			table[hash]=new Entry<K, V>(key, value);
		}else {
			if(current.key.equals(key)) {
				table[hash]=new Entry<K, V>(key, value);
			}else {
				current=table[hash];
				if(previous==null) {
					table[hash]=new Entry<K,V>(key,value);
				}
				else {
				while(current!=null){
					current=current.next;
					previous=current;
				}
				previous.next=new Entry<K, V>(key, value);
				}
			}
		}
		
	}

	private V get(K key) {
		int hash = getHashCode(key);
		Entry<K, V> entry = table[hash];
		while (entry != null) {
			if (entry.key.equals(key))
				return entry.value;
			// System.out.println(entry.key);
			entry = entry.next;
		}
		return null;
	}

	int getHashCode(K key) {
		int code = key.hashCode() % table.length;
		return code;
	}
	boolean remove(K key) {
		int hash=getHashCode(key);
		Entry<K,V>entry=table[hash];
		if(entry.key.equals(key)) {
			return (table[hash]=null)==null;
		}
		else {
			while(entry!=null) {
				entry=entry.next;
				if(entry.key.equals(key)) {
					previous.next=entry.next;
					previous=entry;
					return (entry=null)==null;
				}
			}
		}
		return false;
	}
	public static void main(String args[]) {
		CustomHashMap<Integer, Integer> customHashMap = new CustomHashMap<>();
		customHashMap.put(4, 5);
		customHashMap.put(20, 15);
		customHashMap.put(3, 25);
		customHashMap.put(2, 35);
		System.out.println(	customHashMap.remove(20));
	
		System.out.println(customHashMap.get(20));
		System.out.println(customHashMap.get(3));
	}
}
