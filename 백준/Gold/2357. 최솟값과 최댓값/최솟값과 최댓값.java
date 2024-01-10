import java.util.*;
import java.io.*;

public class Main {

    static int n,min,max;
    static int Init = 1000000001;

    static int [] minTree,maxTree,elemets;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        elemets = new int[n+1];

        for(int index = 1; index <=n;index++){
            elemets[index] = Integer.parseInt(br.readLine());
        }
        
        int size = getTreeSize();

        minTree = new int[size];
        maxTree = new int[size];

        Init(0,minTree,1,n,1);
        Init(1,maxTree,1,n,1);

        for(int tc =0 ; tc <m;tc++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to =  Integer.parseInt(st.nextToken());

            min = Init;
            max = -1;


            query(0,minTree,1,n,1,from,to);
            query(1,maxTree,1,n,1,from,to);

            sb.append(min + " " + max).append("\n");


        }
        System.out.println(sb);

    }

    private static int getTreeSize() {
        int h = (int)Math.ceil(Math.log(n)/Math.log(2)) +1;
        return (int)Math.pow(2,h);
    }

    //0은 최소
    //1은 최대
    private static void Init(int type,int[] tree,int start, int end, int node) {
        if(start == end){
             tree[node] = elemets[start];
        }else{
            int mid = (start+end)/2;
            Init(type,tree,start,mid,node*2);
            Init(type,tree,mid+1,end,node*2+1);

            if(type == 0){
                if(tree[node*2] < tree[node*2+1]){
                    tree[node] = tree[node*2];
                }else{
                    tree[node] =  tree[node*2+1];
                }
            }else{
                if(tree[node*2] > tree[node*2+1]){
                    tree[node] = tree[node*2];
                }else{
                    tree[node] =  tree[node*2+1];
                }
            }
        }
    }

    //최소 최대 값 구하는 함수
    private static void query(int type, int[] tree, int start, int end, int node, int left, int right) {
        if(left > end || right < start) return;

        if(left <= start && end <= right){
            if(type ==0){
                min = Math.min(tree[node],min);
            }else{
                max = Math.max(tree[node],max);
            }
            return;
        }

        int mid = (start+end)/2;
        query(type,tree,start,mid,node*2,left,right);
        query(type,tree,mid+1,end,node*2+1,left,right);
    }
}
