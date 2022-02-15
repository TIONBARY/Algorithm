import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A19_규영이와인영이의카드게임_김시언 {
	static int gyu[], in[], scoreG, scoreI, winG;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T, card[];
		T = Integer.parseInt(br.readLine());
		gyu = new int[9];
		in = new int[9];
		
		for(int i=1; i<=T; i++) {
			winG = 0;
			card = new int[19];
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++) {
				gyu[j] = Integer.parseInt(st.nextToken());
				card[gyu[j]] = 1;
			}
			for(int j=0; j<9; j++) {
				for(int k=1; k<=18; k++) {
					if(card[k] == 0) {
						in[j] = k;
						card[k] = 1;
						break;
					}
				}
			}
			Arrays.sort(in);
			do{
				scoreG = 0;
				scoreI = 0;
				for(int j=0; j<9; j++) {
					if(gyu[j]>in[j]) scoreG += gyu[j] + in[j];
					else scoreI += gyu[j] + in[j];
				}
				if(scoreG > scoreI) winG++;
			}while(np());
			
			System.out.println("#"+i+" "+winG+" "+(362880-winG));
		}
		br.close();
	}
	
	private static boolean np() { //np 순열구하기
		int i = 8;
		while(i>0 && in[i-1] >= in[i]) --i;
		
		if(i==0) return false;
		
		int j = 8;
		while(in[i-1] >= in[j]) --j;
		
		swap(i-1,j);
		
		int k = 8;
		while(i<k) {
			swap(i++,k--);
		}
		return true;
	}
	
	public static void swap(int i, int j) {
		int temp = in[i];
		in[i] = in[j];
		in[j] = temp;
	}
}
