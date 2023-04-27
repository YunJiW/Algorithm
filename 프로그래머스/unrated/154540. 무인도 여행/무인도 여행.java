import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;



class Solution {

    int map[][];

    boolean visited[][];

    PriorityQueue<Integer> island = new PriorityQueue<>();

    int N;
    int M;

    int dx[] = {0,-1,0,1};
    int dy[] = {-1,0,1,0};

    public int[] solution(String[] maps) {

        N = maps.length;
        M = maps[0].length();


        map = new int[N][M];
        visited= new boolean[N][M];

        for (int row = 0; row < N; row++) {

            for(int col = 0; col < M; col++){
                char ch = maps[row].charAt(col);
                if(ch == 'X'){
                    continue;
                }
                map[row][col] = ch - '0' ;
            }
        }

        for(int row =0 ; row < N;row++)
        {
            for(int col = 0; col <M;col++){
                if(!visited[row][col] && map[row][col] != 0){
                    checkIslandSize(row,col);
                }
            }
        }

        if(island.isEmpty()){
            return new int[]{-1};
        }
        int answer[] = new int[island.size()];
        for(int idx=0;idx <answer.length;idx++){
            answer[idx]= island.poll();
        }

        return answer;
    }

    private void checkIslandSize(int row, int col) {
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{row,col});
        visited[row][col] = true;
        int size = 0;
        size += map[row][col];

        while(!que.isEmpty()){
            int[] cur = que.poll();

            for(int idx =0; idx < 4;idx++){
                int nt_row = cur[0] + dx[idx];
                int nt_col = cur[1] + dy[idx];

                //범위를 벗어나거나 이미 방문한경우 갈수 없는경우 제외
                if(nt_row < 0 || nt_row >= N || nt_col < 0 || nt_col >= M || visited[nt_row][nt_col] || map[nt_row][nt_col] == 0)
                    continue;

                if(!visited[nt_row][nt_col]){
                    visited[nt_row][nt_col] = true;
                    size+= map[nt_row][nt_col];
                    que.offer(new int[]{nt_row,nt_col});
                }
            }

        }


        //현재 Island가 존재하면 넣기
        island.offer(size);
    }
}