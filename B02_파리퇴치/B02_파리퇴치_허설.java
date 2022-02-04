package algol_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//0부터 N-M 번 이중포문을 돌면서 
// 파리채 해당하는 배열 총합 더한다
//다음거랑 비교한다. 
//바꾼다.
//탐색끝 
public class B02_파리퇴치_허설 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 배열크기
			int M = sc.nextInt(); // 파리채 크기
			int max = 0;
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) { // 배열에 넣기
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			
			for (int i = 0; i <= N - M; i++) { //파리채 크기로 돌때 한번에 N-M+1번 돈다.
				for (int j = 0; j <= N - M; j++) {
					int sum = 0;
					for (int i2 = 0; i2 < M; i2++) {
						for (int j2 = 0; j2 < M; j2++) {
							sum += arr[i + i2][j + j2];
						}
					}
					max = max>sum?max:sum;
				
				}
			}
			System.out.println("#" + tc + " " + max);
		}
		sc.close();
	}

}
