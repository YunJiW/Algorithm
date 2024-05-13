import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String num = br.readLine();

        Stack<Integer> stack = new Stack<>();
        int deleteCnt = 0;
        for (int idx = 0; idx < num.length(); idx++) {
            int number = num.charAt(idx) - '0';
            if (stack.isEmpty()) {
                stack.push(number);
                continue;
            }
            //stack의 맨위의 값보다 현재 값이 큰 경우
            //K가 남아있기 때문에 지워준다.
            while (!stack.isEmpty() && stack.peek() < number && deleteCnt < K) {
                stack.pop();
                deleteCnt += 1;
            }
            stack.push(number);

        }

        while (true) {
            if (deleteCnt < K) {
                stack.pop();
                deleteCnt += 1;
            } else {
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        //stack넣어놓은 수를 다시 정렬필요함.
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb.reverse().toString());


    }

}