package lists;

public class DynamicArray<E> {
	private E[] array;
	private int capacity, size;
	
	@SuppressWarnings("unchecked")
	public DynamicArray(int capacity) {
		if(capacity <= 0) {
			throw new RuntimeException("Capacity must be a positive number");
		}
		this.array = (E[]) new Object[capacity];
		this.capacity = capacity;
		this.size = 0;	
	}
	
	public E get(int i) {
		if (i<0 || i>capacity) {
			throw new RuntimeException("There is no element at this position");
		}
		return array[i];
	}
	
	public void set(int i, E val) {
		if (i<0 || i>capacity) {
			throw new RuntimeException("There is no element at this position");
		}
		array[i] = val;
	}
	
	public void pushBack(E val) {
		if (size == capacity) {
			@SuppressWarnings("unchecked")
			E[] newArray = (E[]) new Object[capacity*2];
			for (int i=0; i<size; i++) {
				newArray[i] = array[i];
			}
			this.array = newArray;
		}
		array[size] = val;
		++size;
	}
	
	public void remove(int i) {
		if (i<0 || i>capacity) {
			throw new RuntimeException("There is no element at this position");
		}
		for (int j=0; j<size-1; j++) {
			array[j] = array[j+1];
		}
		--size;
	}
	
}
