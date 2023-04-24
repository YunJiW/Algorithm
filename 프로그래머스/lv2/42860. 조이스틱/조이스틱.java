class Solution
{
    public int solution(String name) {
        int move_up_down = 0;

        //A면서 name의 길이가 1인경우
        if(name.charAt(0) == 'A' && name.length() == 1)
            return 0;

        //전부 A인지 체크
        boolean isAllA = true;
        for(int idx =0; idx <name.length();idx++){
            if(name.charAt(idx) != 'A')
                isAllA = false;

            if(!isAllA)
                break;

        }
        if(isAllA)
            return 0;

        System.out.println(moveCost(name));
        return nameCost(name) + moveCost(name);
    }
    //이름 체크용
    private int nameCost(String name) {
        int move_up_down =0;
        //전체에서 각 문자에 대해서 문자 변경이 진행되는 경우
        for(int idx = 0; idx <name.length();idx++){
            char ch = name.charAt(idx);
            //A에서 시작하거나 역순으로 이동했을경우 둘중 작은놈으로
            move_up_down += Math.min(ch - 'A','Z' - ch + 1);
            System.out.println("index = " + idx + "번째 문자" +name.charAt(idx) + " " + move_up_down);
        }

        return move_up_down;
    }

    //이동 횟수 체크
    // 생각해야할점 : 뒷부분이 전부 A이면 횟수를 체크할 필요가없음.
    // 연속적인 A가 몇개인지 알아야함.
    // 가장 긴 A가 연속적인 부분 체크 필요 -> 이건 어떻게 체크해야할까
    //1. 처음부터 끝까지 정순이동
    //2. 역순이동
    //3.중간에 꺾어서 이동
    private int moveCost(String name) {
        int move = name.length() -1;
        for(int idx = 0; idx < name.length();idx++){

            int index = idx+1;
            while(index < name.length() && name.charAt(index)== 'A'){
                index+=1;
            }

            move = Math.min(move,2*idx + name.length() - index);
            move = Math.min(move,idx + (name.length()-index)*2);

        }

        return move;
    }


}