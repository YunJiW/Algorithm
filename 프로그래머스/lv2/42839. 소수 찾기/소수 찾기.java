import java.util.HashSet;


class Solution {
    static HashSet<Integer> set = new HashSet<>();
    static boolean visited[];
    static char arr[];
    static int answer = 0;
    boolean prime[] = new boolean[10000000];
    public int solution(String numbers) {
        get_prime();
        
        arr = new char[numbers.length()];
        visited = new boolean[numbers.length()];
        for(int index =0 ;index <numbers.length();index++){
            arr[index] = numbers.charAt(index);
        }
        dfs("",0);

        return answer;
    } 
    
    public void dfs(String str , int depth)
    {
        if(str != "")
        {
            //set에 들어있지 않으면서 소수일 경우
            if(!prime[Integer.parseInt(str)] && !set.contains(Integer.parseInt(str))){
                set.add(Integer.parseInt(str));
                answer++;
            }
        }
        //끝까지 다 돌앗을경우 끝
        if(depth == arr.length) return;
        
        //완탐
        for(int index =0 ;index <arr.length;index++)
        {
            if(!visited[index]){
                visited[index] = true;
                dfs(str+arr[index],depth+1);
                visited[index] = false;
            }
        }
    }
    //소수 판별
    public void get_prime(){
        prime[0] = prime[1] = true;
        
        for(int i =2 ; i< Math.sqrt(prime.length);i++){
            if(prime[i]) continue;
            for(int j = 2*i; j<prime.length;j+=i){
                prime[j] = true;
            }
        }
    }
}