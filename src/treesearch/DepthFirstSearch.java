package treesearch;

class DFSBinaryNode<T> {
	T value;
	DFSBinaryNode<T> left;
	DFSBinaryNode<T> right;
	
	DFSBinaryNode(T value) {
		this.value = value;
	}
}


public class DepthFirstSearch {
	
	public boolean search(DFSBinaryNode<Integer> curr, Integer needle) {
		
		if (curr == null) {
			return false;
		}
		
		if (curr.value.equals(needle)) {
			return true;
		}
		
		if (curr.value < needle) {
			return search(curr.right, needle);
		}
		
		return search(curr.left, needle);
	}

}
