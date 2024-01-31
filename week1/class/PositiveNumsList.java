// Week1 - class: data structure to contain list of positive numbers
public class PositiveNumsList {

    private int[] pnums;
    private int size;

    public PositiveNumsList(int max_size) {

        size = 0;
        pnums = new int[max_size];

    }

    public void Add(int num) {
        // only add postive numbers
        // does not let caller know if number not inserted
        if (num >= 0) {
            pnums[size++] = num;
        }
    }


    public boolean Search(int snum) {
        if (this.Index(snum) == -1) {
            return false;
        }
        else {
            return true;
        }
    }

    private int Index(int snum) {
        for (int i = 0; i < size; ++i) {
            if (pnums[i] == snum) {
                return i;
            }
        }
        return -1;
    }

    public boolean Delete(int dnum) {  // return true or false if successful
        int index = this.Index(dnum);
        if (index != -1) {
            // move everything down one starting at index
            for (int i = index; i < size; ++i) {
                pnums[i] = pnums[i+1];
            }

            // decrement size
            size--;
            return true; // number was found
        }
        return false;  // number wasn't found
    }        

    public int Max() {
        int max = 0;
        for (int i = 0; i < size; i++) {
            if (pnums[i] > max) {
                max = pnums[i];
            }
        }
        return max;
    }
}
    
