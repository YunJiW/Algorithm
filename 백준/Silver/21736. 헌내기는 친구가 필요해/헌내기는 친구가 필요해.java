import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * O : 빈공간
 * X : 벽
 * I : 도연이
 * P : 사람
 * 
 * 벽은 못뚫고감
 */
public class Main {

    static int N;
    static int M;

    //전체 맵
    static char Map[][];
    //방문 여부
    static boolean visited[][];

    static int dx[] ={0,-1,0,1};
    static int dy[] ={-1,0,1,0};

    static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Map = new char[N][M];
        visited = new boolean[N][M];

        Point me = new Point();
        for(int row = 0; row <N;row++){
            String s = br.readLine();
            for(int col = 0; col <M;col++){
                char index = s.charAt(col);
                Map[row][col] = index;
                if(index == 'I'){
                    me.row = row;
                    me.col = col;
                }

            }
        }
        start(me);




        if(result != 0)
            System.out.println(result);
        else
            System.out.println("TT");
    }

    private static void start(Point me) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(me);
        visited[me.row][me.col] = true;
        while (!queue.isEmpty()){
            Point cur = queue.poll();

            for(int idx = 0; idx <4;idx++)
            {
                int nxt_row = cur.row + dx[idx];
                int nxt_col = cur.col + dy[idx];

                //이미 방문했거나 벽이거나 맵을 벗어나는 경우 제외
                if(nxt_row < 0 || nxt_row >=N || nxt_col <0 || nxt_col >= M || Map[nxt_row][nxt_col] == 'X' || visited[nxt_row][nxt_col]){
                    continue;
                }
                if(Map[nxt_row][nxt_col] == 'P')
                    result+=1;

                visited[nxt_row][nxt_col] = true;
                queue.offer(new Point(nxt_row,nxt_col));

            }
        }
    }

    static class Point{
        int row;
        int col;
        public Point() {
        }

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
