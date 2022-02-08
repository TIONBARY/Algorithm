package algol_1;

import java.util.Scanner;

public class B04_한빈이와SpotMart {
	static int N, M;
	static int max = 0;
	static int[] input, numbers;

	public static void main(String[] args) throws FileNotFoundException {
		//Scanner sc = new Scanner(new File("src\\algol_1\\input6.txt")); //테스트용
		Scanner sc= new Scanner(System.in); //제출용 
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt(); // 테스트 케이스

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(sc.next()); // 과자의 개수
			sb.append("#").append(tc).append(" ");
			int M = Integer.parseInt(sc.next()); // 최대 무게
			input = new int[N];
			numbers = new int[2];
			for (int i = 0; i < N; i++) {
				input[i] = Integer.parseInt(sc.next());
			}

			combination(0, 0, N, M);
			if (max == 0)
				sb.append(-1);
			else
				sb.append(max);
			max =0;
			sb.append("\n");
			
		}
		System.out.print(sb);
	}

	public static void combination(int cnt, int start, int N, int M) {
		//nC2
		if (cnt == 2) {
			int sum = 0;
			for (int i = 0; i < 2; i++) {
				sum += numbers[i]; // 2개 해당하는 넘들
			}
			if (sum <= M) {
				max = max > sum ? max : sum; //max 전역변수 처리해줘서 안넘겨도됨 
			}

			return;
		}
		for (int i = start; i < N; i++) {
			numbers[cnt] = input[i];
			combination(cnt + 1, i + 1, N, M);
		}

	}
}
