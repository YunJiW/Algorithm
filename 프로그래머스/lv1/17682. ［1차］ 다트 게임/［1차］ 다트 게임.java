import java.util.HashMap;

class Solution {

    int S = 1;
    int D = 2;
    int T = 3;
    public int solution(String dartResult) {
        int answer = 0;
        HashMap<Integer,Integer> maps = new HashMap<>();
        int dart_check = 1;

        String number="";
        int idx = 0;
        while(idx < dartResult.length()){
            //숫자인지 체크
            if(dartResult.charAt(idx)>= '0' && dartResult.charAt(idx) <='9'){
                number+=dartResult.charAt(idx);
                if(dartResult.charAt(idx) == '1' && dartResult.charAt(idx+1) =='0'){
                    number+= dartResult.charAt(idx+1);
                    idx+=2;
                    continue;
                }
                idx+=1;
                continue;
            }
            char point = dartResult.charAt(idx);
            System.out.println(number);
            System.out.println(point);
            System.out.println(dart_check);
            switch (point){
                case 'S':
                    int point_S= Integer.parseInt(number);
                    maps.put(dart_check++, (int) Math.pow(point_S,S));
                    break;
                case 'D':
                    int point_D= Integer.parseInt(number);
                    maps.put(dart_check++, (int) Math.pow(point_D,D));
                    break;
                case 'T':
                    int point_T= Integer.parseInt(number);
                    maps.put(dart_check++, (int) Math.pow(point_T,T));
                    break;
                case '*':
                    //아직 1개밖에 없는 경우
                    if(maps.size() == 1){
                        maps.put(dart_check-1,maps.get(dart_check-1) *2);
                        //현재값과 그 이전값이 있는경우
                    }else{
                        maps.put(dart_check-1,maps.get(dart_check-1)*2);
                        maps.put(dart_check-2,maps.get(dart_check-2)*2);
                    }
                    break;
                case '#':
                    maps.put(dart_check-1,maps.get(dart_check-1) * -1);
            }
            idx+=1;
            //다음 계산을 위해 초기화
            number ="";
        }

        for(int key : maps.keySet()){
            answer+= maps.get(key);
        }
        return answer;
    }
}