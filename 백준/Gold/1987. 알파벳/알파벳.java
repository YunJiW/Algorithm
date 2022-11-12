import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

//A - Z 65 ~ 90
public class Main {

	static int R;
	static int C;
	
	//상 하 좌 우
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	
	static char Map[][];
	
	static int Max = Integer.MIN_VALUE;
	
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		
		Map = new char[R+1][C+1];
		
		for(int row = 1 ; row <= R; row++)
		{
			String Line = br.readLine();
			for(int col = 1; col <= C; col++)
			{
				Map[row][col] = Line.charAt(col-1);
			}
		}
		int Alpha [] = new int[26];
		//1,1 체크
		Alpha[Map[1][1] - 65] = 1;
		
		Run(1,1,Alpha,1);
		
		
		
		System.out.println(Max);
	}

	private static void Run(int row, int col,int[] alpha,int cnt) {
		int alpha_check[] = new int[26];
		
		for(int idx = 0 ; idx <26;idx++)
			alpha_check[idx] = alpha[idx];
		
		//갈수 있는 곳이 없을 경우 반환
		if(!ispossible(row,col,alpha_check))
		{
			Max = Math.max(Max,cnt);
			return;
		}
		
		for(int index = 0 ;index < 4; index++)
		{
			int nxt_x = row +dx[index];
			int nxt_y = col +dy[index];
			
			if(nxt_x <= 0 || nxt_x > R ||  nxt_y <= 0 || nxt_y > C)
				continue;
			if(alpha_check[Map[nxt_x][nxt_y] - 65] == 1)
				continue;
			
			alpha_check[Map[nxt_x][nxt_y] - 65] = 1;
			Run(nxt_x,nxt_y,alpha_check, cnt+1);
			alpha_check[Map[nxt_x][nxt_y] - 65] = 0;
		}
		
		
	}

	private static boolean ispossible(int row , int col,int[] alpha) {
		
		for(int index = 0; index < 4 ;index++)
		{
			int nxt_x = row + dx[index];
			int nxt_y = col + dy[index];
			
			//맵을 벗어나거나 알파벳이 중복될경우 pass
			if(nxt_x <= 0 || nxt_x > R ||  nxt_y <= 0 || nxt_y > C)
				continue;
			if(alpha[Map[nxt_x][nxt_y] - 65] == 1)
				continue;
			return true;
		}
		return false;
	}
}
