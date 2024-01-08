import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int abcd[][] = new int[N][4];

        StringTokenizer st;
        for(int idx =0 ; idx <N;idx++){

            st= new StringTokenizer(br.readLine());

            for(int num = 0; num < 4;num++){
                abcd[idx][num] = Integer.parseInt(st.nextToken());
            }
        }

        int ab[] = new int[N*N];
        int cd[] = new int[N*N];

        //ab 와 cd 를 따로 먼저 계산
        //값들이 전부 중복이 발생하지 않게됨.
        for(int idx = 0; idx <N;idx++){
            for(int j = 0; j < N;j++){
                ab[idx*N+j] = abcd[idx][0] + abcd[j][1];
                cd[idx*N+j] = abcd[idx][2] + abcd[j][3];
            }
        }

        Arrays.sort(ab);
        Arrays.sort(cd);

        int abp = 0;
        int cdp = N*N-1;

        long cnt= 0;

        //핵심 로직 투포인터 
        while(abp < N*N && cdp > -1){
            long abv = ab[abp], cdv = cd[cdp];
            long result = abv + cdv;

            if(result < 0){
                abp +=1;
            }else if(result >0){
                cdp -=1;
                //0 인 경우
            }else{
                long xc =0 ,yc = 0;
                //0이 되는 경우의 수와 같은 수가 몇개있는지 확인
                while(abp < N *N && abv == ab[abp]){
                    abp+=1;
                    xc+=1;
                }
                //위와 같이 몇개있는지 확인
                while(cdp > -1 && cdv == cd[cdp]){
                    cdp-=1;
                    yc+=1;
                }
                cnt+= (xc*yc);
            }

        }

        System.out.println(cnt);

    }
}
