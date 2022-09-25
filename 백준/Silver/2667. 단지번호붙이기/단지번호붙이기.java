import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
	public static int[][] complex;
	public static boolean[][] check;
	public static int count;

	
	public static int[] dx = {0,0,-1,1};
	public static int[] dy = {-1,1,0,0};
	public static int N;
	public static ArrayList<Integer> complex_num;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		complex = new int[N][N];
		check = new boolean[N][N];
		complex_num = new ArrayList<>();
	

		for (int col = 0; col < N; col++) {
			String S = br.readLine();
			for (int row = 0; row < N; row++) {
				complex[col][row] = S.charAt(row) - '0';
			}
		}

		for (int col = 0; col < N; col++) {
			for (int row = 0; row < N; row++) {
				if(complex[col][row] == 1 && !check[col][row]) {
					count =1;
					bfs(col,row);
					complex_num.add(count);
				}
				
			}
		}
		
		
		
		Collections.sort(complex_num);
		
		System.out.println(complex_num.size());
		
		for(int  c : complex_num)
		{
			System.out.println(c);
		}
		
		
	}
	public static void bfs(int x,int y)
	{
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x,y});
		check[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			for(int index = 0 ;index <4;index++)
			{
				int qx = poll[0] + dx[index];
				int qy = poll[1] + dy[index];
				
				if(qx < 0 || qx >= N || qy <0 || qy >= N)
				{
					continue;
				}
				
				if(complex[qx][qy] == 1 && !check[qx][qy])
				{

					q.offer(new int[] {qx,qy});
					check[qx][qy] = true;
					count++;
				}
			}
		}
		
		
		
	}

}
