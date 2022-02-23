package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B13_적록색약 {
	static int[] dr = { -1, 0, 0, 1 }; // 상우좌하
	static int[] dc = { 0, 1, -1, 0 };
	static char[][] picture;
	static boolean[][] visited;
	static int N;
	static char start;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str2[];
		N = Integer.parseInt(br.readLine());// [N][N] 행렬
		picture = new char[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				 picture[i][j] =  str.charAt(j);
			}

		} /////// 맵생성완료
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					countArea(i, j, picture[i][j]);
					cnt++;
				
				}
			}

		}
		
		//int tmp_cnt = cnt;// 적록색약 없을때
		 sb.append(cnt).append(" ");
		cnt = 0;// 초기화
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (picture[i][j] == 'G') {
					picture[i][j] = 'R';
				}
			}
		} // R로 바꿔주는 작업

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					countArea(i, j,picture[i][j]);
					cnt++;
				}
			}

		}
		 int temp_cnt1 = cnt;
		 sb.append(temp_cnt1);
		System.out.print(sb);
	}///////////// 메인

	public static void countArea(int r, int c, char start) {

		visited[r][c] = true;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr >= 0 && nc >= 0 && nr < N && nc < N && picture[nr][nc] == start && !visited[nr][nc])// 다음 애가 나랑 같고 다음
																										// 방문안했으면 간다
				countArea(nr, nc, start);

		}
	}
}///////////// 끝
