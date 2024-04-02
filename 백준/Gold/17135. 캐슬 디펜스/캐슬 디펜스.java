import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


//브루트포스 + 조합
public class Main {

    static int N, M, D;
    static int Map[][];
    static int copyMap[][];

    static int res;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        Map = new int[N + 1][M + 1];
        copyMap = new int[N + 1][M + 1];

        for (int row = 1; row <= N; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 1; col <= M; col++) {
                Map[row][col] = Integer.parseInt(st.nextToken());
                copyMap[row][col] = Map[row][col];
            }
        }

        ArrayList<Integer> archer = new ArrayList<>();
        res = 0;

        comb(1, M, 3, archer);

        System.out.println(res);

        br.close();

    }

    //원래 모습으로 변경
    public static void init() {

        for (int row = 1; row <= N; row++) {
            for (int col = 1; col <= M; col++) {
                Map[row][col] = copyMap[row][col];
            }
        }
    }

    public static int distance(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }

    //완탐 계산
    public static void comb(int start, int n, int r, ArrayList<Integer> archer) {
        if (r == 0) {
            init();
            attack(archer);
            return;
        }

        //조합
        for(int idx = start; idx <=n;idx++){
            archer.add(idx);
            comb(idx+1,n,r-1,archer);
            archer.remove(archer.size()-1);

        }
    }

    private static void attack(ArrayList<Integer> archer) {
        int ans = 0;

        for (int n = 1; n <= N; n++) {
            boolean visited[][] = new boolean[N + 1][M + 1];
            for (int k = 0; k < archer.size(); k++) {
                int tmp = archer.get(k);
                int minD = Integer.MAX_VALUE; // 최소 거리
                int minR = Integer.MAX_VALUE; //최소 y좌표
                int minC = Integer.MAX_VALUE; //최소 x 좌표


                //맵 전체 탐색하고 최단거리 계산
                for (int row = 1; row <= N; row++) {
                    for (int col = 1; col <= M; col++) {
                        if (Map[row][col] == 1) {
                            if (minD >= distance(row, col, N + 1, tmp)) {

                                if (minD > distance(row, col, N + 1, tmp)) {
                                    minD = distance(row, col, N + 1, tmp);
                                    minR = row;
                                    minC = col;
                                } else {
                                    if (minC > col) {
                                        minC = col;
                                        minR = row;
                                    }
                                }
                            }
                        }

                    }
                }

                if (minD <= D) {
                    visited[minR][minC] = true;
                }
            }

            for (int row = 1; row <= N; row++) {
                for (int col = 1; col <= M; col++) {
                    if (visited[row][col]) {
                        Map[row][col] = 0;
                        ans += 1;
                    }
                }
            }

            //성바로 윗줄은 궁수 공격다음에 전부 제외되기때문
            for (int idx = 1; idx <= M; idx++) {
                Map[N][idx] = 0;
            }

            for (int row = N; row >= 1; row--) {
                for (int col = 1; col <= M; col++) {
                    Map[row][col] = Map[row-1][col];
                }
            }


        }
        res= Math.max(res,ans);
    }
}