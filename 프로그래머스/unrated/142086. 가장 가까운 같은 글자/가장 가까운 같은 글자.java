import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        HashMap<Character,Integer> map = new HashMap<>();
        
        for(int index =0 ;index <s.length();index++)
        {
            char ch = s.charAt(index);
            if(map.containsKey(ch))
            {
                answer[index] = index - map.get(ch);
                map.put(ch,index);
            }
            else{
                answer[index] = -1;
                map.put(ch,index);
            }
        }
        
        
        
        
        
        return answer;
    }
}