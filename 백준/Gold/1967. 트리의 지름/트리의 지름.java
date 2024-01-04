import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N = 0;
    static int result = 0;

    static int max_node = 0;


    static ArrayList<Edge>[] nodes;


    static class Edge {
        int end;
        int weight;

        public Edge(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }

    static class Node {
        int idx;
        int cnt;

        public Node(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(0);
            return;
        }

        StringTokenizer st;

        nodes = new ArrayList[N + 1];


        for (int idx = 1; idx <= N; idx++) {
            nodes[idx] = new ArrayList<>();
        }

        for (int idx = 1; idx < N; idx++) {
            st = new StringTokenizer(br.readLine());

            int first = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            nodes[first].add(new Edge(end, weight));
            nodes[end].add(new Edge(first, weight));
        }

        bfs(1);
        bfs(max_node);

        System.out.println(result);

    }

    public static void bfs(int start) {

        boolean visited[] = new boolean[N + 1];
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(start, 0));
        visited[start] = true;

        int max_cnt = 0;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.cnt > max_cnt) {
                max_cnt = cur.cnt;
                max_node = cur.idx;
            }

            for (Edge e : nodes[cur.idx]) {
                if (!visited[e.end]) {
                    visited[e.end] = true;
                    queue.add(new Node(e.end, cur.cnt + e.weight));

                }
            }
        }

        result = Math.max(result, max_cnt);

    }
}
