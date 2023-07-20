import java.util.*;

class Solution {
    List<String> candidateKey = new ArrayList<>();
    public int solution(String[][] relation) {
        int answer = 0;

        for(int idx= 0; idx <relation[0].length;idx++){
            boolean[] visited = new boolean[relation[0].length];
            dfs(visited,0,0,idx+1,relation);

        }
        answer = candidateKey.size();

        return answer;
    }

    public void dfs(boolean[] visited,int start,int depth,int end ,String[][] relation){
        if(depth == end){
            List<Integer> list = new ArrayList<>();
            String key = "";
            for(int i=0;i<visited.length;i++){
                if(visited[i]) {
                    key += String.valueOf(i);
                    list.add(i);
                }
            }

            Map<String,Integer> map = new HashMap<>();

            for(int i=0;i<relation.length;i++){
                String s = "";
                for(Integer j : list){
                    s+= relation[i][j];
                }

                //중복인 경우 pass
                if(map.containsKey(s)){
                    return;
                }else{
                    map.put(s,0);
                }
            }

            for(String s :candidateKey){
                int count = 0;
                for(int idx= 0; idx <key.length();idx++){
                    String subs = String.valueOf(key.charAt(idx));
                    if(s.contains(subs)) count+=1;
                }
                //포함되어있는지
                if(count == s.length()) return;
            }
            candidateKey.add(key);

            return;
        }


        for(int idx = start;idx < visited.length;idx++){
            if (visited[idx])
                continue;

            visited[idx] = true;
            dfs(visited, idx, depth+1, end, relation);
            visited[idx] = false;
        }
    }
}