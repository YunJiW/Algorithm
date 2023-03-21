import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String answer = "";
        char ch[] = s.toCharArray();
        Arrays.sort(ch);
        for(int idx = ch.length-1; idx >=0;idx--){
            answer+=ch[idx];
        }
        return answer;
    }
}