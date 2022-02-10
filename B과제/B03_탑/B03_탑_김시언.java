import java.io.BufferedReader;
import java.util.Stack;
import java.util.StringTokenizer;
import java.io.InputStreamReader;

public class B03_탑_김시언 {
	static Stack<int[]> stack;
	static StringTokenizer st;
	static int T, in;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		stack = new Stack<>();
		
		for(int i=1; i<=T; i++) {
			in = Integer.parseInt(st.nextToken());
			while(stack.empty() == false) {
				if(stack.peek()[1] > in) {
					System.out.print(stack.peek()[0] + " ");
					break;
				}
				stack.pop();
			}
			if(stack.empty()) System.out.print("0 ");
			stack.push(new int[] {i,in});
		}
		br.close();
	}
}
