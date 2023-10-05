import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    //맵크기 체크
    static int Rows;
    static int Cols;

    //전체 맵 
    //0 : 아무것도없는거
    // 1 : 음식물쓰레기 있는거
    static int Map[][];

    //중복 체크 방지용
    static boolean visited[][];


    //결과값 체크용
    static int result = Integer.MIN_VALUE;

    private static int dx[] = {0, -1, 0, 1};
    private static int dy[] = {-1, 0, 1, 0};

    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        Rows = Integer.parseInt(st.nextToken());
        Cols = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Map = new int[Rows+1][Cols+1];
        visited = new boolean[Rows+1][Cols+1];
        for (int T = 0; T < K; T++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());

            Map[row][col] = 1;
        }

        for (int row = 1; row <= Rows; row++) {
            for (int col = 1; col <= Cols; col++) {
                //방문한적이 없으면서 1인경우만
                if (!visited[row][col] && Map[row][col] == 1) {
                    Size_check(row, col);
                }
            }
        }

        System.out.println(result);

    }

    //음식물 크기 체크
    private static void Size_check(int row, int col) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(row, col));
        visited[row][col] = true;
        int size = 1;
        while(!queue.isEmpty()){
            Point cur = queue.poll();

            for(int idx =0; idx < 4;idx++){
                int nxt_row = cur.row + dx[idx];
                int nxt_col = cur.col + dy[idx];


                if(nxt_row <=0 || nxt_row>Rows || nxt_col <=0 || nxt_col>Cols){
                    continue;
                }

                if(Map[nxt_row][nxt_col] == 0){
                    continue;
                }

                if(!visited[nxt_row][nxt_col]){
                    size+=1;
                    visited[nxt_row][nxt_col] = true;
                    queue.offer(new Point(nxt_row,nxt_col));
                }
            }



        }

        //크기 갱신
        result = Math.max(result,size);
    }

    public static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
