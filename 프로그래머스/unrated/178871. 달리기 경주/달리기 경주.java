import java.util.HashMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];


        HashMap<Integer,String> maps = new HashMap<>();
        HashMap<String,Integer> nameMap = new HashMap<>();
        for(int idx= 0; idx < players.length;idx++){
            maps.put(idx+1,players[idx]);
            nameMap.put(players[idx],idx+1);
        }

        for(int idx = 0; idx < callings.length;idx++){
            String tmp ="";
            String name = callings[idx];
            int name_rank = nameMap.get(name);

            int before_rank = name_rank -1;
            tmp = maps.get(before_rank);

            maps.put(before_rank,name);
            maps.put(name_rank,tmp);

            nameMap.put(name,before_rank);
            nameMap.put(tmp,name_rank);

        }
        for(int check = 0; check < maps.size(); check++){
            answer[check] = maps.get(check+1);
        }


        return answer;
    }
}