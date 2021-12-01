package level3.네트워크;
import java.util.LinkedList;
import java.util.Queue;

class Solution{
    public int solution(int n, int[][] computers) {
	    int answer = 0;
        
	    /* case1
	    {{1,1,0},
	     {1,1,0},  n = 3;
	     {0,0,1}}  return 2;*/ 
	        
	    /* case2
	    {{1,1,0},
	     {1,1,1},  n = 3;
	     {0,1,1}}  return 1;*/
        
        /* 다른케이스
	    {{1,1,0,1},
	     {1,1,0,0},  n = 4;
	     {0,0,1,0},  return 2; 
         {1,0,0,1}}  */
        
	    Queue<Integer> queue = new LinkedList<>();
	    boolean[] visited = new boolean[n]; //노드 방문 체크용 배열 생성
        
        for(int i = 0; i < n; i++){
            visited[i] = false;
        }        
        
        for(int i = 0; i < n; i++){
            //node[0] ~ node[n-1] 반복
            if(visited[i] == false){ //방문하지 않은 노드인 경우만 queue에 넣는다
                queue.add(i);        //첫번째 노드인경우는 무조건 추가된다
                visited[i] = true;  
            }
               
            while(!queue.isEmpty()){
                
                int idx = queue.poll();

                for(int j = 0; j < n; j++){                
                   if(computers[idx][j] == 1 && visited[j] == false){
                       queue.add(j);
                       visited[j] = true;
                    }
                }
                if(queue.isEmpty()){ //queue가 비게 될 경우 1개의 네트워크 생성
                    answer++;        //연결된 네트워크 끝에 도달
                }
            }
        }
        return answer;
    }

	public static void main(String[] args) {
		int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		int n = 3;
		System.out.println(new Solution().solution(n, computers));
	}
}
	
