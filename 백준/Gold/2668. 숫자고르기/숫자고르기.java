import java.util.*;
import java.io.*;



public class Main {

    static int N;

    static ArrayList<Integer> list;
    static boolean visited[];

    static int num[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        num = new int[N+1];
        for(int idx = 1;idx <=N;idx++){
            num[idx] = Integer.parseInt(br.readLine());
        }

        list = new ArrayList<>();
        visited = new boolean[N+1];
        for(int idx = 1; idx <= N;idx++){
            visited[idx] = true;
            dfs(idx,idx);
            visited[idx] = false;
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();

        System.out.println(list.size());
        for(int idx =0; idx <list.size();idx++){
            sb.append(list.get(idx)).append("\n");
        }

        System.out.print(sb);


    }

    //target으로 순환하면 싸이클이기때문에 넣어줌. 그외는 패스
    private static void dfs(int idx, int target) {
        if(!visited[num[idx]]){
            visited[num[idx]] = true;
            dfs(num[idx],target);
            visited[num[idx]] = false;
        }
        if(num[idx] == target) list.add(target);
    }
}