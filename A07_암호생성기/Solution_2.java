package A07_암호생성기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T, temp;
		StringTokenizer st;
		Queue<Integer> queue = new LinkedList<>();

		for(int i=1; i<=10; i++) {
			T = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());

			for(int j=0; j<8; j++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}

			Loop : while(true) {
				for(int j=1; j<=5; j++) {
					temp = queue.poll();
					temp -= j;
					if(temp < 0) temp = 0;
					queue.offer(temp);
					if(temp == 0) break Loop;
				}
			}
			
			System.out.print("#"+i+" ");
			for(int j=0; j<8; j++) System.out.print(queue.poll()+" ");
			System.out.println();
		}
			br.close();
	}

}
