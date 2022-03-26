package KAKAO_BLIND_2022_RECRUITMENT.주차요금계산;

import java.util.*;

public class Solution {

    public static void main(String[] args) {

        int fees[] = {180,5000,10,600};
        String records[] = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        int[] res = new Solution().solution(fees, records);
        for(int i : res){
            System.out.print(i + " ");
        }

    }

    public int[] solution(int[] fees, String[] records) {
        
        Map<String, List> result = new HashMap<>();
        
        for( String s : records ){
            
            String[] arr = s.split("\\s+");
            String inout = arr[2];
            List tmp = null;

            if( result.get(arr[1]) == null ){

                List list = new ArrayList<>();
                list.add(null);
                list.add(0);

                result.put(arr[1], list);
            } 

            tmp = result.get(arr[1]);
            
            if( inout.equals("OUT") ){

                String in = (String)tmp.get(0);
                String out = arr[0];

                tmp.set(1, (int)tmp.get(1) + getTime(in, out));
                tmp.set(0, null);
                
            } else {

                tmp.set(0, arr[0]);

            }
            
            result.put(arr[1] , tmp);
        }

        for( String key : result.keySet() ){

            List list = result.get(key);
            
            if( list.get(0) != null ){

                String in = (String)list.get(0);
                String out = "23:59";

                list.set(1, (int)list.get(1) + getTime(in, out));
                list.set(0, null);

                result.put(key, list);
            }
        }
        
        Object[] mapkey = result.keySet().toArray();
        Arrays.sort(mapkey);

        int[] answer = new int[result.size()];
        int i = 0;

        for(Object key : mapkey){
            
            List list = result.get(key);
            answer[i] = getFee((int)list.get(1), fees);
            i++;

        }
        return answer;
    }
    
    public int getTime(String in, String out){

        String intime[] = in.split("\\:");
        String outtime[] = out.split("\\:");
        
        int in_minute = (Integer.parseInt(intime[0]) * 60) + (Integer.parseInt(intime[1]));
        int out_minute = (Integer.parseInt(outtime[0]) * 60) + (Integer.parseInt(outtime[1]));      
        int time_gap = out_minute - in_minute;

        return time_gap;
    }

    public int getFee(int times, int fees[]){
        
        if(times <= fees[0]){
            return fees[1];
        }else{
            return fees[1] + up(times, fees) * fees[3];
        }
    }
    
    public int up(int n, int fees[]){
        
        double d = (double)(n - fees[0])/fees[2];
        int x = (int)d;
        
        return x < d ? x + 1 : x;
    }
}
