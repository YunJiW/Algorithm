import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        Stack<Integer>[] stacks = new Stack[N + 1];

        for (int idx = 0; idx <= N; idx++) {
            stacks[idx] = new Stack<>();
        }


        for (int tc = 0; tc < N; tc++) {
            st = new StringTokenizer(br.readLine());
            //음
            int select = Integer.parseInt(st.nextToken());

            //눌러야하는 프렛
            int pret = Integer.parseInt(st.nextToken());

            if(stacks[select].isEmpty()) {
                stacks[select].push(pret);
                result += 1;
            }else{
                while(!stacks[select].isEmpty()){
                    //이전 프렛이 현재 프렛음보다 높은 경우
                    if(stacks[select].peek() > pret){
                        result+=1;
                        stacks[select].pop();
                        continue;
                    }
                    //이전 프렛과 현재 프렛이 같은경우
                    if(stacks[select].peek() == pret){
                        break;
                    }
                    //이전 프렛이 현재 프렛보다 낮은 경우
                    if(stacks[select].peek() < pret){
                        result+=1;
                        stacks[select].push(pret);
                        break;
                    }
                }
                //다빠지는 경우
                if(stacks[select].isEmpty()){
                    result+=1;
                    stacks[select].push(pret);
                }

            }
        }
        System.out.println(result);


    }
}
