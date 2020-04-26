package trees;

public class AVLTree {
	class Node {
		int key; // holds the key
		Node left; // pointer to left child
		Node right; // pointer to right child
		int height; // height of the node

		public Node(int key) {
			this.key = key;
			this.left = null;
			this.right = null;
			this.height = 0;
		}
	}
	
	//Insert a number in AVL tree height of leaf nodes is considered as 0. Returns the new root after balancing
	public Node insert(Node root, int key) {
        if(root == null) {
            Node node = new Node(key);
            return node;
        }
        if(key < root.key) {
            root.left = insert(root.left, key);
        } else {
            root.right = insert(root.right, key);
        }
        root = rebalance(root);
        adjustHeight(root);
        return root;
    }

    public Node rebalance(Node node) {
        int balanceFactor = balanceFactor(node);
        if (balanceFactor < -1) {
            rebalanceLeft(node);
            return rotateLeft(node); 
        } else if (balanceFactor > 1) {
            rebalanceRight(node);
            return rotateRight(node);
        }
        return node;
    }

    public void rebalanceRight(Node node) {
        if(balanceFactor(node.left) < 0) {
            node.left = rotateLeft(node.left);
        }
    }

    public void rebalanceLeft(Node node) {
        if(balanceFactor(node.right) > 0) {
            node.right = rotateRight(node.right);
        }
    }
    
    //Right rotate the tree corresponding to root node. Node x is at which right rotation is needed. Returns the new root of the tree
    public Node rotateRight(Node x) {
        Node y = x.left;
        x.left = y.right;
        y.right = x;
        adjustHeight(x);
        adjustHeight(y);
        return y;
    }
    
    //Left rotate the tree corresponding to root node. Node x is at which left rotation is needed. Returns the new root of the tree
    public Node rotateLeft(Node x) {
        Node y = x.right;
        x.right = y.left;
        y.left = x;
        adjustHeight(x);
        adjustHeight(y);
        return y;
    }

    public void adjustHeight(Node node) {
        int htLeft = -1, htRight = -1;
        if(node.left != null) {
            htLeft = node.left.height;
        }
        if(node.right != null) {
            htRight = node.right.height;
        }
        node.height = 1+Math.max(htLeft, htRight);
    }

    //Find balance factor of node
    public int balanceFactor(Node node) {
        int htLeft = -1, htRight = -1;
        if(node.left != null) {
            htLeft = node.left.height;
        }
        if(node.right != null) {
            htRight = node.right.height;
        }
        return (htLeft - htRight);
    }
    
    //Find height of tree
  	public int treeHeight(Node root) {
  		int treeHeight = -1;
  		if(root.left != null) {
  			treeHeight = Math.max(treeHeight, root.left.height);
  		}
  		if(root.right != null) {
  			treeHeight = Math.max(treeHeight, root.right.height);
  		}
  		return treeHeight;
  	}
	
	/*public int height(Node<Integer> root) {
		if (root == null) {
			return -1;
		} 
		return root.getHeight();
	}
	
	public Node<Integer> find(int key, Node<Integer> root) {
		if (root.getKey() == key) {
			return root;
		} else if (root.getKey() > key) {
			if (root.getLeft() != null) {
				return find(key, root.getLeft());
			}
			return root;
		} else {
			if (root.getRight() != null) {
				return find(key, root.getRight());
			}
			return root;
		}
	}
	
	public Node<Integer> leftDescendant(Node<Integer> node) {
		if (node.getLeft() == null) {
			return node;
		} else {
			return leftDescendant(node.getLeft());
		}
	}
	
	public Node<Integer> rightAncestor(Node<Integer> node) {
		if (node.getKey() < node.getParent().getKey()) {
			return node.getParent();
		} else {
			return rightAncestor(node.getParent());
		}
	}
	
	public Node<Integer> next(Node<Integer> node) {
		if (node.getRight() != null) {
			return leftDescendant(node.getRight());
		} else {
			return rightAncestor(node);
		}
	}
	
	public LinkedList<Node<Integer>> rangeSearch(int x, int y, Node<Integer> root) {
		LinkedList<Node<Integer>> list = new LinkedList<>();
		Node<Integer> node = find(x, root);
		while (node.getKey() <= y) {
			if (node.getKey() >= x) {
				list.pushBack(node);
			}
			node = next(node);
		}
		return list;
	}
	
	public void insert(int key, Node<Integer> root) {
		Node<Integer> newNode = new Node<>(key);
		Node<Integer> parent = find(key, root);
		newNode.setParent(parent);
		if (newNode.getKey() <= parent.getKey()) {
			parent.setLeft(newNode);
		} else {
			parent.setRight(newNode);
		}
	}*/
	
	/*public void delete(Node<Integer> node) {
		if (node.getRight() == null) {
			
		}
	}*/
	
}
