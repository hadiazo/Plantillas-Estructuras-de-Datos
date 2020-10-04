package lists;

public class TwoQueuesBasedStack<E> {
    LinkedListBasedQueue<E> queue1 = new LinkedListBasedQueue<>();
    LinkedListBasedQueue<E> queue2 = new LinkedListBasedQueue<>();

    public void push(E key) {
        queue1.enqueue(key);
    }

    public E pop() {
        if (queue1.empty()) {
            return null;
        }
        while (queue1.list.getSize() != 1) {
            queue2.enqueue(queue1.dequeue());
        }
        LinkedListBasedQueue<E> newQueue = queue1;
        queue1 = queue2;
        queue2 = newQueue;
        return queue1.list.topBack();
    }
}
