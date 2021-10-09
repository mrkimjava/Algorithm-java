package WEB_BACKEND_DEV_2021.행렬테두리회전하기;
import java.util.*;

public class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        //rows * columns 행렬 생성
        int[][] arrays = new int[rows][columns];   
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                arrays[i][j] = (i * columns) + (j + 1);
            }
        }
        //querys 별 최소값
        for(int i = 0; i < answer.length; i++){
            answer[i] = setArray(queries[i], arrays);
        }   
        return answer;
    }
    
    public int setArray(int[] query, int[][] arrays){
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        int x1 = query[0]-1;
        int y1 = query[1]-1;
        int x2 = query[2]-1;
        int y2 = query[3]-1;
        
        rowcol rc = new rowcol(x1,y1); //시작점
        list.add(arrays[rc.x][rc.y]);
        int temp = 0;
        
        while(rc.y < y2){ //rc.y가 주어진 y2보다 작을때까지
            rc.colUp(); //col증가
            temp = arrays[rc.x][rc.y]; //temp에 현재 위치에 해당하는 array값을 넣는다.
            arrays[rc.x][rc.y] = list.get(list.size()-1); //현재 인덱스를 리스트 마지막값으로 대체한다.
            list.add(temp); //리스트에 temp를 추가
        }
        while(rc.x < x2){ //방향전환
            rc.rowUp();
            temp = arrays[rc.x][rc.y];
            arrays[rc.x][rc.y] = list.get(list.size()-1);
            list.add(temp);
        }
        while(rc.y > y1){ //방향전환
            rc.colDown();
            temp = arrays[rc.x][rc.y];
            arrays[rc.x][rc.y] = list.get(list.size()-1);
            list.add(temp);
        }
        while(rc.x > x1){ //방향전환
            rc.rowDown();
            temp = arrays[rc.x][rc.y];
            arrays[rc.x][rc.y] = list.get(list.size()-1);
            list.add(temp);
        }
        
        return Collections.min(list); //리스트 최소값
    }
    
    class rowcol{
        int x;
        int y;
        
        public rowcol(int x, int y){
            this.x = x;
            this.y = y;
        }
        public void rowUp(){
            x = x + 1;
        }
        public void rowDown(){
            x = x - 1;
        }
        public void colUp(){
            y = y + 1;
        }
        public void colDown(){
            y = y - 1;
        }
    }
}
