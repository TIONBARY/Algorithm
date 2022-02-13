package C01_콘테스트;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("src/C01_콘테스트/input.txt"));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int W, K, pointsW[], pointsK[];
		pointsW = new int[10];
		pointsK = new int[10];
		
		for(int i=0; i<10; i++) {
			pointsW[i] = Integer.parseInt(br.readLine());
		}
		for(int i=0; i<10; i++) {
			pointsK[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(pointsW);
		Arrays.sort(pointsK);
		
		W = pointsW[9] + pointsW[8] + pointsW[7];
		K = pointsK[9] + pointsK[8] + pointsK[7];
		
		System.out.println(W+" "+K);
		br.close();
	}
}
