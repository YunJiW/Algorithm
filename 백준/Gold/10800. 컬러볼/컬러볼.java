import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Ball ball[] = new Ball[n];

        for(int idx= 0; idx <n;idx++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            ball[idx] = new Ball(idx,c,s);
        }

        Arrays.sort(ball,((o1, o2) -> o1.size - o2.size));

        int[] result = new int[n];
        int[] colors  = new int[n+1];

        int ball_idx = 0;
        int sum = 0;

        for(int idx = 0; idx <n;idx++){
            Ball cur = ball[idx];
            while(ball[ball_idx].size < cur.size){
                sum+= ball[ball_idx].size;
                colors[ball[ball_idx].color] += ball[ball_idx].size;
                ball_idx+=1;
            }
            result[cur.idx] = sum - colors[cur.color];
        }
        StringBuilder sb = new StringBuilder();
        for(int idx= 0; idx <n;idx++){
            sb.append(result[idx]).append("\n");
        }
        System.out.print(sb);
    }

    public static class Ball{
        int idx;
        int color;
        int size;

        public Ball(int idx, int color, int size) {
            this.idx = idx;
            this.color = color;
            this.size = size;
        }
    }
}
