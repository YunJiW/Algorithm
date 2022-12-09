import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long result[] = new long[N+1];
		long dp[][] = new long[N+1][10];
		
		for(int index =0 ; index <10;index++)
		{
			dp[1][index] = 1;
		}
		result[1] =10;
		
		for(int i=2;i <=N;i++)
		{
			for(int j=0;j<10;j++)
			{
				if(j==0)
					dp[i][j] = dp[i-1][j];
				else {
					dp[i][j] = dp[i][j-1] + dp[i-1][j];
					dp[i][j] %=10007;
				}
				result[i] +=dp[i][j];
			}
		}
		
		System.out.println(result[N] %10007);
	}
}
