package A03_상호의배틀필드;

import java.io.File;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("src/A03_상호의배틀필드/input.txt"));
		char[][] map;
		String temp,action;
		int T,N,M,count,x,y;
		T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++){
			x = 0;
			y = 0;
			N = sc.nextInt();
			M = sc.nextInt();
			map = new char[N][M];
			for(int i=0; i<N; i++) { //2차배열 초기화
				temp = sc.next();
				for(int j=0; j<M; j++) {
					map[i][j] = temp.charAt(j);
					if(map[i][j] == '<' || map[i][j] == '>' || map[i][j] == '^' || map[i][j] == 'v') {
						x = i; //초기화 중 탱크를 발견하면 탱크좌표 저장
						y = j;
					}
				}
			}
			count = sc.nextInt();
			action = sc.next();

			for(int i=0; i<count; i++) { //액션 포문 시작
				switch (action.charAt(i)) {
				case 'U':
					if(x-1>=0 && map[x-1][y]=='.') { //위에 맵이 있고 평지라면
						x -= 1; //탱크의 좌표를 변경해주고
						map[x][y] = '^'; //변경된 좌표에 탱크를 입력해주고
						map[x+1][y] = '.';  //이전의 탱크위치에 평지를 넣어준다
					}
					else map[x][y] = '^';
					break;
				case 'D':
					if(x+1<N && map[x+1][y]=='.') {
						x += 1;
						map[x][y] = 'v';
						map[x-1][y] = '.';
					}
					else map[x][y] = 'v';
					break;
				case 'L':
					if(y-1>=0 && map[x][y-1]=='.') {
						y -= 1;
						map[x][y] = '<';
						map[x][y+1] = '.';
					}
					else map[x][y] = '<';
					break;
				case 'R':
					if(y+1<M && map[x][y+1]=='.') {
						y += 1;
						map[x][y] = '>';
						map[x][y-1] = '.';
					}
					else map[x][y] = '>';
					break;
				case 'S':
					if(map[x][y] == '<' && y-1>=0) { //탱크방향으로 맵이 있으면
						for(int k=y-1; k>=0; k--) {  //그 방향으로 포문을 돌린다.
							if(map[x][k] == '#') break;  //만약 강철벽을 만나면 그만
							else if(map[x][k] == '*') {  //벽돌벽을 만나면
								map[x][k] = '.';  //부숴서 평지로 만들고 break
								break;
							}

						}
					}
					else if(map[x][y] == '>' && y+1<M) {
						for(int k=y+1; k<M; k++) {
							if(map[x][k] == '#') break;
							else if(map[x][k] == '*') {
								map[x][k] = '.';
								break;
							}
						}
					}
					else if(map[x][y] == '^' && x-1>=0) {
						for(int k=x-1; k>=0; k--) {
							if(map[k][y] == '#') break;
							else if(map[k][y] == '*') {
								map[k][y] = '.';
								break;
							}
						}
					}
					else if(map[x][y] == 'v' && x+1<N) {
						for(int k=x+1; k<N; k++) {
							if(map[k][y] == '#') break;
							else if(map[k][y] == '*') {
								map[k][y] = '.';
								break;
							}
						}
					}
					break;
				default:
					break;
				}
				/*System.out.println("#"+(i+1)+" "+action.charAt(i));
				for(int a=0; a<N; a++) {
					for(int b=0; b<M; b++) {
						System.out.print(map[a][b]);
					}
					System.out.println();
				}
				System.out.println();*/
			}
			System.out.print("#"+test_case+" ");
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			System.out.println();
		}
		sc.close();
	}
}
