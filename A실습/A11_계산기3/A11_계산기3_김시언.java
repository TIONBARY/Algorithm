import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class A11_계산기3_김시언 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<Character>();
		Stack<Integer> stack_int = new Stack<Integer>();
		String math, postfix;
		int N, result, x, y;

		for(int i=1; i<=10; i++) {
			N = Integer.parseInt(br.readLine());
			math = br.readLine();
			postfix = "";
			result = 0;

			for(int j=0; j<math.length(); j++) {
				if(math.charAt(j) != '+' && math.charAt(j) != '*' && math.charAt(j) != '(' && math.charAt(j) != ')') {
					postfix += math.charAt(j);
				}
				else {
					switch (math.charAt(j)) {
					case '(':
						stack.push(math.charAt(j));
						break;
					case ')':
						while(stack.peek() != '(') {
							postfix += stack.pop();
						}
						stack.pop();
						break;
					case '+':
						if(stack.peek() == '(') stack.push(math.charAt(j));
						else {
							if(stack.empty()) stack.push(math.charAt(j));
							else {
								while(stack.empty() == false) {
									if(stack.peek() == '(') break;
									postfix += stack.pop();
								}
								stack.push(math.charAt(j));
							}
						}
						break;
					case '*':
						stack.push(math.charAt(j));
						break;
					default:
						break;
					}
				}
			}
			
			for(int j=0; j<postfix.length(); j++) {
				if(postfix.charAt(j) != '+' && postfix.charAt(j) != '*') stack_int.push(postfix.charAt(j)-'0');
				else {
					x= stack_int.pop();
					y= stack_int.pop();
					if(postfix.charAt(j) == '+') {
						result = x + y;
						stack_int.push(result);
					}
					else if(postfix.charAt(j) == '*') {
						result = x * y;
						stack_int.push(result);
					}
				}
			}
			
			System.out.println("#"+i+" "+result);
		}

		br.close();
	}
}
