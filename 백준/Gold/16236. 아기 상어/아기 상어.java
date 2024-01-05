import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int n, pos_x, pos_y, time = 0, size = 2;
    static int[][] map;

    static boolean[][] check;

    //하,상,우,좌
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];

        StringTokenizer st;

        int start_x = 0;
        int start_y = 0;

        for (int row = 0; row < n; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < n; col++) {
                int num = Integer.parseInt(st.nextToken());
                map[row][col] = num;
                if (num == 9) {
                    start_x = row;
                    start_y = col;
                }
            }
        }

        bfs(start_x, start_y);
        System.out.println(time);

    }

    private static void bfs(int startX, int startY) {

        int cnt =0;
        pos_x = startX;
        pos_y = startY;



        while(true){
            Queue<Fish> q = new LinkedList<>();
            List<Fish> preyList = new ArrayList<>();
            check = new boolean[n][n];

            check[pos_x][pos_y] = true;
            q.add(new Fish(pos_x,pos_y,0));

            //먹이 확인
            while(!q.isEmpty()){
                Fish cur = q.poll();
                int nxtMove = cur.move;

                for(int idx = 0;idx <4;idx++){
                    int nx = cur.x + dx[idx];
                    int ny = cur.y + dy[idx];

                    if(nx <0 || nx >= n || ny < 0 || ny >= n || check[nx][ny])
                        continue;

                    check[nx][ny] = true;
                    if(map[nx][ny] <= size){
                        if(map[nx][ny] != 0 && map[nx][ny] < size){
                            preyList.add(new Fish(nx,ny,nxtMove+1));
                        }
                        q.add(new Fish(nx,ny,nxtMove+1));
                    }
                }
            }
            //먹을 수 있는 먹이가 없는 경우
            if (preyList.isEmpty()){
                break;
            }else{
                if (preyList.size() > 1){
                    Collections.sort(preyList, new Comparator<Fish>() {
                        @Override
                        public int compare(Fish o1, Fish o2) {

                            if(o1.move == o2.move){
                                if(o1.x == o2.x)
                                    return o1.y - o2.y;
                                else{
                                    return o1.x - o2.x;
                                }
                            }else{
                                return o1.move - o2.move;
                            }
                        }
                    });
                }
                Fish eat = preyList.get(0);
                time+= eat.move;
                cnt+=1;

                map[pos_x][pos_y] = 0;
                pos_x = eat.x;
                pos_y = eat.y;
                map[pos_x][pos_y] = 9;

                if(size == cnt){
                    size+=1;
                    cnt=0;
                }
                
            }
        }
    }
}

class Fish {
    int x;
    int y;
    int move;

    public Fish(int x, int y, int move) {
        this.x = x;
        this.y = y;
        this.move = move;
    }
}
