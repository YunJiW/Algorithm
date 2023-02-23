class Solution {
    public String solution(int n) {
        String answer = "";
        
        //홀수 -> 수
        //짝수 -> 박
        for(int idx = 1; idx <=n;idx++){
            if(idx % 2== 1){
                answer+="수";
            }else
                answer+="박";
        }
        return answer;
    }
}