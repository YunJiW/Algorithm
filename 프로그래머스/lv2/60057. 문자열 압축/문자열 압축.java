class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        if (s.length() == 1)
            return 1;

        //절반까지만 체크
        for (int idx = 1; idx <= s.length() / 2; idx++) {
            String str = s.substring(0, idx);
            int cnt = 0;
            int part = 0;
            boolean flag = true;
            String newOne = "";
            for (; part < s.length(); part += idx) {
                String part_st = "";
                //길이 범위안쪽일경우
                if (part + idx <= s.length()) {
                    part_st = s.substring(part, part + idx);
                } else {
                    flag = false;
                    break;
                }
                if (str.equals(part_st)) {
                    cnt += 1;
                } else {
                    if (cnt <= 1) {
                        newOne += str;
                    } else {
                        newOne += cnt + str;
                    }
                    str = part_st;
                    cnt = 1;
                }
            }
            if (!flag && cnt > 1) {
                newOne = newOne + cnt + str + s.substring(part);
            } else if (!flag) {
                newOne = newOne + str + s.substring(part);
            }


            if (flag && cnt > 1) {
                newOne += cnt + str;
            }
            if (flag && cnt <= 1) {
                newOne += str;
            }
            answer = Math.min(answer, newOne.length());

        }

        return answer;
    }
}