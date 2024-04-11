import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new int[N + 1];

        if (N % 2 == 0) {
            dp[0] =1;
            dp[2] = 3;

            for(int idx = 4; idx <=N; idx+=2){
                dp[idx] = dp[idx-2] * dp[2];

                for(int num = idx -4; num >= 0;num--){
                    dp[idx] += (dp[num]*2);
                }
            }


        }

        System.out.println(N % 2 == 0 ? dp[N] : 0);

    }
}
