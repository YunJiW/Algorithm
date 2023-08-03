class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        //최악의 시간으로 먼저 해둔다.
        long answer = (long)(10e9 * 2 *10e5 * 2);
        int cityLength = g.length;
        long start = 0;
        long end = answer;
        
        //핵심 로직
        while(start <= end){
            long mid = (start + end) /2;
            int gold = 0;
            int silver = 0;
            int add = 0;

            for(int idx =0; idx <cityLength;idx++){
                int curGold = g[idx];
                int curSilver = s[idx];
                int curWeight = w[idx];
                int curTime = t[idx];

                long move = mid /(curTime *2);
                //마지막 한번더 가야하는 경우
                if(mid %(curTime*2) >= t[idx]){
                    move+=1;
                }

                gold += Math.min(curGold, move * curWeight);
                silver += Math.min(curSilver,move*curWeight);

                add +=Math.min(curGold+curSilver, move * curWeight);
            }

            //조건을 만족하는 경우 answer 와 값을 비교해서 작은 값으로 갱신 end를 낮춤 (최소의 시간을 구하기 위해서)
            if(a <= gold && b <= silver && a + b <= add){
                end = mid -1;
                answer = Math.min(mid, answer);
                continue;
            }

            start = mid +1;

        }


        return answer;
    }
}