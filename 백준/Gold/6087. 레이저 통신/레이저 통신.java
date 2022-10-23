import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

	// 레이저 위치
	static class razer {
		int r_col;
		int r_row;

		public razer(int r_col, int r_row) {
			this.r_col = r_col;
			this.r_row = r_row;
		}
	}

	static char[][] Map;
	// 벽 개수 체크
	static int[][] Stack;

	static boolean[][] visited;

	// 북 동 남 서
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static razer[] Razer;
	// 지도 W H
	static int W;
	static int H;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		Map = new char[H][W];
		Stack = new int[H][W];
		visited = new boolean[H][W];

		Razer = new razer[2];
		int checking = 0;
		for (int col = H - 1; col >= 0; col--) {
			String S = br.readLine();
			for (int row = 0; row < W; row++) {
				Map[col][row] = S.charAt(row);
				// C 위치 파악
				if (Map[col][row] == 'C')
					Razer[checking++] = new razer(col, row);
			}
		}
		// 거울 최소 개수 찾기 시작
		Start(Razer[1].r_col, Razer[1].r_row);
		
		System.out.println(Stack[Razer[0].r_col][Razer[0].r_row]);
	
	}

	private static void Start(int r_col, int r_row) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { r_col, r_row});
		visited[r_col][r_row] = true;

		int min = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			//좌표를 꺼내서 받아둠
			int[] val = q.poll();
			
			
			
			//C 시작시 4방향 체크
			if (Razer[1].r_col == val[0] && Razer[1].r_row == val[1]) {
				for(int index =0 ;index <4 ;index++)
				{
					int d_c = val[0] + dx[index];
					int d_r = val[1] + dy[index];
					
					//범위를 벗어나거나 벽일 경우 pass
					if(d_c < 0 || d_c >= H || d_r < 0 || d_r >= W || Map[d_c][d_r] == '*')
						continue;
					
					//체크하고 queue에 넣어줌
					visited[d_c][d_r] = true;
					q.offer(new int[] {d_c,d_r,index});
				
				}
				continue;
			}
			int Height = val[0];
			int Width = val[1];
			int dir = val[2];
			//방향에 따라서 체크
			//dir = 0 -> 북 0 3 1
			
			if(dir == 0) {
				if(Height + dx[0] < H && Map[Height +dx[0]][Width] != '*')
				{
					//방문 안했을경우
					if(!visited[Height +dx[0]][Width])
					{
						visited[Height +dx[0]][Width] = true;
						Stack[Height +dx[0]][Width] = Stack[Height][Width];
						q.offer(new int[] {Height+dx[0],Width,0});
					}
					else if(visited[Height +dx[0]][Width] && Stack[Height +dx[0]][Width] >= Stack[Height][Width]) {
							Stack[Height+dx[0]][Width] = Stack[Height][Width];
							q.offer(new int[] {Height+dx[0],Width,0});
							
					}
				}
				if(Width + dy[3] >= 0 && Map[Height][Width+ dy[3]] != '*')
				{
					//방문 안했을경우
					if(!visited[Height][Width+ dy[3]])
					{
						visited[Height][Width+ dy[3]] = true;
						Stack[Height][Width+ dy[3]] = Stack[Height][Width]+1;
						q.offer(new int[] {Height,Width+dy[3],3});
					}
					else if(visited[Height][Width +dy[3]] && Stack[Height][Width+ dy[3]] >= Stack[Height][Width] + 1 ){
							Stack[Height][Width+ dy[3]] = Stack[Height][Width] + 1 ;
							q.offer(new int[] {Height,Width+dy[3],3});
						}
					}
				
				
				if(Width + dy[1] < W && Map[Height][Width +dy[1]] != '*')
				{
					//방문 안했을경우
					if(!visited[Height][Width+ dy[1]])
					{
						visited[Height][Width+ dy[1]] = true;
						Stack[Height][Width+ dy[1]] = Stack[Height][Width]+1;
						q.offer(new int[] {Height,Width+dy[1],1});
					}
					else if(visited[Height][Width+ dy[1]] && Stack[Height][Width+ dy[1]] >= Stack[Height][Width] + 1){
							Stack[Height][Width+ dy[1]] = Stack[Height][Width] + 1 ;
							q.offer(new int[] {Height,Width+dy[1],1});
						}
					}
				
				}
		
			//dir = 1 -> 동 1 0 2
 
			else if(dir == 1)
			{
				//동
				if(Width + dy[1] < W && Map[Height][Width+dy[1]] != '*')
				{
					if(!visited[Height][Width+dy[1]])
					{
						visited[Height][Width+dy[1]] =true;
						Stack[Height][Width +dy[1]] = Stack[Height][Width];
						q.offer(new int[] {Height,Width +dy[1],1});
					}
					else if(visited[Height][Width+dy[1]] && Stack[Height][Width +dy[1]] >= Stack[Height][Width]){
						{
							Stack[Height][Width +dy[1]] = Stack[Height][Width];
							q.offer(new int[] {Height,Width + dy[1], 1});
						}
						
					}
				}
				//위
				if(Height + dx[0] < H && Map[Height+dx[0]][Width] != '*')
				{
					//방문 안했을경우
					if(!visited[Height +dx[0]][Width])
					{
						visited[Height +dx[0]][Width] = true;
						Stack[Height +dx[0]][Width] = Stack[Height][Width]+1;
						q.offer(new int[] {Height+dx[0],Width,0});
					}
					else if(visited[Height +dx[0]][Width] && Stack[Height +dx[0]][Width] >= Stack[Height][Width]+1) {
							Stack[Height+dx[0]][Width] = Stack[Height][Width] +1;
							q.offer(new int[] {Height+dx[0],Width,0});
						}
					
				}
				//아래
				if(Height +dx[2] >= 0 && Map[Height +dx[2]][Width] != '*')
				{
					//방문 안했을경우
					if(!visited[Height +dx[2]][Width])
					{
						visited[Height +dx[2]][Width] = true;
						Stack[Height +dx[2]][Width] = Stack[Height][Width]+1;
						q.offer(new int[] {Height+dx[2],Width,2});
					}
					else if(visited[Height +dx[2]][Width] && Stack[Height +dx[2]][Width] >= Stack[Height][Width]+1){
							Stack[Height+dx[2]][Width] = Stack[Height][Width] +1;
							q.offer(new int[] {Height+dx[2],Width,2});
						}
				}
			}
			//dir = 2 -> 남 2 1 3
			else if(dir == 2)
			{
				
				
				//남
				if(Height +dx[2] >= 0 && Map[Height +dx[2]][Width] != '*')
				{
					//방문 안했을경우
					if(!visited[Height +dx[2]][Width])
					{
						visited[Height +dx[2]][Width] = true; 
						Stack[Height +dx[2]][Width] = Stack[Height][Width];
						q.offer(new int[] {Height+dx[2],Width,2});
					}
					else if(visited[Height +dx[2]][Width] && Stack[Height +dx[2]][Width] >= Stack[Height][Width] ) {
							Stack[Height+dx[2]][Width] = Stack[Height][Width];
							q.offer(new int[] {Height+dx[2],Width,2});
						}
				}
				//우
				if(Width + dy[1] < W && Map[Height][Width+dy[1]] != '*')
				{
					if(!visited[Height][Width+dy[1]])
					{
						visited[Height][Width+dy[1]] = true;
						Stack[Height][Width +dy[1]] = Stack[Height][Width]+1;
						q.offer(new int[] {Height,Width +dy[1],1});
					}
					else if(visited[Height][Width+dy[1]] &&  Stack[Height][Width +dy[1]] >= Stack[Height][Width]+1) {
						{
							Stack[Height][Width +dy[1]] = Stack[Height][Width]+1;
							q.offer(new int[] {Height,Width + dy[1], 1});
						}
						
					}
				}
				
				//좌
				if(Width + dy[3] >= 0 && Map[Height][Width+ dy[3]] != '*')
				{
					//방문 안했을경우
					if(!visited[Height][Width+ dy[3]])
					{
						visited[Height][Width+ dy[3]] = true;
						Stack[Height][Width+ dy[3]] = Stack[Height][Width]+1;
						q.offer(new int[] {Height,Width+dy[3],3});
					}
					else if(visited[Height][Width+ dy[3]] && Stack[Height][Width+ dy[3]] >= Stack[Height][Width] + 1){
							Stack[Height][Width+ dy[3]] = Stack[Height][Width] + 1 ;
							q.offer(new int[] {Height,Width+dy[3],3});
						}
				}
				
			}
			//dir = 3 -> 서 3 2 0
			else 
			{
				
				//직진
				if(Width + dy[3] >= 0 && Map[Height][Width+ dy[3]] != '*')
				{
					//방문 안했을경우
					if(!visited[Height][Width+ dy[3]])
					{
						visited[Height][Width+ dy[3]] = true;
						Stack[Height][Width+ dy[3]] = Stack[Height][Width];
						q.offer(new int[] {Height,Width+dy[3],3});
					}
					else if(visited[Height][Width+ dy[3]] &&  Stack[Height][Width+ dy[3]] >= Stack[Height][Width]) {
							Stack[Height][Width+ dy[3]] = Stack[Height][Width];
							
							
							q.offer(new int[] {Height,Width+dy[3],3});
						}
				}
				//아래
				if(Height +dx[2] >= 0 && Map[Height +dx[2]][Width] != '*')
				{
					//방문 안했을경우
					if(!visited[Height +dx[2]][Width])
					{
						visited[Height +dx[2]][Width] = true;
						Stack[Height +dx[2]][Width] = Stack[Height][Width]+1;
						q.offer(new int[] {Height+dx[2],Width,2});
					}
					else if(visited[Height +dx[2]][Width] && Stack[Height +dx[2]][Width] >= Stack[Height][Width]+1){
							Stack[Height+dx[2]][Width] = Stack[Height][Width]+1;
							q.offer(new int[] {Height+dx[2],Width,2});
						}
				}
				
				//위
				if(Height + dx[0] < H && Map[Height+dx[0]][Width] != '*')
				{
					//방문 안했을경우
					if(!visited[Height +dx[0]][Width]) 
					{
						visited[Height +dx[0]][Width] =true;
						Stack[Height +dx[0]][Width] = Stack[Height][Width]+1;
						q.offer(new int[] {Height+dx[0],Width,0});
					}
					else if(visited[Height +dx[0]][Width] && Stack[Height +dx[0]][Width] >= Stack[Height][Width]+1) {
							Stack[Height +dx[0]][Width] = Stack[Height][Width]+1;
							q.offer(new int[] {Height+dx[0],Width,0});
						}
				}
			}
		}

	}

}
