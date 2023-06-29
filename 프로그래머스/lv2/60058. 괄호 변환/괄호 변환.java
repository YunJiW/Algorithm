import java.util.*;
class Solution {
    public String solution(String p) {
        String answer = start(p);
        return answer;
    }

    private String start(String p) {

        if (p.length() == 0) {
            return "";
        }
        String u = "";
        String v = "";
        int lcnt = 0;
        int rcnt = 0;
        for (int idx = 0; idx < p.length(); idx++) {
            if (p.charAt(idx) == '(') {
                lcnt += 1;
            } else rcnt += 1;
            u += p.charAt(idx);
            if (lcnt == rcnt) {
                v = p.substring(idx + 1);
                break;
            }
        }

        if (isCorrect(u)) {
            return u+=start(v);
        }else{
            String temp = "(";
            temp+= start(v);
            temp+=")";
            u = u.substring(1,u.length()-1);
            for(int idx =0; idx <u.length();idx++){
                if(u.charAt(idx) == '('){
                    temp+=')';
                }else{
                    temp+='(';
                }
            }
            return temp;
        }
    }

    private boolean isCorrect(String u) {
        Stack<Character> st = new Stack<>();

        for (int idx = 0; idx < u.length(); idx++) {
            if (u.charAt(idx) == '(') {
                st.push('(');
            } else {
                if (st.isEmpty()) {
                    return false;
                } else {
                    st.pop();
                }
            }
        }
        return true;
    }
}