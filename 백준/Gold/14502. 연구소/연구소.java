import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Queue;
import java.util.StringTokenizer;
import java.util.LinkedList;


public class Main {
	
	static int N;
	static int M;
	static int Map[][];
	
	static int dx[] = {0,0,-1,1};
	static int dy[] = {-1,1,0,0};
	
	
	static int Max_Safe = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		Map = new int[N][M];
		
		//연구소맵을 먼저 넣어둠.
		for(int row = 0; row <N; row++) {
			st = new StringTokenizer(br.readLine());
			for(int col = 0 ; col <M;col++) {
				Map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		
		Run_Test(0);
		System.out.print(Max_Safe);
	}

	private static void Run_Test(int wall_cnt) {
		//벽이 3개일경우 바이러스를 퍼뜨리고 최대 안전구역 갱신
		if(wall_cnt == 3) {
			virus_Run();
			return;
		}
		
		//전체적으로 돌면서 벽을 세워준다.
		for(int row = 0; row <N;row++) {
			for(int col = 0; col <M;col++) {
				if(Map[row][col] == 0) {
					Map[row][col] =1;
					Run_Test(wall_cnt+1);
					Map[row][col] =0;
				}
			}
		}
		
	}

	private static void virus_Run() {
		Queue<int[]> que = new LinkedList<>();
		int new_Map[][] = new int[N][M];
		
		//먼저 바이러스의 위치를 알아둠.
		for(int row = 0; row <N;row++) {
			for(int col = 0;col<M;col++) {
				if(Map[row][col] == 2)
					que.offer(new int[] {row,col});
			}
		}
		
		
		
		//벽을 생성한 맵을 복사
		for(int index=0; index < N;index++)
		{
			new_Map[index] = Map[index].clone();
		}
		//바이러스 퍼뜨리기
		while(!que.isEmpty()) {
			int[] value = que.poll();
			int x = value[0];
			int y = value[1];
			
			for(int index = 0; index <4;index++)
			{
				int nxt_x = x+dx[index];
				int nxt_y = y+dy[index];
				
				if(nxt_x < N && nxt_x >=0 && nxt_y <M && nxt_y >=0 && new_Map[nxt_x][nxt_y] == 0) {
					que.offer(new int[] {nxt_x,nxt_y});
					new_Map[nxt_x][nxt_y] = 2;
				}
			}
			
		}
		
		
		
		check_safe(new_Map);
	}

	private static void check_safe(int[][] new_Map) {
		int count =0;
		for(int row = 0; row <N;row++)
		{
			for(int col = 0; col <M;col++)
			{
				if(new_Map[row][col] == 0) {
					count+=1;
				}
			}
		}
		//최대 안전구역 갱신
		Max_Safe = Math.max(Max_Safe, count);
	}
}
