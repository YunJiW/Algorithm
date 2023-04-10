import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int list[] = new int[N];
        int dp[] = new int [N];
        for(int idx = 0; idx <N;idx++){
            list[idx] = Integer.parseInt(st.nextToken());
            dp[idx] = list[idx];
        }

        int sum = dp[0];
        for(int idx = 0; idx < N; idx++){
            for(int next= 0;next <idx;next++){
                if(list[next] < list[idx]){
                    dp[idx] = Math.max(dp[next]+list[idx],dp[idx]);
                    sum = Math.max(sum,dp[idx]);
                }
            }

        }
        System.out.println(sum);
    }
}
