import java.util.*;

class Solution {
    static Stack<Integer> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();


    public String solution(int n, int k, String[] cmd) {
        String answer = "";
        operationOrder(cmd,k,n);

        answer =sb.toString();
        return answer;
    }

    static void operationOrder(String[] cmd,int k,int n){
        for(String order:cmd){
            StringTokenizer st = new StringTokenizer(order);
            int move = 0;
            switch (st.nextToken()){
                case "C":
                    stack.push(k);
                    n-=1;
                    if(k > n-1) k--;
                    break;
                case "Z":
                    int z = stack.pop();
                    //복구인덱스가 K앞에있는 경우 k를 +1해준다.
                    if(z <= k) k +=1;
                    n +=1;
                    break;
                case "U":
                    move = Integer.parseInt(st.nextToken());
                    k-= move;
                    break;
                case "D":
                    move = Integer.parseInt(st.nextToken());
                    k+= move;
                    break;
            }
        }

        for(int idx = 0; idx <n;idx++){
            sb.append('O');
        }
        while(!stack.isEmpty()){
            int pos = stack.pop();
            sb.insert(pos,'X');
        }
    }
}