package algol_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B06_색종이_허설 {
	static int[][] map = new int[100][100];// 0,0도 있으니까

	public static void main(String[] args) throws IOException {

		//BufferedReader br = new BufferedReader(new FileReader("src\\algol_1\\input.txt"));
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine()); // 사각형의 개수
		int count = 0;
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			int curX = Integer.parseInt(st.nextToken()); 
			int curY = Integer.parseInt(st.nextToken()); 
			for (int i = curX; i < curX + 10; i++) {
				for (int j = curY; j < curY + 10; j++) {
					map[i][j] = 1;
				}
			}

		}
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] == 1)
					count++;
			}
		}
		System.out.println(count);
	}

}
