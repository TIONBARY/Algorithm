package Compare;

public class ComparatorTest {
	public static void main(String[] args) {
		Student_Comparator s1 = new Student_Comparator(16,80,"김시언");
		Student_Comparator s2 = new Student_Comparator(15,90,"허설");
		
		if(s1.compare(s1,s2) > 0) System.out.println(s1.name+"이 나이가 많습니다.");
		else if(s2.compare(s1,s2) < 0) System.out.println(s2.name+"이 나이가 많습니다.");
		else System.out.println("동갑입니다.");
	}
}