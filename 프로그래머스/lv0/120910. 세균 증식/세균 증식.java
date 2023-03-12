class Solution {
    public int solution(int n, int t) {
        int answer = n;
        for(int idx = 0; idx <t ;idx++){
            answer *= 2 ;
        }
        return answer;
    }
}