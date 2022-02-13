package A15_배열돌리기1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static int dx[] = {0,1,0,-1};
	public static int dy[] = {1,0,-1,0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("src/A15_배열돌리기1/input.txt"));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N, M, R, count, index, x, nextX, y, nextY, temp, map[][];

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		count = (Math.min(N, M)) / 2;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i=0; i<count; i++) {
			for(int j=0; j<R; j++) {
				x = i;
				y = i;
				temp = map[x][y];
				index = 0;
				while(index<4) {
					nextX = x + dx[index];
					nextY = y + dy[index];
					
					if(nextX >= i && nextY >= i && nextX < N-i && nextY < M-i) {
						map[x][y] = map[nextX][nextY];
						x = nextX;
						y = nextY;
					}
					else index++;
				}
				map[i+1][i] = temp;
			}
		}

		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}

		br.close();
	}
}
