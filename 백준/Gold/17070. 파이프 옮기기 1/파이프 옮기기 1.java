import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;

import java.util.StringTokenizer;

public class Main {

	static class Pipe {
		int x;
		int y;

		public Pipe(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	static int[][] Map;
	static Pipe pipe = new Pipe(1, 2);
	static int N;

	// 우 하 우대각
	static int[] dx = { 0, 1, 1 };
	static int[] dy = { 1, 0, 1 };

	static boolean[][] visit;

	// 파이프 이동 방법 수
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		// 파이프가 1,1 1,2 시작이기때문에 늘려줌
		Map = new int[N + 1][N + 1];
		visit = new boolean[N + 1][N + 1];

		for (int col = 1; col <= N; col++) {
			st = new StringTokenizer(br.readLine());
			for (int row = 1; row <= N; row++) {
				Map[col][row] = Integer.parseInt(st.nextToken());
			}
		}
		Starting(pipe.x, pipe.y, 1);

		System.out.print(cnt);
	}

	private static void Starting(int pipe_x, int pipe_y, int dir) {
		if (pipe_x == N && pipe_y == N) {
			cnt++;
			return;
		}
		if (pipe_x > N || pipe_y > N)
			return;

		// 우 우대각
		if (dir == 1) {
			if(pipe_x+dx[0] <= N && pipe_y+dy[0] <= N && Map[pipe_x+dx[0]][pipe_y+dy[0]] != 1)
			{
				Starting(pipe_x + dx[0],pipe_y + dy[0], 1);
			}
			//우 대각 -> 우 하 우대각에 위치가 다 0이여야함.
			if(checking(pipe_x,pipe_y))
			{
				Starting(pipe_x + dx[2],pipe_y + dy[2] ,3);
			}
		}
		// 하 우대각
		else if (dir == 2) {
			if(pipe_x+dx[1] <= N && pipe_y+dy[1] <= N && Map[pipe_x +dx[1]][pipe_y+dy[1]] != 1)
			{
				Starting(pipe_x + dx[1],pipe_y +dy[1],2);
			}
			
			if(checking(pipe_x,pipe_y))
			{
				Starting(pipe_x + dx[2],pipe_y + dy[2] ,3);
			}

		}
		// 우 하 우대각
		else if (dir == 3) {
			if(pipe_x+dx[0] <= N && pipe_y+dy[0] <= N && Map[pipe_x+dx[0]][pipe_y+dy[0]] != 1)
			{
				Starting(pipe_x + dx[0],pipe_y + dy[0], 1);
			}
			
			if(pipe_x+dx[1] <= N && pipe_y+dy[1] <= N && Map[pipe_x +dx[1]][pipe_y+dy[1]] != 1)
			{
				Starting(pipe_x + dx[1],pipe_y +dy[1],2);
			}
			
			if(checking(pipe_x,pipe_y))
			{
				Starting(pipe_x + dx[2],pipe_y + dy[2] ,3);
			}
		}
	}

	private static boolean checking(int pipe_x,int pipe_y) {
		for(int index =0 ;index <3; index++)
		{
			if(pipe_x + dx[index] <= N && pipe_y +dy[index] <= N && Map[pipe_x + dx[index]][pipe_y + dy[index]] == 1)
				return false;
		}
		return true;
	}

}

//if (Map[pipe_x + dx[index]][pipe_y + dy[index]] != 1 && pipe_x+dx[index] <= N && pipe_y+dy[index] <= N)