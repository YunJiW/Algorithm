import java.util.*;
class Solution {

    int INF = 999999999;

    public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {

        int road[][] = new int[n+1][n+1];

        for(int idx = 0; idx <edge_list.length;idx++){
            int first = edge_list[idx][0];
            int second = edge_list[idx][1];
            road[first][second] = 1;
            road[second][first] = 1;
        }

        int[][] dp = new int[k][n+1];
        for(int idx = 0; idx <k;idx++){
            for(int j = 0; j<=n;j++){
                dp[idx][j] = INF;
            }
        }

        dp[0][gps_log[0]] = 0;

        for(int idx = 1; idx <k;idx++){
            for(int j = 1; j <n+1;j++){

                dp[idx][j] = Math.min(dp[idx][j],dp[idx-1][j]);
                for(int node =1 ; node <n+1;node++){
                    //연결이 되있는지 체크
                    if(road[j][node] == 1){
                        //j로 가는 모든 경우 확인
                        dp[idx][j] = Math.min(dp[idx][j],dp[idx-1][node]);
                    }
                }
                //정보오류가 발생시
                if(j != gps_log[idx]){
                    dp[idx][j]++;
                }
            }
        }

        if(dp[k-1][gps_log[k-1]] < INF){
            return dp[k-1][gps_log[k-1]];
        }
        else{
            return -1;
        }

    }
}