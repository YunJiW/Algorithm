import java.util.*;

class Solution {
    char Map[][];

    int rows;
    int cols;

    int dx[] = {0, -1, 0, 1};
    int dy[] = {-1, 0, 1, 0};

    Point start;

    Point lever;

    Point end;
    boolean visited[][];
    
    

    public int solution(String[] maps) {
        int answer = 0;

        rows = maps.length;
        cols = maps[0].length();
        Map = new char[rows][cols];

        //맵으로 바꿈
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char ch = maps[row].charAt(col);
                Map[row][col] = ch;
                //시작점 체크
                if (ch == 'S') {
                    start = new Point(row, col, 0);
                }
                else if(ch == 'L'){
                    lever = new Point(row,col,0);
                }
                else if(ch == 'E'){
                    end = new Point(row,col,0);
                }
            }
        }


        Point current = BFS(start, 'L');
        //널 반환시 갈수없다는 의미로 -1 을 리턴함.
        if(current == null){
            return -1;
        }
        current = BFS(current,'E');
        
        //마찬가지로 탈출이 불가능하면 -1 리턴
        if(current == null){
            return -1;
        }

        answer = current.cnt;

        return answer;
    }

    private Point BFS(Point start,char endPoint) {
        Queue<Point> queue = new LinkedList<>();
        visited = new boolean[Map.length][Map[0].length];
        queue.offer(start);
        visited[start.row][start.col] = true;
        while(!queue.isEmpty()){
            Point cur = queue.poll();

            if(Map[cur.row][cur.col] == endPoint){
                return cur;
            }

            for(int idx= 0; idx <4;idx++){
                int nxt_row = cur.row + dx[idx];
                int nxt_col = cur.col + dy[idx];

                //범위를 벗어나거나 이미 방문한경우는 pass
                if(nxt_row >= rows || nxt_row < 0 ||nxt_col >= cols || nxt_col < 0 || visited[nxt_row][nxt_col] || Map[nxt_row][nxt_col] == 'X'){
                    continue;
                }

                visited[nxt_row][nxt_col] = true;
                queue.offer(new Point(nxt_row,nxt_col,cur.cnt+1));
            }


        }

        return null;


    }



    class Point {
        int row;
        int col;
        int cnt;

        public Point(int row, int col, int cnt) {
            this.row = row;
            this.col = col;
            this.cnt = cnt;
        }
    }
}