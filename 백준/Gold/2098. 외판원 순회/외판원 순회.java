import java.io.*;
import java.util.*;


public class Main {

    static int n,statusFullBit,INF=987654321;

    static int[][] w;
    static int [][] dp;

    public static void main(String[] args) throws IOException{

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        //최대 상태 비트 크기
        statusFullBit = (1<<n) -1;


        w = new int[n][n];
        dp = new int[n][statusFullBit];

        for(int idx = 0; idx <n;idx++){
            Arrays.fill(dp[idx],-1);
        }

        for(int idx =0 ;idx <n;idx++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j <n;j++){
                w[idx][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(tsp(0,1));
    }

    private static int tsp(int x, int check) {

        if(check == statusFullBit){
            if(w[x][0] == 0) return INF;
            else return w[x][0];
        }

        //이미 간곳인 경우
        if(dp[x][check] != -1) return dp[x][check];

        dp[x][check] = INF;

        for(int idx = 0; idx <n;idx++){

            int next = check | (1 << idx);

            //경로가 없거나 이미 방문한 경우 넘어감.
            if(w[x][idx] == 0 || ( check &(1<<idx)) != 0)
                continue;

            dp[x][check] = Math.min(dp[x][check],tsp(idx,next) + w[x][idx]);
        }

        return dp[x][check];
    }
}
