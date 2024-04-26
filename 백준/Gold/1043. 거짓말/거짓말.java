import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {


    static int parent[];
    static List<Integer> eList;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];

        for (int idx = 1; idx <= n; idx++) {
            parent[idx] = idx;
        }

        st = new StringTokenizer(br.readLine());
        int en = Integer.parseInt(st.nextToken());
        eList = new ArrayList<>();

        if (en == 0) {
            System.out.println(m);
            return;
        } else {
            for (int idx = 0; idx < en; idx++) {
                eList.add(Integer.parseInt(st.nextToken()));
            }
        }

        List<Integer>[] partyList = new ArrayList[m];
        for (int idx = 0; idx < m; idx++) {
            partyList[idx] = new ArrayList<>();
        }

        for (int idx = 0; idx < m; idx++) {
            st = new StringTokenizer(br.readLine());

            int person = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            partyList[idx].add(x);

            for (int nxt = 1; nxt < person; nxt++) {
                int y = Integer.parseInt(st.nextToken());
                union(x, y);
                partyList[idx].add(y);
            }

        }

        int cnt = 0;
        for (int idx = 0; idx < m; idx++) {
            boolean flag = true;
            for (int num : partyList[idx]) {
                if (eList.contains(find(parent[num]))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                cnt += 1;
            }
        }
        System.out.println(cnt);
    }

    //핵심로직
    public static int find(int x) {
        if (parent[x] == x) return x;

        return find(parent[x]);
    }

    //핵심로직
    private static void union(int x, int y) {
        int rx = find(x);
        int ry = find(y);

        if (eList.contains(ry)) {
            int tmp = rx;
            rx = ry;
            ry = tmp;
        }
        parent[ry] = rx;

    }
}
