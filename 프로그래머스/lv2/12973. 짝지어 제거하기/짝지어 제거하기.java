import java.util.Stack;

class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        
        Stack<Character> stack = new Stack<>();
        
        for(int index =0 ; index < s.length();index++)
        {
            stack.push(s.charAt(index));
            if(stack.size() >= 2)
            {
                if(stack.get(stack.size()-2) == stack.get(stack.size()-1))
                {
                    stack.pop();
                    stack.pop();
                }
            }
        }
        if(stack.isEmpty())
            answer = 1; 
        
        return answer;
    }
}