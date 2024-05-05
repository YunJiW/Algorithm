import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 최소한의 비용으로 각 집들을 연결하고 싶다.
 * 길이 너무많기 때문에 길을 최소한으로 만들기.
 * 최소 스패닝트리 조건
 */


public class Main {

    static int parent[];
    static List<Edge> list = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int idx = 0; idx < M; idx++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list.add(new Edge(start, end, weight));
        }

        parent = new int[N + 1];
        for (int idx = 1; idx <= N; idx++) {
            parent[idx] = idx;
        }

        Collections.sort(list);

        int res = 0;

        //연결된 가장 큰 가중치의 길을 잘라주게되면 마을이 2개로 분리된다.
        int Cost = 0;

        for (int idx = 0; idx < list.size(); idx++) {
            Edge cur = list.get(idx);

            if(find(cur.start) != find(cur.end)){
                res += cur.weight;
                union(cur.start,cur.end);

                Cost = cur.weight;
            }

        }
        System.out.println(res - Cost);


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

    private static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
}
