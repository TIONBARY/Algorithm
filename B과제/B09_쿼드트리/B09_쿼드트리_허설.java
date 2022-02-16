package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class B09_쿼드트리_허설 {
	static int N;
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// N을 받아온다.
		// 0,1검사해 그러다가 0이나 1이 섞여있는걸 발견
		// n/2에 들어가! 그리고 다시 n/2만큼 나눠서 봐 0,1 섞인걸 발견
		// n/2로 들어가!
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0, size = N; i < size; i++) {
			String str = br.readLine();
			for (int j = 0; j < size; j++) {
				arr[i][j] = str.charAt(j)-'0';
			}
		} ///////////////////////// 배열생성 완료
		divide(N, 0, 0);
		System.out.print(sb);

	}///////// 메인

	public static void divide(int N, int x, int y) {
		int size = N;
		if(is01(N,x,y)) //안으로 들어간 그 배열은 숫자가 통일이니~?
			sb.append(arr[x][y]);
		else {
						sb.append("("); 
						divide(size / 2, x, y); //왼쪽 위
						divide(size / 2, x, y+size/2); //오른쪽 위
						divide(size / 2, x+size/2, y); //왼쪽 아래
						divide(size / 2, x+size/2, y+size/2); //오른쪽 아래
						sb.append(")");
					} 
	}////////////////////////////divide 끝

	public static boolean is01(int size, int x, int y) {
		//분열한 작은 배열의 첫시작 기준점
		int standard = arr[x][y];
		
		for(int i= x;i<x+size;i++) {  //작은 배열이 다 같은 숫자인가
			for(int j = y;j<y+size;j++) {
				if(arr[i][j]!=standard){}
                return false;
                }
			}
		}
		return true;
	}
}

