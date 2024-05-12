import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int dp[][] = new int[N + 1][M + 1];

        if (N == 1 && M == 1) {
            System.out.println(1);
            return;
        }

        int res = 0;


        for (int row = 1; row <= N; row++) {
            String line = br.readLine();

            for (int col = 1; col <= M; col++) {
                int temp = line.charAt(col - 1) - '0';

                if (row == 1 && col == 1) {
                    dp[row][col] = temp;
                } else {
                    if (temp == 1) {
                        dp[row][col] = Math.min(dp[row][col - 1], Math.min(dp[row - 1][col], dp[row - 1][col - 1])) + 1;
                        res = Math.max(res, dp[row][col]);
                    }
                }
            }
        }

        System.out.println(res * res);

    }
}
