package alok.test.ds.list;

class Node {
	private Integer data;
	private Node next;

	public Node(Integer data) {
		this.data = data;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node next() {
		return next;
	}

	public Integer data() {
		return data;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + "]";
	}
}

class List {
	private Node head;

	public void add(Integer data) {
		Node newNode = new Node(data);

		if (head == null) {
			head = newNode;
			return;
		}

		Node curr = head;
		while (curr.next() != null) {
			curr = curr.next();
		}

		curr.setNext(newNode);
	}

	public Node getNthNodeFromEnd(int nth) {

		Node curr = head, adv = head;
		
		// advance the node to the nth position
		while (nth > 0) {
			if (adv != null) {
				adv = adv.next();
			} else {
				return null;
			}
			--nth;
		}


		while (adv != null) {
			adv = adv.next();
			curr = curr.next();
		}

		return curr;
	}
	
	public boolean findLoopExistsUsingFloyds() {
		Node fastPtr = head, slowPtr = head;
		
		while (fastPtr != null && fastPtr.next() != null) {
			fastPtr = fastPtr.next().next();
			slowPtr = slowPtr.next();
			
			if (fastPtr == slowPtr) {
				return true;
			}
		}
		
		return false;
	}
	
	public void rotateRight() {

		if (head == null) {
			return;
		}
		
		Node first = head;
		
		while (head.next() != null) {
			head.setNext(head.next().next());
		}
		
		first.setNext(head);
		//head.setNext(first);
	}
	

	@Override
	public String toString() {
		Node curr = head;
		StringBuilder str = new StringBuilder();
		while (curr != null) {
			str.append(curr.toString() + ", ");
			curr = curr.next();
		}

		return str.toString();
	}

}

public class MyList {

	public static void main(String[] args) {
		List myList = new List();
		System.out.println(myList);
		System.out.println("Thirt Last: " + myList.getNthNodeFromEnd(3));

		myList.add(1);
		System.out.println(myList);
		System.out.println("Thirt Last: " + myList.getNthNodeFromEnd(3));

		myList.add(2);
		System.out.println(myList);
		System.out.println("Thirt Last: " + myList.getNthNodeFromEnd(3));

		myList.add(3);
		System.out.println(myList);
		System.out.println("Thirt Last: " + myList.getNthNodeFromEnd(3));

		myList.add(4);
		System.out.println(myList);
		System.out.println("Thirt Last: " + myList.getNthNodeFromEnd(3));

		myList.add(5);
		System.out.println(myList);
		System.out.println("Thirt Last: " + myList.getNthNodeFromEnd(3));
		System.out.println("Second Last: " + myList.getNthNodeFromEnd(2));
		System.out.println("1st Last: " + myList.getNthNodeFromEnd(1));
		System.out.println("0 Last: " + myList.getNthNodeFromEnd(0));
		
		System.out.println("Loop exists: " + myList.findLoopExistsUsingFloyds());
		
		myList.rotateRight();
		System.out.println(myList);


	}

}
