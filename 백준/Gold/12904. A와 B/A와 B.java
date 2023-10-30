import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String T = br.readLine();

        while(S.length() < T.length()){
            StringBuilder sb = new StringBuilder();
            //끝자리가 A 인경우 뒷 부분 지우기
            if(T.endsWith("A")){
                T = T.substring(0,T.length()-1);
                //끝자리가 B인경우 끝부분을 지우고 뒤집기.
            }else{
                T = T.substring(0,T.length()-1);
                T = sb.append(T).reverse().toString();
            }
        }
        if(S.equals(T)){
            System.out.println(1);
            return;
        }

        System.out.println(0);



    }
}
