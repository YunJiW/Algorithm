import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int parent[];
    static ArrayList<Edge> edgeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());

        Point points[] = new Point[N];

        for (int idx = 0; idx < N; idx++) {
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());

            points[idx] = new Point(idx, x, y);
        }

        edgeList = new ArrayList<>();
        //각 간선 계산을 직접 계산해야함.
        for (int idx = 0; idx < N; idx++) {
            for (int j = idx + 1; j < N; j++) {
                double weight = distance(points[idx], points[j]);
                edgeList.add(new Edge(points[idx].num, points[j].num, weight));
            }
        }
        Collections.sort(edgeList);

        parent = new int[N];
        for (int idx = 0; idx < N; idx++) {
            parent[idx] = idx;
        }

        double res = 0;

        for (int idx = 0; idx < edgeList.size(); idx++) {
            Edge edge = edgeList.get(idx);

            if (find(edge.start) != find(edge.end)) {
                res += edge.weight;
                union(edge.start, edge.end);
            }
        }


        System.out.println(res);
        br.close();


    }

    private static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
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
}


class Point {
    int num;
    double x;
    double y;

    public Point(int num, double x, double y) {
        this.num = num;
        this.x = x;
        this.y = y;
    }
}

class Edge implements Comparable<Edge> {
    int start;
    int end;
    double weight;

    public Edge(int start, int end, double weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {

        if (weight < o.weight) {
            return -1;
        }
        return 1;

    }
}
