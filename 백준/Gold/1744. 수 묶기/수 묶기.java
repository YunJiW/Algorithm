import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    //리턴할 값
    static int ans=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int all[] = new int[N];
        ArrayList<Integer> minus = new ArrayList<>();
        ArrayList<Integer> plus =new ArrayList<>();
        //먼저 수를 받아놓는다.
        for(int idx=0;idx<N;idx++)
        {
            int number = Integer.parseInt(br.readLine());
            all[idx] = number;
            if(number <=0){
                minus.add(number);
            }else{
                plus.add(number);
            }
        }
        //한개밖에없다면 그냥 그값이 최대값임
        if(N == 1)
        {
            System.out.println(all[0]);
            return;
        }

        //오름차순으로 먼저 정렬
        Collections.sort(plus,Collections.reverseOrder());
        //마이너스도 정렬
        Collections.sort(minus);
        //스택으로 처리 곱할거랑 더할거 체크

        Stack<Integer> stack = new Stack<>();
        //음수 따로 0 포함
        for(int idx = 0; idx < minus.size();idx++){
            if(stack.isEmpty()){
                stack.push(minus.get(idx));
                continue;
            }
            ans += stack.pop() * minus.get(idx);
        }

        while(!stack.isEmpty()){
            ans+= stack.pop();
        }


        //양수 따로
        for(int idx = 0; idx < plus.size();idx++){
            if(stack.isEmpty() || plus.get(idx) == 1){
                stack.push(plus.get(idx));
                continue;
            }
            if(stack.peek() != 1 ) {
                ans += stack.pop() * plus.get(idx);
            }else {
                stack.push(plus.get(idx));
            }
        }
        while(!stack.isEmpty()){
            ans+= stack.pop();
        }

        System.out.println(ans);

    }
}
