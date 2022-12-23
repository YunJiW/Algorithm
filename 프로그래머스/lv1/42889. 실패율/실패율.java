import java.util.HashMap;
class Solution {
    public int[] solution(int N, int[] stages) {
        

        HashMap<Integer,Double> Map = new HashMap<>();
        
        for(int stage =1; stage <=N;stage++)
        {
        	double stage_total =0;
        	double stage_staying=0;
        	for(int stage_check=0;stage_check<stages.length;stage_check++)
        	{
        		if(stage <= stages[stage_check]) stage_total++;
        		if(stage == stages[stage_check]) stage_staying++;
        	}
        	if(stage_total ==0 && stage_staying ==0)
        		stage_total = 1;
        	
        	Map.put(stage,stage_staying/stage_total);
        }
        int[] answer = new int[N];   
        
        for(int index =0; index <N;index++)
        {
        	double max = -1;
        	int rKey = 0;
        	for(int Key :Map.keySet())
        	{
        		if(max < Map.get(Key))
        		{
        			max = Map.get(Key);
        			rKey = Key;
        		}
        	}
        	answer[index] = rKey;
        	Map.remove(rKey);
        }
        return answer;
    }
}