import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class D02_요리사_김시언 {
	static int N, result, synergy[][], visit[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[];
		int T;
		T = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=T; i++) {
			N = Integer.parseInt(br.readLine());
			synergy = new int[N][N];
			visit = new int[N]; //조합에서 선택된 원소들 표시할 배열 선택되면 1, 아니면 0

			//시너지배열 초기화
			for(int x=0; x<N; x++) {
				s = br.readLine().split(" ");
				for(int y=0; y<N; y++) {
					synergy[x][y] = Integer.parseInt(s[y]);
				}
			}
			
			//최소값을 찾아내는 문제이니 초기값을 최대값으로 설정
			result = Integer.MAX_VALUE;
			
			combination(0,0);
			
			System.out.println("#"+i+" "+result);
		}
		
		br.close();
	}
	
	private static void combination(int cnt, int start) {
		if(cnt == N/2) { //기저조건을 '전체 재료수의 절반이 선택되었을 때'로 설정
			calSynergy(); 
			return;
		}
		
		for (int i = start; i < N; i++) {
			visit[i] = 1; //조합에서 선택되면 1로 저장
			combination(cnt+1,i+1);
			visit[i] = 0;
		}
	}

	private static void calSynergy() {
		int foodA, foodB, indexA, indexB, a[], b[];
		foodA = 0;
		foodB = 0;
		a = new int[N/2];
		b = new int[N/2];
		indexA = 0;
		indexB = 0;
		
		for(int i=0; i<N; i++) {
			if(visit[i] == 1) { //조합에서 선택된 재료들을 a[]에 넣어줌
				a[indexA] = i;
				indexA++;
			}
			else { //조합에서 선택안된 재료들은 b[]에 넣어줌
				b[indexB] = i;
				indexB++;
			}
		}
		
		for(int x=0; x<N/2; x++) { //조합을 계산하는 식으로 배열를 돌려 각 음식의 시너지합을 계산
			for(int y=x+1; y<N/2; y++) {
				foodA += synergy[a[x]][a[y]] + synergy[a[y]][a[x]];
				foodB += synergy[b[x]][b[y]] + synergy[b[y]][b[x]];
			}
		}
		result = Math.min(result, Math.abs(foodA - foodB)); //두 음식의 시너지의 차이를 결과값에 저장
	}
}
