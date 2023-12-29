import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    
    //각 종이의 개수
    static int[] paper = {0, 5, 5, 5, 5, 5};

    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        map = new int[10][10];

        for (int row = 0; row < map.length; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < map[row].length; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());
            }
        }


        DFS(0,0,0);

        if(ans == Integer.MAX_VALUE){
            ans = -1;
        }

        System.out.println(ans);
    }


    //색종이가 붙일수 있는지 확인하는 함수
    public static boolean isAttach(int rows, int cols, int size) {
        for (int row = rows; row < rows + size; row++) {
            for (int col = cols; col < cols + size; col++) {
                //맵을 벗어나는 경우 붙일 수 없음.
                if (row < 0 || row >= 10 || col < 0 || col >= 10) {
                    return false;
                }

                //1이 아닌경우 붙일 수 없음.
                if(map[row][col] != 1){
                    return false;
                }
            }
        }
        return true;
    }


    //색종이 붙이는 함수
    public static void attach(int rows, int cols, int size, int state){

        for(int row = rows ; row < rows+size; row++ ){
            for(int col = cols;col <cols+size;col++){
                map[row][col] = state;
            }
        }
    }


    //최소인지 체크하는 것과 탐색함수
    //핵심로직
    public static void DFS(int row,int col, int cnt){
        //도달시 정답과 현재 cnt 비교해서 작은것으로 갱신
        if(row >=9 && col > 9){
            ans = Math.min(ans,cnt);
            return;
        }

        //최소를 구하는 거기 때문에 현재 정답보다 큰 경우 제외됨.
        if(ans <= cnt){
            return;
        }

        //밑으로 이동
        if(col > 9){
            DFS(row+1,0,cnt);
            return;
        }

        if(map[row][col] == 1){
            for(int i = 5; i >= 1; i--){
                if(paper[i] > 0 && isAttach(row,col,i)){
                    attach(row,col,i,0);
                    paper[i]--;
                    DFS(row,col+1,cnt+1);
                    attach(row,col,i,1);
                    paper[i]++;
                }
            }
        }else{
            DFS(row,col+1,cnt);
        }
    }
    
}
