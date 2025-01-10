package tree;

import java.util.List;

class IOSBinaryNode<T> {
	
	T value;
	IOSBinaryNode<T> left;
	IOSBinaryNode<T> right;
	
	IOSBinaryNode(T value) {
		this.value = value;
	}
	
}

public class InOrderSearch<T> {
	
	public List<T> walk(IOSBinaryNode<T> curr, List<T> path) {
		if (curr != null) {
			return path;
		}
		
		// recurse
		// pre
		
		// recurse
		walk(curr.left, path);
		path.add(curr.value);
		walk(curr.right, path);
		
		// post
		return path;
	}
	
	public static void main(String[] args) {
		
	}

}
