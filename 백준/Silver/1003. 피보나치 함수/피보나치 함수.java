import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Main{
    static Integer[][] dp = new Integer[41][2];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;
        
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int test_case = 0; test_case < T; test_case++)
        {
            int N = Integer.parseInt(br.readLine());
            fibo(N);
            sb.append(dp[N][0]).append(" ").append(dp[N][1]).append("\n");
            
        }
        System.out.print(sb);
    }
    static Integer[] fibo(int n){
        if(dp[n][0] == null || dp[n][1] == null){
            dp[n][0] = fibo(n-1)[0] + fibo(n-2)[0];
            dp[n][1] = fibo(n-1)[1] + fibo(n-2)[1];
        }
        return dp[n];
    }
}