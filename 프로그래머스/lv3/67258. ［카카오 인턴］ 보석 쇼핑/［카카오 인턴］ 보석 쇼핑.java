import java.util.HashSet;
import java.util.HashMap;

import java.util.Queue;
import java.util.LinkedList;


class Solution
 {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        

        HashSet<String> jewel = new HashSet<>();
        //시작지점,끝나는지점, 차이값 저장용
        HashMap<String,Integer> jewels = new HashMap<>();

        
        //모아야하는 보석 총 개수용
        for(int index = 0; index <gems.length;index++){
            jewel.add(gems[index]);
        }
        
        int start = 0;
        int change_start = 0;
        int len = gems.length;


        //구간체크
        Queue<String> que = new LinkedList<>();
        for(int index =0 ;index < gems.length;index++)
        {
            jewels.put(gems[index],jewels.getOrDefault(gems[index],0)+1);
            que.offer(gems[index]);

            while(true){
                String gem = que.peek();
                //가지고있는 같은 종류의 보석이 1개보다 많을 경우
                //앞의 나온 보석을 버리고 start를 바꾼다.
                if(jewels.get(gem) > 1){
                    jewels.put(gem,jewels.get(gem)-1);
                    que.poll();
                    change_start+=1;

                //아닐경우 종료
                }else break;
            }

            if(jewel.size() == jewels.size() && len > que.size()){
                len = que.size();
                start = change_start;
            }

        }
        answer[0] = start+1;
        answer[1] = start+len; 
        return answer;
    }
}