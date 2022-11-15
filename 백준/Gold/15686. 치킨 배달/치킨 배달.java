import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
	
	//치킨집과 집 좌표 용
	static class Point{
		int row;
		int col;
		
		Point(int row,int col){
			this.row = row;
			this.col = col;
		}
	}
	
	
	static int Map[][];
	
	//N -> 도시정보
	//최대 치킨집 개수
	static int N;
	static int M;
	
	//집 좌표 및 치킨집 좌표 저장용
	static Point House[];
	static Point Chicken[];
	
	//집 개수 및 치킨 집 개수
	static int House_cnt = 0;
	static int Chicken_cnt = 0;
	
	static Point Combi[];
	static boolean check[];
	
	//거리값 계산
	static int Min_distance = Integer.MAX_VALUE;
	
	
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		Map = new int[N][N];
		//집과 치킨의 최대 개수로 생성
		Combi = new Point[M];
		House = new Point[100];
		Chicken = new Point[13];
		for(int row = 0; row < N; row++)
		{
			st = new StringTokenizer(br.readLine());
			for(int col = 0 ; col <N;col++)
			{
				Map[row][col] = Integer.parseInt(st.nextToken());
				if(Map[row][col] == 1)
				{
					House[House_cnt++] = new Point(row,col);
				}
				else if(Map[row][col] == 2)
				{
					Chicken[Chicken_cnt++] = new Point(row,col);
				}
			}
		}
		check = new boolean[Chicken_cnt];
		DFS(0,0);
		
		System.out.println(Min_distance);
	}
	private static void DFS(int depth,int idx) {
		if(depth == M)
		{
			Min_distance = Math.min(Min_distance, distance_calc());
			return;
		}
		
		for(int index = idx; index < Chicken_cnt;index++)
		{
			if(!check[index])
			{
				check[index] =true;
				Combi[depth] = Chicken[index];
				DFS(depth+1,index+1);
				check[index] = false;
			}
		}
		
	}
	private static int distance_calc() {
		
		int sum = 0;
		for(int index =0 ; index < House_cnt; index++)
		{
			int Min = Integer.MAX_VALUE;
			for(int chk =0; chk < Combi.length;chk++)
			{
				Min = Math.min(Min,(Math.abs(House[index].row - Combi[chk].row)+Math.abs(House[index].col - Combi[chk].col)));
			}
			sum+= Min;
		}
		return sum;
	}
}
