import java.util.Scanner;

class B02_파리퇴치_김시언{
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		int[][] zone;
		int T,N,M,sum,temp;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++){
			N = sc.nextInt();
			M = sc.nextInt();
			sum = 0;
			zone = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					zone[i][j] = sc.nextInt();
				}
			}
			
			for(int i=0; i<=N-M; i++) {
				for(int j=0; j<=N-M; j++) { 
					temp = 0;
					for(int x=0; x<M; x++) {
						for(int y=0; y<M; y++) {
							temp = temp + zone[i+x][j+y];
						}
					}
					if(temp > sum) sum = temp;
				}
			}
			System.out.println("#"+test_case+" "+sum);
		}
		sc.close();
	}
}
