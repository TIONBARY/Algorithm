import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C02_비밀번호_김시언(시간초과) { //시간초과남
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N, i, count;
		N = Long.parseLong(br.readLine());
		
		count = get(N);
		
		i = N-1;
		while(true) {
			if(get(i) == count) {
				System.out.print(i+" ");
				break;
			}
			i--;
			if(i == 0) {
				System.out.print("0 ");
				break;
			}
		}
		
		i = N+1;
		while(true){
			if(get(i) == count) {
				System.out.println(i);
				break;
			}
			i++;
		}
		br.close();
	}
	
	public static long get(long num) { //2진법시 1의 개수 구하는 메소드
		long temp, countTemp;
		temp = num;
		countTemp = 0;
		while(true) {
			if(temp%2 == 1) countTemp++;
			if(temp == 1) {
				break;
			}
			temp /= 2;
		}
		return countTemp;
	}
}
