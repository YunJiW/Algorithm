import java.util.Stack;

class Solution {
    class check{
        int idx;
        int number;

        check(int idx,int number){
            this.idx = idx;
            this.number = number;
        }
    }

    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<check> stack = new Stack<>();


        for(int index = 0 ;index <numbers.length;index++){
            if(stack.isEmpty()){
                stack.push(new check(index,numbers[index]));
                continue;
            }
            //stack의 맨위의 값이 현재위치의 숫자보다 작은경우
            if(stack.peek().number < numbers[index]){
                while(!stack.isEmpty()&&stack.peek().number < numbers[index]){
                    check check_number = stack.pop();
                    answer[check_number.idx] = numbers[index];
                }
                stack.push(new check(index,numbers[index]));
                
            }else {
                stack.push(new check(index,numbers[index]));
            }
        }
        while(!stack.isEmpty()){
            check result = stack.pop();
            answer[result.idx] = -1;
        }
        return answer;
    }
}