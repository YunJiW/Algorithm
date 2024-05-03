import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = null;

        long[][] point = new long[N + 1][2];

        for (int idx = 0; idx < N; idx++) {
            st = new StringTokenizer(br.readLine());
            point[idx][0] = Long.parseLong(st.nextToken());
            point[idx][1] = Long.parseLong(st.nextToken());
        }
        point[N] = point[0].clone();

        long sum1 = 0;
        long sum2 = 0;

        for(int idx = 0; idx <N;idx++){
            sum1 += point[idx][0] * point[idx+1][1];
            sum2 += point[idx][1] * point[idx+1][0];
        }


        System.out.println(String.format("%.1f",Math.abs(sum1-sum2)/2D));

    }

}