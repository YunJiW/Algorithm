import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int Rows;
    static int Cols;
    static int M;

    static Shark Map[][];

    static int res = 0;


    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, -1, 0, 1};


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        Rows = Integer.parseInt(st.nextToken());
        Cols = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Map = new Shark[Rows][Cols];

        //상어 위치 파악용.
        int numbering = 1;

        //상어들 받아두기.
        for (int idx = 0; idx < M; idx++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            if (d == 1) {
                d = 0;
            } else if (d == 4) {
                d = 1;
            }

            Map[r-1][c-1] = new Shark(r-1,c-1,s,d,z);

        }

        for (int idx = 0; idx < Cols; idx++) {
            select(idx);
            move();
        }

        System.out.println(res);

    }

    //이동(살아있는 상어들 움직이기)
    //핵심로직
    private static void move() {

        //상어 전부 옮기기
        Queue<Shark> que = new LinkedList<>();
        for(int row = 0; row <Rows;row++){
            for(int col =0; col< Cols;col++){
                if(Map[row][col] != null){
                    que.offer(new Shark(row,col,Map[row][col].speed,Map[row][col].dir,Map[row][col].size));
                }
            }
        }

        Map = new Shark[Rows][Cols];

        while(!que.isEmpty()){

            Shark cur = que.poll();

            int speed = cur.speed;

            if(cur.dir == 0 || cur.dir == 2)
                speed %= (Rows-1)*2;
            else if(cur.dir == 1 || cur.dir ==3)
                speed %=(Cols-1)*2;

            for(int s = 0; s<speed;s++){
                int nxtR = cur.row + dx[cur.dir];
                int nxtC = cur.col + dy[cur.dir];

                //맵을 넘어가는 경우 방향을 바꾸고 값을 다시 돌려놓음.
                if(nxtR < 0 || nxtR >= Rows || nxtC < 0 || nxtC >= Cols)
                {
                    cur.row -= dx[cur.dir];
                    cur.col -= dy[cur.dir];
                    cur.dir = (cur.dir + 2) %4;
                    continue;
                }

                //이동
                cur.row = nxtR;
                cur.col = nxtC;
            }

            //이동이 끝난후 위치에 상어가 있는 경우
            if(Map[cur.row][cur.col] != null){
                if(Map[cur.row][cur.col].size < cur.size){
                    Map[cur.row][cur.col] = new Shark(cur.row,cur.col,cur.speed,cur.dir,cur.size);
                }
            }else{
                Map[cur.row][cur.col] = new Shark(cur.row,cur.col,cur.speed,cur.dir,cur.size);
            }
        }

    }

    //위치기준 계산만 필요함.
    //낚시왕의 열에 속한 것들중 땅에 가까운 놈 찾기.
    private static void select(int col) {

        for (int row = 0; row < Rows; row++) {
            if(Map[row][col] != null){
                res += Map[row][col].size;
                Map[row][col] = null;
                return;
            }
        }

    }


    /**
     * row : 행
     * col : 열
     * speed : 속력
     * dir : 방향
     * size : 크기
     */
    public static class Shark {

        int row;
        int col;

        int speed;

        int dir;

        int size;


        public Shark(int row, int col, int speed, int dir, int size) {
            this.row = row;
            this.col = col;
            this.speed = speed;
            this.dir = dir;
            this.size = size;
        }
    }


}

