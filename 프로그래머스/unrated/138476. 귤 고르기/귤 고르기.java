
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution
{
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        //각 귤 크기별 개수 체크
        for(int idx=0; idx <tangerine.length;idx++){
            map.put(tangerine[idx],map.getOrDefault(tangerine[idx],0)+1);
        }
        //key값을 정렬해서 가지고있음.
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys,(o1,o2)-> (map.get(o2).compareTo(map.get(o1))));
        int sum = 0;
        
        //정렬된 key값을 통해서 map에서 꺼내서 더해준다.
        for(int num : keys){
            sum += map.get(num);
            answer+=1;
            if(sum >= k)
                break;
        }
        return answer;
    }
}