import java.util.*;
import java.io.*;


/**
 * Union-find 문제
 * 이 알고리즘을 사용해서 문제를 풀어본적이 거의없음.
 */

public class Main {

    static int[] parent;
    static int[] level;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(T-->0){
            int F = Integer.parseInt(br.readLine());

            parent = new int[F*2];
            level = new int[F*2];

            for(int idx = 0; idx < F*2;idx++){
                parent[idx] = idx;
                level[idx] = 1;
            }

            int index = 0;
            Map<String,Integer> map = new HashMap<>();

            for(int idx =0; idx <F;idx++){
                st = new StringTokenizer(br.readLine());
                String First = st.nextToken();
                String Second = st.nextToken();

                if(!map.containsKey(First)){
                    map.put(First,index++);
                }

                if(!map.containsKey(Second)){
                    map.put(Second,index++);
                }

                sb.append((union(map.get(First), map.get(Second)))).append("\n");
            }


        }
        System.out.println(sb);

    }

    //부모 찾기
    public static int find(int x){
        if(x == parent[x]){
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    public static int union(int x , int y){
        x =find(x);
        y= find(y);

        if(x != y){
            parent[y] =x;
            level[x] += level[y];

            level[y] = 1;
        }

        return level[x];
    }
}
