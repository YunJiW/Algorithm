import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, d = 0;
    static int map[][];
    static Map<Integer, String> moveInfo;

    //우 하 좌 상
    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        map = new int[n][n];
        moveInfo = new HashMap<>();
        StringTokenizer st = null;

        //사과가 있는 곳은 1로 지정
        for (int idx = 0; idx < k; idx++) {
            st = new StringTokenizer(br.readLine());

            int row = Integer.parseInt(st.nextToken())-1;
            int col = Integer.parseInt(st.nextToken())-1;
            map[row][col] = 1;
        }

        int L = Integer.parseInt(br.readLine());

        //방향변환 저장
        for (int idx = 0; idx < L; idx++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();

            moveInfo.put(time, dir);
        }

        run();


    }

    private static void run() {
        Queue<Integer> snake = new LinkedList<>();
        snake.offer(0);
        int time = 0;
        int px = 0;
        int py = 0;

        while (true) {
            int nx = px + dx[d];
            int ny = py + dy[d];
            time += 1;

            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                break;
            }
            //핵심
            //몸통에 부딪히는 경우 -> 좌표를 일렬로 계산해서 넣어두는 형식
            if (snake.contains(nx * n + ny)) {
                break;
            }

            //사과가 있는 곳을 가는경우
            if (map[nx][ny] == 1) {
                map[nx][ny] = 0;
                snake.offer(nx * n + ny);
            }
            //사과가 없으면 머리이동하고 꼬리 반환
            else {
                snake.offer(nx * n + ny);
                snake.poll();
            }

            //몇초후 방향전환에 현재 시간이 걸리는 경우
            if (moveInfo.containsKey(time)) {
                String changeDir = moveInfo.get(time);
                if (changeDir.equals("D")) {
                    d += 1;
                    if (d == 4) d = 0;
                } else {
                    d -= 1;
                    if (d == -1) d = 3;
                }
            }
            px = nx;
            py = ny;
        }

        System.out.println(time);

    }
}
