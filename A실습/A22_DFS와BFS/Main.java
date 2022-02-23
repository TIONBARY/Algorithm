package A22_DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[];
		int M, start, from, to, adjMatrix[][];
		s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		start = Integer.parseInt(s[2]);
		adjMatrix = new int[N+1][N+1];
		
		for(int i=0; i<M; i++) {
			s = br.readLine().split(" ");
			from = Integer.parseInt(s[0]);
			to = Integer.parseInt(s[1]);
			adjMatrix[from][to] = adjMatrix[to][from] = 1;
		}
		
		dfs(adjMatrix, new boolean[N+1], start);
		sb.append("\n");
		bfs(adjMatrix, start);
		
		System.out.println(sb);
		br.close();
	}
	
	public static void bfs(int[][] adjMatrix, int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean visited[] = new boolean[N+1];
		
		queue.offer(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			sb.append(current).append(" ");
			
			for(int i=0; i<=N; i++) {
				if(!visited[i] && adjMatrix[current][i] > 0) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
	}
	
	public static void dfs(int[][] adjMatrix, boolean visited[], int current) {
		visited[current] = true;
		sb.append(current).append(" ");
		
		for(int i=0; i<=N; i++) {
			if(!visited[i] && adjMatrix[current][i] != 0) {
				dfs(adjMatrix, visited,i);
			}
		}
	}
}
