import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
public class Main {
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] nums = new int[N+1][N+1];
		
		for(int col=1 ;col <=N;col++)
		{
			st = new StringTokenizer(br.readLine());
			for(int row =1; row <=N;row++)
			{
				nums[col][row] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] dp = new int[N+1][N+1];
		
		for(int col =1 ;col <= N;col++)
		{
			for(int row =1; row <=N;row++)
			{
				if(row == 1)
					dp[col][row] = nums[col][row];
				else
					dp[col][row] = dp[col][row-1] + nums[col][row];
			}
		}
		
		
		StringBuilder sb = new StringBuilder();
		while(M --> 0) {
			st = new StringTokenizer(br.readLine());
			int st_x = Integer.parseInt(st.nextToken());
			int st_y = Integer.parseInt(st.nextToken());
			
			int en_x = Integer.parseInt(st.nextToken());
			int en_y = Integer.parseInt(st.nextToken());
			
			if(st_x == en_x && st_y == en_y)
			{
				sb.append(nums[st_x][st_y]).append('\n');
				continue;
			}
			
			int sum = 0;
			for(int col = st_x; col <=en_x;col++)
			{
				sum += dp[col][en_y] - dp[col][st_y-1];
			}
			sb.append(sum).append('\n');
			
			
		}
		System.out.print(sb);
		
		
		
		
		
	}

}
