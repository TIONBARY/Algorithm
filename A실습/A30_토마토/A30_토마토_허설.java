package A;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_A30_토마토 {
	static class Tomato {
		int x;
		int y;

		public Tomato(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	static int box[][], N, M, cnt;
	static boolean[][] visited;
	static Queue<Tomato> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken()); // 열
		N = Integer.parseInt(st.nextToken());// 행
		box = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if (box[i][j] == 1) {
					queue.offer(new Tomato(i, j));// 토마토가 있는 위치를 큐에 집어넣기
				}
			}
		} /////////////////// 맵생성
			
		int result = 0;
		result = bfs(result);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (box[i][j]==0) {
					result = -1;
				}
				
			}

		} ///////////////////이렇게 해야하나..? 빈거 있나 체크 
		
		sb.append(result);
		System.out.print(sb); 

	}///////////////// 메인

	static public int bfs(int result) {
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		while (!queue.isEmpty()) {
			Tomato toto = queue.poll(); // 큐안에 있는 앞에있는 놈 뽑기
			// 너의 상하좌우에 0있니? 이미 방문했니?
			//  0이면 1로 바꿔주고 그 좌표를 토마토에 넣어서 큐에 넣어준다.
			// 그리고 카운트
			for (int i = 0; i < 4; i++) {
				int nr = toto.x + dr[i];// 탐색하고자 하는 곳 상하좌우
				int nc = toto.y + dc[i];
				if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc] || box[nr][nc] == -1)
					continue;
				if (box[nr][nc] == 0 && !visited[nr][nc]) {
					visited[nr][nc] = true;
					box[nr][nc] = box[toto.x][toto.y] + 1; //이렇게 카운팅하는거 은근 다른 문제에서도 쓴다고 함~ 
					queue.offer(new Tomato(nr, nc));

				}

			}
			result = box[toto.x][toto.y] - 1; //초기 시작부터 1이여서 숫자가 하나 더 크게나옴 

		}
		return result;

	}
}//////////////////// 끝
