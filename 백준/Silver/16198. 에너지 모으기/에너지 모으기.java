import java.io.*;
import java.util.*;

public class Main {

    static int N;

    static int max =Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int idx = 0;idx <N;idx++){
            list.add(Integer.parseInt(st.nextToken()));
        }
        dfs(list,0);

        System.out.println(max);
    }

    private static void dfs(List<Integer> list, int sum) {
        if(list.size() <= 2){
            if(max <sum){
                max = sum;
            }
            return;
        }
        for(int idx = 1; idx <list.size()-1;idx++){
            int tmp = list.get(idx);
            int num = list.get(idx-1) * list.get(idx+1);
            list.remove(idx);
            dfs(list,sum+num);
            list.add(idx,tmp);
        }
    }
}
