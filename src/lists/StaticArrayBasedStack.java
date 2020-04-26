package lists;

public class StaticArrayBasedStack<E> {
	private E[] array;
	private int capacity, top_pos;

	@SuppressWarnings("unchecked")
	public StaticArrayBasedStack(int capacity) {
		if(capacity <= 0) {
			throw new RuntimeException("Capacity must be a positive number");
		}
		this.array = (E[]) new Object[capacity];
		this.capacity = capacity;
		this.top_pos = -1;
	}

	public void push(E key) {
		if(this.top_pos == this.capacity-1) {
			throw new RuntimeException("Stack Overflow");
		}
		array[this.top_pos+1] = key;
		++this.top_pos;
	}

	public E pop() {
		if(this.top_pos == -1) {
			throw new RuntimeException("There are no elements to delete");
		}
		E key = array[this.top_pos];
		array[this.top_pos] = null;
		--this.top_pos;
		return key;
	}

	public E top() {
		return array[this.top_pos];
	}

	public boolean empty() {
		return this.top_pos == -1;
	}

	public int size() {
		return this.top_pos+1;
	}

	@Override
	public String toString() {
		String stack = "";
		for (int i=this.size()-1; i<=0; i--) {
			stack = stack.concat(array[i].toString()+"\n");
		}
		return stack;
	}
}
