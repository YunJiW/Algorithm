import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int memory[] = new int[n];
        int cost[] = new int[n];

        int [][] dp = new int[n][100001];

        StringTokenizer memoryToken = new StringTokenizer(br.readLine());
        StringTokenizer costToken = new StringTokenizer(br.readLine());


        for(int idx = 0; idx <n;idx++){
            memory[idx] = Integer.parseInt(memoryToken.nextToken());
            cost[idx] = Integer.parseInt(costToken.nextToken());
        }

        int res = Integer.MAX_VALUE;
        for(int appnum = 0; appnum <n;appnum++){
            int curCost = cost[appnum];
            int curMemory = memory[appnum];


            for(int check = 0; check<=10000;check++){

                if(appnum == 0){
                    if(check >= curCost) dp[appnum][check] = curMemory;

                }else{
                    if(check >= curCost){
                        dp[appnum][check] = Math.max(dp[appnum-1][check - curCost] +curMemory,dp[appnum-1][check]);

                    }else{
                        dp[appnum][check] = dp[appnum-1][check];
                    }
                }

                if(dp[appnum][check] >= m){
                    res = Math.min(res,check);
                }
            }
        }
        System.out.println(res);

    }
}
