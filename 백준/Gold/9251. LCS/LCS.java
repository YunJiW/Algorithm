import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] str1 = br.readLine().toCharArray();
		char[] str2= br.readLine().toCharArray();
		
		int len1 =str1.length;
		int len2 =str2.length;
		
		
		int dp[][] = new int[len1 +1][len2+1];
		
		
		for(int str1_idx =1; str1_idx<=len1;str1_idx++)
		{
			for(int str2_idx =1; str2_idx<=len2;str2_idx++)
			{
				if(str1[str1_idx -1] == str2[str2_idx -1])
				{
					dp[str1_idx][str2_idx] = dp[str1_idx-1][str2_idx-1] +1;
				}
				
				else {
					dp[str1_idx][str2_idx] = Math.max(dp[str1_idx-1][str2_idx],dp[str1_idx][str2_idx-1] );
				}
			}
		}
		
		System.out.println(dp[len1][len2]);
	}
}
