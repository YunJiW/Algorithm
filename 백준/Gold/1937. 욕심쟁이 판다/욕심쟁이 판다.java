import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dx= {-1, 0, 1, 0};
    static int[] dy= {0, 1, 0, -1};
    static int N;
    static int[][] map;
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new int[N][N];

        for (int idx = 0; idx < N; idx++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[idx][j] = Integer.parseInt(st.nextToken());
            }
        }

        int res = 0;
        for(int row = 0; row <N;row++){
            for(int col = 0; col <N;col++){
                res = Math.max(res,DFS(row,col));
            }
        }

        System.out.println(res);
    }

    private static int DFS(int row, int col) {

        if(dp[row][col] != 0){
            return dp[row][col];
        }

        dp[row][col] = 1;

        int nx,ny;
        for(int idx= 0; idx <4;idx++){
            nx = row + dx[idx];
            ny = col + dy[idx];

            if(nx < 0 || nx >= N || ny < 0 || ny >= N)
                continue;
            if(map[row][col] < map[nx][ny]){
                dp[row][col] = Math.max(dp[row][col],DFS(nx,ny) +1);
                DFS(nx,ny);
            }

        }
        return dp[row][col];
    }
}
