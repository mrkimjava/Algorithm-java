package level3.입국심사;

public class Solution {
	public static void main(String[] args) {
//		int times[] = new int[] {2,3,5,6,11};
//		int times[] = new int[] {7,10};
//		int times[] = new int[] {6,11};
		int times[] = new int[] {3,4,5};
		
		int n = 1;
		long l = new Solution().solution(n, times);
		System.out.println(l);

		
	}
	//times의 요소를 특정값으로 나눈 나머지가 0이되는 시점을 찾아 해당 인덱스까지 합
	public long sum(int[] arrays, Long l) {
		int pl = 0;
		int pr = arrays.length - 1;
		int index = 0;
		
		while(pl<=pr) {
			index = (pl + pr)/2;
			
			if(l/arrays[index] != 0) {
				pl = index + 1;
			}else {
				if(index != 0 && l/arrays[index-1] != 0) { //n이 1인경우에는 total*(pc-1)을 l로 넘겨받아서 합계가 n보다 작은블록인지 검사하는 과정에서
					break;                                 //total*(pc-1) = 0이므로 0을 모든 인덱스로 나누어도 0이기때문에 index-1까지 참조하게된다.
				}                                          //indexoutofbounds발생으로 index!=0 조건을 걸어둔다. -> 0이면 pl>pr이되어 자동으로 sum = 0을 리턴한다.
				pr = index - 1;
			}
		}
		long sum = 0;
		
        for(int i = 0; i <= index; i++){
            sum += l/arrays[i];
        }
		return sum;
	}
	
	public long solution(int n, int[] times) {
        java.util.Arrays.sort(times);
        
        long pl = 1,  pr = n,  pc = 0;
        long total = times[0];
        //최소시간은 정렬된 배열의 times[0]이고 최대시간은 n*times[0]이므로 이 블록들 안에서 n을 만족하는 부분을 이분탐색시작
        while(pl <= pr){
        	pc = (pl+pr)/2;
       		
        	if(sum(times, total*pc) >= n) {
        		if(sum(times, total*(pc-1)) < n) { 
                    total = total * (pc-1) + 1; //n이상인 block(n-1이 n보다 작은걸 만족하는 블록)이 구해지면 break 후 해당블록부터 재탐색한다
        			break;
        		}else {
        			pr = pc - 1;
        		}
        	}else {
        		pl = pc + 1;
        	}
        }
        
        pl = total; pr = total + times[0]; //확실한 블록이 정해지면 시작을 total로 주고 최대범위를 total + times[0]으로 준다. (2차 이분탐색)
        
        while(pl<=pr) {
        	pc = (pl + pr)/2;
        	
        	if(sum(times, pc) >= n) { //최소시간이 n과 무조건동일하지는 않다.
        		if(sum(times, pc-1) >= n) { //하지만 pc-1은 n보다 작은것을 만족해야한다.
        			pr = pc - 1;
        		}else {
        			total = pc;
        			break;
        		}
        	}else {
    			pl = pc + 1;
    		}
        }
        return total;
	}
}
