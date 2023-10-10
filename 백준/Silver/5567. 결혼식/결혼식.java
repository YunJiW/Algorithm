import java.util.*;
import java.io.*;


public class Main {


    static int N;

    static boolean[] visited;

    public static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    static int result = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for(int idx = 0; idx <=N;idx++){
            list.add(new ArrayList<>());
        }

        int T = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];

        for(int cases = 0; cases < T;cases++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        
        start(1);

        System.out.println(result);

    }

    private static void start(int index) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{index,0});
        visited[index] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            //친구의 친구까지 체크끝난 경우
            if(cur[1] == 2){
                break;
            }

            for(int num : list.get(cur[0])){
                if(!visited[num]){
                    result+=1;
                    visited[num] = true;
                    queue.offer(new int[]{num,cur[1]+1});
                }
            }
        }
    }


}
