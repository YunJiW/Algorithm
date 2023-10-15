import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] list = new int[N+1];
        long[] dp = new long[1101];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int idx = 1; idx <=N;idx++){
            list[idx] = Integer.parseInt(st.nextToken());
            dp[idx] = Integer.MAX_VALUE;
        }
        dp[1] = 0;
        for(int idx = 1 ; idx <=N;idx++){
            if(dp[idx] >= Integer.MAX_VALUE) continue;
            for(int next = 1 ;next <=list[idx];next++){
                dp[idx+next] = Math.min(dp[idx+next],dp[idx]+1);
            }
        }

        if(dp[N] >= Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(dp[N]);
        }


    }
}
