import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int E;
    static int[] distance;

    //최대 간선 * 최대 가중치  200000 * 1000
    static final int INF = 200000000;

    static List<List<Node>> list;

    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());


        list = new ArrayList<>();
        distance = new int[N + 1];

        //최단거리 계산전 전부 INF 처리
        for (int idx = 0; idx <= N; idx++) {
            distance[idx] = INF;
        }

        for (int idx = 0; idx <= N; idx++) {
            list.add(new ArrayList<>());
        }

        for (int idx = 0; idx < E; idx++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list.get(a).add(new Node(b, weight));
            list.get(b).add(new Node(a, weight));

        }
        //반드시 지나야하는 정점 2개
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        //2개의 분기 최단거리 계산
        int res1 = 0;
        res1 += dijkstra(1, v1);
        res1 += dijkstra(v1, v2);
        res1 += dijkstra(v2, N);




        int res2 = 0;
        res2 += dijkstra(1, v2);
        res2 += dijkstra(v2, v1);
        res2 += dijkstra(v1, N);

        res = (res1 >= INF && res2 >= INF) ? -1 : Math.min(res1, res2);

        System.out.println(res);
        br.close();

    }

    public static int dijkstra(int start, int end) {

        //특정한 구간을 반드시 지나야하기 때문에 계산을 따로해줘야함.
        //따로하지 않고 계산하게되면 반드시 지날때 계산이 불가능함.
        //  같은곳을 다시가도된다 + 반드시 지나가야하는 곳이 있다.
        Arrays.fill(distance, INF);

        Queue<Node> pq = new PriorityQueue<>();
        boolean visited[] = new boolean[N+1];
        pq.offer(new Node(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int cur = curNode.end;

            if (!visited[cur]) {
                visited[cur] = true;

                for (Node node : list.get(cur)) {
                    if (!visited[node.end] && distance[node.end] > distance[cur] + node.weight) {
                        distance[node.end] = distance[cur] + node.weight;
                        pq.offer(new Node(node.end, distance[node.end]));
                    }
                }
            }

        }
        return distance[end];
    }




    static class Node implements Comparable<Node> {
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
}
