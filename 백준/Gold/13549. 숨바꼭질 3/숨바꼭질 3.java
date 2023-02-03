import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.util.Queue;
import java.util.LinkedList;

public class Main {
	static int Min =Integer.MAX_VALUE;
	
	static boolean visited[];
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		visited = new boolean[100001];
		
		Run(start,end,0);
		
		
		System.out.println(Min);
	}

	private static void Run(int start, int end,int cnt) {
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {start,cnt});
		visited[start] = true;
		while(!que.isEmpty()) {
			int value[] = que.poll();
			
			if(value[0] == end) {
				Min = Math.min(Min,value[1]);
			}
			//순간이동 좌표가 최댓값을 넘어가지않을경우
			if(value[0]*2 < 100001) {
				if(!visited[value[0]*2]) {
					que.offer((new int[] {value[0]*2,value[1]}));
					visited[value[0]*2] = true;
				}
			}
			
			//음수는 아니면서 방문하지않았을경우
			if(value[0] -1 >= 0 && !visited[value[0]-1]) {
				que.offer(new int[] {value[0]-1,value[1]+1});
				visited[value[0] -1] = true;
			}
			
			//최대값을 넘지 않으면 방문하지않았을경우
			if(value[0] +1 < 100001 && !visited[value[0]+1]) {
				que.offer(new int[] {value[0]+1,value[1]+1});
				visited[value[0]+1] = true;
			}
			
			
			
		}
		
	}

}
