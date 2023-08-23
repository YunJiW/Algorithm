import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];

        Map<String,String> parentMap = new HashMap<>();
        Map<String,Integer> memberIndexMap = new HashMap<>();

        for(int idx =0 ; idx < enroll.length;idx++){
            parentMap.put(enroll[idx],referral[idx]);
            memberIndexMap.put(enroll[idx],idx);
        }

        for(int idx = 0; idx <seller.length;idx++){

            //현재 내가 누군지 그리고 판매 이익
            String now = seller[idx];
            int profit = amount[idx] *100;
            
            //최상위 추천인까지 반복 진행
            while(!now.equals("-")){
                int distribute = profit/10;
                int nowprofit = profit - distribute;

                answer[memberIndexMap.get(now)] += nowprofit;

                now = parentMap.get(now);
                profit = distribute;

                if(profit < 1){
                    break;
                }
            }
            
            
        }

        return answer;
    }
}