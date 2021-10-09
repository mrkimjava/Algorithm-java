package KAKAO_BLIND_2021_RECRUITMENT.메뉴리뉴얼;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Arrays;

class Solution {
    public String[] solution(String[] orders, int[] course) {

        List<String> list = new ArrayList<String>();
        for(int i = 0; i < orders.length; i++){
        	char[] ch = orders[i].toCharArray();
            Arrays.sort(ch);
            String Sorted = new String(ch);
            orders[i] = Sorted;
        }
        
        for(int c : course){
            List<String> temp = getResult(c, orders);
            
            for(int i = 0; i < temp.size(); i++){
                list.add(temp.get(i));
            }
        }
        
        String[] answer = new String[list.size()];
        Collections.sort(list);
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
    
    public ArrayList<String> getResult(int course, String[] orders){
        
        ArrayList<String> list = new ArrayList<String>();
        HashMap<String, Integer> StringMap = new HashMap<String, Integer>();

        //1. orders의 character값들의 경우의수를 조합한다.
        //2. AB AC AF AG .... AC .. CD CE .... AC AD 경우의수를 나열하고 중복되는지 여부를 확인하고 Map에 넣는다.
        
        
        for(String str : orders){
            
            if(str.length() < course) {
                continue;
            }          
            //경우의수 
            
            boolean visited[] = new boolean[str.length()];
            combination(str, visited, 0, course, list);            
        }

        //map push (프리퀀시 2이상)
        for(int i = 0; i < list.size(); i++){
            if(Collections.frequency(list, list.get(i)) > 1){
                StringMap.put(list.get(i), Collections.frequency(list, list.get(i)));
            }
        }
        list.clear();
        
        //maxval 찾기

        int maxVal = 0;
        Set<Entry<String, Integer>> entrySet = StringMap.entrySet();
        for(Entry<String, Integer> entry : entrySet){
            if(maxVal == 0 || entry.getValue() > maxVal){
                System.out.println(entry.getValue());
                maxVal = entry.getValue();
            }
        }
        //max entryset , maxval 
        
        for(Entry<String, Integer> entry : entrySet){
            if(entry.getValue() == maxVal){
                list.add(entry.getKey());
            }
        }
        return list;
    }
    
    //문자열 조합
    public void combination(String str, boolean[] visited, int depth, int r, List<String> list){
        
        if(r == 0){
            String temp = "";
            for(int i = 0; i < str.length(); i++){
                if(visited[i] == true){
                    temp += str.charAt(i);
                }
            }
            list.add(temp);
            return;
        }
        if(depth == str.length()){
            return;
        }else{
            
            //선택 시 r, 선택하지 않을 시 r-1
            visited[depth] = true;
            combination(str, visited, depth + 1, r - 1, list);
            
            visited[depth] = false;
            combination(str, visited, depth + 1, r, list);
        }
    }
    
    public static void main(String[] args) {
		String orders[] = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		int course[] = {2, 3, 4};
		String result[] = new Solution().solution(orders, course);
		System.out.println(Arrays.toString(result));
	}
}
