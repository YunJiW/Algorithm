import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = 0;
        List<HashSet<Integer>> list = new ArrayList<>();
        for(int idx =0; idx <=8 ;idx++){
            list.add(new HashSet<>());
        }
        list.get(1).add(N);
        //N 인경우 1 리턴
        if(number == N) return 1;


        for(int index =2 ; index <= 8; index++){

            //index 개를 썼을때 숫자들이 들어갈 통
            HashSet<Integer> total = list.get(index);

            for(int check = 1; check< index;check++){
                //index개를 만들수 있는 통들
                HashSet<Integer> first = list.get(check);
                HashSet<Integer> second = list.get(index - check);

                for(int x : first){
                    for(int y : second){
                        total.add(x+y);
                        total.add(x-y);
                        total.add(x*y);
                        if(x != 0 && y != 0) total.add(x/y);
                    }
                }
                //N개합친거 예시) 5를 2개쓰는 경우 55를 넣어줘야함.
                total.add(Integer.parseInt(String.valueOf(N).repeat(index)));
            }

            //구한 값중에 원하는 숫자가 있는경우  index 리턴
            //최소한으로 사용하는거기 때문에 나오면 바로 끝
            if(total.contains(number)) return index;
        }


        return -1;
    }
}