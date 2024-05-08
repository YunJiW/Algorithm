import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M, W;

    static int[] dist;
    static int INF = 987654321;

    static ArrayList<ArrayList<Road>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            list = new ArrayList<>();
            dist = new int[N + 1];

            //N개의 지점
            for (int idx = 0; idx <= N; idx++) {
                list.add(new ArrayList<>());
            }

            //M개의 도로
            for (int idx = 0; idx < M + W; idx++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                if (idx < M) {
                    list.get(start).add(new Road(end, weight));
                    list.get(end).add(new Road(start, weight));
                } else {
                    list.get(start).add(new Road(end, -weight));
                }
            }
            boolean CycleCheck = false;
            for (int idx = 1; idx <= N; idx++) {
                if (bellmanFord(idx)) {
                    CycleCheck = true;
                    sb.append("YES\n");
                    break;
                }
            }
            if (!CycleCheck) {
                sb.append("NO\n");
            }

        }
        System.out.print(sb);

    }

    public static boolean bellmanFord(int start) {
        Arrays.fill(dist, INF);
        dist[start] = 0;
        boolean update = false;

        for (int idx = 1; idx < N; idx++) {
            update = false;

            for (int j = 1; j <= N; j++) {
                for (Road road : list.get(j)) {
                    if (dist[j] != INF && dist[road.end] > dist[j] + road.weight) {
                        dist[road.end] = dist[j] + road.weight;
                        update = true;
                    }
                }
            }

            if (!update) {
                break;
            }
        }

        if (update) {
            for (int idx = 1; idx <= N; idx++) {
                for (Road road : list.get(idx)) {
                    if (dist[idx] != INF && dist[road.end] > dist[idx] + road.weight) {
                        return true;
                    }
                }
            }
        }

        return false;

    }

    public static class Road {
        int end;
        int weight;

        public Road(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }

}
