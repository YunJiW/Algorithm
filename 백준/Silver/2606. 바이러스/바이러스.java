
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[][] arr;
	static boolean[] check;
	
	static int com;
	static int couple;
	static int cnt = 0;
	
	static Queue<Integer> q = new LinkedList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//컴퓨터수
		com = Integer.parseInt(br.readLine());
		//컴퓨터 쌍
		couple = Integer.parseInt(br.readLine());
		
		arr = new int[com+1][com+1];
		check = new boolean[com+1];
		
		for(int index = 0 ; index < couple; index++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int G = Integer.parseInt(st.nextToken());
			
			arr[V][G] = arr[G][V] = 1;
		}
		bfs(1);
		System.out.println(cnt);
	}
	
	public static void bfs(int start) {
		q.offer(start);
		check[start] = true;
		
		
		while(!q.isEmpty())
		{
			start = q.poll();
			
			
			for(int index = 1 ; index <= com; index++) {
				if(arr[start][index] ==1 && !check[index])
				{
					q.offer(index);
					check[index] = true;
					cnt++;
				}
			}
		}
		
	}
}
