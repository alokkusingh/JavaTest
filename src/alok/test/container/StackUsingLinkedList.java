package alok.test.container;

import java.util.LinkedList;
import java.util.List;

class MyStack<E> {
	private List<E> container;

	public MyStack() {
		this.container = new LinkedList<E>();
	}

	public void push(E element) {
		container.add(0, element);
	}

	public E pop() {
		if (container.isEmpty()) {
			return null;
		}

		return container.remove(0);
	}
}

public class StackUsingLinkedList {
	public static void main(String[] args) {

		MyStack<String> stack = new MyStack<String>();

		stack.push("Alok");
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		stack.push("Kumar");
		stack.push("Singh");
		stack.push("Alok");
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
	}

}
