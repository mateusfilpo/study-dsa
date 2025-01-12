package treesearch;

class CompareBinaryNode<T> {
	T value;
	CompareBinaryNode<T> left;
	CompareBinaryNode<T> right;
	
	CompareBinaryNode(T value) {
		this.value = value;
	}
}

public class BinaryTreeComparison<T> {
	
	public boolean compare(CompareBinaryNode<T> a, CompareBinaryNode<T> b) {
		
		if (a == null && b == null) {
			return true;
		}
		
		if (a == null || b == null) {
			return false;
		}
		
		if (!a.value.equals(b.value)) {
			return false;
		}
		
		return compare(a.left, b.left) && compare(a.right, b.right);
	}
}
