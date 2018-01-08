package alok.test.container;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

class Student {
	int id;

	public Student(int id) {
		super();
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + "]";
	}	
}

class Marks {
	int marks;

	public Marks() {
		this.marks = (int) (Math.random()*100);
	}

	@Override
	public String toString() {
		return "Marks [marks=" + marks + "]";
	}	
}

public class MyHashMap {
	
	public static void main(String[] args) {
		HashMap<Student, Marks> studentMarksMap = new HashMap<Student, Marks>();
		studentMarksMap.put(new Student(1), new Marks());
		studentMarksMap.put(new Student(1), new Marks());
		studentMarksMap.put(new Student(2), new Marks());
		System.out.println(studentMarksMap.size());
		
		Set<Entry<Student, Marks>> studentsMarks = studentMarksMap.entrySet();
		for (Entry<Student, Marks> studentMarks : studentsMarks) {
			System.out.println(studentMarks.getKey() + " --> " + studentMarks.getValue());
		}
	}
}
