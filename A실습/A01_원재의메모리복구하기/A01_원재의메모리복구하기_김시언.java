import java.util.Scanner;
import java.io.FileInputStream;
import java.util.stream.Stream;

class A01_원재의메모리복구하기_김시언 {
	public static void main(String args[]) throws Exception	{		
		Scanner sc = new Scanner(System.in);
		int T, count;
		T=Integer.parseInt(sc.nextLine());

		for(int test_case = 1; test_case <= T; test_case++) {
			String str = sc.nextLine();
			int[] arr = Stream.of(str.split("")).mapToInt(Integer::parseInt).toArray();
			
            if(arr[0] == 1) count = 1;
			else count = 0;
			
			for(int i=0; i<arr.length-1; i++) {
				if(arr[i] != arr[i+1]) count++;
			}			
			System.out.println("#" + test_case + " "+ count);	
		}
        sc.close();
	}
}
