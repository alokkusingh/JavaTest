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

	public Node getLastThirdNode() {
		
		try {
			if (head.next().next() == null) {
				return null;
			}
		} catch (NullPointerException exp) {
			return null;
		}

		Node curr = head;
		while (curr.next().next().next() != null) {
			curr = curr.next();
		}

		return curr;
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
		System.out.println("Thirt Last: " + myList.getLastThirdNode());

		myList.add(1);
		System.out.println(myList);
		System.out.println("Thirt Last: " + myList.getLastThirdNode());

		myList.add(2);
		System.out.println(myList);
		System.out.println("Thirt Last: " + myList.getLastThirdNode());

		myList.add(3);
		System.out.println(myList);
		System.out.println("Thirt Last: " + myList.getLastThirdNode());

		myList.add(4);
		System.out.println(myList);
		System.out.println("Thirt Last: " + myList.getLastThirdNode());

		myList.add(5);
		System.out.println(myList);
		System.out.println("Thirt Last: " + myList.getLastThirdNode());

	}

}
