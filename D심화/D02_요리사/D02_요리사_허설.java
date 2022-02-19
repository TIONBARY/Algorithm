package D;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class D02_요리사_허설 {
    static int receipe[][], input[], numbers[], rest[], size, mini, sum,result;
    static boolean check[];
 
    public static void main(String args[]) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       // BufferedReader br = new BufferedReader(new FileReader("src\\D\\input1.txt"));
        StringBuilder sb = new StringBuilder();
 
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
            int N = Integer.parseInt(br.readLine()); // 식재료 개수
            size = N;
            receipe = new int[N][N];
            check = new boolean[N + 1];
            result =50000;
            String[] str;
            for (int i = 0; i < N; i++) {
                str = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    receipe[i][j] = Integer.parseInt(str[j]);
                }
 
            }
            input = new int[size];
            numbers = new int[size / 2];
            rest = new int[size / 2];
            for (int i = 0; i < size; i++) {
                input[i] = i;
            }
            Combi(0, 0);
 
 
            sb.append(result).append("\n");
        } ////////////////////////////// 테케문
        System.out.print(sb);
    }/////////////////////// 메인
 
    public static void Combi(int cnt, int start) {
        int k = 0;
        if (cnt == size / 2) {
            for (int j = 0; j < size; j++) { //선택받은 애들의 나머지 조합의 순열 합을 구하기 위해서 체크를 만듦 
                if (check[j] == false) {
                    rest[k] = j;
                    k++;
                }
            }
 
            mini = makingSum(numbers) - makingSum(rest); // N/2개를 고른 조합들 사이에서 2개씩 순열로 합을구한 값의 차 
            result = Math.min(result, Math.abs(mini));
            return;
        }
 
        for (int i = start; i < size; i++) {
            numbers[cnt] = input[i];
            check[input[i]] = true; // 수를 체크해서 안고른 수들을 배열에 넣기 위해 
            Combi(cnt + 1, i + 1);
            check[input[i]] = false;
        }
    }
 
    public static int makingSum(int[] numbers) {
        int n1, n2;
        sum = 0;
        for (int i = 0; i < size / 2; i++) {
            n1 = numbers[i];
            for (int j = 0; j < size / 2; j++) {
                if (j != i) {
                    n2 = numbers[j];
                    sum += receipe[n1][n2]; // 순열을 만들어서 그에 해당하는 값을 행렬에서 찾는다 넣는다 더한다. 
                }
            }
        }
        return sum;
    }
 
}////////////// 끝
