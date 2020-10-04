package lists;

public class StaticArrayBasedQueue<E> {
    private E[] array;
    private int capacity, back_pos;

    @SuppressWarnings("unchecked")
    public StaticArrayBasedQueue(int capacity) {
        if (capacity <= 0) {
            throw new RuntimeException("Capacity must be a positive number");
        }
        this.array = (E[]) new Object[capacity];
        this.capacity = capacity;
        this.back_pos = -1;
    }

    public void enqueue(E key) {
        if (this.back_pos == capacity - 1) {
            throw new RuntimeException("Full Queue");
        }
        array[this.back_pos + 1] = key;
        ++this.back_pos;
    }

    public E dequeue() {
        if (this.back_pos == -1) {
            throw new RuntimeException("There are no elements to delete");
        }
        E key = array[0];
        for (int i = 0; i < this.back_pos - 1; i++) {
            array[i] = array[i + 1];
        }
        array[this.back_pos] = null;
        --this.back_pos;
        return key;
    }

    public boolean empty() {
        return this.back_pos == -1;
    }

    public int size() {
        return this.back_pos + 1;
    }

    @Override
    public String toString() {
        String queue = "" + array[0].toString();
        for (int i = 1; i < this.size(); i++) {
            queue = queue.concat(" " + array[i].toString());
        }
        return queue;
    }
}
