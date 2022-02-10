package B06_색종이;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("src/B06_색종이/input.txt"));
		StringTokenizer st;
		int N, result, x, y, paper[][];	
		
		N = Integer.parseInt(br.readLine());
		paper =  new int[100][100];
		result = 0;

		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			for(int a=x; a<x+10; a++) {
				for(int b=y; b<y+10; b++) {
					paper[a][b] = 1;
				}
			}
		}
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(paper[i][j] == 1) result++;
			}
		}

		System.out.println(result);

		br.close();
	}
}
