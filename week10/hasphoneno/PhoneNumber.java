// Taken from Algorithms, 4th edition by Sedgewick and Wayne

import java.util.HashSet;
import java.util.Iterator;

public final class PhoneNumber {
    private final int area;   // area @code (3 digits)
    private final int exch;   // exchange  (3 digits)
    private final int ext;    // extension (4 digits)

    /**
     * Initializes a new phone number.
     *
     * @param  area the area @code (3 digits)
     * @param  exch the exchange (3 digits)
     * @param  ext  the extension (4 digits)
     */
    public PhoneNumber(int area, int exch, int ext) {
        this.area = area;
        this.exch = exch;
        this.ext  = ext;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (other.getClass() != this.getClass()) return false;
        PhoneNumber that = (PhoneNumber) other;
        return (this.area == that.area) && (this.exch == that.exch) && (this.ext == that.ext);
    }

    public String toString() {
        // 0 for padding with digits with leading 0s
        return String.format("(%03d) %03d-%04d", area, exch, ext);
    }

    public int hashCode() {
        System.out.println("in our hashcode");
        System.out.println("hash is " + (31 * (area + 31 * exch) + ext));
        return 31 * (area + 31 * exch) + ext;
    }

    /**
     * Unit tests the {@code PhoneNumber} data type.
     */
    public static void main(String[] args) {
        PhoneNumber a = new PhoneNumber(609, 258, 4455);
        PhoneNumber b = new PhoneNumber(609, 876, 5309);
        PhoneNumber c = new PhoneNumber(609, 555, 5309);
        PhoneNumber d = new PhoneNumber(215, 876, 5309);
        PhoneNumber e = new PhoneNumber(609, 876, 5309);
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        System.out.println("d = " + d);
        System.out.println("e = " + e);
        System.out.println("before new hashset");
        HashSet<PhoneNumber> set = new HashSet<PhoneNumber>();
        set.add(a);
        set.add(b);
        set.add(c);
        set.add(d);
        set.add(e);
        System.out.println("Size of our hashset: " + set.size());
        System.out.println("after adds");
        System.out.println("Added a, b, c, d");
        System.out.println("contains a:  " + set.contains(a));
        System.out.println("contains b:  " + set.contains(b));
        System.out.println("contains c:  " + set.contains(c));
        System.out.println("contains d:  " + set.contains(d));
        System.out.println("contains e:  " + set.contains(e));
        System.out.println("b == e:      " + (b == e));
        System.out.println("b.equals(e): " + (b.equals(e)));

        Iterator<PhoneNumber> pi = set.iterator();
        while (pi.hasNext()) {
            System.out.println(pi.next().toString());
        }
    }
}
