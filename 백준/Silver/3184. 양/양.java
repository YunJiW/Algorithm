import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    static char[][] Map;
    static boolean[][] visited;

    static int Rows;
    static int Cols;

    static int sheep = 0;

    static int wolf = 0;


    //좌 상 우 하
    static int dx[] = {0, -1, 0, 1};
    static int dy[] = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        Rows = Integer.parseInt(st.nextToken());
        Cols = Integer.parseInt(st.nextToken());

        Map = new char[Rows][Cols];
        visited = new boolean[Rows][Cols];

        //주어진 입력에 따른 맵 만들기
        for (int row = 0; row < Rows; row++) {
            String line = br.readLine();
            for (int col = 0; col < Cols; col++) {
                char curPoint = line.charAt(col);
                Map[row][col] = curPoint;
            }
        }

        for (int row = 0; row < Rows; row++) {
            for (int col = 0; col < Cols; col++) {
                if (!visited[row][col] && Map[row][col] != '#') {
                    check(row, col);
                }
            }
        }

        System.out.println(sheep + " " + wolf);
    }

    private static void check(int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row,col});
        int SheepCnt = 0;
        int WolfCnt = 0;
        if(Map[row][col] == 'v'){
            WolfCnt+=1;
        }
        else if(Map[row][col] == 'o'){
            SheepCnt+=1;
        }
        visited[row][col] = true;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();


            for(int idx =0; idx < 4 ;idx++){
                int nxt_row = cur[0] + dx[idx];
                int nxt_col = cur[1] + dy[idx];

                //범위를 벗어나는 경우 pass
                if(nxt_row < 0 || nxt_row >= Rows || nxt_col <0 || nxt_col >=Cols){
                    continue;
                }

                //이미 간곳이거나 막힌길인경우 pass
                if(visited[nxt_row][nxt_col] || Map[nxt_row][nxt_col] == '#'){
                    continue;
                }

                visited[nxt_row][nxt_col] = true;
                queue.offer(new int[]{nxt_row,nxt_col});
                //양 또는 늑대인경우 체크
                if(Map[nxt_row][nxt_col] == 'o'){
                    SheepCnt+=1;
                }else if(Map[nxt_row][nxt_col] == 'v'){
                    WolfCnt+=1;
                }
            }
        }



        //양이 많으면 양 카운터 올리고 그외는 늑대카운트 올리기.
        if(SheepCnt > WolfCnt){
            sheep+=SheepCnt;
        }else{
            wolf+=WolfCnt;
        }


    }
}
