import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    static int map[][];

    /**
     * 배열의 각 숫자의 종이 개수 저장용
     * <p>
     * 0 : -1
     * 1 : 0
     * 2 : 1
     */
    static int paper[] = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        map = new int[N][N];


        for (int row = 0; row < N; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < N; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        PaperCheck(0, 0, N);


        System.out.print(paper[0] + "\n" + paper[1] + "\n" + paper[2]);
    }

    //종이 개수 확인
    private static void PaperCheck(int row, int col, int n) {

        if (CheckPaper(row, col, n)) {
            switch (map[row][col]) {
                case -1:
                    paper[0] += 1;
                    break;
                case 0:
                    paper[1] += 1;
                    break;
                case 1:
                    paper[2] += 1;
                    break;
            }

            return;
        }
        int newSize = n / 3;

        PaperCheck(row, col, newSize);
        PaperCheck(row, col + newSize, newSize);
        PaperCheck(row, col + 2 * newSize , newSize);



        PaperCheck(row + newSize, col, newSize);
        PaperCheck(row + newSize, col + newSize, newSize);
        PaperCheck(row + newSize, col + newSize * 2, newSize);

        PaperCheck(row + newSize * 2, col, newSize);
        PaperCheck(row + newSize * 2, col + newSize, newSize);
        PaperCheck(row + newSize * 2, col + newSize * 2, newSize);

    }

    //현재 구역이 같은 종이 부분인지 확인용
    private static boolean CheckPaper(int row, int col, int n) {
        int color = map[row][col];

        for (int x = row; x < row + n; x++) {

            for (int y = col; y < col + n; y++) {
                if (map[x][y] != color) {
                    return false;
                }
            }

        }


        return true;
    }
}
