import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A05_백설공주_김시언 {
	static int man[], dwarf[], sum;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		man = new int[9];
		dwarf = new int[7];
		
		for(int i=0; i<9; i++) {
			man[i] = Integer.parseInt(br.readLine());
		}
		
		combination(0,0);
		
		br.close();
	}
	
	public static void combination(int cnt, int start) {
		if(cnt == 7) {
			sum = 0;
			for(int i=0; i<7; i++) {
				sum += dwarf[i];
			}
			if(sum == 100) {
				for(int i=0; i<7; i++) {
					System.out.println(dwarf[i]);
				}
			}
			return;
		}
		
		for (int i = start; i < 9; i++) {
			dwarf[cnt] = man[i];
			combination(cnt+1,i+1);
		}
	}
}
