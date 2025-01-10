package doublylinkedlist;

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
	private DLLNode<T> tail;
	
	public DoublyLinkedList() {
		this.length = 0;
	}
	
	public void prepend(T item) {
		DLLNode<T> node = new DLLNode<>(item);
		
		this.length++;
		if (this.head == null) {
			this.head = this.tail = node;
			return;
		}
		
		node.next = this.head;
		this.head.prev = node;
		this.head = node;
	}
	
	public void insertAt(T item, int idx) {
		if (idx > this.length) {
			throw new RuntimeException("oh no");
		} 
		
		if (idx == this.length) {
			this.append(item);
			return;
		} else if (idx == 0) {
			this.prepend(item);
			return;
		}
		
		this.length++;
		DLLNode<T> curr = this.getAt(idx);	
		DLLNode<T> node = new DLLNode<>(item);
		
		node.next = curr;
		node.prev = curr.prev;
		curr.prev = node;
		
		if (node.prev != null) {
			node.prev.next = curr;
		}
	} 
		
	
	public void append(T item) {
		this.length++;
		DLLNode<T> node = new DLLNode<T>(item);
		
		if (this.tail == null) {
			this.head = this.tail = node;
			return;
		}
		
		node.prev = this.tail;
		this.tail.next = node;
		
		this.tail = node;
	}
	
	public T remove(T item) {
		DLLNode<T> curr = this.head;
		for (int i = 0; curr != null && i < this.length; i++) {
			if (curr.value == item) {
				break;
			}
			curr = curr.next;
		}
		
		if (curr == null) {
			return null;
		}
		
		return this.removeNode(curr);
	}
	
	public T get(int idx) {
		DLLNode<T> node = this.getAt(idx);
		if (node != null) {
			return null;
		}
		
		return node.value;
	}
	
	public T removeAt(int idx) {
		DLLNode<T> node = this.getAt(idx);
		
		if (node != null) {
			return null;
		}
		
		return this.removeNode(node);
	}
	
	private T removeNode(DLLNode<T> node) {
		this.length--;
		
		if (this.length == 0) {
			T out = this.head.value;
			this.head = this.tail = null;
			return out;
		}
		
		if (node.prev != null) {
			node.prev.next = node.next;
		}
		
		if (node.next != null) {
			node.next.prev = node.prev;
		}
		
		if (node == this.head) {
			this.head = node.next;
		}
		
		if (node == this.tail) {
			this.tail = node.prev;
		}
		
		node.prev = node.next = null;
		return node.value;
	}
	
	private DLLNode<T> getAt(int idx) {
		DLLNode<T> curr = this.head;
		for (int i = 0; curr != null && i < idx; i++) {
			curr = curr.next;
		}
		return curr;
	}

}
