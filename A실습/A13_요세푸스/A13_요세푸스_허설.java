package algol_1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class A13_요세푸스_허설 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> list = new ArrayList<>();
		Queue<Integer> queue = new LinkedList<>();
		int N = sc.nextInt();
		int K = sc.nextInt();
		int tmp, count = 0;
		int dir = -1;
		for (int i = 1; i <= N; i++) {
			list.add(i);
		}
		
		while (!list.isEmpty()) {
			for(int i =0;i<K;i++) {
				dir++;
				if(dir==list.size())
					dir=0; //인덱스 넘어가는거 방지 
			}
			//세번 움직인 인덱스 값이 나옴 
			tmp = list.get(dir);
			queue.offer(tmp);
			list.remove(dir);
			dir--;
			count++;
			}
		sb.append("<");
		while(!queue.isEmpty()) {
			if(queue.size()==1) {
				sb.append(queue.poll()+">");
				break;}
		sb.append(queue.poll()+", ");
		}
		System.out.print(sb);
		sb = new StringBuilder();
		sc.close();
}/////////////////////////////////////////// main

}
