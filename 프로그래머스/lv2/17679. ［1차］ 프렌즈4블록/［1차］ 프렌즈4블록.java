import java.util.*;
class Solution {

    static boolean visited[][];

    int Row;
    int Col;

    public int solution(int m, int n, String[] board) {
        int answer = 0;

        char map[][] = new char[m][n];
        Row = m;
        Col = n;
        for(int idx = 0; idx <board.length;idx++){
            map[idx] = board[idx].toCharArray();
        }

        boolean isErase = true;

        //지워지는게 있는 경우
        while(isErase){
            visited = new boolean[m][n];
            isErase = false;

            for(int row = 0; row <m;row++){
                for(int col = 0; col <n;col++){
                    //지워졌을경우 pass
                    if(map[row][col] == '#') continue;
                    if(check(row,col,map)){
                        visited[row][col] = true;
                        visited[row][col+1] = true;
                        visited[row+1][col] = true;
                        visited[row+1][col+1] = true;
                        isErase = true;
                    }
                }
            }
            answer += erase(m,n,map);
        }
        return answer;
    }

    //주변의 모양이 같은지 체크
    private boolean check(int row, int col, char[][] map) {
        char cur = map[row][col];
        if(row+1 >= Row || col+1 >= Col){
            return false;
        }

        if(cur == map[row][col+1] && cur == map[row+1][col] && cur == map[row+1][col+1]){
            return true;
        }
        return false;
    }


    public int erase(int rows, int cols, char map[][]){
        int cnt =0;
        //없어지는 조건에 만족하는 것들 찾아서 .으로 바꿔둔다.
        for(int row = 0; row < rows;row++){
            for(int col = 0; col <cols;col++){
                if(visited[row][col]){
                    map[row][col] = '.';
                }
            }
        }

        for(int col = 0; col <cols;col++){
            Queue<Character> que = new LinkedList<>();
            for(int row = rows-1; row >= 0; row--){
                if(map[row][col] == '.'){
                    cnt +=1;
                }else{
                    que.offer(map[row][col]);
                }
            }
            int idx = rows -1;
            while(!que.isEmpty()){
                map[idx--][col] = que.poll();
            }
            //빈부분 #으로 채워주기
            for(int row = idx; row >= 0; row--){
                map[row][col] = '#';
            }
        }
        return cnt;
    }
}
