package B05_Ladder1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int result, map[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("src/B05_Ladder1/input.txt"));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N, man, index, start[];
		
		for(int i=1; i<=10; i++) {
			N = Integer.parseInt(br.readLine());
			map = new int[100][100];
			man = 0;
			index = 0;
			result = -1;
			
			for(int x=0; x<100; x++) {
				st = new StringTokenizer(br.readLine());
				for(int y=0; y<100; y++) {
					map[x][y] = Integer.parseInt(st.nextToken());
				}
				if(map[0][x] == 1) man++;
			}
			start = new int[man];
			for(int j=0; j<100; j++) {
				if(map[0][j] == 1) {
					start[index] = j;
					index++;
				}
			}
			for(int j=0; j<start.length; j++) {
				if(result != -1) break;
				searchLadder(start[j]);
			}
			
			System.out.println("#"+N+" "+result);
		}
		
		br.close();
	}
	
	public static void searchLadder(int start) {
		int	y = start;
		for(int x=1; x<100; x++) {
			if(y+1 < 100 && map[x][y+1] == 1) {
				while(true) {
					if(y+1 == 100 || map[x][y+1] == 0) break;
					y++;
				}
			}
			else if(y-1 >= 0 && map[x][y-1] == 1) {
				while(true) {
					if(y-1 < 0 || map[x][y-1] == 0) break;
					y--;
				}
			}
		}
		if(map[99][y] == 2) result = start;
	}
}
