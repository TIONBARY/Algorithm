package B02_;

import java.io.File;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(new File("src/B02_/input.txt"));
		int[][] zone;
		int T,N,M,sum,temp;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++){
			N = sc.nextInt();
			M = sc.nextInt();
			sum = 0;
			zone = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					zone[i][j] = sc.nextInt();
				}
			}
			
			for(int i=0; i<=N-M; i++) {
				for(int j=0; j<=N-M; j++) { 
					temp = 0;
					for(int x=0; x<M; x++) {
						for(int y=0; y<M; y++) {
							temp = temp + zone[i+x][j+y];
						}
					}
					if(temp > sum) sum = temp;
				}
			}
			
			System.out.println("#"+test_case+" "+sum);
		}
		sc.close();
	}
}
