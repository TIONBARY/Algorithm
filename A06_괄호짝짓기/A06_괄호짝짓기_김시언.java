import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A06_괄호짝짓기_김시언 {
	static int T, a1, a2, a3, a4;
	static char c[];

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 1; i <= 10; i++) {
			T = Integer.parseInt(br.readLine());
			c = br.readLine().toCharArray();
			a1 = 0;
			a2 = 0;
			a3 = 0;
			a4 = 0;

			for (int j = 0; j < T; j++) {
				switch (c[j]) {
				case '(':
					a1++;
					break;
				case ')':
					a1--;
					break;
				case '{':
					a2++;
					break;
				case '}':
					a2--;
					break;
				case '[':
					a3++;
					break;
				case ']':
					a3--;
					break;
				case '<':
					a4++;
					break;
				case '>':
					a4--;
					break;
				default:
					break;
				}
			}
			if(a1 == 0 && a2 == 0 && a3 == 0 && a4 == 0) System.out.println("#"+i+" 1");
			else System.out.println("#"+i+" 0");
		}
		br.close();
	}
}
