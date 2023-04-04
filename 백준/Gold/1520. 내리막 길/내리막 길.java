import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int result = 0;


    static int dx[] = {0,-1,0,1};
    static int dy[] = {-1,0,1,0};

    static int map[][];

    static int dp[][];
    static int N,M;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dp = new int[N][M];
        for(int rows = 0; rows <N;rows++)
        {
            st = new StringTokenizer(br.readLine());
            for(int cols = 0; cols <M;cols++)
            {
                map[rows][cols] = Integer.parseInt(st.nextToken());
                dp[rows][cols] = -1;
            }
        }

        result = starting(0,0);

        System.out.println(result);
    }

    private static int starting(int row, int col) {
        if(row == N-1 && col == M-1){
            return 1;
        }
        //이미 온곳은 다시 탐색 x
        if(dp[row][col] != -1)
            return dp[row][col];

        dp[row][col] = 0;
        for(int idx= 0; idx < 4 ;idx++){
            int nxt_row = row + dx[idx];
            int nxt_col = col + dy[idx];

            //맵을 벗어나거나 다음 값보다 작은 경우 패스
            if(nxt_row < 0 || nxt_row >= N || nxt_col < 0 || nxt_col >= M || map[row][col] <= map[nxt_row][nxt_col]){
                continue;
            }
            dp[row][col] += starting(nxt_row,nxt_col);
        }

        return dp[row][col];
    }
}