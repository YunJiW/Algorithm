import java.util.*;

class Solution {
        public int solution(int n, int s, int a, int b, int[][] fares) {
            int[][] node = new int[n+1][n+1];
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    node[i][j] = 20000001;
                }
                node[i][i]= 0;
            }

            for(int idx = 0; idx < fares.length;idx++){
                node[fares[idx][0]][fares[idx][1]] = fares[idx][2];
                node[fares[idx][1]][fares[idx][0]] = fares[idx][2];
            }

            for(int k = 1; k<= n;k++){
                for(int i=1;i<=n;i++) {
                    for(int j =1; j<=n;j++) {
                        if(node[i][j] > node[i][k] + node[k][j]){
                            node[i][j] = node[i][k] + node[k][j];
                        }
                    }
                }
            }

            int min = Integer.MAX_VALUE;
            for(int idx =1; idx <=n;idx++){
                min =Math.min(min,node[s][idx] + node[idx][a] + node[idx][b]);
            }
            return min;


        }
}