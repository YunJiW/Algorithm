import java.util.*;
import java.io.*;

public class Main {


    static int N,K;

    static long[] element,tree;



    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));


        StringBuilder sb = new StringBuilder();

        String input ="";
        //테스트 케이스 크기를 주지않았으니 무한루프로 진행.
        while((input = br.readLine()) != null){
            StringTokenizer st = new StringTokenizer(input," ");
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            element = new long[N+1];
            st = new StringTokenizer(br.readLine());

            for(int idx =1; idx <=N;idx++){
                Long tmp = Long.parseLong(st.nextToken());
                element[idx] = (tmp ==0) ? 0 : (tmp > 0)?  1 : -1;
            }

            int size = getTreeSize();
            tree = new long[size];
            init(1,N,1);


            for(int idx =0 ;idx <K;idx++){
                st = new StringTokenizer(br.readLine());
                String command = st.nextToken();

                int num1 = Integer.parseInt(st.nextToken());
                int num2 =Integer.parseInt(st.nextToken());

                if(command.equals("C")){
                    num2 = (num2 == 0) ? 0 : (num2 > 0) ? 1: -1;
                    element[num1] = num2;
                    update(1,N,1,num1,num2);
                }else{
                    long res = multi(1,N,1,num1,num2);
                    if(res > 0){
                        sb.append("+");
                    }
                    else if(res < 0){
                        sb.append("-");
                    }else{
                        sb.append("0");
                    }

                }
            }
            sb.append("\n");



        }
        System.out.println(sb);





    }

    //트리 계산
    private static int getTreeSize() {
        int h = (int)Math.ceil(Math.log(N)/Math.log(2)) +1;
        return (int)Math.pow(2,h);
    }
    
    //init 초기 트리
    public static long init(int start,int end,int node){
        if(start == end){
            return tree[node] = element[start];
        }
        int mid = (start +end)/2;


        return tree[node] = (init(start,mid,node*2) * init(mid+1,end,node*2+1));
    }
    
    
    //multi 곱 계산 용
    public static long multi(int start,int end,int node,int left,int right){
        //0을곱하게되면 0이되기때문에 1로 리턴
        if (left > end || right < start) {
            return 1;
        }

        if (left <= start && right >= end) {
            return tree[node];
        }

        int mid = (start + end) / 2;

        return (multi(start, mid, node * 2, left, right) * multi(mid + 1, end, node * 2 + 1, left, right));

    }
    
    //update 값 변경용
    public static long update(int start,int end,int node,int idx,long val){

        if(idx < start || idx > end){
            return tree[node];
        }

        if(start == end){
            return tree[node] = val;
        }

        int mid = (start+end)/2;



        return tree[node] = (update(start,mid,node*2,idx,val) * update(mid+1,end,node*2+1,idx,val));
    }

}
