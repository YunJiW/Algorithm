import java.util.*;
class Solution {


    public int solution(int n, int[][] results) {
        int answer = 0;

        int record[][] = new int[n+1][n+1];

        for(int idx = 0; idx < results.length;idx++){
            int winner = results[idx][0];
            int loser = results[idx][1];

            record[winner][loser] = 1;
            record[loser][winner] = -1;
        }

        for(int i=1; i<=n;i++){
            for(int j=1; j<=n;j++){
                for(int k=1;k<=n;k++){
                    if(record[i][k] == 1 && record[k][j] == 1){
                        record[i][j] = 1;
                        record[j][i] = -1;
                    }
                    if(record[i][k] == -1 && record[k][j] == -1){
                        record[i][j] = -1;
                        record[j][i] = 1;
                    }
                }
            }
        }

        for(int idx =1; idx <=n;idx++){
            int cnt = 0;
            for(int j=1;j<=n;j++){
                if(record[idx][j] != 0)
                    cnt+=1;
            }
            if(cnt == n-1) answer+=1;
        }


        return answer;

    }
}