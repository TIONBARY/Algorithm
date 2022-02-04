package A04_;

import java.io.File;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(new File("src/A04_/input.txt"));
		int T,N,width,sum;
		String temp;
		T = sc.nextInt();
		
		for(int test_case=0; test_case<T; test_case++) {
			width = 1;
			sum = 0;
			N = sc.nextInt();
			int[][] farm = new int[N][N];
			for(int i=0; i<N; i++) {
				temp = sc.next();
				for(int j=0; j<temp.length();j++) {
					farm[i][j] = temp.charAt(j)-'0';
				}
			}
			
			for(int i=0; i<=N/2; i++) {
				for(int j=N/2-i; j<=N/2+i; j++) {
					sum += farm[i][j];
				}
			}
			for(int i=N-1; i>N/2; i--) {
				for(int j=N/2-(N-i-1);j<=N/2+(N-i-1); j++) {
					sum += farm[i][j];
				}
			}
			System.out.println("#"+(test_case+1)+" "+sum);
		}
		sc.close();
	}
}
