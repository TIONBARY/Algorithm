package A24_서로소집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int N, M, parents[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[];
		int T, a, b, action;
		T = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=T; i++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(i).append(" ");
			s = br.readLine().split(" ");
			N = Integer.parseInt(s[0]);
			M = Integer.parseInt(s[1]);

			makeSet();
			
			for(int j=0; j<M; j++) {
				s = br.readLine().split(" ");
				action = Integer.parseInt(s[0]);
				a = Integer.parseInt(s[1]);
				b = Integer.parseInt(s[2]);
				
				if(action == 1) {
					if(findSet(a)==findSet(b)) sb.append(1);
					else sb.append(0);
				}
				else {
					union(a,b);
				}
			}
			System.out.println(sb);
		}
		br.close();
	}
	
	public static void makeSet() {
		parents = new int[N+1];
		for(int i=1; i<=N; i++) parents[i] = i;
	}
	
	public static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static int findSet(int a) {
		if(a==parents[a]) return a;
		return parents[a] = findSet(parents[a]);
	}
}
