package algol_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//좌,우 ,하 만 탐색 

public class B05_Ladder1_허설 {
	static char[][] map = new char[100][100];
	static int Row, Col;

	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new FileReader("src\\algol_1\\input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		// 테케

		for (int tc = 1; tc <= 10; tc++) {
			int T = Integer.parseInt(br.readLine());
			Row =99;Col=-1;
			sb.append("#" + T + " ");
		

			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine(), " "); //한 행씩 읽어옵니다. 
				for (int j = 0; j < 100; j++) {
					map[i][j] = st.nextToken().charAt(0);
					 
				}
			} ////////////// 맵완성///////////////////

			
				for (int j = 99; j >= 0; j--) {
					if (map[99][j] == '2') 
					Row = 99; 
					Col = j;
				}
			
			int[] dr = { 0, 0, -1 }; // 좌우상 순으로탐색
			int[] dc = { -1, 1, 0 };
			boolean[][] isVisited = new boolean[100][100];
			loop: while (true) {
				for (int k = 0; k < 3; k++) {
					if (Row == 0) {
						sb.append(Col).append("\n");
						break loop;
					}
					if (Row + dr[k] < 0 || Col + dc[k] < 0 || Row + dr[k] >= 100 || Col + dc[k] >= 100) {
						 //System.out.println("범위넘어감");
						continue;
					}
					if (map[Row + dr[k]][Col + dc[k]] != '1') {
						// System.out.println("갈 곳이 없음");
						continue;
					}
					if (map[Row + dr[k]][Col + dc[k]] == '1' && !(isVisited[Row + dr[k]][Col + dc[k]])) {
						isVisited[Row][Col] = true;
						Row = Row + dr[k];
						Col = Col + dc[k];
						
					}

				}
			}

		}
		System.out.print(sb.toString());
		br.close();
		sb = new StringBuilder(); //close() 하는것보다 새로 생성해서 초기화 해주는게 더 좋다! 
	}////////////////// 메인 끝/////////////////////////////

}
