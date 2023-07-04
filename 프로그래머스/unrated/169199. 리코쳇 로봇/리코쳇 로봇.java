import java.util.*;
class Solution {
    int result = Integer.MAX_VALUE;

    char Map[][];

    int rows;
    int cols;
    Point goal;
    Point Robot;

    int[] dx ={0,-1,0,1};
    int[] dy = {-1,0,1,0};

    boolean visited[][];

    public int solution(String[] board) {
        int answer = Integer.MAX_VALUE;
        rows = board.length;
        cols = board[0].length();

        Map = new char[rows][cols];
        visited = new boolean[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                Map[row][col] = board[row].charAt(col);
                //목표지점 체크
                if (board[row].charAt(col) == 'G') {
                    goal = new Point(row,col,0);
                    //로봇 위치 체크
                } else if (board[row].charAt(col) == 'R') {
                    Robot = new Point(row,col,0);
                }

            }
        }
        answer = Start(goal,Robot);

        return answer;
    }

    private int Start(Point goal, Point robot) {
        Queue<Point> que = new LinkedList<>();
        que.offer(robot);
        visited[robot.row][robot.col] = true;
        while(!que.isEmpty()){
            Point cur = que.poll();

            //현재 위치가 goal인경우 return
            if(cur.row == goal.row && cur.col == goal.col){
                return cur.count;
            }

            for(int idx =0; idx <4; idx++){
                int nxt_row = cur.row + dx[idx];
                int nxt_col = cur.col + dy[idx];

                //벽또는 장애물을 만날때까지 진행
                while(nxt_row >= 0 && nxt_row < rows && nxt_col >= 0 && nxt_col < cols && Map[nxt_row][nxt_col] != 'D'){
                    nxt_row += dx[idx];
                    nxt_col += dy[idx];
                }

                nxt_row -= dx[idx];
                nxt_col -= dy[idx];

                //이미 방문했는 경우 제외
                if(visited[nxt_row][nxt_col])
                    continue;

                visited[nxt_row][nxt_col] = true;
                que.offer(new Point(nxt_row,nxt_col,cur.count+1));
            }

        }



        return -1;
    }

    static class Point {
        int row;
        int col;

        int count;

        public Point(int row, int col, int count){
            this.row = row;
            this.col = col;
            this.count =count;
        }
    }
}