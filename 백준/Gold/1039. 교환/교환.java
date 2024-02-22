import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Trade {
    int num;
    int cnt;
	
    public Trade(int num, int cnt) {
        this.num = num;
        this.cnt = cnt;
    }
}

public class Main {

    static int N, K;
    static int result = -1; // K번 연산을 할 수 없는 경우 -1을 출력하도록 -1로 초기화
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs();
        System.out.println(result);
		
    }
	
    public static void bfs() {
        Queue<Trade> q = new LinkedList<>();
        boolean[][] visited = new boolean[1000001][K + 1];
		
        q.add(new Trade(N, 0));
        visited[N][0] = true;
		
        while (!q.isEmpty()) {
            Trade t = q.poll();
			
            // 교환 횟수가 K일 경우 최댓값 갱신 후 다음 숫자로 넘어감
            if (t.cnt == K) {
                result = Math.max(result, t.num);
                continue;
            }
			
            int len = String.valueOf(t.num).length();
			
            for (int i = 0; i < len - 1; i++) {
                for (int j = i + 1; j < len; j++) {
                    int next = swap(t.num, i , j);
					
                    if (next != -1 && !visited[next][t.cnt + 1]) {
                        q.add(new Trade(next, t.cnt + 1));
                        visited[next][t.cnt + 1] = true;
                    }
                }
            }
        }
		
    }
	
    // i번 위치의 숫자와 j번 위치의 숫자를 바꿈
    public static int swap(int n, int i, int j) {
        char[] numArr = String.valueOf(n).toCharArray();
	
        // i가 0이고 j번 위치의 숫자가 0이라면 숫자를 바꿨을 때 0으로 시작하게 되기 때문에 -1을 return
        if (i == 0 && numArr[j] == '0') {
            return -1;
        }
		
        char tmp;
        tmp = numArr[i];
        numArr[i] = numArr[j];
        numArr[j] = tmp;
		
        return Integer.parseInt(new String(numArr));
    }

}