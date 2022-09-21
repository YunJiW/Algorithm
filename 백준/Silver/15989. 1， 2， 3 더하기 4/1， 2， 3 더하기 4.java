import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        int[][] dp = new int[10001][4];
        
        dp[1][1] = 1;
        
        dp[2][1] = 1;
        dp[2][2] = 1;
        
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;
        
        
        for(int index = 4; index <= 10000;index++)
        {
            dp[index][1] = dp[index-1][1];
            dp[index][2] = dp[index-2][1] + dp[index-2][2];
            dp[index][3] = dp[index-3][1] + dp[index-3][2] + dp[index-3][3];
        }
        
        StringBuilder sb = new StringBuilder();
        while(T--> 0){
            int N = Integer.parseInt(br.readLine());
            sb.append(dp[N][1] + dp[N][2] + dp[N][3]).append("\n");
        }
        System.out.print(sb);
    }
}