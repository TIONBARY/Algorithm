package B;
/* 정글 1828*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

//가독성을 위해 논리상 안맞지만 최저온도를 start, 최고온도를 end로 두었습니다. 

public class B08_냉장고_허설 {
	static class Chemical implements Comparable <Chemical> {
		int start, end;

		public Chemical(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Chemical o) {
			
			return this.end!=o.end? this.end-o.end:this.start-o.start; //최고온도가 같다면 최저온도 오름차순으로 
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		ArrayList<Chemical> result = new ArrayList<>();
		int N = Integer.parseInt(br.readLine()); //화학물질의 수 
		Chemical [] chem = new Chemical[N];
		for(int i=0;i<N;i++) {
		st= new StringTokenizer(br.readLine()," "); //매번 new를 반복문에 넣는 나.. 어떻게 해결할 수 있을까?
		chem[i] = new Chemical(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(chem); //최고온도기준으로 돼있으며, 같을 경우 최저온도 오름차순 
		int min=10001; //조건에서 10000도까지여서 10001로 초기화
		result.add(chem[0]);//일단 첫번째걸 선택하셈 
		min = chem[0].end; //첫번째 선택한 화학물질의 최고온도를 기준으로 애매하게 걸쳐있는 반례들을 골라내기 위한 min


		 for(int i =1,size = chem.length;i<size;i++) { //사이즈로해놓는건 변해서 그런건가? 이렇게 한 이유가 뭘까?
			 if(result.get(result.size()-1).end<chem[i].start || min<chem[i].start ) {
				 result.add(chem[i]); //안겹치는 경우에 넣어야 냉장고 개수가 늘어나는 거임
				 min = chem[i].end; //애매하게 중간에 걸쳐진 물질의 최고온도로 갱신해준다. 
			 }
			 
		 }////////////////비교끝
		 StringBuilder sb = new StringBuilder();
		 sb.append(result.size());
		 System.out.println(sb.toString());
	}

}
