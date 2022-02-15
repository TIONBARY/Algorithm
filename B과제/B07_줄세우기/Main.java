package B07_줄세우기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<Integer> list = new LinkedList<Integer>();
		StringTokenizer st;
		int N;
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			int temp = list.size() - Integer.parseInt(st.nextToken());
			list.add(temp,i);
		}
		for(int i=0; i<list.size(); i++) System.out.print(list.get(i)+" ");
		br.close();
	}
}
