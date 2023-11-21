import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long result = 0;
        Stack<Integer> s = new Stack<>();
        for(int idx = 0; idx <N;idx++){
            int num = Integer.parseInt(br.readLine());

            while(!s.isEmpty() && s.peek() <= num){
                s.pop();
            }
            s.push(num);
            result += s.size()-1;
        }

        System.out.println(result);

    }
}
