package B08_냉장고;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Material m[];
		String s[];
		int N, result, max;
		N = Integer.parseInt(br.readLine());
		m = new Material[N];
		result = 1;
		
		for(int i=0; i<N; i++) {
			s = br.readLine().split(" ");
			m[i] = new Material(Integer.parseInt(s[0]),Integer.parseInt(s[1]));
		}
		
		Arrays.sort(m);
		
		max = m[0].high;
		for(int i=1; i<N; i++) {
			if(m[i].low <= max) {
				if(m[i].high < max) max = m[i].high;
				continue;
			}
			else {
				max = m[i].high;
				result++;
			}
		}
		
		System.out.println(result);
		br.close();
	}
	
	static class Material implements Comparable<Material>{
		int low, high;

		public Material(int low, int high) {
			super();
			this.low = low;
			this.high = high;
		}

		@Override
		public int compareTo(Material o) {
			return this.high - o.high;
		}
	}
}

