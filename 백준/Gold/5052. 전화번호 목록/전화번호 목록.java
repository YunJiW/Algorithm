import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        String[] phone;
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            phone = new String[N];
            for (int idx = 0; idx < N; idx++) {
                phone[idx] = br.readLine();
            }
            Arrays.sort(phone);

            if (isContains(N, phone)) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        System.out.println(sb);

    }

    //포함여부 확인
    //포함이 되어있다면 일관성이 없으므로 false
    //포함이 되어있지 않다면 일관성이 있으므로 true
    private static boolean isContains(int n, String[] phone) {

        for(int idx = 0; idx <n-1;idx++){
            if(phone[idx+1].startsWith(phone[idx])){
                return false;
            }

        }

        return true;
    }
}
