package keyValuePair;

public class KeyValuePair<K extends Comparable<K>,V> implements Comparable<KeyValuePair<K,V>> {
	private K k;
	private V v;
	
	public K getK() {
		return k;
	}

	public void setK(K k) {
		this.k = k;
	}

	public V getV() {
		return v;
	}

	public void setV(V v) {
		this.v = v;
	}

	public KeyValuePair(K k, V v) {
		this.k = k;
		this.v = v;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((k == null) ? 0 : k.hashCode());
		result = prime * result + ((v == null) ? 0 : v.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof KeyValuePair))
			return false;
		KeyValuePair<?, ?> other = (KeyValuePair<?, ?>) obj;
		if (k == null) {
			if (other.k != null)
				return false;
		} else if (!k.equals(other.k))
			return false;
		if (v == null) {
			if (other.v != null)
				return false;
		} else if (!v.equals(other.v))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "(" + k + ", " + v + ")";
	}

	@Override
	public int compareTo(KeyValuePair<K, V> o) {
		return this.getK().compareTo(o.getK());
	}
}
