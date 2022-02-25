package A31_미세먼지안녕;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int R, C, T, airCleaner, dust[][];
	static int dx[] = {-1,0,1,0};
	static int dy[] = {0,1,0,-1};
	
	static class Node{
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[];
		int result;
		s = br.readLine().split(" ");
		R = Integer.parseInt(s[0]);
		C = Integer.parseInt(s[1]);
		T = Integer.parseInt(s[2]);
		dust = new int[R][C];
		result = 0;
		
		for(int i=0; i<R; i++) { //먼지 배열 초기화
			s = br.readLine().split(" ");
			for(int j=0; j<C; j++) {
				dust[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		for(int i=0; i<R; i++) { //공기청정기 위치 찾기 airCleaner와 바로아래 airCleaner+1이 공기청정기
			if(dust[i][0] == -1) {
				airCleaner = i;
				break;
			}
		}
		
		for(int i=0; i<T; i++) {
			dustSpread();
			cleanAir();
		}
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				result += dust[i][j];
			}
		}
		
		System.out.println(result+2);
		
		br.close();
	}
	
	static void dustSpread() {
		int nextX, nextY, count, temp[][];
		temp = new int[R][C];
		temp[airCleaner][0] = -1;
		temp[airCleaner+1][0] = -1;
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(dust[i][j] > 0) {
					count = 0;
					for(int n=0; n<4; n++) {
						nextX = i + dx[n];
						nextY = j + dy[n];
						
						if(nextX >= 0 && nextY >= 0 && nextX < R && nextY < C && dust[nextX][nextY] != -1) {
							count++;
							temp[nextX][nextY] += dust[i][j]/5;
						}
					}
					temp[i][j] += dust[i][j] - dust[i][j]/5*count;
				}
			}
		}
		dust = temp;
	}
	
	static void cleanAir() {
		//위쪽 공기청정기 4방향 - 공기청정기가 도는 방향 반대로 돌아서 현재위치값에 다음위치값을 당겨오는 방법
		for(int i=airCleaner; i>0; i--) {
			dust[i][0] = dust[i-1][0];
		}
		for(int i=0; i<C-1; i++) {
			dust[0][i] = dust[0][i+1];
		}
		for(int i=0; i<airCleaner; i++) {
			dust[i][C-1] = dust[i+1][C-1];
		}
		for(int i=C-1; i>1; i--) {
			dust[airCleaner][i] = dust[airCleaner][i-1];
		}
		
		//아래쪽 공기청정기 4방향
		for(int i=airCleaner+1; i<R-1; i++) {
			dust[i][0] = dust[i+1][0];
		}
		for(int i=0; i<C-1; i++) {
			dust[R-1][i] = dust[R-1][i+1];
		}
		for(int i=R-1; i>airCleaner+1; i--) {
			dust[i][C-1] = dust[i-1][C-1];
		}
		for(int i=C-1; i>1; i--) {
			dust[airCleaner+1][i] = dust[airCleaner+1][i-1];
		}
		
		dust[airCleaner][0] = -1;   //공기청정기 돌린 후 공기청정기 자리에 다시 -1
		dust[airCleaner+1][0] = -1;
		dust[airCleaner][1] = 0;   //공기청정기 돌린 후 공기청정기 바로 옆은 무조건 0이 되야함
		dust[airCleaner+1][1] = 0; //하지만 위 공기청정기 돌리는 방법은 다음값을 현재로 당겨오는 방법이라 공기청정기바로 옆의 값은 그대로 유지하게 되서 
		                           //공기청정기 다 돌아간 후 0으로 초기화
	}
}
