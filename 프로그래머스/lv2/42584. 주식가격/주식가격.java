import java.util.Stack;
class Solution
{

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        int len = prices.length-1;
        Stack<price_day> stack = new Stack<>();

        for(int index = 0;index <= len;index++) {
            //비어있으면 넣기
            if(stack.isEmpty()){
                stack.push(new price_day(prices[index],index));
                continue;
            }
            //넣어진 값의 가장 위에 있는 값이 다음 값보다 작거나 같을경우
            if(prices[index] >= stack.peek().price){
                stack.push(new price_day(prices[index],index));
            }else{
                //스택의 가장위로 올라오는 값이 prices보다 크면 계속 뽑음
                while(!stack.isEmpty() && prices[index] < stack.peek().price){
                    price_day p = stack.pop();
                    answer[p.day] = index - p.day;
                }
                stack.push(new price_day(prices[index],index));
            }
            

        }
        while(!stack.isEmpty()){
            price_day p = stack.pop();
            System.out.println(p.day);
            answer[p.day] = len - p.day;
        }
        return answer;
    }

}
class price_day{
        int price;
        //그날 날짜
        int day;
        price_day(int price, int day){
            this.price = price;
            this.day = day;
        }
    }