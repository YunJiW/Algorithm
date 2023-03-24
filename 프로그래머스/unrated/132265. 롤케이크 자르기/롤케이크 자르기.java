import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;

        HashMap<Integer,Integer> All = new HashMap<>();

        for(int index = 0; index <topping.length;index++){
            All.put(topping[index],All.getOrDefault(topping[index],0)+
                    1);
        }

        //철수가 가지는 토핑개수
        HashSet<Integer> chel = new HashSet<>();
        for(int start = 0; start <topping.length;start++){
            chel.add(topping[start]);
            
            All.put(topping[start],All.get(topping[start])-1);
            if(All.get(topping[start]) == 0){
                All.remove(topping[start]);
            }

            if(chel.size() == All.size())
                answer+=1;
        }

        return answer;
    }
}