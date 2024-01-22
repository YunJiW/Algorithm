import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static long[] element, Tree;

    static int N, M;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int size = getTreeSize();
        element = new long[N + 1];
        Tree = new long[size];

        //init 이 필요없음 -> 초기값이 전부 0이기때문에.

        for(int idx = 0; idx <M;idx++){
            st = new StringTokenizer(br.readLine());

            int select = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            long b = Long.parseLong(st.nextToken());


            //0 : a 부터 b까지 합계산
            //1 : a 번째 값을 b로 변환
            if(select == 0){
                if(a > b){
                    int tmp = a;
                    a = (int)b;
                    b = tmp;
                }
                sb.append(sum(1,N,1,a,(int)b)).append("\n");
            }else{
                long diff= b - element[a];
                element[a] = b;
                update(1,N,1,a,diff);
            }
        }

        System.out.println(sb);


    }

    //트리 계산 공식.
    private static int getTreeSize() {

        int h = (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
        return (int) Math.pow(2, h);
    }

    //sum : 구간합을 구할 함수
    private static long sum(int start, int end, int node, int left, int right) {
        if (left > end || right < start) {
            return 0;
        }

        if (left <= start && right >= end) {
            return Tree[node];
        }

        int mid = (start + end) / 2;

        return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);

    }


    //update : 값을 변경시 영향을 미치는 수들을 수정할 함수.

    private static void update(int start, int end,int node,int idx,long dif){

        //범위를 벗어날땐 return
        if(idx < start || idx > end){
            return;
        }

        Tree[node] += dif;
        if(start == end){
            return;
        }
        int mid = (start+end)/2;

        update(start,mid,node*2,idx,dif);
        update(mid+1,end,node*2+1,idx,dif);
    }
}
