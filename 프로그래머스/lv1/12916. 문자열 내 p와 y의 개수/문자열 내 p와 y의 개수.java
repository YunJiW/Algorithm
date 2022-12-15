
import java.util.HashMap;
class Solution {
    boolean solution(String s) {
        s = s.toLowerCase();
         boolean answer = true;       
        HashMap<Character,Integer> Map = new HashMap<>();
        
        for(int index =0; index <s.length();index++)
        {
            char ch = s.charAt(index);
            if(ch =='p' || ch =='y')
                Map.put(ch,Map.getOrDefault(ch,0)+1);
        }
        if(Map.isEmpty())
            return answer;
        
        if(Map.containsKey('p') && Map.containsKey('y'))
        {
            if(Map.get('p').equals(Map.get('y')))
                ;
            else
                answer =false;
        }
        else
            answer = false;
        

        return answer;
    }
}