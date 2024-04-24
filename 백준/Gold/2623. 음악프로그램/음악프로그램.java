import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<ArrayList<Integer>> list = new ArrayList<>();
        for (int idx = 0; idx <= N; idx++) {
            list.add(new ArrayList<>());
        }

        int indegree[] = new int[N + 1];
        for (int idx = 0; idx < M; idx++) {
            st = new StringTokenizer(br.readLine());


            int num = Integer.parseInt(st.nextToken());
            int before = Integer.parseInt(st.nextToken());

            for (int i = 1; i < num; i++) {
                int nxt = Integer.parseInt(st.nextToken());
                list.get(before).add(nxt);
                indegree[nxt]++;

                before = nxt;
            }

        }

        String res = run(list, indegree, N);

        System.out.println(res);
    }

    //핵심 로직
    private static String run(List<ArrayList<Integer>> list, int[] indegree, int n) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        for (int idx = 1; idx <= n; idx++) {
            if (indegree[idx] == 0){
                queue.offer(idx);
            }
        }

        while(!queue.isEmpty()){
            int cur = queue.poll();

            result.add(cur);

            for(int next : list.get(cur)){
                indegree[next]--;

                if(indegree[next] == 0){
                    queue.offer(next);
                }
            }
        }
        //n이 아닌경우 -> 사이클 발생으로 다음 값으로 못감.
        if(result.size()!= n){
            return "0\n";
        }

        for(int idx = 0; idx < result.size();idx++){
            sb.append(result.get(idx)).append("\n");
        }

        return sb.toString();

    }
}
