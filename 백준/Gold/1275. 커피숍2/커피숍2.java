import java.util.*;
import java.io.*;


public class Main {

    static int N,Q;

    static long[] element,tree;



    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        element = new long[N+1];

        st= new StringTokenizer(br.readLine());
        for(int idx =1; idx <=N;idx++){
            element[idx] = Integer.parseInt(st.nextToken());
        }

        int size = getTreeSize();

        tree = new long[size];

        init(1,N,1);


        for(int tc= 0;tc <Q;tc++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            //x 가 클경우 둘이 숫자 바꿈.
            if(x > y){
                int tmp = x;
                x = y;
                y =tmp;
            }

            sb.append(sum(1,N,1,x,y)).append("\n");
            update(1,N,1,a,b);

        }

        System.out.println(sb);


    }



    //초기 트리 만들기
    private static long init(int start, int end, int node) {
        if(start == end){
            return tree[node] = element[start];
        }

        int mid = (start +end)/2;

        return tree[node] = init(start,mid,node*2) + init(mid+1,end,node*2+1);
    }

    //sum 구간합 구하는함수
    private static long sum(int start, int end, int node, int left, int right) {

        if(left > end || right < start)
            return 0;

        if(left <= start && right >= end){
            return tree[node];
        }

        int mid = (start+end)/2;

        return sum(start,mid,node*2,left,right) + sum(mid+1,end,node*2+1,left,right);
    }


    //update 숫자 바뀔때 수정하는 함수
    private static long update(int start,int end,int node,int idx,long val){
        if(idx > end || idx < start)
            return tree[node];

        if(start == end)
        {
            return tree[node] =val;
        }

        int mid = (start+end)/2;

        return tree[node] = update(start,mid,node*2,idx,val) + update(mid+1,end,node*2+1,idx,val);
    }


    //트리 크기 구하는 함수.
    private static int getTreeSize() {
        int h = (int)Math.ceil(Math.log(N)/Math.log(2)) +1;
        return (int)Math.pow(2,h);
    }
}
