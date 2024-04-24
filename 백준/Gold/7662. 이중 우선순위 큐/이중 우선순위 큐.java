import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    //핵심
    static Map<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int test = 0; test < t; test++) {
            int input = Integer.parseInt(br.readLine());

            Queue<Integer> min = new PriorityQueue<>();
            Queue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

            map = new HashMap<>();

            for (int idx = 0; idx < input; idx++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();

                if (command.equals("I")) {
                    int num = Integer.parseInt(st.nextToken());
                    max.offer(num);
                    min.offer(num);
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else {
                    int type = Integer.parseInt(st.nextToken());

                    if (map.size() == 0) {
                        continue;
                    }
                    //1 은 최댓값 삭제
                    //-1 은 최솟값 삭제
                    if (type == 1) {
                        delete(max);
                    } else {
                        delete(min);
                    }

                }
            }

            if (map.size() == 0) {
                sb.append("EMPTY\n");
            } else {
                int res = delete(max);
                sb.append(res + " ");
                if (map.size() > 0) res = delete(min);
                sb.append(res).append("\n");
            }
        }
        System.out.println(sb);


    }

    //핵심 로직
    private static int delete(Queue<Integer> queue) {
        int res = 0;
        while (true) {
            res = queue.poll();

            int cnt = map.getOrDefault(res, 0);
            if (cnt == 0) {
                continue;
            }

            if (cnt == 1) {
                map.remove(res);
            } else {
                map.put(res, cnt - 1);
            }
            break;
        }
        return res;
    }
}