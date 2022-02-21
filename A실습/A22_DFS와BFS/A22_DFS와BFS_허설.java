package A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class A22_DFS와BFS_허설2 {

	static int N, M, Y;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("src\\A\\input.txt"));

		String[] str;
		str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		Y = Integer.parseInt(str[2]);
		int[][] adjMatrix = new int[N + 1][N + 1];// 1부터 사용할것
		for (int i = 1; i <= M; i++) { // 간선의 수만큼 1부터 받기로 했어요~
			String[] str2 = br.readLine().split(" ");
			int from = Integer.parseInt(str2[0]);
			int to = Integer.parseInt(str2[1]); // 무향은 간선하나로 양방향 처리가 가능!!!
			// System.out.println(from+" "+to);
			adjMatrix[from][to] = adjMatrix[to][from] = 1;
		}
		sb = new StringBuilder();
		dfs(adjMatrix, new boolean[N + 1], Y);
		sb.append("\n");
		bfs(adjMatrix, Y);
		System.out.print(sb);
	}

	public static void bfs(int[][] adjMatrix, int start) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N + 1];
		queue.offer(start); //시작하고자 하는 정점을 넣어준다
		visited[start] = true; //트루로 해준다.
		while (!queue.isEmpty()) {
			int current = queue.poll(); //하나를 꺼내서 
			sb.append(current).append(" "); 
			for (int j = 1; j <= N; j++) {
				if (!visited[j] && adjMatrix[current][j] != 0) { // 정점 방문했니? 그리고 그 꺼낸거에 해당하는 행렬값이 0인지아닌지
					queue.offer(j);
					visited[j] = true;
				}
			}
		}
	}

	public static void dfs(int[][] adjMatrix, boolean[] visited, int current) {
		visited[current] = true;  //방문한거 체크 
		sb.append(current).append(" "); 

		for (int j = 1; j <= N; j++) {
			if (!visited[j] && adjMatrix[current][j] != 0) { //방문한적 있니? 그리고 0이 아니니?
				dfs(adjMatrix, visited, j);
			}
		}
	}

}
