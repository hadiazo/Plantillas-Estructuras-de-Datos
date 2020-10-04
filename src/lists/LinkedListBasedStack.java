package lists;

public class LinkedListBasedStack<E> {
    private LinkedList<E> list;

    public LinkedListBasedStack() {
        list = new LinkedList<>();
    }

    public void push(E key) {
        list.pushBack(key);
    }

    public E pop() {
        return list.popBack();
    }

    public E top() {
        return list.topBack();
    }

    public int size() {
        return list.size;
    }
}
