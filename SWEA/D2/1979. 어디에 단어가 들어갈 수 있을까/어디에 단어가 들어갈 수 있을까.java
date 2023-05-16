
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
	    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int test_case = 1; test_case <= T; test_case++)
        {

            int answer= 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int map[][] = new int[N][N];

            //맵을 채워준다.
            for(int row = 0; row <N;row++)
            {
                st = new StringTokenizer(br.readLine());
                for(int col = 0; col <N;col++){
                    map[row][col] = Integer.parseInt(st.nextToken());
                }
            }
            //가로 순 체크
            for(int row = 0; row <N;row++)
            {
                int check = 0;
                for(int col= 0; col <N;col++){
                    //0을 만나는 경우에는 그전 값을 더한 값이 K가 되는지 체크한다.
                    if(map[row][col] == 0){

                        if(check == K) {
                            answer += 1;
                        }
                        check = 0;
                        //끝에 도달한경우
                    }else if(col == N - 1){
                        if (map[row][col] != 0) {
                            check += 1;
                        }
                        if(check == K){
                            answer+=1;
                        }
                    }
                    else {
                        check +=1;
                    }
                }
            }

            //세로 순 체크
            for(int col = 0; col <N;col++)
            {
                int check = 0;
                for(int row = 0; row <N; row++){
                    if(map[row][col] == 0){
                        if(check == K)
                            answer+=1;
                        check = 0;
                    }else if(row == N - 1){
                        if (map[row][col] != 0) {
                            check += 1;
                        }
                        if(check == K){
                            answer+=1;
                        }
                    }
                    else{
                        check+=1;
                    }
                }
            }
            
            //답 찍기
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
}