package algol_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class A01_원재의메모리복구하기_허설 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트케이스
		for (int tc = 1; tc <= T; tc++) {
			String num = sc.next(); // 라인으로 쭉 받아온다. 50이하
			char[] arr = new char[num.length()];
			// 들어온 문자열을 하나씩 떼어서 배열에 집어넣음
			for (int i = 0; i < num.length(); i++) {
				arr[i] = num.charAt(i);
			}
			int count = 0;
			// 하나씩 탐색해서 같은지 안같은지 판별한다.
			for (int i = 0; i < arr.length-1; i++) {
				if (arr[i] == arr[i + 1])
					continue;
				else
					count++;

			}
			if(arr[0] =='1') //맨앞이 1이면 카운팅 1 올려줌 
				count++;
			System.out.println("#"+tc+" "+count);
		}
	}
}
