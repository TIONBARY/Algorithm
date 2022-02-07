package algol_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B03_탑_허설 {

	public static void main(String[] args) throws IOException {
		// BufferedReader br = new BufferedReader(new FileReader("src\\algol_1\\input4.txt")); //혼자 테스트용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 제출용
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		Stack<int[]> stack = new Stack<>();
		// N개의 탑
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			int input = Integer.parseInt(st.nextToken());
			while (!stack.isEmpty()) {
				
				if (stack.peek()[1] >= input) { // 같은 층일때도 수신할 수 있다고 생각
					sb.append(stack.peek()[0]).append(" ");
					break; // 이걸 생각못함.. 시언님거 보고.. 발견..!
					
				} else { // 작으면 pop하고 밑으로 내려가서 0출력, 들어오는 놈 push
					stack.pop();
				}

			}
			if (stack.isEmpty()) { // 첫번째 들어갈때 첫번째 순서는 무조건 0일 수 밖에 없기 때문에
				sb.append("0 ");
			}
			stack.push(new int[] { i, input }); // 배열로 넣을 수 있다는 것을 처음 알게 됨! 이것도 같은 팀 페어인 시언님한테 물어본 것 
		}
		System.out.println(sb);
		br.close();
	}
}
