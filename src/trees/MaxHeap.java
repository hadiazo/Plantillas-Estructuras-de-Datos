package trees;

import java.util.NoSuchElementException;

public class MaxHeap {
    private int[] array;
    private int size;

    public MaxHeap() {
        this.array = new int[2];
        this.size = 0;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
        this.size = array.length;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    private int parent(int i) {
        // (i-1) / 2
        return (i - 1) >> 1;
    }

    private int leftChild(int i) {
        // 2i + 1
        return (i << 1) + 1;
    }

    private int rightChild(int i) {
        // 2i + 2
        return (i << 1) + 2;
    }

    private void swap(int i, int j) {
        int tmp = this.array[i];
        this.array[i] = this.array[j];
        this.array[j] = tmp;
    }

    private void siftUp(int i) {
        while (i != 0 && this.array[parent(i)] < this.array[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    public void siftDown(int i) {
        int maxIndex = i;
        int left = leftChild(i);
        if (left < this.size && this.array[left] > this.array[maxIndex]) {
            maxIndex = left;
        }
        int right = rightChild(i);
        if (rightChild(i) < this.size && this.array[right] > this.array[maxIndex]) {
            maxIndex = rightChild(i);
        }
        if (i != maxIndex) {
            swap(i, maxIndex);
            siftDown(maxIndex);
        }
    }

    public void insert(int value) {
        if (this.size == this.array.length) {
            int[] newArray = new int[this.size << 1];
            System.arraycopy(this.array, 0, newArray, 0, this.size);
            this.array = newArray;
        }
        this.array[this.size] = value;
        siftUp(this.size);
        this.size++;
    }

    public int getMax() {
        return this.array[0];
    }

    public int extractMax() {
        if (this.size == 0) {
            throw new NoSuchElementException("No hay elementos");
        }
        int max = this.array[0];
        this.size--;
        this.array[0] = this.array[this.size];
        siftDown(0);
        return max;
    }

    public void delete(int num) {
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == num) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return;
        } else {
            array[index] = Integer.MAX_VALUE;
            siftUp(index);
            extractMax();
        }
    }

    public void buildHeap(int[] array) {
        this.array = array;
        this.size = array.length;

        for (int i = parent(this.size - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    public void sort(int[] array, boolean isAscending) {
        if (!isAscending) {
            int[] newArray = new int[array.length];
            buildHeap(array);
            for (int i = 0; i < array.length; i++) {
                int max = extractMax();
                newArray[i] = max;
            }
            setArray(newArray);
        } else {
            buildHeap(array);
            for (int i = array.length - 1; i > 0; i--) {
                int max = extractMax();
                array[i] = max;
            }
        }
    }
}
