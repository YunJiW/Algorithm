import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int Map[][];

    static int dx[] = {0, -1, 0, 1};
    static int dy[] = {-1, 0, 1, 0};

    static boolean visited[][];

    static int Rows;
    static int Cols;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        Rows = Integer.parseInt(st.nextToken());
        Cols = Integer.parseInt(st.nextToken());

        Map = new int[Rows][Cols];
        visited = new boolean[Rows][Cols];

        int start_row = 0;
        int start_col = 0;
        for (int row = 0; row < Rows; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < Cols; col++) {
                Map[row][col] = Integer.parseInt(st.nextToken());
                if (Map[row][col] == 2) {
                    start_row = row;
                    start_col = col;
                }
            }
        }

        Start(start_row, start_col, 0);

        Scan();

        print();

    }

    private static void print() {
        for (int row = 0; row < Rows; row++) {
            for (int col = 0; col < Cols; col++) {
                System.out.print(Map[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void Scan() {
        for (int row = 0; row < Rows; row++) {
            for (int col = 0; col < Cols; col++) {
                if (!visited[row][col] && Map[row][col] != 0) {
                    Map[row][col] = -1;
                }
            }
        }
    }

    private static void Start(int row, int col, int count) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col, count});
        Map[row][col] = count;
        visited[row][col] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int idx = 0; idx < 4; idx++) {
                int nxt_row = cur[0] + dx[idx];
                int nxt_col = cur[1] + dy[idx];

                //범위를 벗어나는 경우 pass
                if (nxt_row < 0 || nxt_col < 0 || nxt_row >= Rows || nxt_col >= Cols) {
                    continue;
                }

                //벽인 경우와 이미 간곳인 경우 pass
                if (Map[nxt_row][nxt_col] == 0 || visited[nxt_row][nxt_col]) {
                    continue;
                }

                queue.offer(new int[]{nxt_row, nxt_col, cur[2] + 1});
                Map[nxt_row][nxt_col] = cur[2] + 1;
                visited[nxt_row][nxt_col] = true;

            }
        }
    }
}