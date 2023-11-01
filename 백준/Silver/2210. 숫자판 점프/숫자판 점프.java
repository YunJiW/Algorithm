import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    static int map[][] = new int[5][5];

    static int dx[] = {0, -1, 0, 1};
    static int dy[] = {-1, 0, 1, 0};
    static HashSet<Integer> result = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //숫자판을 받아둔다.
        for (int row = 0; row < 5; row++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int col = 0; col < 5; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());
            }
        }


        for(int row =0; row <5;row++){
            for(int col = 0;col <5;col++){
                dfs(0,row,col,map[row][col]);
            }
        }


        System.out.println(result.size());


    }

    private static void dfs(int depth, int row, int col, int sum) {
        if(depth == 5){
            result.add(sum);
            return;
        }

        for(int idx = 0; idx <4;idx++){
            int nxt_row = row+dx[idx];
            int nxt_col = col +dy[idx];

            if(nxt_row >= 0 && nxt_row <5 && nxt_col >=0 && nxt_col<5){
                dfs(depth+1,nxt_row,nxt_col,sum*10 + map[nxt_row][nxt_col]);
            }
        }
    }
}
