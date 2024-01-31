import java.io.*;

public class Main {


    final static long div = 1000000007;

    final static long[][] origin ={{1,1},{1,0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[][] A = {{1,1},{1,0}};

        long N = Long.parseLong(br.readLine());

        System.out.println(run(A,N-1)[0][0]);

    }

    public static long[][] run(long[][] A,long exp){

        if(exp == 1 || exp == 0){
            return A;
        }

        //지수 절반 재귀호출
        long[][] ret = run(A,exp/2);


        ret = multi(ret,ret);

        if(exp%2== 1L){
            ret = multi(ret,origin);
        }

        return ret;
    }

    private static long[][] multi(long[][] o1, long[][] o2) {

        long[][] ret = new long[2][2];

        ret[0][0] = ((o1[0][0] * o2[0][0]) + (o1[0][1]*o2[1][0])) % div;
        ret[0][1] = ((o1[0][0] * o2[0][1]) + (o1[0][1]*o2[1][1])) % div;
        ret[1][0] = ((o1[1][0] * o2[0][0]) + (o1[1][1]*o2[1][0])) % div;
        ret[1][1] = ((o1[1][0] * o2[0][1]) + (o1[1][1]*o2[1][1])) % div;

        return ret;
    }
}
