import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st;

        parent = new int[N + 1];

        for (int idx = 1; idx <= N; idx++) {
            parent[idx] = idx;
        }

        for (int idx = 1; idx <= N; idx++) {
            st = new StringTokenizer(br.readLine());
            for (int num = 1; num <= N; num++) {
                int tmp = Integer.parseInt(st.nextToken());

                if (tmp == 1) {
                    union(idx, num);
                }

            }
        }

        st =new StringTokenizer(br.readLine());
        int start= find(Integer.parseInt(st.nextToken()));

        for(int idx = 1; idx <M;idx++){
            int cur = Integer.parseInt(st.nextToken());

            if(start != find(cur)){
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");

    }

    //핵심로직
    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            if (x < y) {
                parent[y] = x;
            } else {
                parent[x] = y;
            }
        }

    }

    private static int find(int x) {
        if (x == parent[x])
            return x;

        return parent[x] = find(parent[x]);
    }
}
