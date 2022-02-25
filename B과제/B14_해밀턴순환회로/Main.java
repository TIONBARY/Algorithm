package B14_헤밀턴순환회로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean visited[];
    static int result, sum, N, map[][];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[];
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        
        for(int x=0; x<N; x++) {
            s = br.readLine().split(" ");
            for(int y=0; y<N; y++) {
                map[x][y]=Integer.parseInt(s[y]);
            }
        }
        
        result = Integer.MAX_VALUE;
        for(int j=1; j<N; j++) { 
            visited = new boolean[N];
            sum = 0;
            if(map[0][j]!=0) {
                dfs(0,j,1);
            }
        }
        
        System.out.println(result);
        br.close();
    }
    public static void dfs(int x, int y, int cnt) {
        if(sum>result) {
            return;
        }
        
        sum += map[x][y];  
        visited[x] = true; 
        if(cnt==(N-1)) {
            sum += map[y][0];   
            if(map[y][0]==0) {  
                return;
            }
            result = Math.min(result, sum);
            sum -= map[y][0];  
            return;
        }
        
        for(int i=0; i<N; i++) {
            if(!visited[i] && map[y][i]!=0 &&(sum<result)) {  
                dfs(y,i,cnt+1);
                sum -= map[y][i]; 
                visited[i] = false; 
            }
        }
    }
}