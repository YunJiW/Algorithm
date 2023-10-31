import java.util.*;
import java.io.*;

public class Main {

    static int N;

    static int result = Integer.MAX_VALUE;

    static Ingre ingre[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        ingre = new Ingre[N];

        for(int idx =0; idx <N;idx++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sour = Integer.parseInt(st.nextToken());
            int bitter = Integer.parseInt(st.nextToken());
            Ingre ingres = new Ingre(sour,bitter);
            ingre[idx] = ingres;
        }
        
        dfs(0,1,0,0);

        System.out.println(result);

    }

    private static void dfs(int depth, int Sour, int bitter ,int select) {
        if(depth == N){
            if(select != 0 && Math.abs(Sour-bitter) < result){
                result = Math.abs(Sour - bitter);
            }
            return;
        }

        dfs(depth+1,Sour*ingre[depth].Sour,bitter+ingre[depth].bitter,select+1);
        dfs(depth+1,Sour,bitter,select);
    }

    public static class Ingre{

        int Sour;

        int bitter;

        public Ingre(int sour, int bitter) {
            Sour = sour;
            this.bitter = bitter;
        }
    }
}