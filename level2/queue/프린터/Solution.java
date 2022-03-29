package level2.queue.프린터;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        int[] priorities = {1,1,9,1,1,1};
        int location = 0;
        System.out.println("위치 : " + new Solution().solution(priorities, location));
    }

    public int solution(int[] priorities, int location) {
        
        Queue<document> queue = new LinkedList<document>();
        
        List<Integer> printlist = new ArrayList<>();

        for( int i = 0; i < priorities.length; i++ ){
            queue.add(new document(i, priorities[i]));
        }
        
        Arrays.sort(priorities);
        int max_idx = priorities.length - 1;
        
        
        while( !queue.isEmpty() ){
            
            document doc = queue.poll();
            
            if(doc.priority == priorities[max_idx]){
                
                printlist.add(doc.idx);
                max_idx--;
                
            }else{
                queue.add(doc);      
            }
            
        }
        return printlist.indexOf(location) + 1;
    }
    
    class document {
        int idx;
        int priority;
        
        public document(int idx, int priority){
            this.idx = idx;
            this.priority = priority;
        }
    }
}