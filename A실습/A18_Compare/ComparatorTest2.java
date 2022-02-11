package Compare;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorTest2 {
	public static void main(String[] args) {
		Student[] s = new Student[2];
		Student s1 = new Student(16,80,"김시언");
		Student s2 = new Student(15,90,"허설");

		s[0] = s1;
		s[1] = s2;

		System.out.print("나이비교 - ");
		if(comp.compare(s1, s2) > 0) System.out.println(s1.name+"이 나이가 많습니다.");
		else if(comp.compare(s1,s2) < 0) System.out.println(s2.name+"이 나이가 많습니다.");
		else System.out.println("동갑입니다.");

		System.out.print("점수비교 - ");
		if(comp2.compare(s1, s2) > 0) System.out.println(s1.name+"이 점수가 높습니다.");
		else if(comp2.compare(s1,s2) < 0) System.out.println(s2.name+"이 점수가 높습니다.");
		else System.out.println("동점입니다.");

		System.out.println();
		
		System.out.println("정렬 전 - "+s[0].name+" "+s[1].name);
		
		Arrays.sort(s, comp);
		System.out.println("나이 오름차순 정렬 - "+s[0].name+" "+s[1].name);
		
		Arrays.sort(s, comp2);
		System.out.println("점수 오름차순 정렬 - "+s[0].name+" "+s[1].name);
		
		Arrays.sort(s, new Comparator<Student>(){
			@Override
			public int compare(Student o1, Student o2) {
				if(o1.point > o2.point) return -1;
				else if(o1.point < o2.point) return 1;
				else return 0;
				//return o2.point-o1.point;
			}
		});
		System.out.println("점수 내림차순 정렬 - "+s[0].name+" "+s[1].name);
		
		Arrays.sort(s, (o1,o2) -> o2.age - o1.age);
		System.out.println("나이 내림차순 정렬 - "+s[0].name+" "+s[1].name);
	}

	public static Comparator<Student> comp = new Comparator<Student>() {
		@Override
		public int compare(Student o1, Student o2) {
			if(o1.age > o2.age) return 1;
			else if(o1.age < o2.age) return -1;
			else return 0;
			//return o1.age-o2.age;
		}
	};

	public static Comparator<Student> comp2 = new Comparator<Student>() {
		@Override
		public int compare(Student o1, Student o2) {
			if(o1.point > o2.point) return 1;
			else if(o1.point < o2.point) return -1;
			else return 0;
			//return o1.point-o2.point;
		}
	};
}