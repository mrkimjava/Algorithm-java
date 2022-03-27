package level2.queue.기능개발;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        
        int progresses[] = {95,90,99,99,80,99};
        int speeds[] = {1,1,1,1,1,1};
        int solution[] = new Solution().solution(progresses, speeds);
        System.out.println(Arrays.toString(solution));
        
    }

    public int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> grouplist = new ArrayList<>();
        
        for( int i : progresses ){
            queue.add(100 - i);
        }
        
        int group = 0, idx = 0, day = 1;
        while(!queue.isEmpty()){
            
            boolean ispolled = false;
            
            if(idx < speeds.length && day * speeds[idx] >= queue.peek() ){
                ispolled = true;
                
                queue.poll();
                idx++;
                group++;
                
                while(idx < speeds.length && day * speeds[idx] >= queue.peek() ){
                    queue.poll();
                    idx++;
                    group++;
                }
            }
            
            if(ispolled){
                grouplist.add(group);
                group = 0;
            }

            day++;
        }
        
        return grouplist.stream().mapToInt(Integer::intValue).toArray();
    }
}
