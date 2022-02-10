package A03_;

import java.io.File;
import java.util.Scanner;

public class A03_달팽이숫자_김시언 {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(new File("src/A03_/input.txt"));
		int T,N,x,y,temp,snailNum;
		T = sc.nextInt();

		for(int i=0; i<T; i++) {
			N = sc.nextInt();
			temp = N-1;
			x = 0;
			y = 0;
			snailNum = 1;
			int[][] snail = new int[N][N];
			snail[0][0] = 1;

			if(N == 1) {
				System.out.println("#1\n1");
			}
			else{
				for(int j=0; j<temp; j++) {
					y++;
					snailNum++;
					snail[x][y] = snailNum;
				}
				while(snailNum < N*N) {
					for(int j=0; j<temp; j++) {
						x++;
						snailNum++;
						snail[x][y] = snailNum;
					}
					for(int j=0; j<temp; j++) {
						y--;
						snailNum++;
						snail[x][y] = snailNum;
					}
					temp--;
					for(int j=0; j<temp; j++) {
						x--;
						snailNum++;
						snail[x][y] = snailNum;
					}
					for(int j=0; j<temp; j++) {
						y++;
						snailNum++;
						snail[x][y] = snailNum;
					}
					temp--;
				}
				System.out.println("#"+(i+1));
				for(int a=0; a<N; a++) {
					for(int b=0; b<N; b++) {
						System.out.print(snail[a][b]+"\t");
					}
					System.out.println();
				}
			}
		}
		sc.close();
	}
}
