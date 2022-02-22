package MyAlgo.지옥의벌집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 지옥의벌집 {
	static int N, M, map[][], visit[][];
	static String result = new String();
	static int dx[] = {1,0,-1,0};
	static int dy[] = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s[];
		int T;
		T = Integer.parseInt(br.readLine());
		for(int i=1; i<=T; i++) {
			s = br.readLine().split(" ");
			N = Integer.parseInt(s[0]);
			M = Integer.parseInt(s[1]);
			for(int j=0; j<N*M; j++) result += "1";
			map = new int[N][M];
			visit = new int[N][M];
			for(int x=0; x<N; x++) {
				s = br.readLine().split(" ");
				for(int y=0; y<M; y++) {
					map[x][y] = Integer.parseInt(s[y]);
				}
			}
			move(0,0,"");
			System.out.println("#"+i+" "+result);
		}

		br.close();
	}

	static void move(int x, int y,String temp) { 
		if(x == N-1 && y == M-1) {
			if(result.length() > temp.length()) {
				result = temp;
			}
			return;
		}
		else if(visit[x][y] == 1 || map[x][y] == 1) { 
			return;
		}
		else {
			int nextX, nextY;
			visit[x][y] = 1;
			for(int i=0; i<4; i++) {
				nextX = x + dx[i];
				nextY = y + dy[i];

				if(nextX >=0 && nextY >=0 && nextX < N && nextY < M) move(nextX,nextY,temp+(i+1));
			}	
			visit[x][y] = 0;
		}
	}
}
