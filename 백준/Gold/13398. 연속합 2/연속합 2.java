import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        int arr[] = new int[N];
        int dp[] = new int[N];
        int dp2[] = new int[N];



        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int index = 0; index < N; index++) {
            arr[index] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];
        int result = dp[0];

        //기본 연속합 계산
        for (int idx = 1; idx < N; idx++) {
            dp[idx] = Math.max(arr[idx], dp[idx - 1] + arr[idx]);

            result = Math.max(dp[idx], result);
        }

        dp2[N - 1] = arr[N - 1];

        //오른쪽으로 가는 계산
        for (int idx = N - 2; idx >= 0; idx--) {
            dp2[idx] = Math.max(arr[idx], dp2[idx + 1] + arr[idx]);
        }


        for (int idx = 1; idx < N - 1; idx++) {
            int check = dp[idx - 1] + dp2[idx + 1];

            result= Math.max(check,result);
        }

        System.out.println(result);
    }
}
