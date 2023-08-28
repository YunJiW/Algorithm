class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int deliver = 0;
        int pickup = 0;

        for(int house = n-1; house >=0; house--){
            int cnt = 0;
            //몇번 가야하는지 체크
            while(deliver < deliveries[house] || pickup < pickups[house]){
                cnt+=1;
                deliver += cap;
                pickup += cap;
            }
            deliver -= deliveries[house];
            pickup -= pickups[house];
            //몇번째 집을 몇번 방문하는지 + 왕복
            answer+= (house+1) * cnt * 2;
        }
        return answer;
    }
}