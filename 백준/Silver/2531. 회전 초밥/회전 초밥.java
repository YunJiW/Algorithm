import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int result;
    static int N, d, k, c;

    static int count = 0;

    static int sushi[];
    static int eat[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        count = 0;
        sushi = new int[N];
        eat = new int[d + 1]; //번호가 1 ~ d까지 있기 때문에




        //기본 초밥벨트 입력
        for (int idx = 0; idx < N; idx++) {
            sushi[idx] = Integer.parseInt(br.readLine());
        }

        //초기 세팅
        for (int idx = 0; idx < k; idx++) {
            if (eat[sushi[idx]] == 0) {
                count += 1;
            }
            //중복체크를 해야하기때문에 -> 만약 1개만 할 경우 중복 체크가 잘못될 확률 있음.
            eat[sushi[idx]] += 1;
        }
        result = count;

        Simulacheck();

        System.out.println(result);
    }

    //핵심로직 (슬라이딩 윈도우)
    private static void Simulacheck() {
        //시작 갯수
        for (int start = 1; start < N; start++) {

            if (result <= count) {
                if (eat[c] == 0) {
                    result = count + 1;
                } else {
                    result = count;
                }
            }

            //순환하면서 추가되야하기때문에
            int end = (start + k - 1) % N;
            if (eat[sushi[end]] == 0) {
                count += 1;
            }

            eat[sushi[end]] += 1;

            //이동을 해야하기때문에 start위치의 접시를 빼줌.
            eat[sushi[start - 1]] -= 1;
            if (eat[sushi[start - 1]] == 0) {
                count -= 1;
            }

            //접시수 갱신
            if (result <= count) {
                if (eat[c] == 0) {
                    result = count + 1;
                } else {
                    result = count;
                }
            }

        }
    }
}
