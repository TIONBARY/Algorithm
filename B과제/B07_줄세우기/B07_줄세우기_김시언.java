import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B07_줄세우기_김시언 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<Integer> list = new LinkedList<Integer>();
		StringTokenizer st;
		int N;
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) { //list에 add하는 위치를 현재 list사이즈에서 입력값을 뺀 위치에 1번학생부터 N번 학생까지 입력
			int temp = list.size() - Integer.parseInt(st.nextToken());
			list.add(temp,i);
		}
		for(int i=0; i<list.size(); i++) System.out.print(list.get(i)+" ");
		br.close();
	}
}
