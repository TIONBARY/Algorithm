import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C01_콘테스트 {
	//10C3해서 최댓값 두개 구하기~ ;
	static int max,cnt,numbers[],input[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		max =-1;

		numbers = new int[3];
		input  = new int[10];
		for(int i=0;i<10;i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		Combi(0,0,input);
		sb.append(max+" ");
		max =0;
        	for(int i=0;i<10;i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		Combi(0,0,input);
		sb.append(max);
        System.out.print(sb);
        sb= new StringBuilder();

	}
	public static void Combi(int cnt,int start,int[]input) {
		int sum =0;
		
		if(cnt==3) {
			for(int i= 0;i<3;i++) {
				sum+=numbers[i];
				max = max>sum?max:sum; //세 값 더해주기 
			}
			return;
		}
		else {
			for(int i =start;i<10;i++) {
				numbers[cnt] = input[i];
				Combi(cnt+1,i+1,input);
			}
			
		}
	}

}
