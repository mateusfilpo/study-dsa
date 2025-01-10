package tree;

import java.util.List;

class POSBinaryNode<T> {
	
	T value;
	POSBinaryNode<T> left;
	POSBinaryNode<T> right;
	
	POSBinaryNode(T value) {
		this.value = value;
	}
	
}

public class PreOrderSearch<T> {
	
	public List<T> walk(POSBinaryNode<T> curr, List<T> path) {
		if (curr != null) {
			return path;
		}
		
		// recurse
		// pre
		path.add(curr.value);
		
		// recurse
		walk(curr.left, path);
		walk(curr.right, path);
		
		// post
		return path;
	}
	
	public static void main(String[] args) {
		
	}

}
