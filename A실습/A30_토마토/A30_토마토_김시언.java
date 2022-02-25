import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class A30_토마토_김시언 {
	static int N, M, day, yet, box[][];
	static int dx[] = {-1, 0, 1, 0};
	static int dy[] = {0, 1, 0, -1};
	static Queue<Tomato> queue;
	
	static class Tomato{
		int x, y;

		public Tomato(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		queue = new LinkedList<Tomato>();
		String s[];
		s = br.readLine().split(" ");
		N = Integer.parseInt(s[1]);
		M = Integer.parseInt(s[0]);
		box = new int[N][M]; //토마토가 담겨진 상자
		day = 0; //하루 지날때 마다 카운팅
		yet = 0; //아직 덜 익은 토마토 갯수
		
		for(int i=0; i<N; i++) {
			s = br.readLine().split(" ");
			for(int j=0; j<M; j++) { 
				box[i][j] = Integer.parseInt(s[j]);
				if(box[i][j] == 1) queue.offer(new Tomato(i,j));
				else if (box[i][j] == 0) yet++;
			}
		}
		
		bfs();
		if(yet > 0) System.out.println("-1"); //덜익은 토마토가 있으면 -1출력
		else System.out.println(day); //BFS후 지난 날 출력
		br.close();
	}

	static void bfs() {
		while (!queue.isEmpty() && yet > 0) {
			for (int q = queue.size(); q > 0; q--) {
				Tomato current = queue.poll();
				for (int i = 0; i < 4; i++) {
					int nextX = current.x + dx[i];
					int nextY = current.y + dy[i];

					if (nextX < N && nextY < M && nextX >= 0 && nextY >= 0 && box[nextX][nextY] == 0) {
						// 다음 좌표가 유효하고 아직 덜 익은 토마토라면 
						yet--;
						box[nextX][nextY] = 1;
						queue.add(new Tomato(nextX, nextY));
					}
				}
			}
			day++;
		}
	}
}
