import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int MOD = 1000;

    static int N;

    public static int[][] origin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        origin = new int[N][N];
        //행렬 받아서 넣기
        for(int row =0 ;row <N;row++){
            st= new StringTokenizer(br.readLine());
            for(int col = 0; col<N;col++){

                //1000 보다 작아야하기 때문에 연산 진행.
                origin[row][col] = Integer.parseInt(st.nextToken())%MOD;
            }
        }


        int result[][] = pow(origin,B);
        //행렬 계산 하기

        StringBuilder sb = new StringBuilder();

        for(int row =0; row <N;row++){
            for(int col =0; col <N;col++){
                sb.append(result[row][col]).append(' ');
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }
    
    //재귀 계산
    private static int[][] pow(int[][] A, long exp) {

        if(exp == 1L){
            return A;
        }

        int[][] ret = pow(A,exp/2);

        ret = multi(ret,ret);

        if(exp % 2 == 1L){
            ret = multi(ret,origin);
        }

        return ret;
    }

    //행렬 계산 함수
    private static int[][] multi(int[][] o1, int[][] o2) {

        int ret[][] = new int[N][N];

        for(int i =0 ; i <N;i++){
            for(int j =0; j<N;j++){
                for(int k=0;k<N;k++){

                    ret[i][j] += o1[i][k] *o2[k][j];
                    ret[i][j] %=MOD;
                }
            }
        }
        return ret;
    }
    
}
