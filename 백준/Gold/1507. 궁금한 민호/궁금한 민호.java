import java.util.*;
import java.io.*;

public class Main {

    static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int dist[][] = new int[N+1][N+1]; // 주어진배열
        int arr[][] = new int[N+1][N+1];

        boolean check[][] = new boolean[N+1][N+1];

        for(int row = 1; row <=N;row++){
            st= new StringTokenizer(br.readLine());
            for(int col = 1; col <=N;col++){
                dist[row][col] = Integer.parseInt(st.nextToken());
                arr[row][col] = dist[row][col];
            }
        }

        for(int k =1; k<=N;k++){
            for(int j=1;j<=N;j++){
                for(int i=1;i<=N;i++){


                    if(i == j || j == k || k == i){
                        continue;
                    }

                    //모순적인 상황
                    if(dist[i][j] > dist[i][k] + dist[k][j]){
                        System.out.println(-1);
                        return;
                    }

                    //직통연결되는 간선을 없앤다.
                    if(dist[i][j] == dist[i][k] +dist[k][j]){
                        arr[i][j] = INF;
                    }
                }
            }
        }

        int result = 0;
        for(int row =1; row <=N;row++){
            for(int col = 1; col<=N;col++){
                if(arr[row][col] != INF && row != col && !check[row][col]){
                    result += arr[row][col];
                    check[row][col] = check[col][row] = true;
                }
            }
        }
        System.out.println(result);

    }
}
