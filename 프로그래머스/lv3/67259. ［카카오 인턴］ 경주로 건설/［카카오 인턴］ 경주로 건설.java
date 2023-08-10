import java.util.*;

import java.util.*;

class Solution {

    int[][] maps;
    int rows;
    int cols;

    //좌,상,우,하
    int dx[] = {0, -1, 0, 1};
    int dy[] = {-1, 0, 1, 0};


    //비용체크용
    int cost = Integer.MAX_VALUE;

    boolean visited[][][];


    public int solution(int[][] board) {
        maps = board;
        rows = maps.length;
        cols = maps[0].length;
        visited = new boolean[rows][cols][4];


        BFS(0, 0);

        return cost;
    }

    public void BFS(int row, int col) {
        Queue<road> queue = new LinkedList<>();
        //방향은 현재 아직 정해지지않았기때문에 0으로 지정
        //좌,상,우,하 로 진행해보자

        queue.offer(new road(row, col, 5,0));


        while (!queue.isEmpty()) {
            road cur = queue.poll();

            //목적지 도달시
            if (cur.row == rows - 1 && cur.col == cols - 1) {
                cost = Math.min(cost, cur.costs);
            }


            for (int idx = 0; idx < 4; idx++) {
                int nxt_row = cur.row + dx[idx];
                int nxt_col = cur.col + dy[idx];



                //범위를 벗어나는경우는 제외
                if (nxt_row < 0 || nxt_col < 0 || nxt_row >= rows || nxt_col >= cols) {
                    continue;
                }

                //벽일경우만 pass
                if (maps[nxt_row][nxt_col] == 1) {
                    continue;
                }

                int nxt_price = cur.costs;

                if (cur.direction == 5 || cur.direction == idx) {
                    nxt_price +=100;
                }else {
                    nxt_price +=600;
                }

                if(!visited[nxt_row][nxt_col][idx] || maps[nxt_row][nxt_col] >= nxt_price){
                    queue.offer(new road(nxt_row,nxt_col,idx,nxt_price));
                    visited[nxt_row][nxt_col][idx] = true;
                    maps[nxt_row][nxt_col] = nxt_price;
                }
            }
        }

    }


    public class road {
        int row;
        int col;

        //전체 값 체크용도
        int costs=0;

        //방향 체크 (코너가 만들어지는지 체크하기 위해서)
        int direction;


        public road(int row, int col, int direction,int costs) {
            this.row = row;
            this.col = col;
            this.direction = direction;
            this.costs = costs;
        }
    }
}