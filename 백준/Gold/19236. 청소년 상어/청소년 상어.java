import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int[][] map;
    public static Fish[] fish;
    public static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    public static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};

    public static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new int[4][4];
        fish = new Fish[17];//1~16번 물고기

        //주어진 맵과 물고기들을 받아둠.
        for (int row = 0; row < 4; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < 4; col++) {
                int num = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken()) -1;
                fish[num] = new Fish(num, row, col, dir, 1);
                map[row][col] = num;
            }
        }

        int sx = 0, sy = 0; // 처음 상어위치 0,0
        int sd = fish[map[0][0]].dir; //상어의 방향 -> 먹은 물고기의 방향
        int eat = map[0][0]; //먹은 물고기 번호 저장용
        fish[map[0][0]].alive = 0; //먹힌 물고기는 죽은걸로 표시
        map[0][0] = -1; // 상어 위치는 -1로 표기

        dfs(sx, sy, sd, eat);

        System.out.println(ans);

    }

    private static void dfs(int sx, int sy, int sd, int eat) {
        ans = Math.max(ans, eat);

        int copymap[][] = new int[4][4];
        //복사를 통해서 상어 이동 전 상황 저장
        for (int row = 0; row < 4; row++) {
            System.arraycopy(map[row], 0, copymap[row], 0, map.length);
        }

        Fish[] cpyFish = new Fish[fish.length];
        //이전 물고기 상황도 복사해둠.
        for (int idx = 1; idx <= 16; idx++) {
            cpyFish[idx] = new Fish(fish[idx].num, fish[idx].x, fish[idx].y, fish[idx].dir, fish[idx].alive);
        }

        //물고기 이동
        moveFish();

        for (int idx = 1; idx < 4; idx++) {
            int nx = sx + dx[sd] * idx;
            int ny = sy + dy[sd] * idx;

            if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4 && map[nx][ny] != 0) {
                int eatFish = map[nx][ny];
                int nd = fish[eatFish].dir;
                //상어가 있는 곳은 0 다음 이동한 곳에는 -1로 상어 이동 표현
                //먹힌 물고기는 먹힌 것으로 표현
                map[sx][sy] = 0;
                map[nx][ny] = -1;
                fish[eatFish].alive = 0;

                dfs(nx, ny, nd, eat + eatFish);
                //다시 상황 돌려두기
                fish[eatFish].alive = 1;
                map[sx][sy] = -1;
                map[nx][ny] = eatFish;
            }
        }

        //돌려놓기
        for (int i = 0; i < map.length; i++) {
            System.arraycopy(copymap[i], 0, map[i], 0, map.length);
        }

        //돌려놓기
        for (int index = 1; index <= 16; index++) {
            fish[index] = new Fish(cpyFish[index].num, cpyFish[index].x, cpyFish[index].y, cpyFish[index].dir, cpyFish[index].alive);
        }
    }

    private static void moveFish() {
        for (int idx = 1; idx < 17; idx++) {

            //고기가 죽은경우 pass
            if (fish[idx].alive == 0) {
                continue;
            }

            int cnt = 0;
            int dir = fish[idx].dir;
            int nx = 0, ny = 0;

            while (cnt < 8) { // 방향을 돌리면서 갈 수 있는 방향 찾을때까지 반복(반시계)
                dir %= 8;
                fish[idx].dir = dir;

                nx = fish[idx].x + dx[dir];
                ny = fish[idx].y + dy[dir];


                //맵을 벗어나지 않으면서 상어를 만나지 않는 경우만 이동
                if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4 && map[nx][ny] != -1) {
                    if (map[nx][ny] == 0) { //빈칸인 경우 그냥 이동
                        map[fish[idx].x][fish[idx].y] = 0;
                        fish[idx].x = nx;
                        fish[idx].y = ny;
                        map[nx][ny] = idx;

                    }
                    //다른 물고기를 만나는 경우 둘이 자리를 바꿈
                    else {
                        //다른 물고기의 번호 가져오기
                        int changeFish = fish[map[nx][ny]].num;
                        fish[changeFish].x = fish[idx].x;
                        fish[changeFish].y = fish[idx].y;
                        map[fish[changeFish].x][fish[changeFish].y] = changeFish;

                        fish[idx].x = nx;
                        fish[idx].y = ny;
                        map[nx][ny] = idx;
                    }
                    break;
                } else {
                    dir += 1;
                    cnt += 1;
                }
            }
        }
    }


}

class Fish {
    int num;
    int x;
    int y;
    int dir;
    //0 죽음, 1 살음.
    int alive;

    public Fish(int num, int x, int y, int dir, int alive) {
        this.num = num;
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.alive = alive;
    }
}