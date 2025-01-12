package treesearch;

import java.util.ArrayList;
import java.util.List;

import dsa.sort.Queue;

class BFSBinaryNode<T> {
	T value;
	BFSBinaryNode<T> left;
	BFSBinaryNode<T> right;
	
	BFSBinaryNode(T value) {
		this.value = value;
	}
}

public class BreadthFirstSearch<T> {
	
	public boolean bfs(BFSBinaryNode<T> head, T needle) {
		Queue<BFSBinaryNode<T>> q = new Queue<>();
		
		while(q.length > 0) {
			BFSBinaryNode<T> curr = q.dequeue();
			
			if (curr == null) {
				continue;
			}
			
			if(curr.value.equals(needle)) {
				return true;
			}
			
			if (curr.left != null) {
				q.enqueue(curr.left);
			}
			if (curr.right != null) {
				q.enqueue(curr.right);
			}

		}
		
		return false;
	}
	
	public static void main(String[] args) {
		
	}

}
