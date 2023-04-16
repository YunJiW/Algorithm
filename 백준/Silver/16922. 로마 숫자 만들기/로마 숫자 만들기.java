import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

//중복해서 같은게 가능하다.
public class Main
{
    static int[] roma= {1,5,10,50};
    static int N;
    static HashSet<Integer> roma_sum = new HashSet<>();

    static int[] checking;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));


        N = Integer.parseInt(br.readLine());
        checking = new int[N];
        combi(0,0,0);

        System.out.println(roma_sum.size());
    }

    private static void combi(int depth,int index,int sum) {
        //N개가 됬을경우
        if(depth == N){
            roma_sum.add(sum);
            return;
        }

        for(int idx = index; idx <roma.length;idx++){
            combi(depth+1,idx,sum+roma[idx]);
        }

    }
}
