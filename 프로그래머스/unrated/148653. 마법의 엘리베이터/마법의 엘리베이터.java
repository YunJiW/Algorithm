class Solution {
    public int solution(int storey) {
        int answer = 0;

        //문자열로 변환
        String num = String.valueOf(storey);

        boolean plus = false;
        for(int idx= num.length()-1;idx >=0;idx--){
            int number;
            int nxt_number = 0;
            if(plus) {
                number = (num.charAt(idx) - '0') +1;
                if(number == 10 && idx -1 < 0){
                    answer+=1;
                    continue;
                }if(number == 10)
                {
                    plus= true;
                    continue;
                }
            }else{
                number = num.charAt(idx) - '0';
            }


            if(idx-1 >=0){
                nxt_number = num.charAt(idx-1)-'0';
            }


            if(number < 5){
                answer+=number;
                plus =false;
                //5이면서 가장 앞자리수가 아닌경우
            }else if(number == 5){
                if(nxt_number > 4){
                    plus=true;

                }else{
                    plus= false;
                }
                answer+=5;
            }
            else{
                plus = true;
                if(idx -1 >=0){
                    answer= answer +Math.abs(number -10) ;
                }
                else{
                    answer= answer +Math.abs(number -10) +1;
                }

            }
        }

        return answer;
    }
}