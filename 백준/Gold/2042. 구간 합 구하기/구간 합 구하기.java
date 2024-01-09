import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//세그먼트 트리를 이용한 풀이법.

public class Main {

    static int N;
    static long tree[];

    static long num[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(st.nextToken());

        tree = new long[N * 4];
        //처음 숫자
        num = new long[N + 1];

        StringBuilder sb = new StringBuilder();


        for (int idx = 1; idx <= N; idx++) {
            num[idx] = Long.parseLong(br.readLine());
        }

        init(1, N, 1);


        //총 M+K 만큼 반복되면서 값 갱신.
        for (int tc = 0; tc < M + K; tc++) {
            st = new StringTokenizer(br.readLine());

            int point = Integer.parseInt(st.nextToken());
            int first = Integer.parseInt(st.nextToken());
            long second =Long.parseLong(st.nextToken());


            //1인경우 -> 변환
            if (point == 1) {
                long dif = second - num[first];
                num[first] = second;
                //중간 부분 구간합 갱신
                update(1,N,1,first,dif);

                //2인경우 구간합 계산
            } else {
                sb.append(sum(1,N,1,first,(int)second)).append("\n");
            }

        }

        System.out.println(sb);
    }


    private static long init(int start, int end, int node) {
        if (start == end) {
            return tree[node] = num[start];
        }

        int mid = (start + end) / 2;

        return tree[node] = init(start, mid, node * 2) + init(mid+1, end, node * 2 + 1);
    }

    private static long sum(int start,int end,int node, int left, int right){

        if(left > end || right <start){
            return 0;
        }

        //범위 안에있는 경우
        if(left <= start && right >= end){
            return tree[node];
        }

        int mid = (start + end)/2;

        return sum(start,mid,node*2,left,right) + sum(mid+1,end,node*2+1,left,right);
    }


    private static void update(int start, int end, int node, int idx, long dif) {

        //범위 밖인 경우
        if(idx < start || idx >end){
            return;
        }

        //밑의 원소들 갱신
        tree[node] +=dif;
        if(start ==end){
            return;
        }

        int mid = (start +end)/2;

        update(start,mid,node*2,idx,dif);
        update(mid+1,end,node*2+1,idx,dif);
    }



}
