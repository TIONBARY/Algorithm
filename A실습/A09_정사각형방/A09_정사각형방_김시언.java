package A09_정사각형방;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A09_정사각형방_김시언 {
	static int N, start, index, result, rooms[][], visit[][];
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T;
		T = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=T; i++) {
			N = Integer.parseInt(br.readLine());
			rooms = new int[N][N];
			visit = new int[N][N];
			index = 0;
			result = 0;
			
			for(int x=0; x<N; x++) {
				st = new StringTokenizer(br.readLine());
				for(int y=0; y<N; y++) {
					rooms[x][y] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int x=0; x<N; x++) {
				for(int y=0; y<N; y++) {
					start = rooms[x][y];
					dfs(x,y,1);
				}
			}
			
			System.out.println("#"+i+" "+index+" "+result);
		}
		
		br.close();
	}
	
	public static void dfs(int x, int y, int count) {
		int nextX, nextY;
		visit[x][y] = 1;
		
		for(int i=0; i<4; i++) {
			nextX = x + dx[i];
			nextY = y + dy[i];
			
			if(nextX < N && nextX >= 0 && nextY < N && nextY >= 0) {
				if(visit[nextX][nextY] == 0 && rooms[nextX][nextY] == rooms[x][y] + 1) {
					dfs(nextX,nextY,++count);
				}
			}
		}
		
		if(count > result) {
			result = count;
			index = start;
		}
		else if(count == result) {
			if(start < index) index = start;
		}
		visit[x][y] = 0;
	}
}
