package algol_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A07_암호생성기_허설 {

	public static void main(String[] args) throws IOException {
		// BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); //제출용
		BufferedReader in = new BufferedReader(new FileReader("src\\algol_1\\input5.txt")); //테스트용 
		StringBuilder sb = new StringBuilder();
		Queue<Integer> queue = new LinkedList<>();

		int M = 10;

		while (M-- > 0) {
			int N = Integer.parseInt(in.readLine());
			sb.append("#").append(N).append(" ");
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < 8; i++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			} // 큐안에 8개의 데이터가 들어감
			int cnt = 1;
			while (true) {
				int tmp = queue.poll();
				tmp -= cnt;
				if (tmp > 0) {
					queue.offer(tmp);
				} else { //값이 0보다 작거나 같을때 
					queue.offer(0);
					break;
				}
				if (cnt == 5) { //5되면 다시 1부터 시작 
					cnt = 0;
				}
				cnt++;
			}
			for (int i = 0; i < 8; i++) {
				sb.append(queue.poll() + " ");
			}
			sb.append("\n");

		}
		System.out.print(sb);
	}

}
