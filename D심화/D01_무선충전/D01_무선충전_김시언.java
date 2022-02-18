import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D01_무선충전_김시언 {
	static Man a,b;
	static BC bc[];
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[], ss[];
		int T, M, A, sum, max, batteryA, batteryB, moveA[], moveB[];
		T = Integer.parseInt(br.readLine());

		for(int i=1; i<=T; i++) {
			result = 0;
			a = new Man(0,0); //문제에서 10X10배열에서 첫 인덱스가 1인데 코드에선 0부터 시작
			b = new Man(9,9);
			s = br.readLine().split(" ");
			M = Integer.parseInt(s[0]);
			A = Integer.parseInt(s[1]);

			//a와 b의 이동순서 초기화
			moveA = new int[M+1]; //첫 시작부터 배터리충전 계산하기 위해 index 0~20을 모두 사용하기 위해 M+1
			moveB = new int[M+1];
			s = br.readLine().split(" ");
			ss = br.readLine().split(" ");
			for(int j=0; j<M; j++) {
				moveA[j+1] = Integer.parseInt(s[j]); //String배열이므로 각자 moveA[0]과 moveB[0]은 0으로 초기화
				moveB[j+1] = Integer.parseInt(ss[j]);
			}

			//배터리 초기화
			bc = new BC[A]; 
			for(int j=0; j<A; j++) {
				s = br.readLine().split(" ");
				bc[j] = new BC(Integer.parseInt(s[1])-1,Integer.parseInt(s[0])-1,Integer.parseInt(s[2]),Integer.parseInt(s[3]));
			} //문제에서와 코드에서 X좌표, Y좌표가 반대로 되어있음

			for(int j=0; j<=M; j++) { //두명 이동시작
				a.Move(moveA[j]); //j==0일때 moveA,moveB 둘다 0으로 초기화 되어있으므로 시작위치에서 부터 배터리충전 계산
				b.Move(moveB[j]);
				max = 0;
				
				for(int n=0; n<A; n++) {
					for(int m=0; m<A; m++) {
						sum = 0;
						batteryA = a.getCharge(bc[n]); //두 사람이 이동할 떄 마다 배터리 2개를 반복돌려 각각의 충전량을 구함
						batteryB = b.getCharge(bc[m]);
						
						if(n != m) sum = batteryA + batteryB; //배터리가 다른 경우에는 두 배터리 충전량을 합
						else sum = Math.max(batteryA, batteryB); //배터리가 같을 경우에는 두 배터리 중 큰 값을 반으로 나누어 서로 더하므로 그냥 큰값을 넣어줌
						
						max = Math.max(sum, max);  //두 배터리 합과 max값중 큰 값을 저장
					}
				}
				result += max; //큰 값을 결과에 누적합
			}
			System.out.println("#"+i+" "+result);
		}
		br.close();
	}

	static class BC{
		int x, y, C, P;

		public BC(int x, int y, int c, int p) {
			super();
			this.x = x;
			this.y = y;
			C = c;
			P = p;
		}
	}

	static class Man{
		int x, y;

		public Man(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		public void Move(int m) {
			switch (m) {
			case 0:
				break;
			case 1:
				this.x -= 1;
				break;
			case 2:
				this.y += 1;
				break;
			case 3:
				this.x += 1;
				break;
			case 4:
				this.y -= 1;
				break;
			}
		}

		public int getCharge(BC bc) { //현재 사람과 매개변수로 넘어 온 배터리간의 거리를 계산하여 배터리영역 내에 존재하면 충전량 반환
			return Math.abs(x - bc.x) + Math.abs(y - bc.y) <= bc.C ? bc.P : 0;
		}

		@Override
		public String toString() {
			return "["+x+","+y+"]";
		}
	}
}
