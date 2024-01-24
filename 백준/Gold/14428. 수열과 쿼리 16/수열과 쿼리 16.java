import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int N, M;


    static int[] element, tree;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



        StringBuilder sb= new StringBuilder();
        N = Integer.parseInt(br.readLine());
        element = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int idx = 1; idx <= N; idx++) {
            element[idx] = Integer.parseInt(st.nextToken());
        }

        int size = getTreeSize();
        tree = new int[size];

        init(1, N, 1);

        M = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < M; tc++) {
            st = new StringTokenizer(br.readLine());

            int point = Integer.parseInt(st.nextToken());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            if(point == 1){
                update(1,N,1,first,second);
            }else{
                sb.append(query(1,N,1,first,second)).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void init(int start, int end, int node) {
        if (start == end)
            tree[node] = start;
        else {
            int mid = (start + end) / 2;
            init(start, mid, node * 2);
            init(mid + 1, end, node * 2 + 1);

            if (element[tree[node * 2]] <= element[tree[node * 2 + 1]]) {
                tree[node] = tree[node * 2];
            } else {
                tree[node] = tree[node * 2 + 1];
            }

        }
    }

    private static int query(int start, int end, int node, int left, int right) {
        if (left > end || right < start) {
            return -1;
        }

        if (left <= start && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        int m1 = query(start, mid, node * 2, left, right);
        int m2 = query(mid + 1, end, node * 2 + 1, left, right);

        if (m1 == -1) {
            return m2;
        } else if (m2 == -1) {
            return m1;
        } else {
            if (element[m1] <= element[m2]) {
                return m1;
            } else {
                return m2;
            }
        }
    }

    private static void update(int start, int end, int node, int idx, int val) {
        if (idx < start || idx > end) {
            return;
        }

        if (start == end) {
            tree[node] = idx;
            element[idx] = val;
            return;
        }

        int mid = (start + end) / 2;

        update(start, mid, node * 2, idx, val);
        update(mid + 1, end, node * 2 + 1, idx, val);

        if (element[tree[node * 2]] <= element[tree[node * 2 + 1]]) {
            tree[node] = tree[node * 2];
        } else {
            tree[node] = tree[node * 2 + 1];
        }

    }


    private static int getTreeSize() {
        int h = (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
        return (int) Math.pow(2, h);
    }


}
