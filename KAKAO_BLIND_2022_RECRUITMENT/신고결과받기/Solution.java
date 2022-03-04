package KAKAO_BLIND_2022_RECRUITMENT.신고결과받기;

import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        Map<String, StringBuilder> reporter = new HashMap<String, StringBuilder>();
        Set<String> set = new HashSet<String>();
        
        for(String s : report){
            set.add(s);
        }
        
        Iterator<String> iter = set.iterator();
        while(iter.hasNext()){
            String[] tmp = iter.next().split(" ");
            
            reporter.put(tmp[0], reporter.get(tmp[0])==null? new StringBuilder(tmp[1]) : reporter.get(tmp[0]).append(" " + tmp[1]));
            map.put(tmp[1], map.get(tmp[1])==null? 1 : map.get(tmp[1]) + 1);
        }
        
        for(int i = 0; i < id_list.length; i++){
            
            String id = id_list[i];
            int cnt = 0;
            
            if(reporter.get(id) != null){
                String[] reportList = reporter.get(id).toString().split(" ");
                for(String s : reportList){
                    if(map.get(s) != null && map.get(s) >= k){
                        cnt++;
                    }
                }
            }      
            answer[i] = cnt;
        }
        
        return answer;
    }
}
