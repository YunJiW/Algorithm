import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //최대 64자리의 0 ~ 9 숫자
        long dp[][] = new long[65][10];

        StringBuilder sb = new StringBuilder();

        //1자리수는 모두 1개씩 있음.
        for(int idx = 0; idx <=9;idx++){
            dp[1][idx] = 1;
        }
        
        for(int index = 2; index <=64;index++){
            for(int j= 0; j <=9;j++){
                for(int k = j; k <=9;k++){
                    dp[index][j] += dp[index-1][k];
                }
            }
        }
        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T;tc++){
            int N = Integer.parseInt(br.readLine());
            long ans = 0;

            for(int idx =0; idx <=9;idx++){
                ans += dp[N][idx];
            }
            sb.append(ans).append("\n");
        }

        System.out.print(sb);
    }
}