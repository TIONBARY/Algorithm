import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A14_사칙연산유효성검사_김시언 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		char operator;
		int N, result;
		for(int i=1; i<=10; i++) {
			N = Integer.parseInt(br.readLine());
			result = 1;
			
			for(int j=1; j<=N; j++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				
				operator = st.nextToken().charAt(0);
				if(operator == '+' || operator == '-' || operator == '*' || operator == '/') {
					if(!st.hasMoreTokens()) {
						result = 0;
						continue;
					}
					else {
						st.nextToken();
						if(!st.hasMoreTokens()) {
							result = 0;
							continue;
						}
					}
				}
				else {
					if(st.hasMoreTokens()) {
						result = 0;
						continue;
					}
				}
			}
			
			System.out.println("#"+i+" "+result);
		}
		
		br.close();
	}
}
