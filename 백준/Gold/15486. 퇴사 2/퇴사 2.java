import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N  = Integer.parseInt(br.readLine());
        int dp[] = new int[N+1];

        day_money[] All_day = new day_money[N+1];

        StringTokenizer st;
        for(int idx = 0; idx <N;idx++){
            st = new StringTokenizer(br.readLine());
            int t_day= Integer.parseInt(st.nextToken());
            int p_money = Integer.parseInt(st.nextToken());

            All_day[idx] = new day_money(t_day,p_money);
        }

        for(int idx = 0; idx <N;idx++){
            if(idx + All_day[idx].getT() <= N){
                dp[idx + All_day[idx].getT()]
                        = Math.max(dp[idx+All_day[idx].getT()],dp[idx] +All_day[idx].getP());
            }

            dp[idx+1] = Math.max(dp[idx+1],dp[idx]);
        }

        System.out.println(dp[N]);




    }

    static class day_money{
        private int t;
        private int p;

        day_money(int t, int p){
            this.t = t;
            this.p = p;
        }

        public int getT(){
            return t;
        }

        public int getP()
        {
            return p;
        }
    }
}
