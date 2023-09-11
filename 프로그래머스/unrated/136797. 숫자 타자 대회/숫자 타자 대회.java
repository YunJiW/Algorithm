import java.util.*;

class Solution {

    int[][] cost;
    int[][][] dp;
    int len;
    String nums;

    public int solution(String numbers) {
        int answer = 0;

        initCost();
        len = numbers.length();
        nums = numbers;
        dp = new int[len][10][10];

        for(int i = 0;i < len;i++){
            for(int j =0; j< 10;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        
        return solve(0,4,6);
    }

    //핵심로직
    private int solve(int idx, int left, int right) {
        if(idx == len){
            return 0;
        }

        if(dp[idx][left][right] != -1) return dp[idx][left][right];

        int num = nums.charAt(idx) - '0';
        int ans = Integer.MAX_VALUE;

        if(num != right){
            ans = Math.min(solve(idx+1,num,right)+cost[left][num],ans);
        }

        if(num != left){
            ans = Math.min(solve(idx+1,left,num)+cost[right][num],ans);
        }

        return dp[idx][left][right] = ans;
    }

    //가중치 계산 (핵심)
    private void initCost() {

        cost = new int[10][10];
        //r1 ,c1 idx의 자판 위치
        //r2, c2 choice 자판 위치
        int r1, c1, r2, c2;

        for (int idx = 0; idx < 10; idx++) {
            for (int choice = 0; choice < 10; choice++) {
                if (idx == choice) {
                    cost[idx][choice] = 1;
                    continue;
                }

                if (idx == 0) {
                    r1 = 3;
                    c1 = 1;
                } else {
                    r1 = (idx - 1) / 3;
                    c1 = (idx - 1) % 3;
                }
                if (choice == 0) {
                    r2 = 3;
                    c2 = 1;
                }
                else{
                    r2 = (choice-1)/3;
                    c2 = (choice-1)%3;
                }

                int diffRow = Math.abs(r1- r2);
                int diffCol = Math.abs(c1- c2);
                int min = Math.min(diffRow,diffCol);
                int max = Math.max(diffRow,diffCol);
                int diff = diffRow + diffCol;

                //1밖에 차이가 안나는경우 -> 바로 인접해 있는 경우(대각제외)
                if(diff == 1){
                    cost[idx][choice]= 2;
                }else{
                    cost[idx][choice] = min*3 + (max-min)*2;
                }
            }
        }
    }
}