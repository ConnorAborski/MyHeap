import java.math.*;
public class My_Heap implements Heap{
		Node root = new Node();
		Node lastNode = null;
		int level = 0;
		int numNodes = 0;

	@Override
	public Node makeHeap(Comparable value) {
		root.setData(value);
		numNodes++;
		// TODO Auto-generated method stub
		return root;
	}
	
	public Node findLastNode() {
		Node node = root;
		level = (int)(Math.log(numNodes)/Math.log(2));
		String binNumNodes = Integer.toBinaryString(numNodes);
		int index = binNumNodes.length() - level;
		if (numNodes == 3) {
			lastNode = root.getLeftChild();
			level = (int)Math.floor(Math.log(numNodes)/Math.log(2));
			siftUp(lastNode);
			//System.out.println(level + " New Level");
		}
		else {
		
		while(index < binNumNodes.length() - 1 ) {

			if (binNumNodes.substring(index, index +1).equals("1")) {
				node = node.getRightChild();
		}
			else if (binNumNodes.substring(index, index +1).equals("0")) {
			node = node.getLeftChild();
		}
			index++;
			//System.out.println(index + " Counting index ");
		}
		
		//System.out.println(index + " index");
		//System.out.println(binNumNodes.substring(index)+ " bin substring");

		if (binNumNodes.substring(index).equals("1")) {

			lastNode = node.getRightChild();
			//System.out.println(lastNode.getData() + " right " + lastNode.getParent().getData() + "******************************************************* ");

		}
		else if (binNumNodes.substring(index).equals("0")) {
			
			lastNode = node.getLeftChild();
			//System.out.println(lastNode.getData() + " left " + lastNode.getParent().getData() + "*******************************************************");

			}
	}
		return lastNode;
	}
	public Node getRoot() {
		return root;
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insert(Comparable value) {

		Node node = root;
		double subStart = Math.log(numNodes)/Math.log(2);
		int sub = (int)Math.floor(subStart);
		String binNumNodes = Integer.toBinaryString(numNodes);
		//System.out.println(binNumNodes + " bin nodes");
		int index = binNumNodes.length() - level;
		//System.out.println(index+ " Start index");
		
		if (numNodes == 1) {
			lastNode = new Node(value, null, null, node);
			node.setLeftChild(lastNode);
			System.out.println(lastNode.getData() + " left " + lastNode.getParent().getData() + "*******************************************************");
			numNodes += 2;
			level = (int)Math.floor(Math.log(numNodes)/Math.log(2));
			siftUp(lastNode);
			//System.out.println(level + " New Level");
		}
		else {
		
		while(index < binNumNodes.length() - 1 ) {

			if (binNumNodes.substring(index, index +1).equals("1")) {
				node = node.getRightChild();
		}
			else if (binNumNodes.substring(index, index +1).equals("0")) {
			node = node.getLeftChild();
		}
			index++;
			//System.out.println(index + " Counting index ");
		}
		
		//System.out.println(index + " index");
		//System.out.println(binNumNodes.substring(index)+ " bin substring");

		if (binNumNodes.substring(index).equals("1")) {

			lastNode = new Node(value, null, null, node);
			node.setRightChild(lastNode);
			System.out.println(lastNode.getData() + " right " + lastNode.getParent().getData() + "******************************************************* ");
			numNodes++;
		}
		else if (binNumNodes.substring(index).equals("0")) {
			
			lastNode = new Node(value, null, null, node);
			node.setLeftChild(lastNode);
			System.out.println(lastNode.getData() + " left " + lastNode.getParent().getData() + "*******************************************************");
			numNodes++;
			}
		//System.out.println(root.getData() + " root data");
		siftUp(lastNode);
		//System.out.println(root.getData() + " root data");
		//System.out.println(numNodes + " Num Nodes");
		 level = (int)(Math.log(numNodes)/Math.log(2));
		 //System.out.println(level + " New Level");
		}

	
		
		// TODO Auto-generated method stub
		return false;
	}
	
	public void siftUp(Node insertedNode) {

		if (insertedNode.getParent() != null) {
			Comparable parentData = insertedNode.getParent().getData();
			Comparable nodeData = insertedNode.getData();
			
		if ( 0 < parentData.compareTo(nodeData)) {
			Comparable temp = parentData;
			insertedNode.getParent().setData(nodeData);
			insertedNode.setData(temp);
			siftUp(insertedNode.getParent());
		} else {
			
		}
		}
	}

	public void siftDown(Node lastNode) {
		
	}
	

	@Override
	public boolean deleteMin() {
		numNodes--;
		
		Comparable temp = root.getData();
		
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean decreaseKey(Node key, Comparable updateValue) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Node del) {
		numNodes--;
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean union(My_Heap heap) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Comparable findMin() {
		return  this.getRoot().getData();
		// TODO Auto-generated method stub
	}
	public static void main(String[] args) {
		My_Heap heap = new My_Heap();
		heap.makeHeap(20);
		heap.insert(4);
		heap.insert(15);
		heap.insert(2);
		heap.insert(1);
		heap.insert(16);
		heap.insert(9);
		Node toor = heap.getRoot();
		System.out.println(toor.getData());
		System.out.println(toor.getLeftChild().getData());
		System.out.println(toor.getRightChild().getData());
		System.out.println(toor.getLeftChild().getLeftChild().getData());
		System.out.println(toor.getLeftChild().getRightChild().getData());
		System.out.println(toor.getRightChild().getLeftChild().getData());
		System.out.println(toor.getRightChild().getRightChild().getData());
		Node news = new Node();
		news = heap.findLastNode();
		System.out.println(news.getData());

		
	}
	}

