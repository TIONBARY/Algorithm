package algol_1;


import java.util.Scanner;

public class A04_농작물수확하기_허설 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트케이스
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 배열의 크기
			int total = 0;
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				String row = sc.next(); // 각 행별 원소
				for (int j = 0; j < N; j++) {
					arr[i][j] = (row.charAt(j) - '0'); //잘라서 정수형으로 집어넣는다
					total += arr[i][j]; //총합구한다.

					//System.out.print(arr[i][j] + " ");
				}
				//System.out.println();
			}
			int count = N / 2;
			int sum = 0; //빼는 부분 
			// 위부터 중간까지 색칠 안된 부분 합
			for (int i = 0; i < count; i++) {
				for (int j = count - 1 - i; j >= 0; j--) {
					sum += arr[j][i];
					//System.out.println("상좌 구역 합:  " + sum);

				}
				for (int j = (count + 1 + i); j < N; j++) {
					sum += arr[i][j];
					//System.out.println("상우 구역 합 : " + sum);
					sum += arr[j][i];
					//System.out.println("하좌 구역 합 : " + sum);
				}
			}
			int tmp = 0;
			for (int i = N - 1; i >= count + 1; i--) {
				for (int j = (count + 1) + tmp; j < N; j++) {
					sum += arr[i][j];
					//System.out.println("arr["+i+"]["+j+"]네번째 구역 합:  "+arr[i][j]+" " + sum);
				}
				tmp++;	 
			}
			System.out.println("#"+tc+" "+(total-sum));
		}
	}
}
