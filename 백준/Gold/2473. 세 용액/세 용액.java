import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long ans[] = new long[3];
        int N = Integer.parseInt(br.readLine());
        long res = Long.MAX_VALUE;


        long sol[] = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < N; idx++) {
            sol[idx] = Long.parseLong(st.nextToken());
        }
        //정렬필요 -> 특성값의 오름차순 정렬이 필요하기 때문에
        Arrays.sort(sol);

        for (int idx = 0; idx < N - 2; idx++) {
            int start = idx + 1;
            int end = N - 1;

            while (start < end) {
                long sum = sol[idx] + sol[start] + sol[end];
                if (Math.abs(sum) < res) {
                    res = Math.abs(sum);
                    ans[0] = sol[idx];
                    ans[1] = sol[start];
                    ans[2] = sol[end];
                }
                if (sum == 0) {
                    break;
                } else if (sum < 0) {
                    start += 1;
                } else {
                    end -= 1;
                }
            }
        }

        System.out.println(ans[0] + " " + ans[1] + " " + ans[2]);
        br.close();
    }
}
