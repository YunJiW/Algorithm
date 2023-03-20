import java.util.Arrays;
class Solution {
    int MAX =Integer.MAX_VALUE;
    public int solution(int x, int y, int n) {
        int answer = 0;

        int dp[] = new int[y+1];
        Arrays.fill(dp,0);
        for(int idx = x+1;idx <=y;idx++){
            int div2 = MAX;
            int div3 = MAX;
            int minus = MAX;
            
            int checking;
            if((idx /2 >= x) && (idx %2 == 0)){
                div2 = dp[idx/2];
            }
            if((idx/3 >= x) && (idx %3 ==0)){
                div3 = dp[idx/3];
            }
            if(idx- n >= x){
                minus = dp[idx-n];
            }
            
            //각 계산 값중 최소값을 찾는다.
            checking = Math.min(div2,Math.min(div3,minus));
            
            if(checking < MAX){
                dp[idx] = checking+1;
            }else{
                dp[idx] = MAX;
            }
        }
        if(dp[y] < MAX){
            answer = dp[y];
        }else
            answer = -1;

        return answer;
    }
}