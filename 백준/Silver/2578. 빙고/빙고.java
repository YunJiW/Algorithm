import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    static int map[][];
    static boolean check[][];

    static int bingo = 0;

    //좌 상 우 하

    static int dx[] = {0,-1,0,1};
    static int dy[] ={-1,0,1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new int[5][5];
        check = new boolean[5][5];

        StringTokenizer st;

        //빙고판 채우기.
        for (int row = 0; row < 5; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < 5; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());
            }

        }

        for (int row = 0; row < 5; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < 5; col++) {
                //사회가 부르는 숫자.
                int num = Integer.parseInt(st.nextToken());
                run(num);
                //빙고판 지우기
                bingo_check();


                if (bingo >= 3) {
                    System.out.println((row * 5) + (col + 1));
                    return;
                }
                bingo =0;
            }


        }

    }
    private static void run(int num) {

        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                if (map[row][col] == num) {
                    check[row][col] = true;
                    return;
                }
            }
        }
    }

    private static void bingo_check() {
        
        row();
        
        col();
        
        diag1();

        diag2();
    }


    private static void col() {
        for(int col =0; col <5;col++){
            int cnt = 0;
            for(int row = 0; row <5; row++){
                if(check[row][col]){
                    cnt+=1;
                }
                if(cnt == 5){
                    bingo+=1;
                }
            }
        }
    }

    private static void row() {
        for(int row = 0; row < 5;row++){
            int cnt = 0;
            for(int col = 0; col <5; col++){
                if(check[row][col])
                    cnt+=1;
                if(cnt == 5){
                    bingo+=1;
                }
            }
        }
    }

    private static void diag1() {
        int cnt = 0;

        for(int index = 0; index <5;index++){
            if(check[index][index]){
                cnt+=1;
            }
            if(cnt == 5){
                bingo+=1;
            }
        }
    }


    private static void diag2() {
        int cnt = 0;

        for(int index = 0; index <5;index++){
            if(check[index][4-index]){
                cnt+=1;
            }
            if(cnt == 5){
                bingo+=1;
            }
        }
    }

}
