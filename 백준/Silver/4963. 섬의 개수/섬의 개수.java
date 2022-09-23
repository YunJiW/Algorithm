import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
public class Main {
	
	public static int[][] land;
	public static boolean[][] check;
	
	public static int w;
	public static int h;
	
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(w == 0 && h == 0)
				break;
			
			land = new int[h][w];
			check = new boolean[h][w];
			
			for(int col = 0 ; col < h;col++)
			{
				st = new StringTokenizer(br.readLine()," ");
				for(int row = 0 ; row <w; row++)
				{
					land[col][row] = Integer.parseInt(st.nextToken());
				}
			}
			
			int cnt = 0;
			for(int col = 0; col< h;col++)
			{
				for(int row = 0; row<w;row++)
				{
					if(land[col][row] == 1 && !check[col][row])
					{
						bfs(col,row);
						
						cnt++;
					}
				}
			}
			sb.append(cnt).append('\n');
		}
		System.out.print(sb);
	}


	private static void bfs(int cols, int rows) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {cols,rows});
		check[cols][rows] = true;
		
		int[] dx = {0,0,-1,1,1,1,-1,-1};
		int[] dy = {-1,1,0,0,1,-1,-1,1};
		
		while(!q.isEmpty())
		{
			int[] poll = q.poll();
			
			for(int index = 0;index<8;index++)
			{
				int x = poll[1] + dx[index];
				int y = poll[0] + dy[index];
				
				if(x < 0 || x >= w || y < 0 || y >=h)
				{
					continue;
				}
				
				if(land[y][x] == 1 && !check[y][x])
				{
					q.offer(new int[] {y,x});
					check[y][x] = true;
					
				}
			}
		}
		
	}

}
