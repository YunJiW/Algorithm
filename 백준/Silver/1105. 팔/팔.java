import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        String Left = st.nextToken();
        String right = st.nextToken();

        int result =0;

        if(Left.length() == right.length()){

            for(int idx =0;idx<Left.length();idx++){
                if(Left.charAt(idx) != right.charAt(idx)){
                    break;
                }
                else{
                    if(Left.charAt(idx)=='8'){
                        result+=1;
                    }
                }
            }
        }


        System.out.println(result);

    }
}