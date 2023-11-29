import java.util.*;
import java.io.*;


public class Main {
    static int dp[] = new int[10001];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        //기본적으로 값을 채워둠
        for(int idx = 0; idx <=d;idx++){
            dp[idx] = idx;
        }
        ArrayList<ShortCut> list= new ArrayList<>();
        for(int idx = 0; idx <N; idx++){
            st= new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            //지름길인데 원래 거리보다 길경우는 지름길이 아니다.
            if(y-x > dist){
                list.add(new ShortCut(x,y,dist));
            }

        }
        Collections.sort(list);
        int prev=0;
        for(int idx =0; idx <list.size();idx++){
            ShortCut line = list.get(idx);
            int x = line.x;
            int y = line.y;
            int dist = line.dist;

            prev = dp[x];
            //지름을 더한 값이 원래 거리보다 작은경우와 y가 고속도로보다 작거나 같은 경우
            //값 갱신 필요
            if(dp[y] > (prev+dist) && y <= d){
                dp[y] = prev+dist;
                //값 갱신 필요
                for(int j = y+1; j <= d ;j++) {
                    dp[j] = Math.min(dp[j],prev+dist+ (j - y));
                }
            }

        }
        System.out.println(dp[d]);
    }

    public static class ShortCut implements Comparable<ShortCut>{
        int x;
        int y;
        int dist;

        public ShortCut(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(ShortCut o) {
            if(this.x == o.x){
                if(this.y == o.y){
                    return this.dist - o.dist;
                }
                return this.y - o.y;
            }
            return this.x - o.x;
        }
    }
}