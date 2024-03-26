import java.util.*;
import java.io.*;


public class Main {

    private static final int R = 0;
    private static final int U = 1;
    private static final int L = 2;
    private static final int D = 3;

    private static final int Len = 101;

    private static boolean map[][] = new boolean[Len][Len];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        StringTokenizer st = null;

        for(int idx = 0; idx <N;idx++){
            st= new StringTokenizer(br.readLine());

            int x= Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            Run(x,y,getDirections(d,g));
        }

        System.out.println(Squarecheck());

    }

    private static void Run(int x, int y, List<Integer> directions) {
        map[x][y] = true;

        for(int dir : directions){

            switch (dir){
                case R:
                    map[++x][y] = true;
                    break;
                case U:
                    map[x][--y] = true;
                    break;
                case L:
                    map[--x][y] = true;
                    break;
                case D:
                    map[x][++y] = true;
                    break;
            }
        }
    }

    private static List<Integer> getDirections(int d, int g) {
        List<Integer> dir = new ArrayList<>();
        dir.add(d);

        while(g --> 0){
            for(int idx = dir.size()-1; idx >= 0; idx--){
                int direction = (dir.get(idx) +1) %4;
                dir.add(direction);
            }
        }
        return dir;



    }

    private static int Squarecheck() {
        int cnt = 0;

        for(int x= 0 ;x < Len -1; x++){
            for(int y=0;y <Len-1;y++){
                if(map[x][y] && map[x+1][y] && map[x][y+1] && map[x+1][y+1])
                    cnt+=1;
            }
        }
        return cnt;
    }

}
