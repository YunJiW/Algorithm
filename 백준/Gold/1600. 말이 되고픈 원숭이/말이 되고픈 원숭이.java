import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


    static int K;
    static int W;
    static int H;

    static int res = Integer.MAX_VALUE;

    //말 움직임시
    static int Hdx[] = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int Hdy[] = {-1, 1, -2, 2, -2, 2, -1, 1};

    //원숭이 기본 움직임.
    static int Mdx[] = {0, 1, 0, -1};
    static int Mdy[] = {1, 0, -1, 0};


    static int Map[][];
    static boolean visited[][][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        Map = new int[H][W];

        for (int row = 0; row < H; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < W; col++) {
                Map[row][col] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[H][W][K + 1];
        res = bfs(0, 0);


        if (res == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(res);
    }

    private static int bfs(int row, int col) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(row,col,0,0));
        visited[row][col][0] = true;

        while(!queue.isEmpty()){
            Node cur = queue.poll();

            if(cur.row == H-1 && cur.col == W-1 )
                return cur.cnt;
            
            //원숭이 기본 움직임
            for(int idx = 0; idx < 4 ;idx++){
                int nx = cur.row + Mdx[idx];
                int ny = cur.col + Mdy[idx];
                if(nx >= 0 && nx < H && ny >= 0 && ny < W && !visited[nx][ny][cur.k] && Map[nx][ny] == 0){
                    visited[nx][ny][cur.k] = true;
                    queue.offer(new Node(nx,ny,cur.cnt+1,cur.k));
                }
                
            }
            
            //말의 움직임이 남았을 경우
            if(cur.k < K){

                for(int idx= 0; idx <8;idx++){
                    int nx = cur.row + Hdx[idx];
                    int ny = cur.col + Hdy[idx];

                    if(nx >= 0 && nx < H && ny >= 0 && ny < W && !visited[nx][ny][cur.k + 1] && Map[nx][ny] == 0){
                        visited[nx][ny][cur.k+1] = true;
                        queue.offer(new Node(nx,ny,cur.cnt+1,cur.k +1));
                    }

                }
                
            }
        }

        return res;
    }

    private static class Node{
        int row;
        int col;
        int cnt;
        int k;

        public Node(int row, int col, int cnt, int k) {
            this.row = row;
            this.col = col;
            this.cnt = cnt;
            this.k = k;
        }
    }
}
