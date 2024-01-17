import java.util.*;
import java.io.*;


public class Main {

    static int N,M;
    static int [] minTree,elements;


    static int res = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        elements = new int[N+1];

        for(int idx = 1; idx <=N;idx++){
            elements[idx] = Integer.parseInt(br.readLine());
        }

        int size = getTreeSize();
        minTree = new int[size];

        Init(minTree,1,N,1);

        for(int tc = 0; tc<M;tc++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());


            res = Integer.MAX_VALUE;

            query(minTree,1,N,1,a,b);

            sb.append(res).append("\n");



        }

        System.out.println(sb);
        

    }

    private static void query(int[] tree, int start, int end, int node, int left, int right) {
        //범위바깥인 경우는 끝
        if(left > end ||start > right) return;

        //범위 안 인경우 최소값 계산
        if(left <= start && right >= end){
            res = Math.min(tree[node],res);
            return;
        }

        int mid = (start +end)/2;
        query(tree,start,mid,node*2,left,right);
        query(tree,mid+1,end,node*2+1,left,right);


    }

    private static void Init(int[] tree, int start, int end, int node) {
        if(start == end){
            tree[node] = elements[start];
        }
        else{
            int mid = (start +end)/2;
            Init(tree,start,mid,node*2);
            Init(tree,mid+1,end,node*2+1);

            if(tree[node*2] < tree[node*2+1]){
                tree[node] = tree[node*2];
            }else{
                tree[node] = tree[node*2+1];
            }
        }
    }

    private static int getTreeSize() {
        int h = (int)Math.ceil(Math.log(N)/Math.log(2)) +1;
        return (int)Math.pow(2,h);
    }
}
