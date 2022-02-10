package algol_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//내가 체크해야할 사항 
//상하좌우 방이 있는지
//탐색하는 방번호가 내 방보다 큰지 그렇다면 카운트 (저장할때 배열?)
/* 한번밖에 탐색을 못해서 어쩔 수 없이 재귀를 써야했음...*/
//최대 몇 개 방 갈 수 있는지, 시작 방 번호 저장 

public class A09_정사각형방_허설 {
	static int[][] room;
	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { -1, 0, 1, 0 }; // 좌상우하

	// static int Row,Col;
	// static int count;

	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new FileReader("src\\algol_1\\input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());// 방 크기
			room = new int[N][N];
			for (int i = 0; i < room.length; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < room.length; j++) {
					room[i][j] = Integer.parseInt(st.nextToken());
				}
			} /////////////////////// 방만들기 //////////////////////////////////
			
			int max = -1;
			int max_room = 2147483647;
			for (int i = 0; i < room.length; i++) {
				for (int j = 0; j < room.length; j++) {
					//count 부분은 첫시작부터 방 하나는 방문하니까 1 시작 
					int res2 = searchMore(i, j, 1); // result값이 줄줄이 나올것임
					if (max < res2) {
						max_room = room[i][j];
						max = res2;
					} else if (max == res2) {
						max_room = max_room < room[i][j] ? max_room : room[i][j];
					}
				}

			}
		

		sb.append("#" + tc + " " + max_room + " " + max + "\n");

	} // 전체케이스끝
		 System.out.print(sb.toString());

	}//////////////// 메인///////////////////////

	public static int searchMore(int Row, int Col, int count) {
		int res = count;
		for (int k = 0; k < 4; k++) {
			// System.out.println("들어옴!");
			// System.out.println("현재위치 [" + Row + "," + Col + "]");

			if (Row + dr[k] < 0 || Col + dc[k] < 0 || Row + dr[k] >= room.length || Col + dc[k] >= room.length) {
				// System.out.println("범위넘어감");
				continue;
			}
			if (room[Row][Col] != room[Row + dr[k]][Col + dc[k]] - 1) {
				// System.out.println("옆방에 1더 크지않음");
				continue;
			}
			// System.out.println("범위됨!");
			int tmp = searchMore(Row + dr[k], Col + dc[k], count + 1);
			res = res < tmp ? tmp : res;

		}
		return res;
	}
}
