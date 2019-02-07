import java.util.function.Consumer;

public class SmartArray {

    private static final int INITIAL_CAPACITY = 4;

    private int[] data;
    private int size;
    private int capacity;

    public int size() {
        return size;
    }

    public SmartArray() {
        this.data = new int[SmartArray.INITIAL_CAPACITY];
        this.size = 0;
        this.capacity = SmartArray.INITIAL_CAPACITY;
    }

    public SmartArray(int num) {
        this.data = new int[num];
        this.size = 0;
        this.capacity = num;
    }

    private void resize() {
        this.capacity *= 2;

        int[] newData = new int[this.capacity];
        for (int i = 0; i < this.size; i++) {
            newData[i] = this.data[i];
        }
        this.data = newData;
    }

    private void shrink() {
        this.capacity /= 2;

        int[] newData = new int[this.capacity];
        for (int i = 0; i < this.size; i++) {
            newData[i] = this.data[i];
        }
        this.data = newData;
    }


    public void addElement(int element) {
        if (this.size == this.capacity) {
            this.resize();
        }
        this.data[this.size] = element;
        this.size += 1;
    }

    public void insertAt(int index, int element) {
        if (this.size == this.capacity) {
            this.resize();
        }

        if (index == this.size - 1) {
            this.addElement(this.data[this.size - 1]);
            this.data[this.size - 2] = element;
        } else {
            this.size += 1;
            this.shiftRight(index);
            this.data[index] = element;
            if (this.size == this.capacity) {
                this.resize();
            }
        }
    }

    private void shiftLeft(int index) {
        if (this.size - 1 - index >= 0) System.arraycopy(this.data, index + 1, this.data, index, this.size - 1 - index);
    }

    private void shiftRight(int index) {
        if (this.size - index >= 0) System.arraycopy(this.data, index, this.data, index + 1, this.size - index);
    }


    //Removes an element at given index

    public int removeAt(int index) {
        if (index < 0 || index > this.size - 1) {
            throw new IndexOutOfBoundsException("Index out of bounds exception for SmartArray with size of"
                    + this.size
                    + "and index" + index);
        }

        int removedEl = this.data[index];
        this.shiftLeft(index);
        this.size -= 1;

        if (this.size <= this.capacity * 4) {
            this.shrink();
        }
        return removedEl;
    }

//Removes the last element in the SmartArray

    public int removeLast() {

        if (this.size == 0) {
            throw new IndexOutOfBoundsException("SmartArray needs to have size larger than 0");
        }

        int removedEl = this.data[this.size - 1];
        this.shiftLeft(this.size - 1);
        this.size -= 1;

        if (this.size <= this.capacity * 4) {
            this.shrink();
        }
        return removedEl;
    }

    //Removes the first element in the SmartArray

    public int removeFirst() {
        if (this.size == 0) {
            throw new IndexOutOfBoundsException("SmartArray needs to have size larger than 0");
        }

        int removedEl = this.data[0];
        this.shiftLeft(0);
        this.size -= 1;

        if (this.size <= this.capacity * 4) {
            this.shrink();
        }
        return removedEl;
    }

//Check if an element exists in the SmartArray

    public boolean contains(int element) {

        for (int i = 0; i < this.size; i++) {
            if (this.data[i] == element) {
                return true;
            }
        }
        return false;
    }

    //Gets the count of an element

    public int getCount(int element) {
        int count = 0;

        for (int i = 0; i < this.size; i++) {
            if (this.data[i] == element) {
                count += 1;
            }
        }
        return count;
    }

    //Get element at given index
    public int getElement(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Index out of bounds for SmartArray at index " + index);
        }
        return this.data[index];
    }

//Prints the Array with a delimiter

    public void printArr(String joiner) {
        int i = 0;
        for (int j = 0; j < this.size; j++) {
            if (i != this.size - 1) {
                System.out.print(this.data[i] + joiner);
            } else {
                System.out.print(this.data[i]);
            }
            i += 1;
        }
    }

    //Print the Array with each element on a new line

    public void printNewLn() {
        for (int i = 0; i < this.size; i++) {
            System.out.println(this.data[i]);
        }
    }

    //forEach

    public void forEach(Consumer<Integer> consumer) {
        for (int i = 0; i < this.size; i++) {
            consumer.accept(this.data[i]);
        }
    }

    //Rotate SmartArray

    public void rotate() {

        for (int i = 0; i < this.size / 2; i++) {

            int temp = this.data[i];
            this.data[i] = this.data[this.size - 1 - i];
            this.data[this.size - i - 1] = temp;
        }
    }
}
