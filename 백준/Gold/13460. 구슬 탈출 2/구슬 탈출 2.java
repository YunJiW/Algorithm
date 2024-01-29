import java.io.*;
import java.util.*;

public class Main {

    static int N,M;
    static char[][] map;

    static boolean[][][][] visited;

    static int holeX,holeY;

    //상,우,하,좌
    static int dx[] ={-1,0,1,0};
    static int dy[] ={0,1,0,-1};

    static Marble Red;

    static Marble Blue;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M][N][M];

        for(int row =0; row <N;row++){
            String line = br.readLine() ;
            for(int col = 0; col<M;col++){
                map[row][col] = line.charAt(col);

                //홀 위치 체크
                if(map[row][col] == 'O'){
                    holeX = row;
                    holeY = col;
                }else if(map[row][col] == 'R'){
                    Red = new Marble(row,col,0,0,0);
                }else if(map[row][col] == 'B'){
                    Blue = new Marble(0,0,row,col,0);
                }
            }
        }
        System.out.println(bfs());


        br.close();
    }

    private static int bfs() {
        Queue<Marble> queue = new LinkedList<>();
        queue.add(new Marble(Red.rx,Red.ry, Blue.bx, Blue.by, 1));
        visited[Red.rx][Red.ry][Blue.bx][Blue.by] = true;

        while(!queue.isEmpty()){
            Marble marble = queue.poll();

            int curRx = marble.rx;
            int curRy = marble.ry;
            int curBx = marble.bx;
            int curBy = marble.by;
            int curCnt = marble.cnt;

            if(curCnt > 10){
                return -1;
            }

            for(int idx = 0; idx <4;idx++){
                int newRx = curRx;
                int newRy = curRy;
                int newBx = curBx;
                int newBy = curBy;

                //각 공이 홀에 들어갔는지 체크용.
                boolean isRedHole = false;
                boolean isBlueHole = false;


                while(map[newRx +dx[idx]][newRy + dy[idx]] != '#'){
                    newRx +=dx[idx];
                    newRy +=dy[idx];

                    if(newRx == holeX && newRy == holeY){
                        isRedHole = true;
                        break;
                    }
                }

                while(map[newBx +dx[idx]][newBy + dy[idx]] != '#'){
                    newBx +=dx[idx];
                    newBy +=dy[idx];

                    if(newBx == holeX && newBy == holeY){
                        isBlueHole = true;
                        break;
                    }
                }

                if(isBlueHole){
                    continue;
                }
                if(isRedHole && !isBlueHole){
                    return curCnt;
                }

                if(newRx == newBx && newRy == newBy){
                    //상
                    if(idx ==0){
                        if(curRx > curBx){
                            newRx -= dx[idx];

                        }else{
                            newBx -=dx[idx];
                        }
                        //우
                    }else if(idx ==1){
                        if(curRy <curBy){
                            newRy -= dy[idx];
                        }else{
                            newBy -=dy[idx];
                        }
                        //하
                    }else if(idx == 2){
                        if(curRx < curBx){
                            newRx-=dx[idx];
                        }else{
                            newBx-=dx[idx];
                        }
                        //좌
                    }else{
                        if(curRy> curBy){
                            newRy -= dy[idx];
                        }else{
                            newBy -=dy[idx];
                        }
                    }
                }

                if(!visited[newRx][newRy][newBx][newBy]){
                    visited[newRx][newRy][newBx][newBy] = true;
                    queue.add(new Marble(newRx,newRy,newBx,newBy,curCnt+1));
                }

            }
        }

        return -1;
    }

}
class Marble{
    int rx;
    int ry;
    int bx;
    int by;
    int cnt;

    public Marble(int rx, int ry, int bx, int by, int cnt) {
        this.rx = rx;
        this.ry = ry;
        this.bx = bx;
        this.by = by;
        this.cnt = cnt;
    }
}
