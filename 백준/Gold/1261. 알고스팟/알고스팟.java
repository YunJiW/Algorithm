import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    static int N;
    static int M;

    static int Map[][];

    static boolean visited[][];

    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};

    static int res = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        Map = new int[N][M];
        //방향을 포함한 방문체크 계산용
        visited = new boolean[N][M];

        for (int row = 0; row < N; row++) {
            String line = br.readLine();
            for (int col = 0; col < M; col++) {
                Map[row][col] = line.charAt(col) - '0';
            }
        }
        

        start(0, 0);

        System.out.println(res);
    }

    private static void start(int row, int col) {
        Queue<move> que = new PriorityQueue<>();

        que.offer(new move(row, col, 0));
        visited[row][col] = true;

        while (!que.isEmpty()) {
            move cur = que.poll();
            int rows = cur.row;
            int cols = cur.col;
            int cnt = cur.wall_break;


            //도달하면 끝.
            if (rows == N - 1 && cols == M - 1) {
                res = cnt;
                return;
            }

            for (int idx = 0; idx < 4; idx++) {
                int nt_row = rows + dx[idx];
                int nt_col = cols + dy[idx];

                //범위를 벗어나는 경우 또는 방문한적이 있는 경우 pass
                if (is_possible(nt_row, nt_col, idx))
                    continue;

                visited[nt_row][nt_col] = true;
                if (Map[nt_row][nt_col] == 1) {
                    que.offer(new move(nt_row, nt_col, cnt + 1));
                }else{
                    que.offer(new move(nt_row, nt_col, cnt));
                }

            }


        }


    }

    private static boolean is_possible(int row, int col, int dir) {
        return (row < 0 || row >= N || col < 0 || col >= M || visited[row][col]);
    }

    //좌표 및 벽부순개수 저장용 클래스
    private static class move implements Comparable<move> {
        int row;
        int col;
        int wall_break;

        public move(int row, int col, int wall_break) {
            this.row = row;
            this.col = col;
            this.wall_break = wall_break;
        }

        public int compareTo(move o) {
            return wall_break - o.wall_break;
        }
    }
}
