import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, x, y, k;

    static int map[][];

    static int dice[] = new int[7];

    //동 서 북 남
    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int row = 0; row < N; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < M; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < k; idx++) {
            int d = Integer.parseInt(st.nextToken());
            command(d);
        }

    }

    private static void command(int d) {
        int nx = x + dx[d - 1];
        int ny = y + dy[d - 1];

        if (nx < 0 || nx >= N || ny < 0 || ny >= M)
            return;

        rolling(d, nx, ny);
        x = nx;
        y = ny;
    }

    /**
     * 1: 동
     * 2: 서
     * 3: 북
     * 4: 남
     */
    //핵심 로직
    //주사위 굴리는 공식만 파악하면 쉽게 풀이 가능.
    private static void rolling(int d, int x, int y) {
        int tmp = dice[3];

        switch (d){
            case 1:
                dice[3] = dice[4];
                dice[4] = dice[6];
                dice[6] = dice[2];
                dice[2] = tmp;
                break;
            case 2:
                dice[3] = dice[2];
                dice[2] = dice[6];
                dice[6] = dice[4];
                dice[4] = tmp;
                break;
            case 3:
                dice[3] = dice[5];
                dice[5] = dice[6];
                dice[6] = dice[1];
                dice[1] =tmp;
                break;
            case 4:
                dice[3] = dice[1];
                dice[1] = dice[6];
                dice[6] = dice[5];
                dice[5] = tmp;
                break;
        }

        if(map[x][y] == 0){
            map[x][y] = dice[6];
        }else{
            dice[6] = map[x][y];
            map[x][y] =0;
        }

        System.out.println(dice[3]);
        
    }


}