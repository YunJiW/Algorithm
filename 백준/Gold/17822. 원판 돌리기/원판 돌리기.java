import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static int N, M, T;
    static int circle[][];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        circle = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                int num = Integer.parseInt(st.nextToken());
                circle[i][j] = num;
            }
        }

        //T만큼 변환 및 인접 숫자 삭제 Or 각 원판 평균 구해서 크면 원판의 각 값이-1 작으면 +1 해주기
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            rotate(x, d, k);
            erase();
        }

        int res = 0;
        for(int i = 1; i<=N;i++){
            for(int j =1 ;j<=M;j++){
                if(circle[i][j] != -1)
                    res+=circle[i][j];
            }
        }
        System.out.println(res);
    }

    private static void rotate(int x, int d, int k) {

        int num = x;
        // 0 : 시계 1 : 반시계
        if (d == 0) {
            //x의 배수 원판 변환하기
            while (num <= N) {
                int tmp[] = new int[M + 1];
                for (int idx = 1; idx <= M; idx++) {
                    //M보다크면 한바퀴 돌아서 계산해야함.
                    int next = idx + k > M ? idx + k - M : idx + k;
                    tmp[next] = circle[num][idx];
                }
                for (int idx = 1; idx <= M; idx++) {
                    circle[num][idx] = tmp[idx];
                }
                num += x;

            }

            //반시계 회전
        } else {
            while (num <= N) {
                int tmp[] = new int[M + 1];
                for (int idx = M; idx >= 1; idx--) {
                    //M보다크면 한바퀴 돌아서 계산해야함.
                    int next = idx - k > 0 ? idx - k : idx - k + M;
                    tmp[next] = circle[num][idx];
                }
                //옮겨진 값을 다시 넣어줌.
                for (int idx = 1; idx <= M; idx++) {
                    circle[num][idx] = tmp[idx];
                }
                num += x;

            }
        }

    }

    private static void erase() {
        boolean check[][] = new boolean[N+1][M+1];

        for(int i =1; i <=N;i++) {
            for(int j = 1; j<=M;j++){
                //수가 없는경우는 넘어감.
                if(circle[i][j] == -1) continue;

                //좌
                int left = (j-1) > 0 ? j-1 : M;
                if(circle[i][j] == circle[i][left]){
                    check[i][j] = true;
                    check[i][left] = true;
                }
                
                //우
                int right = (j+1) % M;
                if(circle[i][j] == circle[i][right]){
                    check[i][j] =true;
                    check[i][right] = true;
                }
                //상
                int up = i+1;
                if(up <=N){
                    if(circle[i][j] == circle[up][j]){
                        check[i][j] = true;
                        check[up][j] = true;
                    }
                }
                //하
                int down = i-1;
                if(down > 0){
                    if(circle[i][j] == circle[down][j]){
                        check[i][j] = true;
                        check[down][j] = true;
                    }
                }

            }
        }


        boolean isErase = false;
        int sum = 0;
        int cnt= 0;

        for(int i = 1; i <=N;i++){
            for(int j =1;j<=M;j++){


                if(check[i][j]){
                    isErase = true;
                    circle[i][j] = -1;
                }else{
                    if(circle[i][j] != -1){
                        sum += circle[i][j];
                        cnt+=1;
                    }
                }
            }
        }

        //삭제된게 있으면 끝
        if(isErase)
            return;
        
        //삭제되는게 없는 경우 -> 평균값 계산 후 원판에 평균값보다 큰건 -1 작은건 +1 진행
        double avg = (double) sum /(double) cnt;

        for(int i = 1; i <=N;i++){
            for(int j = 1; j<=M;j++){
                if(circle[i][j] == -1) continue;

                if(circle[i][j] > avg){
                    circle[i][j] -=1;
                }
                else if(circle[i][j] < avg){
                    circle[i][j]+=1;
                }
            }
        }

    }

}
