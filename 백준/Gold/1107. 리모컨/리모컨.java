import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args)throws IOException{
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int broken = Integer.parseInt(br.readLine());
        //0~9번까지 못쓰는 거 번호를 체크
        boolean broken_num[] = new boolean[10];
        //부서진게 없는 경우도 존재하기때문에
        if(broken > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            //true일경우 부서짐 false => 안부서짐
            while (st.hasMoreTokens()) {
                broken_num[Integer.parseInt(st.nextToken())] = true;

            }
        }
        //최대 횟수
        int ans = Math.abs(N - 100);


        for(int number = 0; number <=999999; number++){
            String check = String.valueOf(number);
            boolean is_possible = true;
            for(int checks = 0; checks < check.length();checks++)
            {
                //부서진 번호가 들어있을경우 
                if(broken_num[check.charAt(checks) -'0']){
                   is_possible = false; 
                   break;
                }
            }
            //안되는 번호일경우 넘어감
            if(!is_possible) continue;

            int calc = check.length() + Math.abs(N - number);

            ans = Math.min(calc,ans);
            
        }
        System.out.println(ans);
    }
}
