import java.util.*;
import java.io.*;


public class Main {

    static int N,M;

    static int [] element,tree;


    static int res;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        element = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int idx= 1 ; idx <=N;idx++){
            element[idx] =Integer.parseInt(st.nextToken());
        }
        
        int size = getTreeSize();
        tree = new int[size];
        
        Init(1,N,1);

        M = Integer.parseInt(br.readLine());

        for(int tc = 0; tc <M;tc++){
            st = new StringTokenizer(br.readLine());

            int point = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            res = Integer.MAX_VALUE;

            //1 인경우 변경
            //2 인경우 최솟값 출력
            if(point == 1){
                element[i] = j;
                update(1,N,1,i,j);


            }else{
                select(1,N,1,i,j);
                sb.append(res).append("\n");
            }
        }
        System.out.println(sb);

    }

    private static void select(int start, int end, int node, int left, int right) {
        if(left > end || right < start){
            return;
        }
        if(left <= start && right >= end){
            res = Math.min(tree[node],res);
            return;
        }

        int mid = (start +end)/2;

        select(start,mid,node*2,left,right);
        select(mid+1,end,node*2+1,left,right);

    }

    private static int update(int start, int end, int node, int idx, int num) {
        if(idx < start || idx > end){
            return tree[node];
        }


        if(start == end)
            return tree[node] = num;


        int mid = (start +end)/2;

        return tree[node] = Math.min(update(start,mid,node*2,idx,num),update(mid+1,end,node*2+1,idx,num));

    }

    private static int Init(int start, int end, int node) {
        if(start == end){
            return tree[node] = element[start];
        }

        int mid =(start+end)/2;

        return tree[node] = Math.min(Init(start,mid,node*2) , Init(mid+1,end,node*2+1));

    }

    private static int getTreeSize() {
        int h = (int)Math.ceil(Math.log(N)/Math.log(2)) +1;
        return (int) Math.pow(2,h);
    }
}
