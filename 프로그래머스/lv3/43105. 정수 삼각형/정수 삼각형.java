class Solution
{
    public static int solution(int[][] triangle) {
        int answer = 0;

        int height = triangle.length;

        int dp[][] = new int[height][height];
        for(int index = 0; index < height;index++){
            dp[height-1][index] = triangle[height-1][index];
        }

        for(int index = height-2;index >=0;index--){
            for(int round = 0; round <= index; round++){
                dp[index][round] = Math.max(dp[index+1][round],dp[index+1][round+1])+triangle[index][round];
            }
        }


        answer = dp[0][0];



        return answer;
    }
    
}