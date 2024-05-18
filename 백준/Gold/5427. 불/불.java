import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static char[][] map;

    public static int h, w;

    //핵심
    public static Queue<Point> sang;
    public static Queue<Point> fire;

    public static int dx[] = {-1, 0, 1, 0};
    public static int dy[] = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            sang = new LinkedList<>();

            //불 위치
            fire = new LinkedList<>();

            map = new char[h][w];
            //맵 정보 복사
            for (int row = 0; row < h; row++) {
                String line = br.readLine();
                for (int col = 0; col < w; col++) {
                    map[row][col] = line.charAt(col);
                    if (map[row][col] == '@') {
                        sang.offer(new Point(row, col, 0));
                    } else if (map[row][col] == '*') {
                        fire.add(new Point(row, col));
                    }
                }
            }

            int ans = -1;
            //핵심 코드
            while (true) {
                //불 번짐 먼저 진행 -> 어쩌피 불이 이동할 곳은 상근이 이동못하니까
                int fireSize = fire.size();
                for (int idx = 0; idx < fireSize; idx++) {
                    Point cur = fire.poll();
                    fireRun(cur);
                }

                int sangSize = sang.size();
                for (int idx = 0; idx < sangSize; idx++) {
                    Point cur = sang.poll();
                    ans = sangRun(cur);
                    if (ans != -1) {
                        break;
                    }
                }
                if (sang.isEmpty() || ans != -1) {
                    break;
                }
            }
            if (ans != -1) {
                sb.append(ans).append("\n");
            } else {
                sb.append("IMPOSSIBLE\n");
            }


        }
        System.out.println(sb);


    }

    private static int sangRun(Point cur) {
        for (int idx = 0; idx < 4; idx++) {
            int nx = cur.row + dx[idx];
            int ny = cur.col + dy[idx];

            //바깥에 도착했다 -> 탈출
            if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
                return cur.time + 1;
            }

            if (map[nx][ny] == '.') {
                map[nx][ny] = '@';
                sang.offer(new Point(nx, ny, cur.time + 1));
            }
        }

        return -1;
    }


    private static void fireRun(Point cur) {
        for (int idx = 0; idx < 4; idx++) {
            int nx = cur.row + dx[idx];
            int ny = cur.col + dy[idx];

            if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;

            if (map[nx][ny] == '.' || map[nx][ny] == '@') {
                map[nx][ny] = '*';
                fire.offer(new Point(nx, ny));
            }
        }
    }

    public static class Point {
        int row;
        int col;

        int time;

        public Point() {

        }

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public Point(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }

    }
}