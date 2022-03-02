package A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_A31_미세먼지안녕 {
	static class Dust { //좌표를 넣어줄 클래스 구성 
		int x;
		int y;

		public Dust(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	static int R, C, Office[][], temp[][];
	static Queue<Dust> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] str, str2;

		str = br.readLine().split(" ");
		R = Integer.parseInt(str[0]);
		C = Integer.parseInt(str[1]);
		int T = Integer.parseInt(str[2]);
		int result = 0;
		int airX1 = 0, airX2 = 0; //공기청정기의 x좌표 
		Office = new int[R][C];
		for (int i = 0; i < R; i++) {
			str2 = br.readLine().split(" ");
			for (int j = 0; j < C; j++) {
				Office[i][j] = Integer.parseInt(str2[j]);
				if (Office[i][j] == -1)
					airX2 = i;// 덮어씌워져서 두번째 x좌표로 나올것이다.
			}
		} //////////////////////// 맵생성
		airX1 = airX2 - 1;
		while (T-- > 0) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {

					if (Office[i][j] != 0 && Office[i][j] != -1 && Office[i][j] > 4 ) { // 먼지들 다 넣어주기
						//System.out.println("[" + i + "," + j + "]");  
						queue.offer(new Dust(i, j));
					}
				}

			}
			diffusionDust();
			movingUp(airX1);
			movingDown(airX2);

		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (Office[i][j] != -1)
					result += Office[i][j];
			}
		}
		sb.append(result);
		System.out.println(result);

	}/////////////////// end of Main

	static public void diffusionDust() {
		int[] dr = { -1, 1, 0, 0 }; // 상하좌우 탐색
		int[] dc = { 0, 0, -1, 1 };
		int[][] temp = new int[R][C];
		while (!queue.isEmpty()) {
			Dust huhu = queue.poll();
			int tinyDust = Office[huhu.x][huhu.y] / 5;// 확산될 먼지값
			for (int i = 0; i < 4; i++) {
				//너 범위에 있니? 벽에 막혀있니? 옆에 -1이니?
				int nr = huhu.x + dr[i];// 탐색하고자 하는 곳 상하좌우
				int nc = huhu.y + dc[i];
				if (nr < 0 || nc < 0 || nr >= R || nc >= C || Office[nr][nc] == -1)
					continue;

				temp[nr][nc] += tinyDust; // 주변에 더해주고
				Office[huhu.x][huhu.y] -= tinyDust; // 그 더해준만큼 빼준다.
			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				Office[i][j] += temp[i][j]; //변하는 숫자들이 동시에 갱신되기 어려워서 숫자들만 들어있는 행렬을 따로 만들어 합쳐주었다.
			}
		}
	}

	// 2는 공기청정기 좌표
	static public void movingUp(int r) {
		for (int i =r-1; i  >0; i--) { // 내려가는놈
			Office[i][0] = Office[i - 1][0];
		}
		for (int i = 0; i < C - 1; i++) { // 왼쪽으로 미는 놈
			Office[0][i] = Office[0][i + 1];
		}
		for (int i = 0; i < r; i++) { // 위로 올라가는 놈
			Office[i][C - 1] = Office[i + 1][C - 1];
		}
		for (int i = C - 1; i > 0; i--) { // 오른쪽으로 가는 놈
			if (Office[r][i - 1] == -1) {
				Office[r][i] = 0;
				break;
			}
			Office[r][i] = Office[r][i - 1];
		}
	

	}
    //r에는 밑에 부분의 공기청정기 x좌표가 들어간다 
	static public void movingDown(int r) {

		for (int i = r; i < R - 1; i++) { // 위로 올라가는 놈
			if (Office[i][0] == -1)
				continue;
			Office[i][0] = Office[i + 1][0];

		}

		for (int i = 0; i < C - 1; i++) { // 왼쪽으로 미는 놈
			Office[R - 1][i] = Office[R - 1][i + 1];
		}
		for (int i = R - 1; i > r; i--) { // 내려가는놈

			Office[i][C - 1] = Office[i - 1][C - 1];
			//System.out.println("i값:" + i + " " + Office[i][C - 1]);
		}

		for (int i = C - 1; i > 0; i--) { // 오른쪽으로 가는 놈
			if (Office[r][i - 1] == -1) {
				Office[r][i] = 0;
				break;
			}
			Office[r][i] = Office[r][i - 1];
		}

	}

}//////////////////////////// end
