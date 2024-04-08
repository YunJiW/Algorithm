import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    static int V;
    static int E;

    static int res;

    static int[] parent;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        parent = new int[V + 1];
        for (int idx = 1; idx <= V; idx++) {
            parent[idx] = idx;
        }

        Queue<Node> pq = new PriorityQueue<>();


        for (int idx = 0; idx < E; idx++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            pq.offer(new Node(from, to, weight));
        }

        int size = pq.size();
        res = 0;

        for(int idx =0; idx <size;idx++){
            Node cur = pq.poll();
            int from = find(cur.from);
            int to = find(cur.to);

            if(!isSame(from,to)){
                res += cur.weight;
                union(cur.from, cur.to);
            }
        }
        System.out.println(res);

    }

    //핵심로직 union-find
    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parent[y] = x;
        }
    }

    public static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static boolean isSame(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) return true;

        else return false;
    }


    static class Node implements Comparable<Node> {
        
        int from;

        int to;
        int weight;

        public Node(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
}
