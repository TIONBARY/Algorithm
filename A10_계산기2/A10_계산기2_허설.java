package algol_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class A10_계산기2_허설 {
	static int res = 0;
	static Stack<Integer> numbers = new Stack<>();
	static Stack<Character> oper = new Stack<>();

	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new FileReader("src\\algol_1\\input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 아스키코드 *가 더 작기 때문에 부등호를 반대로 표시할것
		// 수 받아올 배열 만든다
		// 스택 두개 만든다
		// 수 스택에 넣고 연산자 스택에 넣다가 연산자가 또 들어올때 비교
		// 들어오는 연산자가 우선순위가 낮으면 그 전에거 pop 하고 연산자 푸시
		// 두수 뽑아서 계산 후 수 스택에 다시 넣는다
		// 다 끝났으면 저 계산 마저 반복 연산자의 isEmpty()가 트루일때까지


//		for(int i = 0;i<N;i++) {
//			System.out.print(arr[i]+" ");
//		}
		for(int tc=1;tc<=10;tc++) {
			sb.append("#").append(tc).append(" ");
			oper.clear();
			numbers.clear();
			int N = Integer.parseInt(br.readLine()); // 배열의 개수?
			String str = br.readLine();
			char[] arr = str.toCharArray(); // char 형 배열로 선언
		for (int i = 0; i < N; i++) {
			if (arr[i] != '+' && arr[i] != '*') {
				numbers.push(arr[i] - '0');
				//System.out.println("numbers 스택에 " + numbers.peek() + "들어옴");
			} else {
				if (oper.isEmpty()) {
					oper.push(arr[i]);
				} else if ((oper.peek() - '0') <= (arr[i] - '0')) { // 연산자 *가 십진수고 +가 더 작기때문에
					loop();
					oper.push(arr[i]);
					//System.out.println("numbers 스택에 " + numbers.peek() + "들어옴");
				} else {// 연산자인데 같거나 높은게(+가 있는데 *들어온경우)
					oper.push(arr[i]);

				}
			}
		} 
		while (!oper.isEmpty()) {
			loop();
		
		}
		sb.append(numbers.pop()).append("\n");
		}
		System.out.print(sb);
	}

	public static void Calculator(int num1, int num2, char operator) {
		switch (operator) {
		case '+':
			res = num1 + num2;

			break;
		case '*':
			res = num1 * num2;

			break;
		}
	}

	public static void loop() {
		char operator = oper.pop();
		int num2 = numbers.pop();
		int num1 = numbers.pop();
		Calculator(num1, num2, operator);
		numbers.push(res);
	}
}
