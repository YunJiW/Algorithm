import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {


    static int N, M, O;

    static ArrayList<position> lists = new ArrayList<>();



    static int dx[] ={-1,1,0,0};
    static int dy[] ={0,0,-1,1};

    static int curX,curY,curC;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        O = Integer.parseInt(st.nextToken());

        int [][]map = new int[N][N];
        for(int row = 0; row <N;row++){
            st = new StringTokenizer(br.readLine());
            for(int col = 0; col<N;col++){
                map[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        //택시 현재 위치
        curX = Integer.parseInt(st.nextToken())-1;
        curY = Integer.parseInt(st.nextToken())-1;

        for(int idx = 2;idx <M+2;idx++){
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken())-1;
            int sy = Integer.parseInt(st.nextToken())-1;
            int ex = Integer.parseInt(st.nextToken())-1;
            int ey = Integer.parseInt(st.nextToken())-1;

            map[sx][sy] = idx;
            lists.add(new position(ex,ey,0));
        }

        int cnt = 0;

        while(cnt < M){
            int tmp = searchPerson(N,map);

            if(O - tmp <=0 || tmp == -1){
                System.out.println(-1);
                return;
            }
            
            int tmp2 = searchGoal(N,map);
            if(O - (tmp + tmp2) < 0 || tmp2 == -1){
                System.out.println(-1);
                return;
            }else{
                O+= tmp2 - tmp;
            }
            cnt+=1;
        }

        if(cnt == M){
            System.out.println(O);
        }
    }

    private static int searchGoal(int N,int[][] map) {
        PriorityQueue<position> pq = new PriorityQueue<>();

        boolean visited[][] = new boolean[N][N];
        pq.add(new position(curX,curY,0));
        visited[curX][curY] = true;

        //번호가 2칸씩 밀려있기 때문에 -2를 해서 원래 값 찾아오기
        int gx = lists.get(curC-2).x;
        int gy = lists.get(curC-2).y;
        while(!pq.isEmpty()){
            position cur = pq.poll();
            if(cur.x == gx && cur.y == gy){
                curX =gx;
                curY =gy;
                return cur.value;
            }

            for(int idx = 0; idx < 4; idx++){
                int nxtX = cur.x + dx[idx];
                int nxtY = cur.y + dy[idx];
                if(nxtX >= 0 && nxtX< N && nxtY >= 0 && nxtY < N && !visited[nxtX][nxtY] && map[nxtX][nxtY] != 1){
                    visited[nxtX][nxtY] = true;
                    pq.add(new position(nxtX,nxtY,cur.value+1));
                }

            }

        }
        return -1;
    }

    //최단거리 고객 찾기
    private static int searchPerson(int N,int[][] map) {
        PriorityQueue<position> pq = new PriorityQueue<>();

        boolean visited[][] = new boolean[N][N];
        pq.add(new position(curX,curY,0));
        visited[curX][curY] = true;

        while(!pq.isEmpty()){
            position cur = pq.poll();
            
            //최단거리 고객 만난경우
            if(map[cur.x][cur.y] > 1){
                curC = map[cur.x][cur.y];
                curX = cur.x;
                curY = cur.y;
                map[curX][curY] = 0;
                return cur.value;
            }

            for(int idx = 0; idx < 4; idx++){
                int nxtX = cur.x + dx[idx];
                int nxtY = cur.y + dy[idx];
                if(nxtX >= 0 && nxtX< N && nxtY >= 0 && nxtY < N  && !visited[nxtX][nxtY] && map[nxtX][nxtY] != 1){
                    visited[nxtX][nxtY] = true;
                    pq.add(new position(nxtX,nxtY,cur.value+1));
                }
                
            }
        }
        return -1;
    }


    static class position implements Comparable<position> {
        int x, y, value;

        public position(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        @Override
        public int compareTo(position o) {
            if (this.value == o.value) {
                if (this.x == o.x) {
                    return this.y - o.y;
                } else {
                    return this.x - o.x;
                }

            }


            return this.value - o.value;
        }
    }
}
