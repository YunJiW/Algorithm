
import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        HashMap<Character,Integer> map = new HashMap<>();
        //있는지 없는지 체크용도
        HashSet<Character> check = new HashSet<>();

        for(int idx = 0; idx <keymap.length;idx++){
            for(int start = 0; start < keymap[idx].length();start++){
                char alpha = keymap[idx].charAt(start);
                //이미 idx를 가지고 존재할경우
                if(check.contains(alpha)){
                    if(map.get(alpha) > start+1){
                        map.put(alpha,start+1);
                    }
                }else {
                    check.add(alpha);
                    map.put(alpha,start+1);
                }
            }
        }
        for(int idx= 0;idx<targets.length;idx++){
            int count = 0;
            for(int start = 0; start < targets[idx].length();start++){
                if(!check.contains(targets[idx].charAt(start))){
                    count = -1;
                    break;
                }
                count += map.get(targets[idx].charAt(start));
                System.out.println(count);
            }
            answer[idx] = count;
        }
        return answer;
    }
}