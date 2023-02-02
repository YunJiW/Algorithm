import java.util.HashMap;


class Solution 
{
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String,Integer> map = new HashMap<>();
        
        for(int index = 0; index < clothes.length;index++)
        {
        	map.put(clothes[index][1], map.getOrDefault(clothes[index][1],0)+1);
        }
        
        for(String cloth : map.keySet()) {
        	answer=answer* (map.get(cloth)+1);
        }
        
        
        
        
        
        
        
        return answer-1;
    }
}
