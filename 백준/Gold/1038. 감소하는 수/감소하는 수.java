import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static ArrayList<Long> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        //10 이하는 그값 자체가 N번째임
        if (N <= 10) {
            System.out.println(N);
            return;
        }else if(N >= 1023) {
            System.out.println(-1);
            return;
        }

        for (int idx = 0; idx < 10; idx++) {
            dfs(idx, 1);
        }

        //숫자를 오름차순 정렬필요- > N번째 숫자를 뽑아야하기때문에.
        Collections.sort(list);

        System.out.println(list.get(N));


    }

    //만들어지는 모든수 체크
    //핵심로직
    private static void dfs(long num, int depth) {
        if (depth > 10) return;

        list.add(num);
        for (int index = 0; index < num % 10; index++) {
            dfs((num * 10) + index, depth + 1);
        }
    }
}
