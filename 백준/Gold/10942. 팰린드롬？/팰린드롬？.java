import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean dp[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n + 1];
        dp = new boolean[n + 1][n + 1];

        st = new StringTokenizer(br.readLine());
        for (int idx = 1; idx <= n; idx++) {
            arr[idx] = Integer.parseInt(st.nextToken());
        }

        run(arr, n);
        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int idx = 0; idx < m; idx++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if (dp[start][end])
                sb.append("1\n");
            else
                sb.append("0\n");
        }

        System.out.println(sb);
    }

    private static void run(int[] arr, int n) {
        for (int idx = 1; idx <= n; idx++) {
            dp[idx][idx] = true;
        }

        for (int idx = 1; idx < n; idx++) {
            if (arr[idx] == arr[idx + 1])
                dp[idx][idx + 1] = true;
        }

        for (int idx = 2; idx < n; idx++) {
            for (int j = 1; j <= n - idx; j++) {
                if (arr[j] == arr[j + idx] && dp[j + 1][j + idx - 1])
                    dp[j][j + idx] = true;
            }
        }

    }
}
