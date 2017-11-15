
public interface Heap {
	public Node makeHeap(Comparable value);
	public boolean isEmpty();
	public boolean insert(Comparable value);
	public boolean deleteMin();
	public boolean decreaseKey(Node key, Comparable updateValue);
	public boolean delete(Node del);
	public boolean union(My_Heap heap);
	public Comparable findMin();
}
