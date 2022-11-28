import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };
	static boolean check[][];
	static int Map[][];
	static int M;
	static int N;
	static int K;
	
	static ArrayList<Integer> part;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		
		part = new ArrayList<>();
		check = new boolean[M][N];
		Map = new int[M][N];
		
		StringBuilder sb = new StringBuilder();
		// K좌표를 통해서 직사각형를 만들어준다.
		for (int index = 0; index < K; index++) {
			st = new StringTokenizer(br.readLine());
			int left_x = Integer.parseInt(st.nextToken());
			int left_y = Integer.parseInt(st.nextToken());

			int right_x = Integer.parseInt(st.nextToken());
			int right_y = Integer.parseInt(st.nextToken());

			square_make(left_x, left_y, right_x, right_y);
		}
		
		for(int row = 0; row < M; row++)
		{
			for(int col =0; col <N; col++)
			{
				if(!check[row][col])
				{
					check_sqaure(row,col);
				}
			}
		}
		
		Collections.sort(part);
		
		sb.append(part.size()).append("\n");
		for(int nums : part)
		{
			sb.append(nums).append(" ");
		}
		System.out.println(sb);
	}

	private static void square_make(int left_x, int left_y, int right_x, int right_y) {
		
		for(int row = left_y; row < right_y; row++) {
			for(int col=left_x ; col < right_x ;col++) {
				check[row][col] = true;
			}
		}
		
	}

	// 영역 체크 탐색
	public static void check_sqaure(int row, int col) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {row,col});
		
		int cnt = 1;
		check[row][col] = true;
		while(!q.isEmpty())
		{
			int value[] = q.poll();
			
			for(int index =0 ; index <4;index++)
			{
				int nxt_y = value[0] + dy[index];
				int nxt_x = value[1] + dx[index];
				
				//벗어나거나 이미 간적있을경우 제외
				if(nxt_x < 0 || nxt_x >= N || nxt_y < 0 || nxt_y >= M || check[nxt_y][nxt_x])
					continue;
				
				q.offer(new int[] {nxt_y,nxt_x});
				check[nxt_y][nxt_x] = true;
				cnt++;
			}
		}
		part.add(cnt);

	}
}
