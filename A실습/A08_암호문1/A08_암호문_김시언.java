import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class A08_암호문_김시언 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<Integer> list = new LinkedList<>();
		StringTokenizer st;
		int N,index, nums;
		
		for(int i=1; i<=10; i++) {
			list.clear();
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				switch (st.nextToken()) {
				case "I":
					index = Integer.parseInt(st.nextToken());
					nums = Integer.parseInt(st.nextToken());
					for(int k=0; k<nums; k++) {
						list.add(index++,Integer.parseInt(st.nextToken()));
					}
					break;
				default:
					break;
				}
			}
			System.out.print("#"+i+" ");
			for(int j=0; j<10; j++) {
				System.out.print(list.get(j)+" ");
			}
			System.out.println();
		}
		br.close();
	}
}
