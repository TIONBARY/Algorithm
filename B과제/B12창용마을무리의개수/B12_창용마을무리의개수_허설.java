import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
 
 
class Solution
{
        static int N;  //왜 여기에 선언해두는게 메모리가 덜 잡아먹는지 모르겠다 
    static int[] parents;
    static boolean[] check;
     
    static public void makeSet(int size) {
        parents = new int[size+1];
        // 자신의 부모노드를 자신의 값으로 세틴
        for (int i = 1; i < size+1; i++) {
            parents[i] = i;
        }
    }
     
    //a의 집합 찾기 :a의대표자 찾기
        public static int findSet(int a) {
            if (a == parents[a])
                return a;
            return parents[a] = findSet(parents[a]); // path compression
        }
 
         
    //a,b 합치기
        public static boolean union(int a, int b) {
 
            int aRoot = findSet(a);
            int bRoot = findSet(b);
            if (aRoot == bRoot)
                return false;
 
            parents[bRoot] = aRoot;
            return true;
        }
 
    public static void main(String args[]) throws Exception
    {
            BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        sb= new StringBuilder();
        String str[],str2[];
         
        int T  = Integer.parseInt(br.readLine());
        for(int tc = 1;tc<=T;tc++) {
            sb.append("#").append(tc).append(" ");
            str  =br.readLine().split(" ");
            int N = Integer.parseInt(str[0]); //마을 사람들 수
            int size = N;
            check = new boolean[N+1];
            int M = Integer.parseInt(str[1]); //관계의 개수  
            makeSet(size);
             for (int i = 1; i <=M; i++) {
                str2 = br.readLine().split(" ");
                int from = Integer.parseInt(str2[0]);
                int to = Integer.parseInt(str2[1]);
                union(from,to);
                 
            }
             
                    for(int i =N;i>=1;i--) { // 누구를 가리키고 있는지 정리를 해줘야 정확하게 무리를 셀 수 있음 
            findSet(i);
        }
             
             int cnt =0;
 
             for(int i =1;i<=N;i++) {
                 check[parents[i]]=true;
            if(check[i])cnt++;
             }
             sb.append(cnt).append("\n");
             
              
 
              
              
             
        }//////////////테케문
         System.out.print(sb); 
 
    }///////////메인
 
}
