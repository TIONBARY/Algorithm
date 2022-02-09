package A12_퍼펙트셔플;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("src/A12_퍼펙트셔플/input.txt"));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String cards[], cardsL[], cardsR[];
		int T, N,indexL, indexR;
		T = Integer.parseInt(br.readLine());

		for(int i=1; i<=T; i++) {
			N = Integer.parseInt(br.readLine());
			cards = new String[N];
			cards = br.readLine().split(" ");
			indexL = 0;
			indexR = 0;

			if(N%2 == 1) {
				cardsL = new String[N/2+1];
				cardsR = new String[N/2+1];
				for(int j=0; j<N/2+1; j++) cardsL[j] = cards[j];
				for(int j=N/2+1; j<N; j++) cardsR[j-N/2-1] = cards[j];
			}
			else {
				cardsL = new String[N/2];
				cardsR = new String[N/2];
				for(int j=0; j<N/2; j++) cardsL[j] = cards[j];
				for(int j=N/2; j<N; j++) cardsR[j-N/2] = cards[j];
			}

			for(int j=0; j<N; j++) {
				if(j%2 == 0) {
					cards[j] = cardsL[indexL];
					indexL++;
				}
				else {
					cards[j] = cardsR[indexR];
					indexR++;
				}
			}

			System.out.print("#"+i+" ");
			for(int j=0; j<N; j++) {
				System.out.print(cards[j]+" ");
			}
			System.out.println();
		}

		br.close();
	}
}
