import java.util.Stack;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        boolean flag = true;
        Stack<Integer> stack = new Stack<>();
        
        //재료를 ArrayList에 넣어준다.
        for(int index =0; index <ingredient.length;index++)
        {
            stack.push(ingredient[index]);
            //스택의 크기가 4보다 클경우 시작
            if(stack.size() >=4)
            {
                if((stack.get(stack.size()-4) == 1) 
                    &&(stack.get(stack.size()-3) == 2) 
                    &&(stack.get(stack.size()-2) == 3) 
                    &&(stack.get(stack.size()-1) == 1)){
                    
                    answer++;
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                }
            }
        }
        
        return answer;
    }
}