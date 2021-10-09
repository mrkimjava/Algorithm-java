package KAKAO_BLIND_2021_RECRUITMENT.신규아이디추천;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class Solution {
    public String solution(String new_id) {
        
        List<Character> list = new ArrayList<Character>(Arrays.asList('_','-','.'));
        for(int i = 65; i <= 90; i++){list.add((char)i);}
        for(int i = 97; i <= 122; i++){list.add((char)i);}
        for(int i = 48; i <= 57; i++){list.add((char)i);}
        
        StringBuilder sb = new StringBuilder(new_id);

        //1단계
        for(int i = 0; i < sb.length(); i++){
            if(sb.charAt(i) >= 65 && sb.charAt(i) <= 90)  {
                String temp = "" + sb.charAt(i);
            	sb.replace(i, i+1, temp.toLowerCase());
            }
        }
        
        //2단계
        for(int i = 0; i < sb.length();){
            boolean b = false;
            outer:{
                for(int j = 0; j < list.size(); j++){
                    if(sb.charAt(i) == list.get(j)){
                        b = true;
                        i++;
                        break outer;
                    }
                }
                if(!b){
                    sb.deleteCharAt(i);
                }
            }
        }
        
        //3단계
        for(int i = 0; ; i++){
            if(i == sb.length()-1) break;;
            if(sb.charAt(i) == '.' && sb.charAt(i+1) == '.'){
                sb.deleteCharAt(i); 
                i--;
            }
        }
        
        //4단계
        if(sb.length() != 0 && sb.charAt(0) == '.') sb.deleteCharAt(0);
        if(sb.length() != 0 && sb.charAt(sb.length()-1) == '.') sb.deleteCharAt(sb.length()-1);
        
        //5단계
        if(sb.length() == 0){sb.append('a');}
        
        //6단계
        if(sb.length() > 15){sb.delete(15, sb.length());}
        if(sb.length() != 0 && sb.charAt(sb.length()-1) == '.') sb.deleteCharAt(sb.length()-1);
        
        //7단계
        while(sb.length() <= 2){
            sb.append(sb.charAt(sb.length()-1));
        }                
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution().solution("...!@BaT#*..y.abcdefghijklm"));
	}
}