import java.util.HashMap;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        HashMap<String,Integer> maps = new HashMap<>();
        for(int idx = 0; idx <name.length;idx++){
            maps.put(name[idx],yearning[idx]);
        }
        for(int row =0; row <photo.length;row++){
            for(int col = 0; col <photo[row].length;col++){
                if(maps.containsKey(photo[row][col]))
                {
                    answer[row] += maps.get(photo[row][col]);
                }
            }

        }
        return answer;
    }
}
