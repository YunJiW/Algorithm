import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main{
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int[] arr = new int[N];
		int[] dp = new int[N];
		
		for(int index =0 ; index < N;index++)
		{
			arr[index] = Integer.parseInt(st.nextToken());
		}
		dp[0] = arr[0];
		int max = arr[0];
		
		for(int check = 1; check<N;check++)
		{
			
			dp[check] = Math.max(dp[check-1] + arr[check],arr[check]);
			
			max = Math.max(max,dp[check]);
		}
		System.out.print(max);
		

		
		
	}

}
