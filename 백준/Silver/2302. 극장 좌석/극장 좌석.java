import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] dp = new int[41];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;


        //전체 경우 계산
        for(int idx = 3; idx <=N;idx++){
            dp[idx] = dp[idx-2] + dp[idx-1];
        }

        int result = 1;

        int beforeIdx = 0;
        for(int idx = 0; idx <M;idx++){
            int temp = Integer.parseInt(br.readLine());
            result*= dp[temp - beforeIdx -1];
            beforeIdx = temp;
        }
        result*= dp[N - beforeIdx];

        System.out.println(result);
    }
}
