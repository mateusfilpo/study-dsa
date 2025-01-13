package heap;

import java.util.ArrayList;
import java.util.List;

public class MinHeap {
	
	public int length;
	private List<Integer> data = new ArrayList<>();
	
	public MinHeap() {
		this.length = 0;
	}
	
	public void insert(Integer value) {
		this.data.add(length);
		this.data.set(length, value);
		this.length++;
	}
	
	public Integer delete() {
		if (this.length == 0) {
			return -1;
		}
		
		Integer out = this.data.get(0);
		this.length--;
		
		if (this.length == 0) {
			this.data = new ArrayList<>();
			return out;
		}
		
		this.data.set(0, this.data.get(this.length));
		this.heapifyDown(0);
		return out;
	}
	
	private void heapifyDown(int idx) {
		int lIdx = this.leftChild(idx);
		int rIdx = this.rightChild(idx);
		
		if (idx >= this.length || lIdx >= this.length) {
			return;
		}
		
		Integer lV = this.data.get(lIdx);
		Integer rV = this.data.get(rIdx);
		Integer v = this.data.get(idx);
		
		if (lV > rV && v > rV) {
			this.data.set(idx, rV);
			this.data.set(rIdx, v);
			this.heapifyDown(rIdx);
		} else if (rV > lV && v > lV) {
			this.data.set(idx, lV);
			this.data.set(lIdx, v);
			this.heapifyDown(lIdx);
		}
		
	}
	
	private void heapifyUp(int idx) {
		if (idx == 0) {
			return;
		}
		
		int p = this.parent(idx);
		Integer parentV = this.data.get(p);
		Integer v = this.data.get(idx);
		
		if (parentV > v) {
			this.data.set(idx, parentV);
			this.data.set(p, v);
			this.heapifyUp(p);
		}
		
		
	}
	
	private int parent(int idx) {
		return (idx - 1) / 2;
	}
	
	private int leftChild(int idx) {
		return idx * 2 + 1;
	}
	
	private int rightChild(int idx) {
		return idx * 2 + 2;
	}
	
	

}
