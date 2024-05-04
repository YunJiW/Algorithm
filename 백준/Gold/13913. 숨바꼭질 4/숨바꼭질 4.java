import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {

    static int N, K;

    //시간을 누적계산하면서 중복 방문 방지.
    static int visited[] = new int[100001];

    //도착시에 경로 체크를 위해서 사용
    static int parent[] = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());


        run(N);
        Stack<Integer> s = new Stack<>();

        System.out.println(visited[K]);

        int idx = K;
        while (idx != N) {
            s.push(idx);
            idx = parent[idx];
        }
        s.push(idx);

        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }

        br.close();

    }

    private static void run(int X) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(X);
        visited[X] = 0;

        while (!queue.isEmpty()) {

            int cur = queue.poll();

            if(cur == K){
                return;
            }


            //X+1
            if (cur + 1 <= 100000 && visited[cur + 1] == 0) {
                visited[cur + 1] = visited[cur] + 1;
                parent[cur + 1] = cur;
                queue.offer(cur + 1);
            }

            //X-1
            if (cur - 1 >= 0 && visited[cur - 1] == 0) {
                visited[cur - 1] = visited[cur] + 1;
                parent[cur - 1] = cur;
                queue.offer(cur - 1);
            }
            //2X
            if (2 * cur <= 100000 && visited[2 * cur] == 0) {
                visited[2 * cur] = visited[cur] + 1;
                parent[2 * cur] = cur;
                queue.offer(2 * cur);
            }

            if (visited[K] != 0) return;

        }

    }

}
