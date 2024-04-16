import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;

    static int parent[];

    static ArrayList<Node> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        list = new ArrayList<>();


        for (int idx = 0; idx < M; idx++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());


            list.add(new Node(a, b, weight));
        }
        parent = new int[N + 1];

        for (int idx = 1; idx <= N; idx++) {
            parent[idx] = idx;
        }

        Collections.sort(list);

        int res = 0;
        for (int idx = 0; idx < list.size(); idx++) {
            Node cur = list.get(idx);

            if (find(cur.start) != find(cur.next)) {
                res += cur.weight;
                union(cur.start, cur.next);
            }
        }

        System.out.println(res);

    }

    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parent[y] = x;
        }
    }


    static class Node implements Comparable<Node> {
        int start;
        int next;
        int weight;

        public Node(int start, int next, int weight) {
            this.start = start;
            this.next = next;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
}
