import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {


    //나눌 값.
    static int div = 1000000007;

    static int N, M, K;

    //값을 받아놓을 element, 세그먼트 트리만들기 tree
    static long[] element, tree;

    //결과값 필요.
    static int res;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        element = new long[N + 1];
        for (int idx = 1; idx <= N; idx++) {
            element[idx] = Long.parseLong(br.readLine());

        }

        int size = getTreeSize();

        tree = new long[size];
        StringBuilder sb = new StringBuilder();

        init(1, N, 1);

        for (int tc = 0; tc < M + K; tc++) {
            st = new StringTokenizer(br.readLine());

            int point = Integer.parseInt(st.nextToken());
            int first = Integer.parseInt(st.nextToken());
            long second = Long.parseLong(st.nextToken());

            //1은 first번의 값을 second로 변경하고 트리 수정
            //2는 first부터 second 까지 구간곱 구해서 출력
            if (point == 1) {
                element[first] = second;
                update(1, N, 1, first, second);

            } else {
                sb.append(multi(1, N, 1, first, (int) second)).append("\n");
            }

        }
        System.out.println(sb);

    }

    //multi 구간 곱구하는 코드
    private static long multi(int start, int end, int node, int left, int right) {

        //0을곱하게되면 0이되기때문에 1로 리턴
        if (left > end || right < start) {
            return 1;
        }

        if (left <= start && right >= end) {
            return tree[node];
        }

        int mid = (start + end) / 2;

        return (multi(start, mid, node * 2, left, right) * multi(mid + 1, end, node * 2 + 1, left, right)) % div;

    }


    //트리 크기 계산
    private static int getTreeSize() {
        int h = (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
        return (int) Math.pow(2, h);
    }


    //update 값이 바뀐곳 부터 영향주는 곳 값 수정 코드
    private static long update(int start, int end, int node, int idx,long after) {

        if (idx < start || idx > end) {
            return tree[node];
        }

        if (start == end) {
            return tree[node] = after;
        }

        int mid = (start + end) / 2;

        return tree[node] = (update(start, mid, node * 2, idx, after) * update(mid + 1, end, node * 2 + 1, idx, after))%div;
    }


    //init 초반 세그먼트 트리 만드는 코드
    private static long init(int start, int end, int node) {
        if (start == end) {
            return tree[node] = element[start];
        }

        int mid = (start + end) / 2;

        return tree[node] = (init(start, mid, node * 2) * init(mid + 1, end, node * 2 + 1)) % div;
    }


}
