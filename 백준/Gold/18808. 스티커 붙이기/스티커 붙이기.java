import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	// 스티커들
	static LinkedList<int[][]> Stickers = new LinkedList<>();

	// 전체 노트북칸
	static int[][] Map;
	// 노트북 칸의 수
	static int N;
	static int M;

	// 스티커 개수
	static int K;
	
	//스티커 붙이기 시작점들 체킹
	static int st_row;
	static int st_col;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		Map = new int[N][M];

		for (int index = 0; index < K; index++) {
			st = new StringTokenizer(br.readLine());
			// 각스티커들의 크기
			int rows = Integer.parseInt(st.nextToken());
			int cols = Integer.parseInt(st.nextToken());

			// 각 스티커들의 정보
			int[][] info = new int[rows][cols];
			for (int row = 0; row < rows; row++) {
				st = new StringTokenizer(br.readLine());
				for (int col = 0; col < cols; col++) {
					info[row][col] = Integer.parseInt(st.nextToken());
				}
			}
			Stickers.offer(info);
		}

		while (!Stickers.isEmpty()) {
			int[][] cur_stiker = Stickers.poll();
			
			int cnt = 0;
			// 270도 까지 돌경우
			while (cnt != 360) {
				// 스티커가 들어가는 곳 체크
				int stiker_posible = 0;
				for (int row = 0; row <= N - cur_stiker.length; row++) {
					for (int col = 0; col <= M - cur_stiker[0].length; col++) {
						//스티커가 들어갈 수 있을경우 끝
						stiker_posible = checking(cur_stiker,row,col);
						if(stiker_posible == 1) {
							st_row = row;
							st_col = col;
							break;
						}
					}
					if(stiker_posible == 1)
						break;
				}
				//스티커가 붙일수 있을경우
				if(stiker_posible == 1) {
					for(int row = st_row; row <st_row + cur_stiker.length; row++)
					{
						for(int col = st_col; col <st_col + cur_stiker[0].length; col++)
						{
							if(cur_stiker[row - st_row][col - st_col] ==1)
								Map[row][col] = cur_stiker[row - st_row][col - st_col];
						}
					}
					
					break;
				}
				//붙일수 없는경우 90도 회전
				else
				{
					cur_stiker = turn(cur_stiker);
					cnt += 90;
				}

			}

		}
		
		int Stickers_cnt = cnt_map();

		
		System.out.print(Stickers_cnt);

	}

	private static int cnt_map() {
		int cnt =0;
		for(int row =0; row < N;row++)
		{
			for(int col=0; col <M;col++)
			{
				if(Map[row][col] == 1)
					cnt++;
			}
		}
		
		return cnt;
		
	}

	// 돌리기
	private static int[][] turn(int[][] cur_stiker) {
		int row = cur_stiker.length;
		int col = cur_stiker[0].length;
		
		int copy[][] = new int[col][row];
		for(int i =0 ; i <row;i++)
		{
			for(int j = 0; j <col;j++) {
				copy[j][row - 1 - i] = cur_stiker[i][j];
			}
		}
		
		return copy;
		
	}

	// 스티커 위치
	private static int checking(int[][] cur_stiker, int st_row, int st_col) {
		
		for(int row = st_row; row < st_row+cur_stiker.length;row++)
		{
			for(int col = st_col; col < st_col+cur_stiker[0].length;col++)
			{
				
				//빈칸이 아닐경우 -> 스티커가 붙어있다
				if(Map[row][col] != 0 && cur_stiker[row-st_row][col - st_col] != 0 )
					return 0;
			}
		}
		return 1;
	}

}
