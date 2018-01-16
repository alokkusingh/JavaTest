package alok.test.algo.queue;

import java.util.Arrays;

class Queue {
	
	private static final int MAXSIZE = 5;
	
	private Integer[] queue = new Integer[MAXSIZE];
	private int size;
	private int front;
	private int rear;
	
	public int size() {
		return size;
	}
	
	public Boolean isEmpty() {
		return size()==0;
	}
	
	public Boolean enQueue(Integer data) {
		if (size == MAXSIZE || data == null)
			return false;
		
		queue[rear] = data;	
		rear = (rear + 1) % MAXSIZE;
		++size;
		
		return true;
	}
	
	public Integer deQueue() {
		if (size == 0)
				return  null;
		
		Integer data = queue[front];
		front = (front + 1) % MAXSIZE;
		--size;
		
		return data;
	}
	
	public String toString() {
		StringBuffer str = new StringBuffer("[");
		
		for (int i = front, j = 0; j < size; i = (i + 1) % MAXSIZE, ++j) {
			str.append(queue[i] + ", ");
		}
		
		str.append("]");
		
		return str.toString().replace(", ]", "]");
	}
	
	public void printActualQ() {
		System.out.println(Arrays.toString(queue));
	}
}

public class MyQueue {

	public static void main(String[] args) {
		Queue q = new Queue();
		
		System.out.println(q);
		q.printActualQ();
		
		q.enQueue(1);
		System.out.println(q);
		q.printActualQ();
		
		q.enQueue(2);
		System.out.println(q);
		q.printActualQ();
		
		System.out.println(q.deQueue());
		System.out.println(q);
		q.printActualQ();
		
		q.enQueue(3);
		System.out.println(q);
		q.printActualQ();
		
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		System.out.println(q);
		q.printActualQ();
		
		if (q.enQueue(4))
			System.out.println("4 added!");
		if (q.enQueue(5))
			System.out.println("5 added!");
		if (q.enQueue(6))
			System.out.println("6 added!");
		if (q.enQueue(7))
			System.out.println("7 added!");
		if (q.enQueue(8))
			System.out.println("8 added!");
		if (!q.enQueue(9))
			System.out.println("9 not added!");
		
		System.out.println(q);
		q.printActualQ();
		
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		
		if (q.enQueue(9))
			System.out.println("9 added!");
		if (q.enQueue(10))
			System.out.println("10 added!");
		
		System.out.println(q);
		q.printActualQ();
		
		System.out.println(q.deQueue());
		if (q.enQueue(11))
			System.out.println("11 added!");
		System.out.println(q);
		q.printActualQ();
	}
}
