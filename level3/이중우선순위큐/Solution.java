package level3.이중우선순위큐;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        String[] operations = {"I 16", "I 1"};
        int[] answer = new Solution().solution(operations);
        System.out.println("최대값 " + answer[0]);
        System.out.println("최솟값 " + answer[1]);
    }


    public int[] solution(String[] operations) {
        
        TreeSet<Integer> set = new TreeSet<Integer>();
        
        for( String s : operations ){
            
            String temp[] = s.split("\\s");
            int data = Integer.parseInt(temp[1]);
            
            if( temp[0].equals("I") ){
                set.add(data);
            }else{
                
                if( data == 1 ){
                    set.pollLast();
                }else{
                    set.pollFirst();
                }
                
            }
            
        }
        
        int answer[] = { set.size() == 0? 0 : set.last() , set.size() == 0? 0 : set.first() };
        return answer;
    }
}
