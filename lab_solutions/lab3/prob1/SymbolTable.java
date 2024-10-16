
import java.util.TreeMap;

public class SymbolTable<Key extends Comparable<Key>, Value> {

    private TreeMap<Key, Value> st;

    public SymbolTable() {
        st = new TreeMap<Key, Value>();
    }

    public Value get(Key key) {
        return st.get(key);
    }

    public void put(Key key, Value val) {
        if (val == null) {
            st.remove(key);
        }
        else {
            st.put(key, val);
        }
    }

    public void delete(Key key) {
        st.remove(key);
    }

    public boolean contains(Key key) {
        return st.containsKey(key);
    }

    public int size() {
        return st.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Iterable<Key> keys() {
        return st.keySet();
    }

    public Key min() {
        return st.firstKey();
    }

    public Key max() {
        return st.lastKey();
    }

}

