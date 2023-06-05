import java.io.*;
import java.util.*;

public class Main {

    static int map[][];

    static boolean visited[][];

    static int N;
    static int M;

    static int dx[] = {0,-1,0,1};
    static int dy[] ={-1,0,1,0};

    static int all_picture = 0;
    static int result = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //전체맵
        map = new int[N][M];
        //방문 여부
        visited = new boolean[N][M];

        for(int row = 0; row <N;row++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int col =0; col <M;col++){
                map[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        for(int row =0; row <N;row++){
            for(int col =0; col <M;col++){
                if(!visited[row][col] && map[row][col] != 0){
                    search_pixel(row,col);

                    all_picture+=1;
                }
            }
        }

        System.out.println(all_picture);
        System.out.println(result);



    }

    private static void search_pixel(int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row,col});
        visited[row][col] = true;

        int sum = 1;
        while(!queue.isEmpty()){
            int cur[] = queue.poll();

            for(int idx =0; idx <4;idx++){
                int nxt_row = cur[0] + dx[idx];
                int nxt_col = cur[1] + dy[idx];

                //범위를 벗어나거나 이미 체크한 경우는 pass 0인경우 pass
                if(nxt_row < 0 || nxt_row >= N || nxt_col < 0 || nxt_col >= M || map[nxt_row][nxt_col] == 0){
                    continue;
                }

                if(!visited[nxt_row][nxt_col]) {
                    visited[nxt_row][nxt_col] = true;
                    queue.offer(new int[]{nxt_row, nxt_col});
                    sum += 1;
                }
            }
        }

        result = Math.max(sum,result);
    }
}
