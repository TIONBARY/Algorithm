package A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int n, parents[];

	public static void makeSet(int n) {
		parents = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parents[i] = i;
		}

	}

	public static int findSet(int a) {
		if (a == parents[a])
			return a;
		return parents[a] = findSet(parents[a]);
	}

	public static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot)
			return false;
		parents[bRoot] = aRoot;
		return true;

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader br = new BufferedReader(new FileReader("src\\A\\input.txt"));
		StringBuilder sb = new StringBuilder();
		int n, m;
		String[] str, str2;
		int T = Integer.parseInt(br.readLine()); // 테케~

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			str = br.readLine().split(" ");
			n = Integer.parseInt(str[0]);
			m = Integer.parseInt(str[1]);

			makeSet(n);
			for (int i = 0; i < m; i++) {
				str2 = br.readLine().split(" ");
				int oper = Integer.parseInt(str2[0]);
				int from = Integer.parseInt(str2[1]);
				int to = Integer.parseInt(str2[2]);
				// 코드가 너무 길어서 변수로 넣어줌

				if (oper == 0) {
					union(from, to);
				} else if (oper == 1) {
					if (findSet(from) == findSet(to))
						sb.append(1);
					else
						sb.append(0);
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);

	}

}
