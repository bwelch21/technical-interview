public class HashTable {
	
	private int maxSize;
	private int size;
	private String[] table;

	public HashTable() {
		this(10);
	}

	public HashTable(int size) {
		this.table = new String[size];
		this.maxSize = size;
		this.size = 0;
	}

	public void add(String key, String value) {

		if(size == maxSize) {
			this.resizeTable();
		}

		int index = this.hash(key);

		if(table[index] == null) {
			table[index] = value + key;	
		} else {
			while(table[index] != null) {
				if(index + 1 < maxSize) {
					index++;
				} else {
					index = 0;
				}
			}
			table[index] = value + key;
		}
		size++;
	}

	public String get(String key) {
		int startIndex = this.hash(key);
		int index = startIndex;

		if(table[index] == null) {
			return null;
		} else if(table[index].substring(10).equals(key)) {
			return table[index].substring(0, 10);
		} else {
			do {
				while(!table[index].substring(10).equals(key)) {
					if(index + 1 < maxSize) {
						index++;
						if(index == startIndex || table[index] == null) {
							return null;
						}
					} else {
						index = 0;
					}
				}
			} while(!table[index].substring(10).equals(key));

			return table[index].substring(0, 10);
		}
	}

	public int hash(String key) {
		int charSum = 0;
		int keyLength = key.length();

		for(int i = 0; i < keyLength; i++) {
			charSum += key.charAt(i);
		}

		return charSum % this.maxSize;	
	}

	public void resizeTable() {
		String[] newTable = new String[this.maxSize + 10];

		for(int i = 0; i < maxSize; i++) {
			newTable[i] = this.table[i];
		}

		this.table = newTable;
		this.maxSize = this.maxSize + 10;
		this.size = this.maxSize;

		return;
	}

	public static void main(String[] args) {
		HashTable phoneNumbers = new HashTable(3);

		phoneNumbers.add("Brandt", "3013567889");
		phoneNumbers.add("Home", "7037717657");
		phoneNumbers.add("Maryland", "3013170235");
		System.out.println(phoneNumbers.get("Brandt"));
		System.out.println(phoneNumbers.get("Home"));
		System.out.println(phoneNumbers.get("Maryland"));
		phoneNumbers.add("NoLongerAnError", "1234567890");
		System.out.println(phoneNumbers.get("NoLongerAnError"));

	}
}