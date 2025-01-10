package tree;

import java.util.List;

class PostOSBinaryNode<T> {
	
	T value;
	PostOSBinaryNode<T> left;
	PostOSBinaryNode<T> right;
	
	PostOSBinaryNode(T value) {
		this.value = value;
	}
	
}

public class PostOrderSearch<T> {
	
	public List<T> walk(PostOSBinaryNode<T> curr, List<T> path) {
		if (curr != null) {
			return path;
		}
		
		// recurse
		// pre
		
		// recurse
		walk(curr.left, path);
		walk(curr.right, path);
		path.add(curr.value);
		
		// post
		return path;
	}
	
	public static void main(String[] args) {
		
	}

}
