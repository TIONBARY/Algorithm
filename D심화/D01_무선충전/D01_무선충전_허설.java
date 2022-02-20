package D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class D01_무선충전_허설 {
	static int[][] map = new int[11][11];// 0라인은 안쓸거임

//0:움직이지않음. 1:상 2:우 3:하 4:좌
	static int[] dr = { 0, -1, 0, 1, 0 };
	static int[] dc = { 0, 0, 1, 0, -1 };
	static ArrayList<Charger> ch;

	static class Charger implements Comparable<Charger> {
		int row, col, distance, status;

		public Charger(int row, int col, int distance, int status) { // d: distance, s:status
			this.row = row;
			this.col = col;
			this.distance = distance;
			this.status = status;
		}

		@Override
		public int compareTo(Charger o) {

			return o.status - this.status; // 내림차순
		}

		@Override
		public String toString() {
			return "Charger [row=" + row + ", col=" + col + ", distance=" + distance + ", status=" + status + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("src\\D\\input.txt"));
		StringBuilder sb = new StringBuilder();
		ch = new ArrayList<>();
		int T = Integer.parseInt(br.readLine()); // 테케를 받아온다
		String[] input;
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			input = br.readLine().split(" ");
			int M = Integer.parseInt(input[0]); // 이동시간 (사용자가 움직일 수있는 기회?)
			int A = Integer.parseInt(input[1]); // BC의 개수
			String[] userA = br.readLine().split(" ");// 사용자A의 움직임 1초부터 M초까지
			String[] userB = br.readLine().split(" ");

///////////////////////////////////////////////

			for (int num = 0; num < A; num++) { // BC의 정보를 저장할 포문

				String[] input2 = br.readLine().split(" "); // BC의 정보
				int r = Integer.parseInt(input2[1]); // 맵 뒤집어져 있음
				int c = Integer.parseInt(input2[0]);
				int d = Integer.parseInt(input2[2]);
				int s = Integer.parseInt(input2[3]);
				ch.add(new Charger(r, c, d, s));
			}
			Collections.sort(ch); // 충전량이 높은 순으로 돼있다.

			int aX = 1, aY = 1;
			int bX = 10, bY = 10;
			int aS = 0, bS = 0;
			int Sum = 0, result = 0;
			for (int i = -1; i < M; i++) { //초기상태를 챙겨주기 위해서 -1부터 시작 
				Sum = 0; 
				// System.out.println((i+1)+"초 때의 움직임");
				if (i != -1) {
					aX += dr[Integer.parseInt(userA[i])];
					aY += dc[Integer.parseInt(userA[i])];
					bX += dr[Integer.parseInt(userB[i])];
					bY += dc[Integer.parseInt(userB[i])];
				}
				for (int j = 0; j < A; j++) { // 중복순열이라고 생각하자!!
					for (int k = 0; k < A; k++) {

						// System.out.println("a: "+aX+" "+aY);
						// System.out.println("b: "+bX+" "+bY);

						if (Math.abs(aX - ch.get(j).row) + Math.abs(aY - ch.get(j).col) <= ch.get(j).distance) { //안전거리 계산하는거 
						//	 System.out.println((aX - ch.get(j).row) +" "+ (aY - ch.get(j).col));
							aS = ch.get(j).status; //범위 안의 충전기 값 

						} else
							aS = 0;
						// System.out.print(j+1+"번 충전기에 해당하닝? aS: "+aS+" ");
						if (Math.abs(bX - ch.get(k).row) + Math.abs(bY - ch.get(k).col) <= ch.get(k).distance) {
							bS = ch.get(k).status;
						} else
							bS = 0; // 배터리거리를 비교해서 안에 있으면 충전량을 구해준다.
						// System.out.println(k+1+"번 충전기에 해당하닝? bS: "+bS);
						if (j==k) { // 둘이 같은 배터리를 공유하는 경우
							Sum = Math.max(Sum, aS);
							
							 //System.out.println("Sum: " +Sum);
						} else { // 둘이 다른 경우
							Sum = Math.max(Sum, (aS + bS));
							
							
						}
						
						// System.out.println("Sum: " +Sum);
						
						
					}
				}
				// System.out.println("======================================================");
				result += Sum; // 최종 충전량
				//System.out.println("누적sum: " + result);
			}
			sb.append(result).append("\n");
			
	ch.clear();
		} ///////////// 테케를 위한 반복분
	System.out.print(sb);
	}////////// 메인

}
