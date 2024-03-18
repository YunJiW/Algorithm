import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int tc = 0; tc <T ;tc++){
            int k;
            int[] book;
            int[] sum;
            int[][] dp;

            k = Integer.parseInt(br.readLine());
            book = new int[k+1];
            sum = new int[k+1];
            dp = new int[k+1][k+1];

            st = new StringTokenizer(br.readLine());
            for(int idx = 1; idx <=k;idx++){
                int num = Integer.parseInt(st.nextToken());

                book[idx] = num;
                sum[idx] = sum[idx-1] + book[idx];
            }

            for(int n = 1; n <=k;n++){

                for(int from = 1; from+n <= k;from++){
                    int to = from +n;

                    dp[from][to] = Integer.MAX_VALUE;
                    for(int divide= from; divide<to;divide++){
                        dp[from][to] = Math.min(dp[from][to],dp[from][divide] + dp[divide+1][to] +sum[to] - sum[from-1]);
                    }
                }
            }
            sb.append(dp[1][k]).append("\n");
        }
        System.out.print(sb);
    }
}
