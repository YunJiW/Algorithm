import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static char[][] map;

    static int R;
    static int C;

    static boolean[][] visited;

    static Point Start;

    static Queue<Point> water;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        water = new LinkedList<>();

        //맵 정보 받기
        for (int row = 0; row < R; row++) {
            String line = br.readLine();
            for (int col = 0; col < C; col++) {
                char check = line.charAt(col);
                //물,굴,도슴도치 정보 받기.
                if (check == '*') {
                    water.offer(new Point(row, col));
                } else if (check == 'S') {
                    Start = new Point(row, col);
                }
                map[row][col] = check;
            }
        }

        int res = run();

        if (res == -1) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(res);
        }

    }

    private static int run() {
        Queue<Point> hedge = new LinkedList<>();
        hedge.offer(Start);
        visited[Start.row][Start.col] = true;

        //물을 먼저 이동시키고 고슴도치를 이동시키도록해보자.
        //물전파를 받을 하나가 더있으면되고
        //고슴도치 이동을 하나가 더 있으면 될거같다.
        int time = 0;

        while (true) {
            Queue<Point> next_water = new LinkedList<>();
            Queue<Point> next_hedge = new LinkedList<>();

            //고슴도치가 더이상 움직일수 없으면 더 이동 필요없음.
            if (hedge.isEmpty()) {
                break;
            }
            //물 전파 -> 다음 물을 저장할 큐가 있으면 되지않을까?
            while (!water.isEmpty()) {
                Point curWater = water.poll();

                for (int idx = 0; idx < 4; idx++) {
                    int nxt_r = curWater.row + dx[idx];
                    int nxt_c = curWater.col + dy[idx];

                    if (!isPossible(nxt_r, nxt_c))
                        continue;

                    //동굴을 만나는 경우 pass
                    if (map[nxt_r][nxt_c] == 'D')
                        continue;

                    //같은 물을 만나는 경우도 pass
                    if (map[nxt_r][nxt_c] == '*') {
                        continue;
                    }

                    map[nxt_r][nxt_c] = '*';
                    next_water.offer(new Point(nxt_r, nxt_c));
                }
            }


            while (!hedge.isEmpty()) {
                Point cur = hedge.poll();


                //도착하면 끝
                if (map[cur.row][cur.col] == 'D') {
                    return time;
                }

                for (int idx = 0; idx < 4; idx++) {
                    int nxt_r = cur.row + dx[idx];
                    int nxt_c = cur.col + dy[idx];


                    if (!isPossible(nxt_r, nxt_c))
                        continue;

                    //물만나면 가면안됨.
                    if (map[nxt_r][nxt_c] == '*') {
                        continue;
                    }

                    if (!visited[nxt_r][nxt_c]) {
                        visited[nxt_r][nxt_c] = true;
                        next_hedge.offer(new Point(nxt_r, nxt_c));

                    }
                }

            }
            time += 1;


            hedge = next_hedge;
            water = next_water;
        }

        return -1;

    }

    static boolean isPossible(int row, int col) {

        //범위를 벗어나거나 돌을 만난 경우 pass
        if (row < 0 || row >= R || col < 0 || col >= C || map[row][col] == 'X')
            return false;

        return true;
    }


    //좌표 클래스
    static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}

