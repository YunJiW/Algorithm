import java.util.*;
import java.io.*;

public class Main {

    static int n,m;
    static int hole = -999;

    static int max = Integer.MIN_VALUE;

    //무한루프인지 체크용도
    static boolean flag = false;

    static int [][] dp,map;

    static boolean visited[][];


    static int dx[] = {-1,1,0,0};
    static int dy[] ={0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dp = new int[n][m];
        visited = new boolean[n][m];


        for(int row = 0; row <n;row++){
            String line = br.readLine();
            for(int col = 0; col<m;col++){
                if(line.charAt(col) == 'H'){
                    map[row][col] = hole;
                }else{
                    map[row][col] = line.charAt(col) -'0';
                }
            }
        }

        visited[0][0] = true;
        dfs(0,0,1);

        if(flag){
            System.out.println(-1);
        }else{
            System.out.println(max);
        }

    }

    private static void dfs(int x, int y, int cnt) {
        if(max < cnt){
            max = cnt;
        }
        dp[x][y] = cnt;

        for(int idx = 0; idx <4;idx++){
            int move = map[x][y];
            int nx = x + (move*dx[idx]);
            int ny = y + (move*dy[idx]);
            
            //맵을 벗어나거나 목적지가 hole인경우 out
            if(nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny] == hole){
                continue;
            }

            //이미 온적있는곳을 다시오는 경우 무한루프가 돈다.
            if(visited[nx][ny]){
                flag = true;
                return;
            }

            //이미 탐색한 부분은 스킵한다.
            if(dp[nx][ny] > cnt) continue;

            visited[nx][ny] = true;
            dfs(nx,ny,cnt+1);
            visited[nx][ny] = false;


        }
    }
}