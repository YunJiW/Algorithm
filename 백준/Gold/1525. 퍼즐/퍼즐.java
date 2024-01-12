import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static String answer = "123456780";
    static Map<String, Integer> map = new HashMap<>();

    //좌 우 상 하
    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {-1, 1, 0, 0};

    static int result = -1;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String init = "";
        for (int row = 0; row < 3; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < 3; col++) {
                int num = Integer.parseInt(st.nextToken());
                init += num;
            }
        }

        map.put(init,0);
        start(init);

        System.out.println(result);
    }

    private static void start(String init) {
        Queue<String> q = new LinkedList<>();

        q.offer(init);
        while(!q.isEmpty()){
            String cur = q.poll();
            int move = map.get(cur);
            int zeroPoint = cur.indexOf("0");
            int cur_x = zeroPoint/3;
            int cur_y = zeroPoint%3;

            if(cur.equals(answer)){
                result = move;
                return;
            }

            for(int idx = 0;idx <4;idx++)
            {
                int nx = cur_x +dx[idx];
                int ny = cur_y + dy[idx];

                //맵을 벗어나는 경우 제외.
                if(nx < 0 || nx >= 3|| ny <0 || ny>=3)
                    continue;

                int nPos = nx*3 + ny;
                char ch = cur.charAt(nPos);
                String next = cur.replace(ch,'c');
                next = next.replace('0', ch);
                next = next.replace('c','0');

                if(!map.containsKey(next)){
                    q.add(next);
                    map.put(next,move+1);
                }
            }
        }
     }
}