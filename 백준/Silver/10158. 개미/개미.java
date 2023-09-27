import java.io.*;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st= new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int t = Integer.parseInt(br.readLine());

        int x = (p+t) %(2*w);
        int y = (q+t) %(2*h);

        if(x > w){
            x = 2*w - x;
        }

        if(y > h){
            y = 2*h - y;
        }

        sb.append(x).append(" ").append(y);
        System.out.print(sb);
    }
}
