import java.util.*;
import java.io.*;

public class Main {

    static int R;
    static int C;
    static Point start;
    static Point end;

    static int K;

    static char Map[][];

    static boolean visited[][];
    static int result = 0;

    static int dx[]={0,-1,0,1};
    static int dy[]={-1,0,1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        start = new Point(R,1);
        end = new Point(1,C);

        Map = new char[R+1][C+1];
        visited = new boolean[R+1][C+1];

        for(int row = 1; row <=R;row++){
            String line = br.readLine();
            for(int col =1; col <= C;col++){
                Map[row][col] = line.charAt(col-1);
            }
        }

        visited[start.row][start.col] = true;
        Check(1,start);

        System.out.println(result);
    }



    private static void Check(int count,Point cur) {
        //K인경우 현재 좌표가 도착하는 좌표인경우 result+=1
        //아닌경우 pass
        if(count == K){
            if(cur.row == end.row && cur.col == end.col){
                result +=1;
            }
            return;
        }

        //4방향 전부 체크
        for(int idx =0; idx <4;idx++){
            int nxt_row = cur.row +dx[idx];
            int nxt_col = cur.col +dy[idx];

            //범위를 벗어나는 경우는 pass
            if(nxt_row <= 0 || nxt_row > R || nxt_col <= 0 || nxt_col > C || Map[nxt_row][nxt_col] == 'T')
                continue;

            if(!visited[nxt_row][nxt_col]){
                visited[nxt_row][nxt_col] = true;
                Check(count+1,new Point(nxt_row,nxt_col));
                visited[nxt_row][nxt_col] = false;
            }
        }
    }


    public static class Point{
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
