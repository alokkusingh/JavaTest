package alok.test.container;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

class DescendingOrder implements Comparator<Integer> {

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Integer o1, Integer o2) {
		if (o1 < o2) {
			return 1;
		}
		
		if (o1 > o2) {
			return -1;
		}
		
		return 0;
	}
	
}

class MyKey implements Comparable<MyKey> {

	private Integer key;
	
	public MyKey(final Integer key) {
		this.key = key;		
	}
	
	public Integer getKey() {
		return key;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	//Desecnding Order
	@Override
	public int compareTo(MyKey o) {
		if (key < o.getKey()) {
			return 1;
		}
		
		if (key > o.getKey()) {
			return -1;
		}
		return 0;
	}

	@Override
	public String toString() {
		return "MyKey [key=" + key + "]";
	}
}

class FBookComments implements Comparable<FBookComments> {

	private static Integer nextCommentID = 0;
	private Integer getNextCommentID() {
		return ++nextCommentID;
	}
	
	private Integer ID;
	private Integer likeCount;
	
	public FBookComments() {
		ID = getNextCommentID();
		likeCount = 0;		
	}
	
	public FBookComments(Integer likes) {
		ID = getNextCommentID();
		likeCount = likes;		
	}
	
	public void incrLikes() {
		++likeCount;
	}
	
	public Integer geCommentID() {
		return ID;
	}
	
	public Integer getLikes() {
		return likeCount;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	
	//Not sure the below will work?????
	@Override
	public int compareTo(FBookComments o) {
		
		if (ID.equals(o.geCommentID())) {
			//this is to make sure we dont allow duplicate comment ID
			return 0;
		}
		
		//this is to make sure we sort based on like counts
		if (likeCount < o.getLikes()) {
			return 1;
		}
		
		if (likeCount > o.getLikes()) {
			return -1;
		}
		return 0;
	}

	@Override
	public String toString() {
		return "FaceBookComments [ID=" + ID + ", likeCount=" + likeCount + "]";
	}
}

public class TreeMapTest {

	public static void main(String[] args) {
		
		Map<Integer,String> ascMap = new TreeMap<>();
		ascMap.put(2, "Singh");
		ascMap.put(1, "Alok");
		ascMap.put(9, "Hello");
		ascMap.put(5, "Kumar");
		ascMap.put(4, "Bangalore");
		ascMap.put(6, "India");
		
		/*Iterator<Integer> itr = ascMap.keySet().iterator();
		
		while(itr.hasNext()) {
			System.out.println("Key: " + itr.toString() + ", Value: " + ascMap.get(itr));
		}*/
		System.out.println("Asending order");
		for (Map.Entry<Integer,String> entry : ascMap.entrySet()) {
			System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
		}
		
		Map<Integer,String> dscMap = new TreeMap<>(new DescendingOrder());
		dscMap.put(2, "Singh");
		dscMap.put(1, "Alok");
		dscMap.put(9, "Hello");
		dscMap.put(5, "Kumar");
		dscMap.put(4, "Bangalore");
		dscMap.put(6, "India");
		
		System.out.println("\nDesending order");
		for (Map.Entry<Integer,String> entry : dscMap.entrySet()) {
			System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
		}
		
		Map<MyKey,String> dscUsingMyKeyMap = new TreeMap<>();
		dscUsingMyKeyMap.put(new MyKey(2), "Singh");
		dscUsingMyKeyMap.put(new MyKey(1), "Alok");
		dscUsingMyKeyMap.put(new MyKey(9), "Hello");
		dscUsingMyKeyMap.put(new MyKey(5), "Kumar");
		dscUsingMyKeyMap.put(new MyKey(4), "Bangalore");
		dscUsingMyKeyMap.put(new MyKey(6), "India");
		System.out.println("\nDesending order using MyKey");
		for (Map.Entry<MyKey,String> entry : dscUsingMyKeyMap.entrySet()) {
			System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
		}
		
		Map<FBookComments,String> facebookLikeMap = new TreeMap<>();
		facebookLikeMap.put(new FBookComments(), "Singh");
		facebookLikeMap.put(new FBookComments(1), "Alok");
		facebookLikeMap.put(new FBookComments(9), "Hello");
		facebookLikeMap.put(new FBookComments(5), "Kumar");
		FBookComments bangalore = new FBookComments(4);
		facebookLikeMap.put(bangalore, "Bangalore");
		facebookLikeMap.put(new FBookComments(6), "India");
		facebookLikeMap.put(new FBookComments(6), "US");
		System.out.println("\nPrinting Facebook Comments");
		for (Map.Entry<FBookComments,String> entry : facebookLikeMap.entrySet()) {
			System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
		}
		
	}
}
