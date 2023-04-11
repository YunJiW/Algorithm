import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int list[] = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < N; idx++) {
            list[idx] = Integer.parseInt(st.nextToken());
        }

        int result = 0;

        //M값 체크용
        int check_sum = 0;
        int start_idx = 0;
        int end_idx = 0;
        while (start_idx != N) {
            if(end_idx == N){
                check_sum -= list[start_idx++];
                if(check_sum == M)
                    result+=1;
                continue;
            }


            if(check_sum >= M){
                check_sum -= list[start_idx++];
            }
            else if(check_sum < M){
                check_sum += list[end_idx++];
            }

            if(check_sum == M){
                result+=1;
            }
        }

        System.out.println(result);
    }
}
