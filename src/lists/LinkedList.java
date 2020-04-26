package lists;

public class LinkedList<E> {
	ListNode<E> head;
	ListNode<E> tail;
	int size=0;
	
	public boolean isEmpty() {
        return this.head == null;
    }
	
	public int getSize() {
		return size;
	}

	public void pushFront(E key) {
		ListNode<E> node = new ListNode<>(key);
		size++;
		if (head == null) {
			tail = node;
            head = tail;
        } else {
        	node.setNext(head);
        	head.setPrev(node);
        	head = node;
        }
	}
	
	public E topFront() {
		if (head == null) {
            throw new RuntimeException("Empty list");
        }
        return head.getKey();
	}
	
	public E popFront() {
		if (head == null) {
            throw new RuntimeException("Empty list");
        }
		E key = head.getKey();
		if (head == tail) {
			tail = null;
            head = tail;
        } else {
        	head = head.getNext();
        	head.setPrev(null);
        }
		size--;
		return key;
	}
	
	public void pushBack(E key) {
		ListNode<E> node = new ListNode<>(key);
		size++;
		if (tail == null) {
			tail = node;
			head = tail;
		} else {
			tail.setNext(node);
			node.setPrev(tail); //DLL
			tail = node;
		}
	}
	
	public E topBack() {
		if (head == null) {
            throw new RuntimeException("Empty list");
        }
        return tail.getKey();
	}
	
	public E popBack() {
		if (head == null) {
            throw new RuntimeException("Empty list");
        }
		E key = tail.getKey();
		if (head == tail) {
			tail = null;
            head = tail;
        } else {
        	tail = tail.getPrev();
        	tail.setNext(null);
        }
		size--;
		return key;
	}
	
	public ListNode<E> searchNode(E key) {
		if (head == null) {
            throw new RuntimeException("Empty list");
        }
		ListNode<E> current = head;
		while (current != null) {
			if (current.getKey().equals(key)) {
				return current;
			}
			current = current.getNext();
		}
		return null;
	}
	
	public boolean find(E key) {
		/*if (head == null) {
            throw new RuntimeException("Empty list");
        }*/
		ListNode<E> current = this.searchNode(key);
		return current != null;
		/*if (head == null) {
            throw new RuntimeException("Empty list");
        }
		boolean flag = false;
		Node<E> current = head;
		if (head == tail) {
			flag = (current.getKey() == key);
		} else {
			while(current.getNext() != null) {
				if(current.getKey() != key) {
					current = current.getNext();
				} else {
					flag = true;
					break;
				}
			}
		}
		return flag;*/
	}
	
	public void addAfter(E node, E key) {
		ListNode<E> existentNode = this.searchNode(node);
		if (existentNode == null) {
			throw new RuntimeException("Node not found");
		}
		ListNode<E> newNode = new ListNode<> (key, existentNode.getNext(), existentNode);
		existentNode.setNext(newNode);
		if (newNode.getNext() != null) {
			newNode.getNext().setPrev(newNode);
		}
		if (tail == existentNode) {
			tail = newNode;
		}
		size++;
	}
	
	public void addBefore(E node, E key) {
		ListNode<E> existentNode = this.searchNode(node);
		if (existentNode == null) {
			throw new RuntimeException("Node not found");
		}
		ListNode<E> newNode = new ListNode<> (key, existentNode, existentNode.getPrev());
		existentNode.setPrev(newNode);
		if (newNode.getPrev() != null) {
			newNode.getPrev().setNext(newNode);
		}
		if (head == existentNode) {
			head = newNode;
		}
		size++;
	}
	
	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        ListNode<E> current = head;
        while (current != null) {
            sb.append(current.getKey());
            current = current.getNext();
            if (current != null) {
                sb.append(", ");
            }
        }
        sb.append("]");

        return sb.toString();
    }
	
	/*public void addAfter(Node<E> node, E key) {
		Node<E> newNode = new Node<> (key, node.getNext(), node);
		node.setNext(newNode);
		if (newNode.getNext() != null) {
			newNode.getNext().setPrev(newNode);
		}
		if (tail == node) {
			tail = newNode;
		}
		size++;
	}
	
	public void addBefore(Node<E> node, E key) {
		Node<E> newNode = new Node<> (key, node, node.getPrev());
		node.setPrev(newNode);
		if (newNode.getPrev() != null) {
			newNode.getPrev().setNext(newNode);
		}
		if (head == node) {
			head = newNode;
		}
		size++;
	}*/
	
}
