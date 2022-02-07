import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class A06_괄호짝짓기_김시언 {
	static int T;
	static char bracket[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();

		for(int i=1; i<=10; i++) {
			T = Integer.parseInt(br.readLine());
			bracket = br.readLine().toCharArray();
			stack.clear();

			Loop : for(int j=0; j<T; j++) {
				switch (bracket[j]) {
				case ')':
					if(stack.peek() == '(') stack.pop();
					else break Loop;
					break;
				case '}':
					if(stack.peek() == '{') stack.pop();
					else break Loop;
					break;
				case ']':
					if(stack.peek() == '[') stack.pop();
					else break Loop;
					break;
				case '>':
					if(stack.peek() == '<') stack.pop();
					else break Loop;
					break;
				default:
					stack.push(bracket[j]);
					break;
				}
			}
			if(stack.empty()) System.out.println("#"+i+" 1");
			else System.out.println("#"+i+" 0");
		}
		br.close();
	}
}
