import java.util.*;
import java.io.*;


public class Main {

    static int N,M;
    static int[] vol;

    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

         N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());


         vol = new int[N];


        st = new StringTokenizer(br.readLine());
        for(int idx =0; idx < N;idx++){
            vol[idx] = Integer.parseInt(st.nextToken());
        }

        dp = new int[M+1][N];

        for(int[] arr : dp){
            Arrays.fill(arr,-2);
        }

        int result = recursion(S,0);
        System.out.println(result);


    }

    private static int recursion(int sum, int idx) {
        if(sum > M || sum < 0)
            return -1;

        if(idx == N){
            return sum;
        }

        if(dp[sum][idx] != -2){
            return dp[sum][idx];
        }

        return dp[sum][idx] = Math.max(dp[sum][idx],Math.max(recursion(sum+vol[idx],idx+1),recursion(sum-vol[idx],idx+1)));

    }
}
