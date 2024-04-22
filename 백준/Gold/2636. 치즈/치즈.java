import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    static int map[][];
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};

    static int ROW;
    static int COL;


    static int res = 0;

    static int time =0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        ROW = Integer.parseInt(st.nextToken());
        COL = Integer.parseInt(st.nextToken());

        map = new int[ROW][COL];

        //첫 맵 정보
        for (int row = 0; row < ROW; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < COL; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        //1 : 치즈 2: 지워지는 치즈 3: 사이에낀 공기 4 : 공기
        while (true) {
            //치즈가 더이상 없는 경우 이전 값 찍기.
            //종료를위한 셋업
            if (cheese_Empty()) {
                System.out.println(time);
                System.out.println(res);
                break;
            }

            //공기를 바꾸기.
            for (int row = 0; row < ROW; row++) {
                for (int col = 0; col < COL; col++) {
                    if (map[row][col] == 0) {
                        bfs(row, col);
                    }
                }
            }

            //남아있는 치즈가 지워지기전에 체크해두기
            res = cheese_check();

            //치즈 주변 체크해서 지워지는 치즈 체크하기.
            for(int row= 0; row <ROW;row++){
                for(int col =0; col <COL;col++){
                    if(map[row][col] == 1){
                        around(row,col);
                    }
                }
            }

            //치즈 지우기.
            for(int row =0; row <ROW;row++)
            {
                for(int col = 0; col<COL; col++){
                    if(map[row][col] == 2 || map[row][col] == 3 || map[row][col] ==4){
                        map[row][col] = 0;
                    }
                }
            }

            time+=1;

        }


    }

    private static void around(int row, int col) {

        int x = row;
        int y = col;

        for(int idx =0; idx <4;idx++){
            int nx = x+dx[idx];
            int ny = y+dy[idx];

            //외부 공기와 접촉하는 경우 -> 2로 변경
            if(map[nx][ny] == 4){
                map[x][y] = 2;
                break;
            }
        }
    }

    //치즈 개수 세기
    private static int cheese_check(){

        int cnt = 0;

        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                if (map[row][col] == 1) {
                    cnt+=1;
                }
            }
        }
        return cnt;
    }


    //치즈가 더이상 남아있는게 없는지 체크
    private static boolean cheese_Empty() {

        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                if (map[row][col] == 1) {
                    return false;
                }
            }
        }
        return true;
    }


    // 주변 공기 바꾸기
    private static void bfs(int row, int col) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row, col});
        boolean check[][] = new boolean[ROW][COL];
        map[row][col] = 3;
        check[row][col] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int idx = 0; idx < 4; idx++) {
                int nx = x + dx[idx];
                int ny = y + dy[idx];

                //범위를 벗어나는 경우 -> 끝쪽이라 외부 공기임
                //다음 값이 4인경우 -> 외부 공기임.
                if (nx < 0 || nx >= ROW || ny < 0 || ny >= COL || map[nx][ny] == 4) {
                    map[x][y] = 4;
                    continue;
                }

                if (map[nx][ny] == 0 && !check[nx][ny]) {
                    check[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }

}
