import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


    static int before;
    static int after;


    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st = null;

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            before = Integer.parseInt(st.nextToken());
            after = Integer.parseInt(st.nextToken());

            Queue<Integer> que = new LinkedList<>();
            boolean[] visited = new boolean[10000];
            String[] command = new String[10000];

            que.offer(before);
            visited[before] = true;
            Arrays.fill(command, "");


            while (!que.isEmpty() && !visited[after]) {
                int cur = que.poll();

                int D = (cur * 2) % 10000;

                int S = cur == 0 ? 9999 : cur - 1;

                int L = (cur % 1000) * 10 + cur / 1000;
                int R = (cur % 10) * 1000 + cur / 10;

                if (!visited[D]) {
                    que.offer(D);
                    visited[D] = true;
                    command[D] = command[cur] + "D";
                }

                if (!visited[S]) {
                    que.offer(S);
                    visited[S] = true;
                    command[S] = command[cur] + "S";
                }

                if (!visited[L]) {
                    que.offer(L);
                    visited[L] = true;
                    command[L] = command[cur] + "L";
                }
                if (!visited[R]) {
                    que.offer(R);
                    visited[R] = true;
                    command[R] = command[cur] + "R";
                }

            }
            sb.append(command[after]).append("\n");


        }
        System.out.println(sb);


    }
}
