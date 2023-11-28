import java.util.*;
import java.io.*;
import java.util.regex.Pattern;

public class Main {

    public static final Pattern p = Pattern.compile("(100+1+|01)+");

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());


        for(int tc = 0; tc < T;tc++){


            if(p.matcher(br.readLine()).matches()){
                sb.append("YES").append("\n");
            }else{
                sb.append("NO").append("\n");
            }
        }

        System.out.print(sb);

    }

}
