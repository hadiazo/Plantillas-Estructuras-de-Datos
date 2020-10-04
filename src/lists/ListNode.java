package lists;

public class ListNode<E> {
    private E key;
    private ListNode<E> next;
    private ListNode<E> prev;

    public ListNode(E key) {
        this.setKey(key);
        this.setNext(null);
        this.setPrev(null);
    }

    public ListNode(E key, ListNode<E> next) {
        this.setKey(key);
        this.setNext(next);
        this.setPrev(null);
    }

    public ListNode(E key, ListNode<E> next, ListNode<E> prev) {
        this.setKey(key);
        this.setNext(next);
        this.setPrev(prev);
    }

    public E getKey() {
        return key;
    }

    public void setKey(E key) {
        this.key = key;
    }

    public ListNode<E> getNext() {
        return next;
    }

    public void setNext(ListNode<E> next) {
        this.next = next;
    }

    public ListNode<E> getPrev() { //Para DLL
        return prev;
    }

    public void setPrev(ListNode<E> prev) { //Para DLL
        this.prev = prev;
    }

    @Override
    public String toString() {
        return "" + key;
    }
}
