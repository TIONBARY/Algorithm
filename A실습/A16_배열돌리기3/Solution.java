package A16_배열돌리기3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, M, R, C, map[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("src/A16_배열돌리기3/input.txt"));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<R; i++) {
			C = Integer.parseInt(st.nextToken());
			switch (C) {
			case 1:
				rotation1();
				break;
			case 2:
				rotation2();
				break;
			case 3:
				rotation3();
				break;
			case 4:
				rotation4();
				break;
			case 5:
				rotation5();
				break;
			case 6:
				rotation6();
				break;
			default:
				break;
			}
		}

		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}

		br.close();
	}

	public static void rotation1() {
		int tempMap[][] = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				tempMap[N-1-i][j] = map[i][j];
			}
		}
		map = tempMap;
	}
	public static void rotation2() {
		int tempMap[][] = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				tempMap[i][M-1-j] = map[i][j];
			}
		}
		map = tempMap;
	}
	public static void rotation3() {
		int temp, tempMap[][] = new int[M][N];
		temp = N-1;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				tempMap[j][temp] = map[i][j];
			}
			temp--;
		}
		temp = M;
		M = N;
		N = temp;
		map = tempMap;
	}
	public static void rotation4() {
		int temp, tempMap[][] = new int[M][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				tempMap[M-1-j][i] = map[i][j];
			}
		}
		temp = M;
		M = N;
		N = temp;
		map = tempMap;
	}
	public static void rotation5() {
		int midN, midM, temp, tempMap[][];
		tempMap = new int[N][M];
		midN = N/2;
		midM = M/2;

		for(int i=0; i<midN; i++) {
			for(int j=0; j<midM; j++) {
				tempMap[i][midM+j] = map[i][j];
			}
		}
		for(int i=0; i<midN; i++) {
			for(int j=midM; j<M; j++) {
				tempMap[midN+i][j] = map[i][j];
			}
		}
		for(int i=midN; i<N; i++) {
			temp = 0;
			for(int j=midM; j<M; j++) {
				tempMap[i][temp] = map[i][j];
				temp++;
			}
		}
		temp = 0;
		for(int i=midN; i<N; i++) {
			for(int j=0; j<midM; j++) {
				tempMap[temp][j] = map[i][j];
			}
			temp++;
		}
		map = tempMap;
	}
	public static void rotation6() {
		int midN, midM, temp, tempMap[][];
		tempMap = new int[N][M];
		midN = N/2;
		midM = M/2;

		for(int i=0; i<midN; i++) {
			for(int j=0; j<midM; j++) {
				tempMap[midN+i][j] = map[i][j];
			}
		}
		for(int i=midN; i<N; i++) {
			for(int j=0; j<midM; j++) {
				tempMap[i][midM+j] = map[i][j];
			}
		}
		temp = 0;
		for(int i=midN; i<N; i++) {
			for(int j=midM; j<M; j++) {
				tempMap[temp][j] = map[i][j];
			}
			temp++;
		}
		for(int i=0; i<midN; i++) {
			temp = 0;
			for(int j=midM; j<M; j++) {
				tempMap[i][temp] = map[i][j];
				temp++;
			}
		}
		map = tempMap;
	}
}
