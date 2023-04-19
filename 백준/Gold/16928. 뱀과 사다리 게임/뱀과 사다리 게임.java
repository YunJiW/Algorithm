import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {



    static HashSet<Integer> start_line = new HashSet<>();
    static HashMap<Integer,Integer> maps = new HashMap<>();

    static HashSet<Integer> start_snake = new HashSet<>();
    static HashMap<Integer,Integer> snake_maps = new HashMap<>();

    public static boolean visited[] = new boolean[101];

    static int answer;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(st.nextToken());
        answer = Integer.MAX_VALUE;
        //사다리 먼저
        for(int idx = 0; idx < N;idx++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            start_line.add(start);
            maps.put(start,end);
        }
        //뱀 위치 체크 사실상 뱀은 밟는순간 뒤로 가기 때문에 최소가 아닌게 아닌가?
        for(int idx = 0; idx < M;idx++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            start_snake.add(start);
            snake_maps.put(start,end);
        }

        game_Start(1);

        System.out.println(answer);
    }

    private static void game_Start(int start_idx) {
        Queue<Point> que = new LinkedList<>();
        que.offer(new Point(start_idx,0));
        visited[start_idx] = true;
        while(!que.isEmpty()){
            Point cur = que.poll();
            if(cur.number == 100){
                answer = Math.min(answer,cur.count);
                return;
            }

            for(int idx= 1; idx <=6;idx++){
                int next_number = cur.number + idx;

                //100을 넘기는 경우는 pass
                if(next_number > 100 ){
                    continue;
                }

                //사다리가 있는 곳인경우
                if(start_line.contains(next_number) && !visited[next_number]){
                    visited[next_number] = true;
                    visited[maps.get(next_number)] = true;
                    que.offer(new Point(maps.get(next_number),cur.count+1));
                    continue;
                }
                //뱀이있는 경우
                if(start_snake.contains(next_number) && !visited[next_number] ){
                    visited[next_number] = true;
                    visited[snake_maps.get(next_number)] = true;
                    que.offer(new Point(snake_maps.get(next_number), cur.count+1));
                    continue;
                }

                //방문하지 않은 경우
                if(!visited[next_number]) {
                    visited[next_number] = true;
                    que.offer(new Point(next_number, cur.count + 1));
                }

            }
        }
    }
}

class Point{
    int number;
    int count;

    public Point(int number, int count) {
        this.number = number;
        this.count = count;
    }
}
