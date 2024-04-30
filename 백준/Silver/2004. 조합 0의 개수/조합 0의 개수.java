import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long cnt5 = five_power(n) - five_power(n - m) - five_power(m);
        long cnt2 = second_power(n) - second_power(n - m) - second_power(m);

        System.out.println(Math.min(cnt5, cnt2));


    }

    static long five_power(long num) {
        int cnt = 0;

        while (num >= 5) {
            cnt += num / 5;
            num /= 5;
        }

        return cnt;
    }

    static long second_power(long num) {
        int cnt = 0;

        while (num >= 2) {
            cnt += num / 2;
            num /= 2;
        }
        return cnt;
    }
}