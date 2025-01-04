package dsa.sort;

class QNode<T> {
	T value;
	QNode<T> next;
	
	QNode(T value) {
		this.value = value;
	}
}

public class Queue<T> {
	
	public int length;
	private QNode<T> head;
	private QNode<T> tail;
	
	public Queue() {
		this.length = 0;
	}
	
	public void enqueue(T item) {
		QNode<T> node = new QNode<>(item);
		this.length++;
		if (this.tail == null) {
			this.tail = this.head = node;
			return;
		}
		
		this.tail.next = node;
		this.tail = node;
	}
	
	public T dequeue() {
		if (this.head == null) {
			return null;
		}
		
		this.length--;
		
		QNode<T> head = this.head;
		this.head = this.head.next;
		
		// free
		head.next = null;
		
		return head.value;
	}
	
	public T peek() {
		if (this.head == null) {
			return null;
		}
		
		return this.head.value;
	}
	
	
	
	public static void main(String[] args) {
		Queue<Integer> queue = new Queue<>();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		
		System.out.println(queue.peek());
		
		System.out.println();
		
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		
		System.out.println();
		
		System.out.println(queue.peek());
	}

}
