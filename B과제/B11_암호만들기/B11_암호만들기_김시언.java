import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B11_암호만들기_김시언 {
	static int L, C;
	static String alphabet[], password[];
	static boolean visited[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[];
		s = br.readLine().split(" ");
		L = Integer.parseInt(s[0]);
		C = Integer.parseInt(s[1]);
		visited = new boolean[C];
		password = new String[L];
		
		alphabet = br.readLine().split(" ");
		
		Arrays.sort(alphabet);

		combination(0,0);
		
		br.close();
	}

	public static void combination(int cnt, int start) {
		if(cnt == L) {
			int index, v, c;
			index = 0;
			v = 0;
			c = 0;
			
			for(int i=0; i<C; i++) {
				if(visited[i]) {
					password[index++] = alphabet[i];
					
					if(alphabet[i].equals("a") || alphabet[i].equals("e") || alphabet[i].equals("i") || alphabet[i].equals("o") || alphabet[i].equals("u")) {
						v++;
					}
					else c++;
				}
			}
			if(v>=1 && c>=2) {
				for(int i=0; i<L; i++) System.out.print(password[i]);
				System.out.println();
			}
			
			return;
		}
		
		for (int i = start; i < C; i++) {
			visited[i] = true;
			combination(cnt+1,i+1);
			visited[i] = false;
		}
	}
}
