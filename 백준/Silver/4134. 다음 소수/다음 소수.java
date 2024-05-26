import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            long N = Long.parseLong(br.readLine());

            if (N == 0 || N == 1) {
                sb.append(2).append("\n");
                continue;
            }

            while (true) {
                long cnt = 0;
                for (long num = 2; num <= Math.sqrt(N); num++) {
                    if (N % num == 0) {
                        cnt += 1;
                        break;
                    }
                }

                if (cnt == 0) {
                    sb.append(N).append("\n");
                    break;
                }
                N += 1;
            }
        }
        System.out.println(sb);

    }
}
