package C;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C03_야바위 { 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("src\\C\\input.txt"));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 컵개수
		int X = Integer.parseInt(st.nextToken()); // 몇번째 컵에 있능교
		int K = Integer.parseInt(st.nextToken()); // K번 수행
		boolean[] isIn = new boolean[N + 1];
		isIn[X] = true;

		for (int i = 1; i <= K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			if (isIn[num1] || isIn[num2]) {
				
				isIn[num1] = !isIn[num1];
				isIn[num2] = !isIn[num2];
				
			}
		}

		for (int i = 1; i < N + 1; i++) {
			if (isIn[i]) {
				System.out.print(sb.append(i));
				break;
			}
		}
	}

}
