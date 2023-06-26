//dp 비교 -> 점화식 Math.max(dp[idx-1],dp[idx]+dp[idx-2]) 이전값을 가져가던가 아니면 이전값을 제외한 값을 더하던가
class Solution {
    public int solution(int sticker[]) {
        int answer = 0;

        //스티커가 1개 일경우
        if(sticker.length == 1){
            return sticker[0];
        }

        int dp1[] = new int[sticker.length];
        int dp2[] = new int[sticker.length];

        //첫번째 스티커를 떼는 경우
        dp1[0] = sticker[0];
        dp1[1] = sticker[0];
        for(int idx = 2; idx <sticker.length-1;idx++){
            dp1[idx] = Math.max(dp1[idx-1],sticker[idx]+dp1[idx-2]);
        }

        //두번째 스티커를 떼는 경우
        dp2[0]= 0;
        dp2[1] = sticker[1];
        for(int idx = 2; idx <sticker.length;idx++){
            dp2[idx] = Math.max(dp2[idx-1],sticker[idx]+dp2[idx-2]);
        }

        answer = Math.max(dp1[sticker.length-2],dp2[sticker.length-1]);
        return answer;
    }
}