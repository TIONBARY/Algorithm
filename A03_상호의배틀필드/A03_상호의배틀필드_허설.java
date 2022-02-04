package algol_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class A03_상호의배틀필드_허설 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new File("src\\algol_1\\input.txt"));
		StringBuilder sb = new StringBuilder(); // 모아놓았다가 한번에 출력
		int T = sc.nextInt();// 테스트케이스
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 }; // 상하좌우 가는거 델타
		char tank = ' '; // 탱크 위치
		for (int tc = 1; tc <= T; tc++) {
			int dir = 0; // 방향 넣으려고
			// boolean exist = true;
			int H = sc.nextInt();// 높이
			int W = sc.nextInt();// 너비
			char[][] map = new char[H][W];
			int curX = -1;
			int curY = -1; // 이거 하는 이유가 뭐임?
			// 행렬이랑x,y 같이 생각하려니까 뭔가 헷갈림 배열이다배열..
			for (int i = 0; i < H; i++) {
				String row = sc.next();
				for (int j = 0; j < W; j++) {
					map[i][j] = row.charAt(j);
					if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
						curX = i;
						curY = j;
						tank = map[i][j];
						switch (tank) {
						case '^':
							dir = 0;
							break;
						case 'v':
							dir = 1;
							break;
						case '<':
							dir = 2;
							break;
						case '>':
							dir = 3;
							break;
						}
					} ///////////// 이프문 끝

				}
			}
			//////////////////// 맵 생성완료 //////////////////////////

			int N = sc.nextInt();// 몇개의 문자열이 들어올까?
			char[] moving = sc.next().toCharArray(); // 신세계 지수님 ㄳ
			for (int i = 0; i < moving.length; i++) {
				switch (moving[i]) {
				case 'S':
					int tmpX = curX; // 일단 현재 위치를 임시저장
					int tmpY = curY;
					while (tmpX + dx[dir] >= 0 && tmpX + dx[dir] < H && tmpY + dy[dir] >= 0 && tmpY + dy[dir] < W) { // 범위안에
																														// 있다면

						// 강철벽이라면
						if (map[tmpX + dx[dir]][tmpY + dy[dir]] == '#') {
							break; // 아무일도 일어나지 않고 움직일수도없음
						}

						// 벽돌벽이라면
						else if (map[tmpX + dx[dir]][tmpY + dy[dir]] == '*') {
							map[tmpX + dx[dir]][tmpY + dy[dir]] = '.';
							break;

						}
						// 평지 혹은 물가 (물가도 어차피 바뀌는건 아니니까?)
						else {
							// 평지라면 그 방향으로 한칸 전진 후 다시 탐색(포탄은 쭉가니께)
							tmpX += dx[dir];
							tmpY += dy[dir];
						}
					}

					break;
				case 'U':
					dir = 0;
					tank = '^';
					break;
				case 'D':
					dir = 1;
					tank = 'v';
					break;
				case 'L':
					dir = 2;
					tank = '<';
					break;
				case 'R':
					dir = 3;
					tank = '>';
					break;
				}
				if (curX + dx[dir] >= 0 && curX + dx[dir] < H && curY + dy[dir] >= 0 && curY + dy[dir] < W
						&& map[curX + dx[dir]][curY + dy[dir]] == '.') {// 이동한 곳이 평지면
					map[curX][curY] = '.';
					map[curX + dx[dir]][curY + dy[dir]] = tank;
					curX = curX + dx[dir];
					curY = curY + dy[dir];
				} else {
					map[curX][curY] = tank;
				}
			}

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");

			}

		}
		System.out.println(sb.toString());
	}
}
