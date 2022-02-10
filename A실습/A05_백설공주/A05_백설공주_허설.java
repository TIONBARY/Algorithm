package algol_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A05_백설공주_허설 {
	// 9명중 7명 조합 구해서
	// 그 값이 100인걸 찾는다
	// 그에 해당하는 수를 뽑을 것
	static int N = 9;
	static int R = 7;
	static int[] input, numbers;
	static int sum;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = new int[N];
		numbers = new int[R];
		for (int i = 0; i < N; i++) {

			input[i] = Integer.parseInt(br.readLine());

		}
		combination(0, 0);
	}

	public static void combination(int cnt, int start) {
		if (cnt == R) {
			
			sum = 0;
			for (int i = 0; i < R; i++) {
				sum += numbers[i];
			}
			if (sum == 100) {
				for (int i = 0; i < R; i++) {
					System.out.println(numbers[i]);
				}
			}
				return;
			}
			for (int i = start; i < N; i++) {
				numbers[cnt] = input[i];

				combination(cnt + 1, i + 1);

			}
		}
	}

