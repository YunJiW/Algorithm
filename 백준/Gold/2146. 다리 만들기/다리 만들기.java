import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    static int n;
    static boolean check[][];
    static int map[][];

    static Queue<int[]> que;

    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        check = new boolean[n][n];
        que = new LinkedList<>();

        StringTokenizer st = null;

        for (int row = 0; row < n; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < n; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        IsLandCheck();


        //핵심로직 - 최단거리 구하기.
        int min = Integer.MAX_VALUE;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (map[row][col] > 0) {
                    check = new boolean[n][n];

                    int res = bridge(row, col);

                    if (res == -1) continue;
                    if (min > res) {
                        min = res;
                    }
                }
            }
        }

        System.out.println(min - 1);

    }

    private static int bridge(int row, int col) {
        que = new LinkedList<>();

        int IsLandNum = map[row][col];
        check[row][col] = true;
        que.offer(new int[]{row, col, 0});


        while (!que.isEmpty()) {
            int cur[] = que.poll();
            int px = cur[0];
            int py = cur[1];
            int cnt = cur[2];

            if (map[px][py] != 0 && map[px][py] != IsLandNum) {
                return cnt;
            }

            for (int d = 0; d < 4; d++) {
                int nx = px + dx[d];
                int ny = py + dy[d];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }
                if(check[nx][ny] || map[nx][ny] == IsLandNum) {
                    continue;
                }

                check[nx][ny] = true;
                que.offer(new int[]{nx, ny, cnt + 1});
            }
        }
        return -1;

    }

    //각 섬별 번호 바꿔주기.
    private static void IsLandCheck() {
        int index = 2;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (!check[row][col] && map[row][col] != 0) {
                    map[row][col] = index;
                    check[row][col] = true;
                    que.add(new int[]{row, col});

                    while (!que.isEmpty()) {
                        int[] cur = que.poll();
                        int px = cur[0];
                        int py = cur[1];

                        for (int d = 0; d < 4; d++) {
                            int nx = px + dx[d];
                            int ny = py + dy[d];

                            //범위를 벗어나면 넘어가기
                            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;

                            if(check[nx][ny]) continue;

                            if (map[nx][ny] == 1) {
                                check[nx][ny] = true;
                                map[nx][ny] = index;
                                que.offer(new int[]{nx, ny});
                            }
                        }
                    }
                    index += 1;
                }
            }
        }
    }
}
