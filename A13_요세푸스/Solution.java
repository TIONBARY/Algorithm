package A13_요세푸스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> queue = new LinkedList<Integer>();
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N, K, temp;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		for(int i=1; i<=N; i++) {
			queue.offer(i);
		}

		for(int i=0; i<N; i++) {
			for(int j=0; j<K-1; j++) {
				temp = queue.poll();
				queue.offer(temp);
			}
			sb.append(queue.poll()).append(", ");
		}
		sb.setLength(sb.length()-2);

		System.out.println("<"+sb+">");

		br.close();
	}
}
