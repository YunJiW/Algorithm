import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Iterator;

class Solution 
{
    public int solution(String s) {
        int answer = 0;
        
        
        int len = s.length()-1;
        
        Queue<Character> list = new LinkedList<>();
        Iterator<Character> iter;
        
        //s를 먼저 받아둠.
        for(int index = 0;index <s.length();index++) {
        	list.offer(s.charAt(index));
        }
        
        for(int index = 0; index <len;index++) {
        	if(index ==0) {
        		iter = list.iterator();
        		if(check(iter))
        			answer+=1;
        	}
        	else {
        		list.offer(list.poll());
        		iter = list.iterator();
        		if(check(iter))
        			answer+=1;
        	}
        }
        
        return answer;
    }

	private boolean check(Iterator<Character> list) {
		
		Stack<Character> stack = new Stack<>();
		while(list.hasNext()) {
			char bracket = list.next();
			if(stack.isEmpty()) {
				if(bracket =='}' || bracket==')' || bracket=='}')
					return false;
				else
					stack.push(bracket);
			}
			else {
				if(bracket=='{' || bracket=='(' || bracket=='[') {
					stack.push(bracket);
					continue;
				}
				
				if(bracket =='}') {
					if(stack.peek() == '{') {
						stack.pop();
						continue;
					}
					else
						return false;
				}
				
				if(bracket==')') {
					if(stack.peek() == '(') {
						stack.pop();
						continue;
					}
					else
						return false;
				}
				
				if(bracket==']') {
					if(stack.peek() =='[') {
						stack.pop();
						continue;
					}
					else
						return false;
				}
				
			}
			
		}
		if(stack.isEmpty())
			return true;
		
		
		return false;
	}
}