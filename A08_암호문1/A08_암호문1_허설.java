package algol_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class A08_암호문1_허설 {

	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new FileReader("src\\algol_1\\input7.txt")); //테스트용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //제출용
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		ArrayList<String> list = new ArrayList<>();
		// 테스트 케이스는 10개
		int T = 1;
		while (T <= 10) {
			list.clear();
			sb.append("#").append(T);
			T++;
			int N = Integer.parseInt(br.readLine()); // 암호문의 숫자 개수
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) { // 암호문 리스트에 넣기~
				list.add(st.nextToken());
			}
			int M = Integer.parseInt(br.readLine());// 명령어의 개수
			st = new StringTokenizer(br.readLine(), "I| ");
			while (M-- > 0) {
				int index = Integer.parseInt(st.nextToken());// 인덱스로 쓸 예정
				int deadline = Integer.parseInt(st.nextToken());// for문으로 자를 예정

				for (int i = index; i < index + deadline; i++) {
					list.add(i, st.nextToken());
				}
			}
			for (int i = 0; i < 10; i++) {
				sb.append(" ").append(list.get(i));
			}
			sb.append("\n");

		}
/////////////////////////while 끝/////////////////////
		System.out.print(sb);
	}
/////////////////main 끝/////////////////////////////////////

}
