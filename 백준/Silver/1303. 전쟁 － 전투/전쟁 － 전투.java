import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static char map[][];

    static int Rows;
    static int Cols;

    static boolean visited[][];

    static int Power;

    static int enemy;

    static int dx[] ={0,-1,0,1};
    static int dy[] ={-1,0,1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        Cols = Integer.parseInt(st.nextToken());
        Rows = Integer.parseInt(st.nextToken());

        map = new char[Rows][Cols];
        visited = new boolean[Rows][Cols];

        for(int row =0; row <Rows;row++){
            String line = br.readLine();
            for(int col = 0; col < Cols;col++){
                map[row][col] = line.charAt(col);

            }
        }

        for(int row =0; row <Rows;row++){
            for(int col = 0; col < Cols;col++){
                if(!visited[row][col]){
                    //처음 시작하는 곳이 누구팀인지 체크와 어디좌표인지 보냄.
                    Start(map[row][col],row,col);
                }
            }
        }
        System.out.println(Power + " " + enemy);
    }

    private static void Start(char Color, int row, int col) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(Color,row,col));
        visited[row][col] = true;
        int count = 1;

        while(!queue.isEmpty()){
            Point cur = queue.poll();

            for(int idx = 0; idx <4;idx++){
                int nxt_row = cur.row + dx[idx];
                int nxt_col = cur.col + dy[idx];

                //범위를 벗어나는 경우 제외
                if(nxt_row < 0 ||  nxt_row >= Rows || nxt_col < 0 || nxt_col >=Cols){
                    continue;
                }

                //중복체크가 되었거나 색깔이 다른경우 제외.
                if(cur.color != map[nxt_row][nxt_col] || visited[nxt_row][nxt_col]){
                    continue;
                }

                visited[nxt_row][nxt_col] = true;
                count+=1;
                queue.offer(new Point(map[nxt_row][nxt_col],nxt_row,nxt_col));

            }


        }


        if(Color == 'W'){
            Power += Math.pow(count,2);
        }
        else{
            enemy += Math.pow(count,2);
        }
    }


    static class Point{
        char color;
        int row;
        int col;

        public Point(char color, int row, int col) {
            this.color = color;
            this.row = row;
            this.col = col;
        }
    }
}
