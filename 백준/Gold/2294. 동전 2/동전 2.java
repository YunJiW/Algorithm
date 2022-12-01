import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	
	static int k;
	
	static int Coin[];
	
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		Coin = new int[N+1];
		
		for(int index =1 ;index <=N;index++)
		{
			Coin[index] = Integer.parseInt(br.readLine());
		}
		
		int dp[] = new int[k+1];
		for(int index =1; index <=k;index++)
		{
			dp[index] = Integer.MAX_VALUE-1;
		}
		
		for(int i = 1; i<= N;i++)
		{
			for(int coin_value = Coin[i]; coin_value <=k ;coin_value++)
			{
				dp[coin_value] = Math.min(dp[coin_value],dp[coin_value - Coin[i]]+ 1);
				
			}
		}
		
		if(dp[k] == Integer.MAX_VALUE-1)
			System.out.println(-1);
		else
			System.out.println(dp[k]);
	}

}
