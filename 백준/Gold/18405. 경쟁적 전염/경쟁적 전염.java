import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int K;

    static int S;
    static int X;
    static int Y;


    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};


    static int Map[][];

    static Queue<PriorityQueue<Virus>> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Map = new int[N][N];

        PriorityQueue<Virus> list = new PriorityQueue<>();

        for (int row = 0; row < N; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < N; col++) {
                Map[row][col] = Integer.parseInt(st.nextToken());
                if (Map[row][col] != 0) {
                    list.add(new Virus(row, col, Map[row][col]));
                }
            }
        }
        queue.offer(list);
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        Start();
        System.out.println(Map[X-1][Y-1]);

    }

    private static void print() {

        for(int row = 0; row <N; row++){
            for(int col = 0; col <N;col++){
                System.out.print(Map[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void Start() {

        int cnt = 0;
        while (!queue.isEmpty()) {
            PriorityQueue<Virus> cur = queue.poll();

            PriorityQueue<Virus> next = new PriorityQueue<>();
            //시간초만큼 전염 끝나면 리턴
            if (cnt == S) {
                return;
            }
            while (!cur.isEmpty()) {
                Virus curp = cur.poll();
                //시간 만큼 진행될 경우 나옴.
                //전염
                for (int idx = 0; idx < 4; idx++) {
                    int nxt_row = curp.row + dx[idx];
                    int nxt_col = curp.col + dy[idx];

                    //맵을 벗어나는 경우 pass
                    if (nxt_row < 0 || nxt_row >= N || nxt_col < 0 || nxt_col >= N) {
                        continue;
                    }
                    //0이 아니다 -> 이미 전염된 곳이다.
                    if (Map[nxt_row][nxt_col] != 0) {
                        continue;
                    }

                    Map[nxt_row][nxt_col] = curp.number;
                    next.add(new Virus(nxt_row, nxt_col, curp.number));

                }


            }
            queue.offer(next);
            cnt += 1;
        }
    }

    public static class Virus implements Comparable<Virus> {
        int row;
        int col;
        int number;

        public Virus(int row, int col, int number) {
            this.row = row;
            this.col = col;
            this.number = number;
        }

        //바이러스 번호순 정렬
        @Override
        public int compareTo(Virus o) {
            return this.number - o.number;
        }
    }
}
