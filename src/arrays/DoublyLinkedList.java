package arrays;

class DLLNode<T> {
	T value;
	DLLNode<T> prev;
	DLLNode<T> next;
	
	DLLNode(T value) {
		this.value = value;
	}
}

public class DoublyLinkedList<T> {
	public int length;
	private DLLNode<T> head;
	
	public DoublyLinkedList() {
		this.length = 0;
	}
	
	public void prepend(T item) {
		
	}
	
	public void insert(T item, int idx) {
		
	}
	
	public void append(T item) {
		
	}
	public T remove(T item) {
		return null;
	}
	
	public T get(int idx) {
		DLLNode<T> curr = this.head;
		
		for (int i = 0; i < idx && curr != null; i ++) {
			curr = curr.next;
		}
		
		if (curr != null) {
			return curr.value;
		}
		
		return null;
	}
	
	public T removeAt(int idx) {
		return null;
	}

}
