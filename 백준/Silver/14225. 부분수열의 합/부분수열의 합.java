import java.io.*;
import java.util.*;


public class Main {

    static HashSet<Integer> numbers = new HashSet<>();

    static int[] num;

    static int N;

    static boolean[] visited;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        num = new int[N];
        visited = new boolean[N];

        st= new StringTokenizer(br.readLine());
        for(int idx= 0; idx <N;idx++){
            num[idx] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);
        for(int idx =1;idx <=N;idx++){
            partSum(0,0,0,idx);
        }

        //작은 수부터 체크용
        int result = 1;
        while(true){
            if(numbers.contains(result)){
                result+=1;
            }else{
                break;
            }
        }
        System.out.println(result);

    }

    private static void partSum(int depth,int sum,int index,int max) {

        if(depth == max){
            numbers.add(sum);
            return;
        }

        for(int idx =index;idx < N;idx++){
            if(!visited[idx]){
                visited[idx] = true;
                partSum(depth+1,sum+num[idx],idx,max);
                visited[idx] = false;
            }
        }

    }
}
