package KAKAO_BLIND_2022_RECRUITMENT.k진수에서소수개수구하기;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(437674, 3));
    }

    public int solution(int n, int k) {
        
        return count(parse(n, k));
        
    }
    
    public String parse(int n, int k){

        StringBuffer parseValue = new StringBuffer("");
        
        while(n > 0){
            int j = n % k;
            n = n / k;
            
            parseValue.append(j);
        }
        
        return parseValue.reverse().toString();
    }
    
    public int count(String s){
        
        int count = 0;
        
        String[] numbers = s.split("0");
        for(String tmp : numbers){
            if(findDemical(tmp)) count++;
        }
        
        return count;
    }
    
    public boolean findDemical(String s){
        
        if(s.equals("1") || s.equals("")){
            return false;
        }

        long number = Long.parseLong(s);
        
        for(int i = 2; i <= Math.sqrt(number); i++){
            if(number % i == 0) return false;
        }
        return true;
    }
    
}