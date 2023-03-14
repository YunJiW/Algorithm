class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        int first_card_idx = 0;
        int second_card_idx =0;
        for(int idx = 0; idx < goal.length;idx++){
            //첫번째 카드에서 idx 위치의 값이 goal과 같은경우
            if(first_card_idx < cards1.length && cards1[first_card_idx].equals(goal[idx])) {
                first_card_idx += 1;
                continue;
            }
            if(second_card_idx < cards2.length && cards2[second_card_idx].equals(goal[idx])){
                second_card_idx +=1;
                continue;
            }
            return "No";

        }
        return answer;
    }
}