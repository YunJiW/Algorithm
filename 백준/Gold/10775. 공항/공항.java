import java.io.*;
import java.util.*;

public class Main {

    static int parent[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int G = Integer.parseInt(br.readLine());

        int P = Integer.parseInt(br.readLine());

        parent = new int[G+1];

        for(int idx = 1 ; idx <= G;idx++){
            parent[idx] = idx;
        }

        int ans = 0;

        for(int idx= 0 ; idx < P; idx++){
            int num = Integer.parseInt(br.readLine());

            int emptyGate = find(num);

            //도킹이 불가능하기 때문에 끝
            if(emptyGate == 0){
                break;
            }

            ans+=1;
            union(emptyGate,emptyGate-1);

        }

        System.out.println(ans);


    }

    public static int find(int x){
        if(x == parent[x]){
            return x;
        }

        return parent[x] = find(parent[x]);
    }


    public static void union(int x, int y){
        x= find(x);
        y = find(y);

        if(x != y){
            parent[x] = y;
        }
    }
}
