import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<Character> braket = new Stack<>();
        
        for(int index =0;index <s.length();index++)
        {
            if(s.charAt(index) == '(')
            {
                braket.push(s.charAt(index));
            }
            else if(s.charAt(index) == ')')
            {
                if(!braket.isEmpty())
                {
                    braket.pop();
                }else{
                    answer = false;
                    return answer;
                }
            }
        }
        if(!braket.isEmpty())
            answer = false;
        
        
        return answer;
    }
}