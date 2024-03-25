import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int L;

    static int map[][];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int row = 0; row < N; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < N; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        int res = 0;
        for (int idx = 0; idx < N; idx++) {
            if (checkRow(idx)) res += 1;
            if (checkCol(idx)) res += 1;
        }

        System.out.println(res);


    }

    private static boolean checkRow(int col) {
        boolean isCheck[] = new boolean[N];


        for (int idx = 0; idx < N - 1; idx++) {
            int diff = map[idx][col] - map[idx + 1][col];


            if (diff > 1 || diff < -1) return false;
                //다음 번호가 값이 높은 경우
            else if (diff == -1) {
                for (int i = 0; i < L; i++) {
                    //설치할 길이가 안나오거나 이미 설치가 되있는 경우
                    if (idx - i < 0 || isCheck[idx - i]) return false;
                    if (map[idx][col] != map[idx - i][col]) return false;
                    isCheck[idx - i] = true;
                }
            }
            //낮은 경우
            else if (diff == 1) {
                for (int i = 1; i <= L; i++) {
                    //범위를 벗어나거나 이미 설치가 된 경우
                    if (idx + i >= N || isCheck[idx + i]) return false;
                    if (map[idx][col] - 1 != map[idx + i][col]) return false;
                    isCheck[idx + i] = true;
                }
            }
        }


        return true;

    }

    private static boolean checkCol(int row) {

        boolean isCheck[] = new boolean[N];

        for (int idx = 0; idx < N - 1; idx++) {
            int diff = map[row][idx] - map[row][idx + 1];

            if (diff > 1 || diff < -1) {
                return false;
            } else if (diff == -1) {
                for (int i = 0; i < L; i++) {
                    //설치할 길이가 안나오거나 이미 설치가 되있는 경우
                    if (idx - i < 0 || isCheck[idx - i]) return false;
                    if (map[row][idx] != map[row][idx - i]) return false;
                    isCheck[idx - i] = true;
                }
            }
            //낮은 경우
            else if (diff == 1) {
                for (int i = 1; i <= L; i++) {
                    //범위를 벗어나거나 이미 설치가 된 경우
                    if (idx + i >= N || isCheck[idx + i]) return false;
                    if (map[row][idx] - 1 != map[row][idx + i]) return false;
                    isCheck[idx + i] = true;
                }
            }


        }


        return true;
    }
}