import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int number[] = new int[N];
        Stack<Integer> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        //값을 먼저 받아둔다.
        for(int idx = 0; idx < N; idx++)
        {
            number[idx] = Integer.parseInt(st.nextToken());
        }

        for(int idx = 0; idx < N ;idx++){
            //비어있는경우 값을 시작하는 idx를 넣어준다.
            if(stack.isEmpty()){
                stack.push(idx);
                continue;
            }

            //만약 stack의 맨위의 값의 idx에 있는 값이 현재 idx보다 작은경우 그값 idx값을 현재 idx값으로 채워주고 다른 들어있는 값들과 비교를 한다.
            while(!stack.isEmpty() && number[stack.peek()] < number[idx]){
                number[stack.pop()] = number[idx];
            }
            //현재의 idx를 push해준다 -> 현재 idx도 찾아봐야하니까
            stack.push(idx);

        }
        //stack에 남아있는 값은 그것보다 큰 오큰수가 존재하지않기때문에 각 idx에 -1을 채워준다.
        while(!stack.isEmpty()){
            number[stack.pop()] = -1;
        }
        StringBuilder sb = new StringBuilder();
        
        for(int numbers :number){
            sb.append(numbers).append(" ");
        }

        System.out.println(sb);

    }


}