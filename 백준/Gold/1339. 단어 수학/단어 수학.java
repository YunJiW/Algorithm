import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    static int alpha[] = new int[26];
    static int start = 9;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        //N개만큼 주어짐.
        for(int test = 0; test < N;test++) {
            String str = br.readLine();
            int ten = (int)Math.pow(10,str.length()-1);
            //각 자리수에맞춰서 계산
            for (int idx = 0; idx < str.length(); idx++) {
                char Alpha = str.charAt(idx);
                alpha[Alpha- 'A'] += ten;
                ten /= 10;
            }
        }
        //boxing
        Integer alphas[] = Arrays.stream(alpha).boxed().toArray(Integer[]::new);
        //int를 내림차순으로 sorting
        Arrays.sort(alphas,Collections.reverseOrder());
        for(int num : alphas){
            //0이아니면서 start가 0이아닐경우 -> 10개를 초과하지않을경우만
            if(num != 0 && start != 0){
                ans += num *start;
                start--;
            }else{
                break;
            }
        }
        System.out.println(ans);
    }
}
