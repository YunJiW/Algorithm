import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for (int idx = 0; idx <= N; idx++) {
            list.add(new ArrayList<>());
        }

        int indegree[] = new int[N + 1];
        Building building[] = new Building[N + 1];


        for (int idx = 1; idx <= N; idx++) {
            st = new StringTokenizer(br.readLine());

            int time = Integer.parseInt(st.nextToken());
            building[idx] = new Building(idx, time);

            while (true) {
                int num = Integer.parseInt(st.nextToken());
                if (num == -1) {
                    break;
                }

                list.get(num).add(idx);

                indegree[idx]++;
            }
        }

        String res = run(list, indegree, building, N);

        System.out.print(res);
    }

    private static String run(ArrayList<ArrayList<Integer>> list, int[] indegree, Building[] building, int n) {

        PriorityQueue<Building> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        for (int idx = 1; idx <= n; idx++) {
            if (indegree[idx] == 0) {
                pq.offer(building[idx]);
            }
        }

        while (!pq.isEmpty()) {
            int cur = pq.poll().num;

            for (int next : list.get(cur)) {
                indegree[next]--;

                if (indegree[next] == 0) {
                    building[next].time += building[cur].time;
                    pq.offer(new Building(next, building[next].time));
                }
            }
        }

        for (int idx = 1; idx <= n; idx++) {
            sb.append(building[idx].time + "\n");
        }

        return sb.toString();
    }


    static class Building implements Comparable<Building> {
        int num;
        int time;

        public Building(int num, int time) {
            this.num = num;
            this.time = time;
        }

        @Override
        public int compareTo(Building o) {
            return time - o.time;
        }
    }
}
