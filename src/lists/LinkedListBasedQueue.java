package lists;

public class LinkedListBasedQueue<E> {
	LinkedList<E> list;

	public LinkedListBasedQueue() {
		list = new LinkedList<>();
    }

	public void enqueue(E e) {
		this.list.pushFront(e);
	}

	public E dequeue() {
       	return this.list.popBack();
    }

	public boolean empty() {
       	return this.list.isEmpty();
   	}

	public String toString() {
       	return this.list.toString();
   	}
}
