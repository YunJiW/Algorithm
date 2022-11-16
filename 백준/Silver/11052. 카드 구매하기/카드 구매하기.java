
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
public class Main {
	
	
	public static void main(String[] args)throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int dp[] = new int[N+1];
		
		int Card_Value[] = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		
		for(int index =1; index <=N;index++)
		{
			Card_Value[index] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = 0;
		
		for(int i =1; i <=N; i++)
		{
			for(int j = 1; j <= i;j++)
			{
				dp[i] = Math.max(dp[i],dp[i-j] + Card_Value[j]);
			}
		}
		
		System.out.println(dp[N]);
		
	}

}
