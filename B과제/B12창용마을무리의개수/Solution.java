package B12_창용마을무리의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int N, M, result, parents[];
	static boolean visited[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[];
		int T, a, b;
		T = Integer.parseInt(br.readLine());

		for(int i=1; i<=T; i++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(i).append(" ");
			s = br.readLine().split(" ");
			N = Integer.parseInt(s[0]);
			M = Integer.parseInt(s[1]);
			result = 0;

			makeSet();

			for(int j=0; j<M; j++) {
				s = br.readLine().split(" ");
				union(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
			}
			
			for(int j=1; j<=N; j++) {
				visited[parents[j]] = true;
			}
			for(int j=1; j<=N; j++) {
				if(visited[j]) result++;
			}

			sb.append(result);
			System.out.println(sb);
		}

		br.close();
	}

	public static void makeSet() {
		parents = new int[N+1];
		visited = new boolean[N+1];
		for(int i=1; i<=N; i++) parents[i] = i;
	}

	public static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return false;

		if (aRoot < bRoot) {
			parents[bRoot] = aRoot;
			for (int i=1; i<=N; i++) {
				if (parents[i] == bRoot)
					parents[i] = aRoot;
			}
		} 
		else {
			parents[aRoot] = bRoot;
			for (int i=1; i<=N; i++) {
				if (parents[i] == aRoot)
					parents[i] = bRoot;
			}
		}

		return true;
	}

	public static int findSet(int a) {
		if(a==parents[a]) return a;
		return parents[a] = findSet(parents[a]);
	}
}
