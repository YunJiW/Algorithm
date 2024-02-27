import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int T =Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(T --> 0){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Point point[] = new Point[M+1];

            for(int idx=  1; idx <=M;idx++){
                st= new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                point[idx] = new Point(a,b);
            }
            Arrays.sort(point, 1, M + 1, (p1, p2) -> (p1.y == p2.y) ? p1.x - p2.x : p1.y - p2.y);

            int ans = 0;
            boolean [] check = new boolean[N+1];

            for(int idx = 1; idx <=M;idx++){
                int a = point[idx].x;
                int b= point[idx].y;

                for(int j = a; j<=b;j++){
                    if(!check[j]){
                        check[j] = true;
                        ans+=1;
                        break;
                    }
                }
            }
            sb.append(ans + "\n");

        }
        System.out.print(sb);

    }

    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
}
