class Solution {
    
    public int solution(String[] babbling) {
        int answer = 0;
        String[] impossible = {"ayaaya","yeye","woowoo","mama"};
        String[] possible ={"aya","ye","woo","ma"};
        
        for(int idx =0; idx< babbling.length;idx++){
            String check = babbling[idx];
            boolean is_pos = true;
            for(int im_check=0 ; im_check <4;im_check++){
                check = check.replace(impossible[im_check],"X");
            }
            for(int po_check=0 ; po_check <4;po_check++){
                check = check.replace(possible[po_check],"O");
            }
            for(int checking = 0; checking<check.length();checking++){
                if(check.charAt(checking) == 'X' || check.charAt(checking) != 'O'){
                    is_pos = false;
                    break;
                }
            }
            if(is_pos){
                answer+=1;
            }
            
        }
        return answer;
    }
}