package alok.test.container;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class MyCopyOnWriteArrayList {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<Integer>() {
			{
				add(1);
				add(2);
				add(3);
				add(4);
				add(5);
				add(6);
				add(7);
				add(8);
			}
		};

		List<Integer> corList = new CopyOnWriteArrayList<Integer>(list);
		ListIterator<Integer> itr = corList.listIterator(); // Fail Safe Iterator

		corList.remove(2);
		// 2nd index is removed (value=3) but still the original list will be printed
		while (itr.hasNext()) {
			System.out.println("Data 1: " + itr.next());
		}
		System.out.println();

		itr = corList.listIterator();
		// now the latest list is traversed
		while (itr.hasNext()) {
			System.out.println("Data 2: " + itr.next());
		}
		System.out.println();

		itr = list.listIterator(); // Fail Fast Iterator
		while (itr.hasNext()) {
			int data = itr.next();
			System.out.println("Data 3: " + data);
			if (data == 2) {
				itr.remove();

				// Fail Fast Iterator: this will throw exception CuncurrentModificatonException
				//list.remove(2);
			}

		}
		System.out.println();

		itr = list.listIterator();
		while (itr.hasNext()) {
			System.out.println("Data 4: " + itr.next());
		}
		System.out.println();
	}

}
