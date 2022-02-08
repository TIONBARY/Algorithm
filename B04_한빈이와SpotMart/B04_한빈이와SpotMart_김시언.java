import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B04_한빈이와SpotMart_김시언 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T, N, M, sum, max, cookies[];
		T = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=T; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			sum = 0;
			max = 0;
			cookies = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) cookies[j] = Integer.parseInt(st.nextToken());
			
			for(int x=0; x<N-1; x++) {
				for(int y=x+1; y<N; y++) {
					sum = cookies[x] + cookies[y];
					if(sum > max && sum <= M) max = sum;
				}
			}
			
			if(max == 0) System.out.println("#"+i+" -1");
			else System.out.println("#"+i+" "+max);
		}
		br.close();
	}
}
