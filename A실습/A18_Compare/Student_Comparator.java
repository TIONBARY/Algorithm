package Compare;

import java.util.Comparator;

public class Student_Comparator extends Student implements Comparator<Student>{

	public Student_Comparator(int age, int point, String name) {
		super(age, point, name);
	}

	@Override
	public int compare(Student o1, Student o2) {
		if(o1.age > o2.age) return 1;
		else if(o1.age < o2.age) return -1;
		else return 0;
		//return o1.age-o2.age;
	}

}
