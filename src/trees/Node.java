package trees;

public class Node<E> {
    private E key;
    private Node<E> left;
    private Node<E> right;
    //private Node<E> parent;
    //private int height;

    public Node(E key) {
        this.setKey(key);
        this.setLeft(null);
        this.setRight(null);
        //this.setParent(null);
        //this.setHeight(0);
    }

    public E getKey() {
        return key;
    }

    public void setKey(E key) {
        this.key = key;
    }

    public Node<E> getLeft() {
        return left;
    }

    public void setLeft(Node<E> left) {
        this.left = left;
    }

    public Node<E> getRight() {
        return right;
    }

    public void setRight(Node<E> right) {
        this.right = right;
    }

    /*public Node<E> getParent() {
		return parent;
	}
	public void setParent(Node<E> parent) {
		this.parent = parent;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}*/

    @Override
    public String toString() {
        return "" + key;
    }
}
