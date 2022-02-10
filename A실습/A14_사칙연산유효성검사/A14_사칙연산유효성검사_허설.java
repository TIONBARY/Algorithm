package A;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.InputStreamReader;

public class A14_사칙연산유효성검사_허설 {
	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new FileReader("src\\A\\input.txt"));
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for (int T = 1; T <= 10; T++) {
			int N = Integer.parseInt(br.readLine());// 명령어 개수
			int check = -1;
			for (int i = 0; i < N; i++) {

				st = new StringTokenizer(br.readLine(), " ");
				int m = Integer.parseInt(st.nextToken());// 번호.. 랄까
				char what = st.nextToken().charAt(0); // 연산자나 숫자가 들어올 것임
				switch (what) { //연산자는 자식노드가 있어야함 
				case '+':
				case '-':
				case '*':
				case '/':
					if (st.hasMoreTokens()) //뒤에 읽어들일게 있는지 (자식노드 있는지?)
						check = 1;
					else
						check = 0;
					break;
				default: //다른 이상한 문자가 아니라 입력자체가 숫자가... 들어오길 바라며 디폴트 처리 
					if (st.hasMoreTokens()) //자식노드가 있으면 안되는데 있다면?
						check = 0;
					break; 
				}
			} //////////////// 테케 1개의 반복문
			sb.append("#" + T + " " + check + "\n");

		} // 전체 테케문
		System.out.println(sb);
		sb = new StringBuilder();
	}//////////////////// 메인

}
