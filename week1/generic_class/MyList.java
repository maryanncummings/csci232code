// data structure for a generic list 
public class MyList<E> {

    private E[] tarray;
    private int size;

    public MyList(int max_size) {

       size  = 0;
       tarray = (E[]) new Object[max_size];

    }

    public void Add(E obj) {
        tarray[size++] = obj;
    }


    public boolean Search(E sobj) {
        if (this.Index(sobj) == -1) {
            return false;
        }
        else {
            return true;
        }
    }

    private int Index(E sobj) {
        for (int i = 0; i < size; ++i) {
            if (tarray[i].equals(sobj)) {
                return i;
            }
        }
        return -1;
    }

    public boolean Delete(E dobj) {  // return true or false if successful
        int index = this.Index(dobj);
        if (index != -1) {
            // move everything down one starting at index
            for (int i = index; i < size; ++i) {
                tarray[i] = tarray[i+1];
            }

            // decrement size
            size--;
            return true; // was found
        }
        return false;  // wasn't found
    }        

    public int Size() {
        return size;
    }

    public E getElement(int index) {
        return this.tarray[index];
    }
}
    
