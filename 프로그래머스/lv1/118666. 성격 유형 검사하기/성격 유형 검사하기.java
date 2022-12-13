import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] survey, int[] choices)
	{
		int Score[] = {-11,3,2,1,0,1,2,3};
		String answer="";
		
		HashMap<String,Integer> Person = new HashMap<>();
		
		for(int index =0; index <survey.length;index++)
		{
			String check_personality="";
			if(choices[index] < 4)
			{
				check_personality = String.valueOf(survey[index].charAt(0));
			}else if(choices[index] == 4)
			{
				continue;
			}
			else if(choices[index] >4){
				check_personality = String.valueOf(survey[index].charAt(1));
			}
			
			Person.put(check_personality,Person.getOrDefault(check_personality, 0)+Score[choices[index]]);
		}
		answer+= Person.getOrDefault("R", 0) >= Person.getOrDefault("T",0) ? "R" : "T";
		answer+= Person.getOrDefault("C", 0) >= Person.getOrDefault("F",0) ? "C" : "F";
		answer+= Person.getOrDefault("J", 0) >= Person.getOrDefault("M",0) ? "J" : "M";
		answer+= Person.getOrDefault("A", 0) >= Person.getOrDefault("N",0) ? "A" : "N";
		return answer;
		
	}
}