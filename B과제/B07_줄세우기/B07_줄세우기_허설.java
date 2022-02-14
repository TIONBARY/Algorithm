package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B07_줄세우기_허설 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<Integer> list = new LinkedList<>();
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < N; i++) {
			int order = Integer.parseInt(st.nextToken());
			if (order != 0) {
				list.add(i - order, i + 1);
			} else
				list.add(i + 1);

		} ////////////// for 문 끝
		for (int i = 0; i < N; i++) {
			sb.append(list.get(i) + " ");
		}
		System.out.print(sb);
        sb= new StringBuilder();
	}

}
