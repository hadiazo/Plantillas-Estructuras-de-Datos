package lists;

public class TwoStacksBasedQueue<E> {
	
	private LinkedListBasedStack<E> stack1 = new LinkedListBasedStack<>();
    private LinkedListBasedStack<E> stack2 = new LinkedListBasedStack<>();
    
    public void enqueue(E key) {
        stack1.push(key);
    }
    
    public E dequeue() {
        if(stack2.size() == 0) {
            while (stack1.size() != 0) {
                stack2.push(stack1.pop());
            } 
        }
        return stack2.pop();
    }
    
    public E printFront() {
        if(stack2.size() == 0) {
            while (stack1.size() != 0) {
                stack2.push(stack1.pop());
            } 
        }
        return stack2.top();
    }
    
    public int size() {
        return stack1.size() + stack2.size();
    }

}
