class Solution {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        while(n > 0){
            int divNum = n % 3;
            if(divNum == 1){
               answer.insert(0,"1");
            }else if(divNum == 2){
                answer.insert(0,"2");
            }else if(divNum == 0){
                answer.insert(0,"4");
            }

            if(divNum == 0){
                n -=1;
            }
            n /=3;
        }
        return answer.toString();
    }
}