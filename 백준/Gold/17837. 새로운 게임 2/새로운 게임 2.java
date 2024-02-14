import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static class Horse {
        int x;
        int y;
        int d;

        public Horse(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    static int N, K, nx, ny, nd;
    static int[][] map, dir = {{0, 0}, {0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    static Horse[] horses;
    static ArrayList<Integer>[][] build;

    static int[] change_dir = {0, 2, 1, 4, 3};
    static Deque<Integer> dq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        //전체 맵
        map = new int[N][N];
        //말위치 체크용
        build = new ArrayList[N][N];

        for (int row = 0; row < N; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < N; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());
                build[row][col] = new ArrayList<>();
            }
        }
        horses = new Horse[K + 1];

        //각 위치의 말들 정보 받기
        for (int idx = 1; idx <= K; idx++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken())-1;
            int col = Integer.parseInt(st.nextToken())-1;
            int dir = Integer.parseInt(st.nextToken());

            horses[idx] = new Horse(row, col, dir);
            build[row][col].add(idx);
        }

        int turn = 0;

       Out: while (true) {
            turn += 1;

            //번호순으로 말 이동 진행
            for (int i = 1; i <= K; i++) {
                Horse h = horses[i];
                int idx = -1;
                int size = build[h.x][h.y].size();

                //몇번째 말인지 체크-> 그다음에 쌓인애들은 같이 움직이니까.
                for(int j =0; j < size; j++){
                    if(build[h.x][h.y].get(j) == i){
                        idx = j;
                        break;
                    }
                }

                dq = new ArrayDeque<>();

                for(int j= idx; j < size;j++){
                    dq.offer(build[h.x][h.y].get(j));
                }

                for(int j = idx; j <size;j++){
                    build[h.x][h.y].remove(idx);
                }

                nx = h.x + dir[h.d][0];
                ny= h.y + dir[h.d][1];
                nd= h.d;
                
                //범위를 벗어나거나 파랑색을 만나는 경우
                //방향 변경 및 한칸 이동
                if(!inside(nx,ny) ||map[nx][ny] == 2)
                {
                    nd = change_dir[h.d];
                    nx += (dir[nd][0]*2);
                    ny += (dir[nd][1]*2);
                }

                //다음 움직인 부분이 범위를 벗어나거나 파란색인경우
                //그자리 그대로
                if(!inside(nx,ny) || map[nx][ny] == 2){
                    nx -= dir[nd][0];
                    ny -= dir[nd][1];
                    while(!dq.isEmpty()){
                        build[nx][ny].add(dq.poll());
                    }
                }else if(map[nx][ny] == 0){
                    while(!dq.isEmpty()){
                        build[nx][ny].add(dq.poll());
                    }
                    //빨간색은 반대로 쌓기 때문에 반대로 뽑기.
                }else if(map[nx][ny] == 1){
                    while(!dq.isEmpty()){
                        build[nx][ny].add(dq.pollLast());
                    }
                }
                //while을 라벨을 줘서 바로 break가 되게하기
                if(build[nx][ny].size() >= 4 || turn > 1000) break Out;

                for(int j = 0; j <build[nx][ny].size();j++){
                    int hn = build[nx][ny].get(j);
                    Horse oi = horses[hn];
                    if(hn == i) horses[hn] = new Horse(nx,ny,nd);
                    else horses[hn] = new Horse(nx,ny,oi.d);
                }
            }

        }
        if(turn > 1000) System.out.println(-1);
        else System.out.println(turn);

        br.close();
    }

    private static boolean inside(int x, int y) {
        return x >= 0 && x <N &&  y >= 0 && y < N;
    }
}
