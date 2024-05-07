import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static ArrayList<ArrayList<City>> list;
    static long[] dist;
    static int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        dist = new long[N + 1];
        for (int idx = 0; idx <= N; idx++) {
            list.add(new ArrayList<>());
            dist[idx] = INF;
        }

        for (int idx = 0; idx < M; idx++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list.get(start).add(new City(end, weight));
        }
        StringBuilder sb = new StringBuilder();
        if (bellmanFord()) {
            sb.append("-1").append("\n");
        } else {
            for (int idx = 2; idx <= N; idx++) {
                if (dist[idx] == INF) {
                    sb.append("-1\n");
                } else {
                    sb.append(dist[idx] + "\n");
                }
            }
        }

        System.out.println(sb);
        br.close();

    }

    public static boolean bellmanFord() {
        dist[1] = 0;
        boolean update = false;

        for (int idx = 1; idx < N; idx++) {
            update = false;

            for (int j = 1; j <= N; j++) {
                for (City city : list.get(j)) {
                    if (dist[j] == INF) {
                        break;
                    }

                    if (dist[city.end] > dist[j] + city.weight) {
                        dist[city.end] = dist[j] + city.weight;
                        update = true;
                    }

                }
            }
            if (!update) break;
        }

        if (update) {
            for (int idx = 1; idx <= N; idx++) {
                for (City city : list.get(idx)) {
                    if (dist[idx] == INF) {
                        break;
                    }
                    if (dist[city.end] > dist[idx] + city.weight) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static class City {
        int end;
        int weight;

        public City(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }
}
