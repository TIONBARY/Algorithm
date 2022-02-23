package B13_적록색약;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static char map[][];
	static boolean visited[][];
	static int dx[] = {-1,0,0,1};
    static int dy[] = {0,1,-1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s;
		int count;
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		
		for(int i=0; i<N; i++) {
			s = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		count = 0;
		visited = new boolean[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
					dfs(i,j);
					count++;
				}
			}
		}
		sb.append(count).append(" ");
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 'G') map[i][j] = 'R';
			}
		}
		
		count = 0;
		visited = new boolean[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
					dfs(i,j);
					count++;
				}
			}
		}
		sb.append(count);
		
		System.out.println(sb);
		br.close();
	}
	
	static void dfs(int x, int y) {
		char temp;
		int nextX, nextY;
		visited[x][y] = true;
		temp = map[x][y];
		
		for(int i=0; i<4; i++) {
			nextX = x+dx[i];
			nextY = y+dy[i];
			
			if(nextX >= 0 && nextY >= 0 && nextX < N && nextY < N && !visited[nextX][nextY] && map[nextX][nextY] == temp) {
				dfs(nextX,nextY);
			}
			
		}
	}
}
