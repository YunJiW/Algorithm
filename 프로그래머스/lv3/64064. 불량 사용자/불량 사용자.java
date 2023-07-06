import java.util.*;

class Solution {
    String[] userId;
    String[] bannedId;
    HashSet<HashSet<String>> result = new HashSet<>();


    public int solution(String[] user_id, String[] banned_id) {
        userId =user_id;
        bannedId =banned_id;
        dfs(new HashSet<>(),0);


        return result.size();
    }

    private void dfs(HashSet<String> set, int depth) {
        if(depth == bannedId.length){
            result.add(set);
            return;
        }

        for(int idx = 0; idx <userId.length;idx++){
            if(set.contains(userId[idx])){
                continue;
            }

            if(check(userId[idx],bannedId[depth])){
                set.add(userId[idx]);
                dfs(new HashSet<>(set),depth+1);
                set.remove(userId[idx]);
            }
        }



    }

    private boolean check(String userid, String banid) {
        if(userid.length() != banid.length()){
            return false;
        }
        boolean ispossible = true;
        for(int idx= 0; idx <userid.length();idx++){
            if(banid.charAt(idx) != '*' && userid.charAt(idx) != banid.charAt(idx)){
                ispossible =false;
                break;
            }
        }
        return ispossible;
    }
}
