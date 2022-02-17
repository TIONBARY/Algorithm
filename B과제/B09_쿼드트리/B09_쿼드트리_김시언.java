import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B09_쿼드트리_김시언 {
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
		int sum = 0;
		
		for(int i=x; i<x+n; i++) {
			for(int j=y; j<y+n; j++) {
				sum += map[i][j];
			}
		}
		
		if(sum == n*n) sb.append(1);
		else if(sum == 0) sb.append(0);
		else {
			int size = n/2;
			sb.append("(");
			
			mapping(x, y, size);
			mapping(x, y+size, size);
			mapping(x+size, y, size);
			mapping(x+size, y+size, size);
			
			sb.append(")");
		}
	}
}
