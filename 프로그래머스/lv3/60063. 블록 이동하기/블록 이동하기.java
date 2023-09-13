import java.util.*;
class Solution {

    private int result = Integer.MAX_VALUE;

    private int map[][];

    int N;

    //상 하 좌 우
    int dx[] = {-1, 1, 0, 0};
    int dy[] = {0, 0, -1, 1};

    //회전 2가지
    //좌표 기준은 왼쪽 과 위쪽좌표를 기준으로 한다.
    int rx[][] = {{-1, 0, -1, 0}, {0, 0, 1, 1}};

    int ry[][] = {{0, 0, 1, 1}, {-1, 0, -1, 0}};


    private boolean visited[][][];


    public int solution(int[][] board) {
        map = board;
        N = board.length;
        //가로 세로모양인지, 맵크기
        visited = new boolean[2][N][N];

        //로봇 출발
        Start(0, 0, 0, 0);
        return result;
    }


    private void Start(int x, int y, int dir, int sec) {
        Queue<Robot> queue = new LinkedList<>();
        queue.offer(new Robot(x, y, dir, sec));
        visited[dir][x][y] = true;

        while (!queue.isEmpty()) {
            Robot cur = queue.poll();
            //가로 기준 도달
            if (cur.dir == 0 && cur.x == N - 1 && cur.y == N - 2) {
                result = Math.min(result, cur.sec);
                continue;
                //세로 기준 도달
            } else if (cur.dir == 1 && cur.x == N - 2 && cur.y == N - 1) {
                result = Math.min(result, cur.sec);
                continue;
            }

            //상하 좌우 이동
            for (int idx = 0; idx < 4; idx++) {
                int nx = cur.x + dx[idx];
                int ny = cur.y + dy[idx];

                //이동이 가능한지 체크
                if (!canMove(nx, ny, cur.dir)) continue;
                
                //간적없는 경우 체크
                if(!visited[cur.dir][nx][ny]){
                    queue.offer(new Robot(nx,ny,cur.dir,cur.sec+1));
                    visited[cur.dir][nx][ny] = true;
                }
            }
            //회전도 4가지 존재 -> 왼쪽 좌표기준 2가지 오른쪽 기준 2가지
            for(int idx = 0; idx <4; idx++){
                int nx = cur.x + rx[cur.dir][idx];
                int ny = cur.y + ry[cur.dir][idx];

                //가로기준 상하 움직이면 가능
                int cx = cur.x + dx[idx%2];
                int cy = cur.y + dy[idx%2];

                //세로 기준 좌우 움직일수 있으면 가능
                if(cur.dir == 1){
                    cx = cur.x + dx[idx <2? idx+2 : idx];
                    cy = cur.y + dy[idx <2? idx+2 : idx];

                }

                //Xor 연산
                int ndir = cur.dir^1;
                if (!canMove(nx, ny,  ndir) || !canMove(cx,cy,cur.dir)) continue;

                if(!visited[ndir][nx][ny]){
                    queue.offer(new Robot(nx,ny,ndir,cur.sec+1));
                    visited[ndir][nx][ny] = true;
                }
            }
        }

    }

    private boolean canMove(int nx, int ny, int dir) {
        //공통적으로 맵의 범위를 벗어나는 경우
        if (nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] != 0) {
            return false;
        }

        //가로 모양인경우 체크
        if (dir == 0) {
            if (ny + 1 >= N || map[nx][ny + 1] != 0) {
                return false;
            }

            //세로모양인경우 체크
        } else {
            if (nx + 1 >= N || map[nx + 1][ny] != 0) {
                return false;
            }

        }
        return true;
    }

    private class Robot {
        int x;
        int y;

        int dir;

        //걸린시간
        int sec;

        public Robot(int leftRow, int leftCol, int dir, int sec) {
            this.x = leftRow;
            this.y = leftCol;
            this.dir = dir;
            this.sec = sec;
        }
    }
}