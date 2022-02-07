package algol_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A06_괄호짝짓기_허설 {

	public static void main(String[] args) throws IOException {
		int T = 10;
		char[] arr;
		char[] arr2 = new char[8];
		// 0,1 -> ()
		// 2,3 -> {}
		// 4,5 -> []
		// 6,7 -> <>

		// 테스트 케이스 10개
		// 첫줄에 괄호 개수를 받는다
		// 그다음에 그 수대로 와랄라라라
		BufferedReader br = new BufferedReader(new FileReader("src\\algol_1\\input2.txt"));
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine()); // 명령어 개수
			arr = new char[N];
			String str = br.readLine();
			for (int i = 0; i < N; i++) {
				switch (str.charAt(i)) {
				case '(':
					arr2[0]++;
					break;
				case ')':
					arr2[1]++;
					break;
				case '{':
					arr2[2]++;
					break;
				case '}':
					arr2[3]++;
					break;
				case '[':
					arr2[4]++;
					break;
				case ']':
					arr2[5]++;
					break;
				case '<':
					arr2[6]++;
					break;
				case '>':
					arr2[7]++;
					break;

				}
			}
			sb.append("#").append(tc).append(" ").append(match(arr2)).append("\n");

			for (int i = 0; i < 8; i++) {
				arr2[i] = 0;
			}

		}
		System.out.println(sb);
	}

	public static int match(char[] arr2) {
		if (arr2[0] == arr2[1] && arr2[2] == arr2[3] && arr2[4] == arr2[5] && arr2[6] == arr2[7])
			return 1;
		else
			return 0;
	}

}
