package B;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class B10_알파벳_허설 {
	static int[] dr = { 0, 1, 0, -1 }; // 우하좌상
	static int[] dc = { 1, 0, -1, 0 };
	static int R, C, result;
	static char[][] map;
	static boolean[] isVisited = new boolean[26];

	/* A=65 ~ Z=90 */
//A=0 ~ Z=25;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("src\\B\\input.txt"));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		result = -1; // 최댓값을 결정하는 놈
		String str;
		for (int i = 0; i < R; i++) {
			str = br.readLine(); // 배열 한 행씩 읽어오기
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		} /////////////// 맵 생성
		isVisited[(map[0][0] - 'A')]=true;
		visit(0, 0, 1);
		System.out.print(result);

	}

	static void visit(int r, int c, int count) {
			int nr, nc;// 현재위치
			result = Math.max(result, count);
			// 이거 왜 nr = r;nc = c; 선언하면 안됨??? 궁금해 죽어버림
			for (int i = 0; i < 4; i++) {
				nr = r + dr[i];
				nc = c + dc[i];
				if (nr < 0 || nr >= R || nc < 0 || nc >= C||isVisited[(map[nr][nc] - 'A')]) {
					continue;
				}
				isVisited[(map[nr][nc] - 'A')] = true;
				visit(nr, nc, count + 1);
				isVisited[(map[nr][nc] - 'A')] = false;
			
			
		}
	}

}
