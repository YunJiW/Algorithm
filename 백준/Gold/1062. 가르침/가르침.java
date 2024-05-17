import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int K;
    static boolean alpha[] = new boolean[26];

    static String words[];

    static int res = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        words = new String[N];
        for (int idx = 0; idx < N; idx++) {
            words[idx] = br.readLine();
        }

        //기본적으로 들어가는 a,n,t,i,c는 true로 바꿔주기 -> 항상 들어가기 때문에.
        alpha['a' - 'a'] = true;
        alpha['n' - 'a'] = true;
        alpha['t' - 'a'] = true;
        alpha['i' - 'a'] = true;
        alpha['c' - 'a'] = true;

        //K의 개수가 5개 미만인 경우 -> 기본적인 5개의 글자도 못읽는거기때문에 0 출력
        if (K < 5) {
            System.out.println(res);
            return;
        }

        dfs(0, 0);
        System.out.println(res);


    }

    //조합 만들기.
    private static void dfs(int idx, int cnt) {
        if (cnt + 5 == K) {
            wordCheck();
            return;
        }

        for (int i = idx; i < 26; i++) {
            //이미 선택한 단어는 pass -> 항상 선택해야하는 단어가 있기 때문에.
            if (alpha[i]) {
                continue;
            }


            alpha[i] = true;
            dfs(i + 1, cnt + 1);
            alpha[i] = false;

        }
    }

    private static void wordCheck() {
        int cnt = 0;
        for (int idx = 0; idx < N; idx++) {
            String word = words[idx];
            boolean IsPossible = true;
            for (int index = 0; index < word.length(); index++) {
                //현재 알파벳을 배우지 않은 경우 읽을수 없으니 다음 단어로 넘어가기.
                if (!alpha[word.charAt(index) - 'a']) {
                    IsPossible = false;
                    break;
                }
            }
            if (IsPossible) {
                cnt += 1;
            }
        }
        res = Math.max(res, cnt);

    }
}
