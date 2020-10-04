package trees;

import lists.LinkedListBasedQueue;

public class BinaryTree<E> {
    Node<Integer> o_root;

    public Node<Integer> insert(Node<Integer> root, int key) {
        if (o_root == null) {
            o_root = new Node<Integer>(key);
        }
        if (root == null) {
            root = new Node<Integer>(key);
        } else {
            Node<Integer> cur;
            if (key < root.getKey()) {
                cur = insert(root.getLeft(), key);
                root.setLeft(cur);
            } else {
                cur = insert(root.getRight(), key);
                root.setRight(cur);
            }
        }
        return root;
    }

    /*public Node<String> insert(Node<String> root, String key) {
		if(root == null) {
            return new Node<String>(key);
        } else {
            Node<String> cur;
            if(key.compareTo(root.getKey()) <= 0) {
            	cur = insert(root.getLeft(), key);
                root.setLeft(cur);
            } else {
            	cur = insert(root.getRight(), key);
                root.setRight(cur);
            }
            return root;
        }
	}*/
    public int height(Node<E> root) {
        if (root == null) { //root == null || (root.right == null && root.left == null)
            return 0;
        }
        return 1 + Math.max(height(root.getLeft()), height(root.getRight()));
    }

    public int size(Node<E> root) { //N�mero de nodos en el �rbol
        if (root == null) {
            return 0;
        }
        return 1 + size(root.getLeft()) + size(root.getRight());
    }

    public void inOrderTraversal(Node<E> root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.getLeft());
        System.out.print(root.toString());
        inOrderTraversal(root.getRight());
    }

    public void preOrderTraversal(Node<E> root) {
        if (root == null) {
            return;
        }
        System.out.print(root.toString());
        preOrderTraversal(root.getLeft());
        preOrderTraversal(root.getRight());
    }

    public void postOrderTraversal(Node<E> root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.getLeft());
        postOrderTraversal(root.getRight());
        System.out.print(root.toString());
    }

    public void levelOrderTraversal(Node<E> root) {
        if (root == null) {
            return;
        }
        LinkedListBasedQueue<Node<E>> queue = new LinkedListBasedQueue<>();
        queue.enqueue(root);
        while (!queue.empty()) {
            Node<E> node = queue.dequeue();
            if (node.getLeft() != null) {
                queue.enqueue(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.enqueue(node.getRight());
            }
            System.out.print(node.toString());
        }
    }

    /*class Node<E> {
		private E key;
		private Node<E> left;
		private Node<E> right;
		
		public Node(E key) {
			this.setKey(key);
			this.setLeft(null);
			this.setRight(null);
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
	}
	
	Node<E> root;

	public Tree() {
		this.root = null;
	}
	
	public int height(Node<E> tree) {
		if (tree.equals(null)) {
			return 0;
		}
		return 1+Math.max(height(tree.left), height(tree.right));
	}*/
}
