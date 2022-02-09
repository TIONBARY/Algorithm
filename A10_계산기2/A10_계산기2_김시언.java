import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class A10_계산기2_김시언 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<Character>();
		Stack<Integer> stack_int = new Stack<Integer>();
		int N, result, x, y;
		String math, postfix;
		
		for(int i=1; i<=10; i++) {
			N = Integer.parseInt(br.readLine());
			math = br.readLine();
			postfix = "";
			result = 0;
			
			for(int j=0; j<math.length(); j++) {
				if(math.charAt(j) != '+' && math.charAt(j) != '*') postfix += math.charAt(j);
				else {
					if(math.charAt(j) == '*') stack.push(math.charAt(j));
					else {
						if(stack.empty()) stack.push(math.charAt(j));
						else {
							while(stack.empty() == false) {
								postfix += stack.pop();
							}
							stack.push(math.charAt(j));
						}
					}
				}
			}
			while(stack.empty() == false) {
				postfix += stack.pop();
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
