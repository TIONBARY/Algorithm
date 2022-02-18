import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10_알파벳_김시언 {
	static int R, C, result, visit[], map[][];
	static int dx[] = {1,0,-1,0};
	static int dy[] = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String s;
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		visit = new int[26];
		map = new int[R][C];
		result = 0;
		
		for(int i=0; i<R; i++) {
			s = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = s.charAt(j)-'A';
			}
		}
		
		move(0,0,0);
		System.out.println(result);
		br.close();
	}
	
	static void move(int x, int y, int count) { //DFS 탐색으로 진행
		if(visit[map[x][y]] == 1) { //만약 찾아 간 곳이 이미 간 적이 있는 알파벳이면 리턴
			result = Math.max(result, count);
			return;
		}
		else {
			int nextX, nextY;
			visit[map[x][y]] = 1;
			for(int i=0; i<4; i++) {
				nextX = x + dx[i];
				nextY = y + dy[i];
				
				if(nextX >=0 && nextY >=0 && nextX < R && nextY < C) move(nextX,nextY,count+1);
			}
			visit[map[x][y]] = 0;
		}
	}
}
