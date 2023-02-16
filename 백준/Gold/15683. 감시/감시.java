import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static class cctv {
		int row;
		int col;
		int cctv_number;

		cctv(int row, int col, int cctv_number) {
			this.row = row;
			this.col = col;
			this.cctv_number = cctv_number;
		}
	}

	static int Map[][];
	static int copyMap[][];
	static int Min = Integer.MAX_VALUE;

	static int N;
	static int M;

	//cctv개수 체크
	static int cctv_cnt = 0;
	//최대 8개이므로 8개가 들어갈수있게 해둠.
	static cctv cctv_check[] = new cctv[8];
	//각 cctv의 방향 체크
	static int cctv_direction[]; 
	
	//상 우 하 좌
	static int dx[] = {-1,0,1,0};
	static int dy[] = {0,1,0,-1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		Map = new int[N][M];
		for (int row = 0; row < N; row++) {
			st = new StringTokenizer(br.readLine());
			for (int col = 0; col < M; col++) {
				int number = Integer.parseInt(st.nextToken());
				// 0도 아니고 6도 아닐경우 -> CCTV다.
				if (number != 0 && number != 6) {
					//CCTV 체크용
					cctv_check[cctv_cnt++] = new cctv(row, col, number);
					Map[row][col] = number;
					continue;
				}
				Map[row][col] = number;
			}
		}
		cctv_direction = new int[cctv_cnt];
		Run(0);
		
		System.out.println(Min);
	}

	private static void Run(int depth) {
		if(depth == cctv_cnt) {
			//복사
			copyMap = new int[N][M];
			
			for(int row = 0; row <N;row++)
			{
				for(int col = 0; col<M;col++)
				{
					copyMap[row][col] = Map[row][col];
				}
			}
			for(int idx =0; idx <cctv_cnt;idx++) {
				direct(cctv_check[idx],cctv_direction[idx]);
			}
			Check_room();
			
			return;
		}
		
		//방향에 대해서 순열
		for(int index = 0; index <4;index++) {
			cctv_direction[depth] = index;
			Run(depth+1);
		}
		
	}
	//감지 안되는 지역 찾기
	private static void Check_room() {
		int cnt = 0;
		for(int row = 0; row< N;row++) {
			for(int col =0; col <M;col++) {
				if(copyMap[row][col] == 0) {
					cnt+=1;
				}
			}
		}
		Min = Math.min(Min, cnt);
	}

	private static void direct(cctv cctvs, int dir) {
		//CCTV의 번호
		int cctv_num = cctvs.cctv_number;
		if(cctv_num ==1) {
			switch(dir) {
			case 0:
				watch_check(cctvs,0);
				break;
			case 1:
				watch_check(cctvs,1);
				break;
			case 2:
				watch_check(cctvs,2);
				break;
			case 3:
				watch_check(cctvs,3);
				break;
			}
		}
		else if(cctv_num ==2) {
			//좌 우
			if(dir == 0 || dir == 2) {
				watch_check(cctvs,0);
				watch_check(cctvs,2);
			//상 하
			}else {
				watch_check(cctvs,1);
				watch_check(cctvs,3);
			}
		}else if(cctv_num ==3) {
			//상 우
			if(dir == 0) {
				watch_check(cctvs,0);
				watch_check(cctvs,1);
			//우 하
			}else if(dir==1) {
				watch_check(cctvs,1);
				watch_check(cctvs,2);
			//하 좌
			}else if(dir ==2) {
				watch_check(cctvs,2);
				watch_check(cctvs,3);
			//좌 상
			}else if(dir ==3) {
				watch_check(cctvs,3);
				watch_check(cctvs,0);
			}
		}else if(cctv_num ==4) {
			//좌 상 하 
			if(dir ==0) {
				watch_check(cctvs,0);
				watch_check(cctvs,1);
				watch_check(cctvs,3);
			}else if(dir ==1) {
				watch_check(cctvs,0);
				watch_check(cctvs,1);
				watch_check(cctvs,2);
			}else if(dir ==2) {
				watch_check(cctvs,1);
				watch_check(cctvs,2);
				watch_check(cctvs,3);
			}else if(dir ==3) {
				watch_check(cctvs,2);
				watch_check(cctvs,3);
				watch_check(cctvs,0);
			}
			
			
		}else if(cctv_num ==5) {
			watch_check(cctvs,0);
			watch_check(cctvs,1);
			watch_check(cctvs,2);
			watch_check(cctvs,3);
		}
	}

	private static void watch_check(cctv cctvs, int dir) {
		Queue<int[]> que = new LinkedList<>();
		que.offer(new int[] {cctvs.row,cctvs.col});
		
		while(!que.isEmpty()) {
			int[] cur= que.poll();
			
			int nxt_row= cur[0]+dx[dir];
			int nxt_col= cur[1]+dy[dir];
			
			//맵밖을 벗어나거나 
			if(nxt_row < 0 || nxt_row >= N || nxt_col < 0 || nxt_col >=M || copyMap[nxt_row][nxt_col] == 6) {
				continue;
			}
			
			//벽이 아닌 CCTV를 만나거나 이미 지나간 경우
			if(copyMap[nxt_row][nxt_col] != 0) {
				que.offer(new int[] {nxt_row,nxt_col});
				continue;
			}
			copyMap[nxt_row][nxt_col] = -1;
			que.offer(new int[] {nxt_row,nxt_col});
			
			
		}
	}


}
