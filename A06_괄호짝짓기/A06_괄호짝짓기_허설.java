package algol_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class A06_괄호짝짓기_허설 {


	public static void main(String[] args) throws IOException {
		int T = 10;
		Stack<Character> stack = new Stack<>();
		char[] arr;
		BufferedReader br = new BufferedReader(new FileReader("src\\algol_1\\input2.txt"));
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine()); // 명령어 개수
			arr = br.readLine().toCharArray();
			stack.clear(); //초기화를 꼭 시켜줘야한다 
			// 루프탈출하는 법을 알게 됐다! 
			out: for (int i = 0; i < N; i++) {
				switch (arr[i]) { //하나씩 돌면서 닫힌괄호를 찾고 제일 위에있는 열린괄호와 비교한다. 
				case ')':

					if (stack.peek() == '(') {
						stack.pop();
					} else {
						break out;
					}
					break;
				case '}':
					if (stack.peek() == '{') {
						stack.pop();
					} else {
						break out;
					}
					break;
				case ']':
					if (stack.peek() == '[') {
						stack.pop();
					} else {
						break out;
					}
					break;
				case '>':
					if (stack.peek() == '<') {
						stack.pop();
					} else {
						break out;
					}
					break;
				default:
					stack.push(arr[i]);
					break;
				}
			}
			if (stack.isEmpty())
				sb.append("#").append(tc).append(" ").append("1").append("\n"); //append 사용이 이렇게 하는건지 잘 모르겠다 
			else
				sb.append("#").append(tc).append(" ").append("0").append("\n");
		}
		System.out.println(sb);
	}

}
