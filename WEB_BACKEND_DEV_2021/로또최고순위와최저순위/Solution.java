package WEB_BACKEND_DEV_2021.로또최고순위와최저순위;

import java.util.Arrays;

public class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        
        //당첨 번호
        int cnt = 0;
        //lottos에 0의 갯수
        int cnt_zero = 0;
        
        //0의 갯수
        for(int i = 0; i < 6; i++){
            if(lottos[i] == 0){cnt_zero++;}
        }
        
        //lottos와 win_nums 일치갯수
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 6; j++){
                if(win_nums[i] == lottos[j]){cnt++; break;}
            }
        }
        
        int min_grade = ((7-cnt) >= 6)? 6 : (7-cnt);
        int max_grade = (min_grade - cnt_zero) == 0? 1 : min_grade - cnt_zero;
        int answer[] = {max_grade, min_grade};
        
        return answer;
    }
    
    public static void main(String[] args) {
    	int lottos[] = {44,1,0,0,31,25};
    	int wins[] = {31,10,45,1,6,19};
    	int result[] = new Solution().solution(lottos, wins);
		System.out.println(Arrays.toString(result));
	}
}

