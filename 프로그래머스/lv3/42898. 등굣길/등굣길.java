class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int dp[][] = new int[m+1][n+1];
        boolean possible[][] = new boolean[m+1][n+1];
        
        //물웅덩이 먼저 체크
        for(int row = 0; row < puddles.length;row++){
            
            int rows = puddles[row][0];
            int cols = puddles[row][1];
            possible[rows][cols] = true; 
        }
        //물웅덩이로 집의 옆과 아래가 막힐경우 갈방법이없음.
        if(possible[1][2] && possible[2][1]){
            return 0;
        }

        for(int index = 1;index<=n;index++)
        {
            if(!possible[1][index])
                dp[1][index] = 1;
            else
                break;

        }
        for(int index = 1;index<=m;index++)
        {
            if(!possible[index][1])
                dp[index][1] = 1;
            else
                break;

        }

        for(int rows =2; rows <=m; rows++){

            for(int cols =2; cols <=n;cols++){

                if(!possible[rows-1][cols]){

                    dp[rows][cols] += (dp[rows-1][cols] % 1000000007);

                }
                if(!possible[rows][cols-1]){

                    dp[rows][cols] += (dp[rows][cols-1] % 1000000007);

                }
                dp[rows][cols] %= 1000000007;
            }
        }
        
        
        return dp[m][n];
    }
}