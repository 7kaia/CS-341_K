package chu;

public class LinkedList {
	
	private Node head;
	private Node tail;

	public LinkedList() {
		head = null;
		tail = null;
	}
	
	
	public Node getHead() {
		return head;
	}
	
	
	public void addNode(Node n) {
		if (head == null) {
			head = n;
			tail = n;
		} else {
			tail.next = n;
			tail = n;
		}
	}
	
	
	public double calculateAverage() {
		
		double sum = 0;
		int count = 0;
		Node pointer = head;
		
		while (pointer != null) {
			sum += pointer.value;
			count++;
			pointer = pointer.next;
		}
		
		return sum/count;
	}
	
	
	public double calculateStandardDeviation(double average) {
		
		double numerator = 0;
		int count = 0;
		Node pointer = head;
		
		while (pointer != null) {
			double x = average - pointer.value;
			
			numerator += x * x;
			count++;
			pointer = pointer.next;
		}
		
		return Math.sqrt(numerator/(count-1));
	}
	
	public String toString() {
		String re = "";
		Node pointer = head;
		while (pointer != null) {
			re += pointer.value + " ";
			pointer = pointer.next;
		}
		return re;
	}
}
