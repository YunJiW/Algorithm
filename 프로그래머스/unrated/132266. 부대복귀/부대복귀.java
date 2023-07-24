import java.util.*;

class Solution {

    List<Integer>[] road;
    int[] destinations;

    boolean[] visited;

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        road = new ArrayList[n+1];
        destinations = new int[n+1];
        visited = new boolean[n+1];

        //-1로 채워두기
        Arrays.fill(destinations,-1);



        for(int idx =1;idx<=n;idx++){
            road[idx] = new ArrayList<>();
        }

        //연결된 도로들 적어두기
        for(int index = 0; index < roads.length;index++){
            int start = roads[index][0];
            int end = roads[index][1];

            road[start].add(end);
            road[end].add(start);
        }
        
        start(destination);
        for(int idx =0; idx <sources.length;idx++){
            answer[idx] = destinations[sources[idx]];
        }


        return answer;
    }

    private void start(int destination) {
        Queue<Integer> queue = new LinkedList<>();
        int cnt = 0;
        queue.offer(destination);
        queue.offer(cnt);
        visited[destination] = true;
        destinations[destination] = 0;

        while(!queue.isEmpty()){
            int cur = queue.poll();
            int node = queue.poll();
            //한번도 방문하지 않은경우 일단 갱신
            if(destinations[cur] == -1){
                destinations[cur] = node;
                //방문한적이있는경우 최소 거리인지 체크
            }else if(destinations[cur] != -1){
                destinations[cur] = Math.min(node,destinations[cur]);
            }

            for(int idx =0; idx <road[cur].size();idx++){
                int nxt_road = road[cur].get(idx);

                if(visited[nxt_road])
                    continue;

                visited[nxt_road] = true;
                queue.offer(nxt_road);
                queue.offer(node+1);
            }

        }


    }
}
