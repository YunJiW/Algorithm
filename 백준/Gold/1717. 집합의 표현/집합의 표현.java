import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        parent = new int[N+1];
        //전체 만들어두기 그리고 본인 포함 해두기
        for (int idx = 0; idx <= N; idx++) {
            parent[idx] = idx;
        }

        for (int test = 0; test < M; test++) {
            st = new StringTokenizer(br.readLine());
            int select = Integer.parseInt(st.nextToken());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            //0인 경우 둘다 포함
            if (select == 0) {
                if (first == second) {
                    continue;
                }
                union(first,second);
                //쌍방으로 넣어준다.
            } else {
                if (first == second) {
                    sb.append("YES").append("\n");
                    continue;
                }
                if(isSameParent(first,second)){
                    sb.append("YES").append("\n");
                }else
                    sb.append("NO").append("\n");
                //한쪽에만 포함되면 어쩌피 포함된거임.
            }
        }

        System.out.print(sb);
    }

    //부모가 같은지 체크 -> 같으면 같은 집합임.
    private static boolean isSameParent(int first, int second) {
        first = find(first);
        second = find(second);

        if(first == second){
            return true;
        }

        return false;
    }

    public static int find(int num){
        if(num == parent[num]){
            return num;
        }

        return parent[num] = find(parent[num]);
    }
    private static void union(int first, int second) {
        //각 부모 찾기
        first = find(first);
        second = find(second);

        if(first != second){
            if(first < second){
                parent[second] =first;

            }else{
                parent[first]= second;
            }
        }
    }
}
