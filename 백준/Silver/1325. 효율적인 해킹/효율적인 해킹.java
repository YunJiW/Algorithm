import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static int[] hacking;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) list.add(new ArrayList<>());
        hacking = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
        }

        int max = 0;

        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            bfs(i);
        }

        for (int i : hacking) max = Math.max(max, i);

        for (int i = 1; i <= n; i++) {
            if (hacking[i] == max) sb.append(i + " ");
        }

        System.out.println(sb);
    }

    static void bfs(int v) {
        queue.clear();
        queue.add(v);
        visited[v] = true;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int next : list.get(current)) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                    hacking[next]++;
                }
            }
        }

    }


}