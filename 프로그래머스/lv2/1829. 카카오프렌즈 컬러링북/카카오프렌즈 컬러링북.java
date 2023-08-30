import java.util.*;

class Solution {
    //영역 개수
    int numberOfArea = 0;
    //최대 영역 크기
    int maxSizeOfOneArea = 0;

    //좌 상 우 하
    int dx[] ={0,-1,0,1};
    int dy[] ={-1,0,1,0};

    boolean visited[][];
    int rows;
    int cols;

    int[][] map;
    public int[] solution(int m, int n, int[][] picture) {
        int[] answer = new int[2];

        map = picture;
        rows = m;
        cols = n;

        //중복 체크 방지용
        visited = new boolean[rows][cols];

        for(int row = 0; row < rows;row++){
            for(int col = 0; col< cols; col++){
                //한번도 체크 안됬으면서 색칠이 되어있는 경우
                if(!visited[row][col] && map[row][col] != 0){
                    //현재 위치부터 탐색(색깔을 포함해서)
                    start(row,col,map[row][col]);
                }
            }
        }
        answer[0]= numberOfArea;
        answer[1] = maxSizeOfOneArea;

        return answer;
    }

    private void start(int row, int col, int color) {
        Queue<Color> queue = new LinkedList<>();
        queue.offer(new Color(row,col,color));
        visited[row][col] = true;

        int size = 1;
        while(!queue.isEmpty()){
            Color cur = queue.poll();
            int curColor = cur.color;

            for(int idx = 0; idx < 4; idx++){
                int nt_row = cur.row + dx[idx];
                int nt_col = cur.col + dy[idx];

                //모든 가능성 체크
                if(check(nt_row,nt_col,curColor)) continue;

                queue.offer(new Color(nt_row,nt_col,curColor));
                visited[nt_row][nt_col] = true;
                size+=1;

            }
        }
        //다체크하고 영역 +1
        //가장 큰영역도 체크
        numberOfArea +=1;
        maxSizeOfOneArea = Math.max(maxSizeOfOneArea,size);
    }

    private boolean check(int ntRow, int ntCol, int curColor) {
        //범위를 벗어나는 경우 pass
        if(ntRow < 0 || ntCol < 0 || ntRow >= rows || ntCol >= cols)
            return true;

        //같은색이 아닌경우 pass -> 0 도 포함됨.
        if(map[ntRow][ntCol] != curColor){
            return true;
        }

        //이미 방문한경우 pass
        if(visited[ntRow][ntCol])
            return true;

        return false;
    }

    //위치 및 색깔을 포함하는 Color 클래스
    public class Color{
        int row;
        int col;

        int color;

        public Color(int row, int col, int color){
            this.row = row;
            this.col = col;
            this .color = color;
        }
    }
}