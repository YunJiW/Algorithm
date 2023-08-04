import java.util.*;


class Solution {
    public int[] solution(long begin, long end) {

        int size = (int) (end - begin);
        int[] answer = new int[size + 1];

        for (int start = (int)begin; start <= (int)end; start++) {
            int index = (int)(start - begin);
            answer[index] = check(start);

        }
        return answer;
    }

    //공약수 구하기
    private int check(int start) {
        if(start == 1){
            return 0;
        }
        List<Integer> lists = new ArrayList<>();
        for(int idx = 2; idx <= Math.sqrt(start);idx++){
            if(start ==idx){
                continue;

            }

            if(start % idx == 0){
                lists.add(idx);
                //나눈 값이 천만보다 작은 경우 -> 최대 값임. -> 천만보다 크면 어쩌피 아웃임.
                if(start / idx <=10000000){
                    return start/idx;
                }
            }
        }

        if(!lists.isEmpty()){
            return lists.get(lists.size()-1);
        }

        //1로만 나눠지는 경우 -> 소수인 경우
        return 1;

    }
}