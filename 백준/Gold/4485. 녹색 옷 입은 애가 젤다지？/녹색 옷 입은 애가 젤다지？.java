import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


    static int N;
    static int map[][];

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int tc = 1;
        while (true) {
            N = Integer.parseInt(br.readLine());
            //0입력받으면 끝
            if (N == 0) {
                break;
            }
            map = new int[N][N];

            for (int row = 0; row < N; row++) {
                st = new StringTokenizer(br.readLine());
                for (int col = 0; col < N; col++) {
                    map[row][col] = Integer.parseInt(st.nextToken());
                }
            }

            int cost = run();
            sb.append("Problem " + tc + ": " + cost + "\n");
            tc++;
        }

        System.out.println(sb);

    }

    private static int run() {
        //우선순위큐 이용이유 -> 최소한의 비용으로 가기때문에
        Queue<Node> queue = new PriorityQueue<>();
        //가중치 계산
        int[][] move = new int[N][N];

        for (int idx = 0; idx < N; idx++) {
            Arrays.fill(move[idx], Integer.MAX_VALUE);
        }

        queue.add(new Node(0, 0, map[0][0]));
        move[0][0] = map[0][0];

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int cx = cur.row;
            int cy = cur.col;
            int cost = cur.cost;

            //도달시 반환
            if (cx == N - 1 && cy == N - 1) {
                return cost;
            }

            for(int i=0; i<4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx<0 || nx>N-1 || ny<0 || ny>N-1) continue;

                //최소비용인경우 갱신진행.
                if (cost + map[nx][ny] < move[nx][ny]) {
                    move[nx][ny] = cost + map[nx][ny];
                    queue.offer(new Node(nx, ny, cost + map[nx][ny]));
                }
            }
        }

        return -1;
    }

    static class Node implements Comparable<Node> {
        int row;
        int col;
        int cost;

        public Node(int row, int col, int cost) {
            this.row = row;
            this.col = col;
            this.cost = cost;
        }

        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }
}
