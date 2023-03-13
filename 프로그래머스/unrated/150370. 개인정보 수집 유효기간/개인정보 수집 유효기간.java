import java.util.ArrayList;
import java.util.HashMap;

//terms 형식 ["A 6", "B 12", "C 3"] -> split 공백을 자르기
//단순 구현문제
//terms를 hashMap으로 <String,Integer>형식으로 종류와 유효기간으로 체크
//privacies의 각 배열 형식 2021.05.02 A -> 공백으로 나눠서 뒤의 부분으로 종류 체크
//체크하고 남은 앞부분으로 만료되는 유효기간 계산
//모든달은 28일까지 있다.
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        HashMap<String,Integer> term = new HashMap<>();
        for(int idx =0; idx <terms.length;idx++){
            String part[] = terms[idx].split(" ");
            term.put(part[0],Integer.parseInt(part[1]));
        }
        //오늘날짜 체크용
        String YMD[] = today.split("\\.");
        int check_year = Integer.parseInt(YMD[0]);
        int check_month =Integer.parseInt(YMD[1]);
        int check_day = Integer.parseInt(YMD[2]);
        ArrayList<Integer> ans = new ArrayList<>();
        for(int index = 0; index < privacies.length;index++){
            //날짜월일과 타입 나누기
            String parts[] = privacies[index].split(" ");
            //날짜월일을 .기준으로 분리
            //start[0] = >year [1] => month [2] day
            String Start[] = parts[0].split("\\.");
            //유효기간 계산
            int add_month = term.get(parts[1]);
            int  cur_year = Integer.parseInt(Start[0]);
            int cur_month = Integer.parseInt(Start[1]);
            int cur_day = Integer.parseInt(Start[2]);

            cur_month += add_month;
            cur_day -=1;
            //1일에서 만료계산시 전달로 돌아가야함.
            if(cur_day ==0){
                //1월인경우 -> 전년도로 돌아감.
                if(cur_month == 1){
                    cur_year-= 1;
                    cur_month =12;
                    cur_day =28;
                }else{
                    cur_month-=1;
                    cur_day=28;
                }
            }
            //유효기간을 더했을때 12월을 넘어가는경우 1년을 넘김.
            if(cur_month > 12)
            {

                if(cur_month %12 == 0){
                    cur_year += (cur_month-1)/12 ;
                    cur_month =12;
                }else{
                    cur_year+= cur_month/12;
                    cur_month %=12;
                }

            }
            System.out.println("cur year =" + cur_year);
            System.out.println("cur month =" + cur_month);
            System.out.println("cur day =" + cur_day);
            //현재를 기준으로 유효기간이 남아있으면 넘어감.
            if(check_year < cur_year){
                continue;
            }else if(check_year == cur_year){
                if(check_month < cur_month){
                    continue;
                    //달까지 같은경우
                }else if(check_month == cur_month){
                    if(check_day <= cur_day){
                        continue;
                    }else {
                        ans.add(index+1);
                    }
                }else{
                    ans.add(index+1);
                }
            }else {
                ans.add(index+1);
            }


        }
        int[] answer = new int[ans.size()];
        for(int idx = 0; idx <ans.size();idx++){
            answer[idx] = ans.get(idx);
        }
        return answer;
    }
}