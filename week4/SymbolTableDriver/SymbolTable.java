
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.TreeMap;

public class SymbolTable {

    private TreeMap<String, Integer> st;

    public SymbolTable() {
        st = new TreeMap<String, Integer>();
    }


    public int get(String key) {
        if (key == null) throw new IllegalArgumentException("calls get() with null key");
        return st.get(key);
    }

    public void put(String key, int val) {
        if (key == null) throw new IllegalArgumentException("calls put() with null key");
        if (val == -1) st.remove(key);
        else             st.put(key, val);
    }

    public void delete(String key) {
        if (key == null) throw new IllegalArgumentException("calls delete() with null key");
        st.remove(key);
    }

    public boolean contains(String key) {
        if (key == null) throw new IllegalArgumentException("calls contains() with null key");
        return st.containsKey(key);
    }

    public int size() {
        return st.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Iterable<String> keys() {
        return st.keySet();
    }

    public String min() {
        if (isEmpty()) throw new NoSuchElementException("calls min() with empty symbol table");
        return st.firstKey();
    }

    public String max() {
        if (isEmpty()) throw new NoSuchElementException("calls max() with empty symbol table");
        return st.lastKey();
    }

    public String ceiling(String key) {
        if (key == null) throw new IllegalArgumentException("argument to ceiling() is null");
        String k = st.ceilingKey(key);
        if (k == null) throw new NoSuchElementException("all keys are less than " + key);
        return k;
    }

    public String floor(String key) {
        if (key == null) throw new IllegalArgumentException("argument to floor() is null");
        String k = st.floorKey(key);
        if (k == null) throw new NoSuchElementException("all keys are greater than " + key);
        return k;
    }
    
}

