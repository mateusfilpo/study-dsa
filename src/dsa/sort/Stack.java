package dsa.sort;

class StackNode<T> {
	T value;
	StackNode<T> prev;

	StackNode(T value) {
		this.value = value;
	}
}

public class Stack<T> {
	
	public int length;
	private StackNode<T> head;
	
	public Stack() {
		this.length = 0;
	}
	
	public void push(T item) {
		StackNode<T> node = new StackNode<>(item);
		
		this.length++;
		if (this.head == null) {
			this.head = node;
			return;
		}
		
		node.prev = this.head;
		this.head = node;
	}
	
	public T pop() {
		this.length = Math.max(0, length - 1);
		
		if (this.length == 0) {
			StackNode<T> head = this.head;
			this.head = null;
			
			if (head != null) {
				return head.value;
			}
			
			return null;
		}
		
		StackNode<T> head = this.head;
		this.head = head.prev;
		
		return head.value;
	}
	
	public T peek() {
		if (this.head == null) {
			return null;
		}
		
		return this.head.value;
	}
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		
		System.out.println(stack.peek());
		
		System.out.println();
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		System.out.println();
		
		System.out.println(stack.peek());
		
		System.out.println();
		
		System.out.println(stack.pop());
	}

}
