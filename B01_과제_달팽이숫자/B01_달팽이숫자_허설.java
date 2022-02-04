package algol_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B01_달팽이숫자_허설 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int i = 0; i < tc; i++) {
			int nNum = Integer.parseInt(br.readLine());
			int[][] snail = new int[nNum][nNum];
			boolean[][] flag = new boolean[nNum][nNum];
			int cnt = 1;
			int k = 0;
			int row = 0;
			int col = -1;
			while (cnt <= (nNum * nNum)) {
				for (int j = 0; j < nNum - k; j++) { // 오른쪽
					snail[row][++col] = cnt++;
				}
				for (int j = 0; j < nNum - k - 1; j++) { // 아래
					snail[++row][col] = cnt++;
				}
				for (int j = 0; j < nNum - k - 1; j++) { // 왼
					snail[row][--col] = cnt++;
				}
				k += 1;
				for (int j = 0; j < nNum - k - 1; j++) { // 위
					snail[--row][col] = cnt++;
				}
				k += 1;
			}
			sb.append("#"+" "+(i+1)+"\n");
			for (int r = 0; r < nNum; r++) {
				for (int c = 0; c < nNum; c++) {
					sb.append(snail[r][c] + " ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}


