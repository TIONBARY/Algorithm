package Compare;

public class Student_Comparable extends Student implements Comparable<Student> {

	public Student_Comparable(int age, int point, String name) {
		super(age, point, name);
	}

	public int compareTo(Student o) {
		if(this.age > o.age) return 1;
		else if(this.age < o.age) return -1;
		else return 0;
		//return this.age - o.age;
	}

}
