import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		int[] stair = new int[T+1];
		int[] dp = new int[T+1];
		
		//계단 값 넣어둠
		for(int index = 1; index <=T;index++)
		{
			stair[index] = Integer.parseInt(br.readLine());
		}
		
		dp[1] = stair[1];
        //T가 2이상일때
		if(T >=2)
		{
			dp[2] = dp[1] + stair[2];
		}
		
		
		for(int index = 3; index <=T;index++)
		{
			dp[index] = Math.max(dp[index-3] + stair[index-1],dp[index-2]) +stair[index];
		}
		System.out.println(dp[T]);
		
	}
}
