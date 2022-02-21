import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	static int L, C;
	static String[] str2, password;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		String[] str;
		str = br.readLine().split(" ");
		L = Integer.parseInt(str[0]); // 암호길이
		C = Integer.parseInt(str[1]); // 알파벳 개수

		// 나는 cPl 을 구할 것임
		str2 = br.readLine().split(" "); // 암호들이 들어있삼
		Arrays.sort(str2);
		password = new String[L];
		combination(0, 0,0,0);
		System.out.print(sb);
	}

	public static void combination(int cnt, int start,int vowelcnt,int consocnt) {
		if (cnt == L) {
			if (consocnt >= 2 && vowelcnt >= 1) {
				for(String i :password) {
				sb.append(i);}
				sb.append("\n");
			}
			
			return;
		}
		for (int i = start; i < C; i++) {
			password[cnt] = str2[i];
			if (str2[i].equals("a")||str2[i].equals("i")||str2[i].equals("o")||str2[i].equals("e")||str2[i].equals("u")  ) {
				combination(cnt+1, i+1, vowelcnt+1, consocnt);
			} else 
				combination(cnt+1, i+1, vowelcnt, consocnt+1);

		}
	}

}
