import java.util.*;

class Solution {

    private ArrayList<Integer>[] adj;
    private int[] visited;
    private int depth = 0;



    public int solution(int n, int[][] edge) {
        int answer = 0;
        adj = new ArrayList[n + 1];
        visited = new int[n + 1];

        for (int idx = 1; idx <= n; idx++)
            adj[idx] = new ArrayList<>();

        for (int idx = 0; idx < edge.length; idx++) {
            int start = edge[idx][0];
            int end = edge[idx][1];

            adj[start].add(end);
            adj[end].add(start);
        }

        bfs(1, 1);

        for (int idx = 1; idx <= n; idx++) {
            if (depth == visited[idx]) answer += 1;
        }

        return answer;
    }

    //핵심 로직
    private void bfs(int start, int count) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        queue.offer(count);
        visited[start] = count;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int cnt = queue.poll();

            //깊이 체크
            if (depth < cnt) depth = cnt;
            for (int idx = 0; idx < adj[cur].size(); idx++) {
                int next = adj[cur].get(idx);

                //0이 아니라는 것으로 방문여부 체크
                if (visited[next] != 0) continue;
                visited[next] = cnt + 1;
                queue.offer(next);
                queue.offer(cnt + 1);
            }
        }
    }

}