class Solution {

    //각 숫자별 개수 계산
    int[] dp;

    int[] maxList;

    public int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];
        dp = new int[5000001];
        maxList = new int[5000001];
        dp[1] = 1;

        check(e);
        int max = 0;
        int maxaddr =0;
        for(int idx = e; idx >= 0; idx--){
            //약수개수가 max가 더작은경우 갱신
            if(max <= dp[idx]){
                maxaddr = idx;
                max = dp[idx];
            }
            maxList[idx] = maxaddr;

        }

        for(int idx =0; idx <starts.length;idx++){
            answer[idx] = maxList[starts[idx]];
        }

        return answer;
    }

    //약수 개수 구하는 알고리즘
    private void check(int end) {

        for(int i = 2 ; i<=end ; i++){
            for(int j = 1 ; j<=(end/i) ; j++){
                dp[i*j]++;
            }
        }
    }


}