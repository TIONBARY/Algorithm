package Compare;

import java.util.Arrays;

public class ComparableTest {
	public static void main(String[] args) {
		Student_Comparable[] s = new Student_Comparable[2];
		Student_Comparable s1 = new Student_Comparable(16,80,"김시언");
		Student_Comparable s2 = new Student_Comparable(15,90,"허설");
		
		s[0] = s1;
		s[1] = s2;
		
		if(s1.compareTo(s2) > 0) System.out.println(s1.name+"이 나이가 많습니다.");
		else if(s1.compareTo(s2) < 0) System.out.println(s2.name+"이 나이가 많습니다.");
		else System.out.println("동갑입니다.");
		
		System.out.println();
		
		System.out.println("정렬 전 - "+s[0].name+" "+s[1].name);
		Arrays.sort(s);
		System.out.println("나이 오름차순 정렬 - "+s[0].name+" "+s[1].name);
	}
}
