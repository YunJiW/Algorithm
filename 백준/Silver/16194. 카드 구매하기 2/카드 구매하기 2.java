import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] CardValue = new int[N+1];

        int[] dp = new int[N+1];
        
        //각 개수별 가격 결정
        for(int idx = 1; idx <=N;idx++){
            CardValue[idx] = Integer.parseInt(st.nextToken());

        }


        Arrays.fill(dp,99999);
        dp[0]= 0;
        for(int index = 1; index <=N;index++){
            for(int j = 1; j<=index;j++){
                dp[index] = Math.min(dp[index],dp[index-j] + CardValue[j]);
            }
        }

        System.out.println(dp[N]);


    }
}
