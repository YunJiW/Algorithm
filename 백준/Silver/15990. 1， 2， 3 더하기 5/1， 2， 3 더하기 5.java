import java.io.*;
import java.util.*;

public class Main {
    static long MOD = 1000000009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        long[][] dp = new long[100001][4];
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        StringBuilder sb = new StringBuilder();

        for(int idx = 4; idx <=100000;idx++){
            dp[idx][1] = (dp[idx-1][2] + dp[idx-1][3]) % MOD;
            dp[idx][2] = (dp[idx-2][1] + dp[idx-2][3]) % MOD;
            dp[idx][3] = (dp[idx-3][1] + dp[idx-3][2]) % MOD;
        }

        for(int testcase = 0; testcase < T;testcase++){
            int N = Integer.parseInt(br.readLine());
            sb.append((dp[N][1] + dp[N][2] + dp[N][3])% MOD ).append("\n");
        }

        System.out.print(sb);
    }
}
