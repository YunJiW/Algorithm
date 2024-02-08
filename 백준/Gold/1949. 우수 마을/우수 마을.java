import java.util.*;
import java.io.*;


public class Main {

    static int[] town;
    static List<Integer>[] list;
    static boolean[] check;
    static int[][] memo;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        town = new int[n+1];
        memo = new int[n+1][2];
        check = new boolean[n+1];
        list = new List[n+1];

        for(int idx = 0; idx <=n;idx++){
            list[idx] = new ArrayList<>();
        }

        for(int idx =1;idx <=n;idx++){
            Arrays.fill(memo[idx],-1);
        }
        st = new StringTokenizer(br.readLine());
        for(int idx =1; idx <=n;idx++){
            town[idx] = Integer.parseInt(st.nextToken());
        }

        for(int idx= 0; idx <n-1;idx++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[b].add(a);
            list[a].add(b);
        }

        System.out.println(Math.max(traveral(1,0),traveral(1,1) + town[1]));

    }

    public static int traveral(int pos,int flag){
        if(list[pos].size() == 0) return 0;
        if(memo[pos][flag] != -1) return memo[pos][flag];

        check[pos] = true;
        memo[pos][flag] = 0;
        for(int child : list[pos]){
            if(check[child]) continue;
            if(flag == 1){
                memo[pos][flag] += traveral(child,0);
            }else{
                memo[pos][flag] += Math.max(traveral(child,1) + town[child],traveral(child,0));
            }
        }
        check[pos] = false;
        return memo[pos][flag];
    }
}
