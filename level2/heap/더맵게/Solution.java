package level2.heap.더맵게;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        int[] scoville = {1,2,3,9,10,12};
        int K = 7;
        System.out.println("최소 횟수 : " + new Solution().solution(scoville, K));
    }

    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i : scoville){
            queue.add(i);
        }
        
        while(queue.size() > 1 && queue.peek() < K){
            
            int min = queue.poll();
            int min2 = queue.poll();
            int scovilleValue = min + (min2 * 2);
            
            queue.add(scovilleValue);
            answer++;
        }
        
        return queue.peek() < K ? -1 : answer;
    }
}
