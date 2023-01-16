import java.util.HashMap;

class Solution {
    HashMap<Character,Integer> skill_set;
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        skill_set = new HashMap<>();
        
        
        //순서를 먼저 저장해준다.
        for(int index = 0; index <skill.length();index++)
        {
            char ch = skill.charAt(index);
            skill_set.put(ch,index);
        }
        
        for(int index = 0; index <skill_trees.length;index++)
        {

            //스킬 순서에 문제가없으면 answer를 늘려줌.
            if(skill_chekcing(skill_trees[index])){
                answer+=1;
            }
        }
        return answer;
    }

    public boolean skill_chekcing(String skills){
        int idx = 0;

        for(int index = 0; index <skills.length();index++){
            char skill_name = skills.charAt(index);
            if(skill_set.containsKey(skill_name) && skill_set.get(skill_name) != idx){
                return false;
            }

            if(skill_set.containsKey(skill_name) && skill_set.get(skill_name) == idx ){
                idx+=1;
            }
            if(idx == skill_set.size())
                return true;
        }
        return true;

    }
}