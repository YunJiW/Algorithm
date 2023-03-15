class Solution {
    public int solution(int slice, int n) {
        int answer = 1;
        int pizza = slice;
        while(true){
            if(pizza / n > 0){
                return answer;
            }else{
                pizza +=slice;
                answer+=1;
            }
        }
    }
}