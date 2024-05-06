import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    static int K;

    static int visited[];

    static int dx[] = {-1, 1, 2};

    /**
     * min_sec : 가장 빠른시간 확인
     * cnt : 경우의 수 체크
     */

    static int min_sec = Integer.MAX_VALUE;

    static int cnt = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new int[100001];
        run(N);

        System.out.println(min_sec);
        System.out.println(cnt);

    }

    private static void run(int start) {
        Queue<Warp> queue = new LinkedList<>();
        queue.offer(new Warp(start, 0));

        while (!queue.isEmpty()) {
            Warp cur = queue.poll();

            if (min_sec < cur.cnt) return;
            if (cur.pos == K && cur.cnt <= min_sec) {
                cnt += 1;
                min_sec = cur.cnt;
            }

            //x+1,x-1,2x 3가지 처리
            for (int idx = 0; idx < 3; idx++) {
                int next = cur.pos;
                if (idx == 2) {
                    next = cur.pos * dx[idx];
                } else {
                    next = cur.pos + dx[idx];
                }

                if (next >= 0 && next < 100001) {
                    if (visited[next] == 0 || visited[next] >= visited[cur.pos] + 1) {
                        visited[next] = visited[cur.pos] + 1;
                        queue.offer(new Warp(next, cur.cnt + 1));
                    }
                }
            }
        }
    }

    static class Warp {
        int pos;
        int cnt;

        public Warp(int pos, int cnt) {
            this.pos = pos;
            this.cnt = cnt;
        }
    }
}
