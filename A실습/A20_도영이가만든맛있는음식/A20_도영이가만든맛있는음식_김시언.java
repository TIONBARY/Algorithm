import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A20_도영이가만든맛있는음식_김시언 {
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N;
		N = Integer.parseInt(br.readLine());
		food[] f = new food[N];

		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			f[i] = new food(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		result = Math.abs(f[0].S-f[0].B);
		
		generateSubset(f);
		
		System.out.println(result);

		br.close();
	}
	
	private static void generateSubset(food input[]) {
		int S, B, N, flavor;
		N = input.length;
		for(int flag=0,caseCount=1<<N; flag<caseCount; flag++) {
			S = 1;
			B = 0;
			for(int i=0; i<N; i++) {
				if((flag&1<<i) != 0) {
					S *= input[i].S;
					B += input[i].B;
					flavor = Math.abs(S - B);
					result = Math.min(flavor, result);
				}
			}
		}
	}
	
	static class food {
		int S, B;
		
		food(int s, int b){
			this.S = s;
			this.B = b;
		}
	}
}
