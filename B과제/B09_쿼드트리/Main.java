package B09_쿼드트리;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int map[][];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("src/B09_쿼드트리/input.txt"));
		String s;
		int N;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			s = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}
		mapping(0,0,N);
		System.out.println(sb);
		br.close();
	}
	
	public static void mapping(int x, int y, int n) {
		int size = n/2;
		
		if(check(x, y, n)) {
			sb.append(map[x][y]);
			return;
		}
		
		sb.append("(");
		
		mapping(x, y, size);
		mapping(x, y+size, size);
		mapping(x+size, y, size);
		mapping(x+size, y+size, size);
		
		sb.append(")");
	}
	
	public static boolean check(int x, int y, int n) {
		int point = map[x][y];
		
		for(int i=x; i<x+n; i++) {
			for(int j=y; j<y+n; j++) {
				if(point != map[i][j]) {
					return false;
				}
			}
		}
		
		return true;
	}

}
