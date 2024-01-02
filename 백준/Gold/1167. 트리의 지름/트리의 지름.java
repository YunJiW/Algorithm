import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class Main {

    static int N;
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

        nodes = new ArrayList[N + 1];


        for (int idx = 1; idx <= N; idx++) {
            nodes[idx] = new ArrayList<>();
        }
        //주어진 가중치를 넣어줌.
        for (int idx = 1; idx <= N; idx++) {
            String[] input = br.readLine().split(" ");
            int index = Integer.parseInt(input[0]);

            int j = 1;
            while (true) {
                int v_num = Integer.parseInt(input[j]);
                //-1 이 찍히면 끝.
                if (v_num == -1)
                    break;
                int weight = Integer.parseInt(input[j + 1]);


                nodes[index].add(new Edge(v_num, weight));
                j += 2;
            }
        }

        bfs(1);
        bfs(max_node);

        System.out.println(result);

    }

    private static void bfs(int start) {

        boolean visited[] = new boolean[N+1];

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start,0));
        visited[start] = true;

        int max_cnt = 0;

        while(!queue.isEmpty()){
            Node now = queue.poll();

            if(now.cnt > max_cnt){
                max_cnt = now.cnt;
                max_node = now.idx;
            }

            for(Edge e : nodes[now.idx]){
                if(!visited[e.end]){
                    visited[e.end] = true;
                    queue.add(new Node(e.end,now.cnt + e.weight));
                }
            }
        }


        result = Math.max(max_cnt,result);
    }
}
