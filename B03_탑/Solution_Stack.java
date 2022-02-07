package B03_탑;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_Stack {
	static Stack<int[]> stack;
	static StringTokenizer st;
	static int T, in;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("src/B03_탑/input.txt"));
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