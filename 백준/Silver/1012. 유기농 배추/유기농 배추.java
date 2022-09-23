import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static int[][] ground;
	public static boolean[][] check;
	public static int col;
	public static int row;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			col= Integer.parseInt(st.nextToken());
			row = Integer.parseInt(st.nextToken());
			ground = new int[col][row];
			check = new boolean[col][row];
			int num = Integer.parseInt(st.nextToken());
			
			while(num --> 0)
			{
				st = new StringTokenizer(br.readLine()," ");
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				
				ground[start][end] = 1;
			}
			int cnt = 0;
			
			for(int cols = 0; cols < col;cols++)
			{
				for(int rows = 0 ; rows < row; rows++)
				{
					if(ground[cols][rows] == 1 && !check[cols][rows])
					{
						bfs(cols,rows);
						
						cnt++;
					}
				}
			}
			sb.append(cnt).append('\n');

		}
		System.out.print(sb);

	}
	public static void bfs(int cols,int rows) {
		Queue<int[]> q= new LinkedList<>();
		q.offer(new int[] {cols,rows});
		
		check[cols][rows] = true;
		
		int[] dx = {0,0,-1,1};
		int[] dy = {-1,1,0,0};
		
		while(!q.isEmpty())
		{
			int[] poll = q.poll();
			
			for(int index =0 ; index < 4;index++)
			{
				int x = poll[0] + dx[index];
				int y = poll[1] + dy[index];
				
				if(x <0 || x >= col || y < 0 || y >= row)
				{
					continue;
				}
				
				if(ground[x][y] == 1 & !check[x][y]) {
					q.offer(new int[] {x,y});
					check[x][y] = true;
				}
			}
		}
	}
	
}
