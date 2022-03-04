package KAKAO_2021.거리두기확인하기;

import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for(int i = 0; i < 5; i++){
            answer[i] = result(places[i]);
        }
        return answer;
    }
    
    public int result(String[] arr){
        List<node> Plist = new ArrayList<node>();
        //list에 p add 완료(좌표정보 포함)
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(arr[i].charAt(j) == 'P') Plist.add(new node(i,j));
            }
        }
        for(int i = 0; i < Plist.size()-1; i++){
            for(int j = i + 1; j < Plist.size(); j++){
                int x1 = Plist.get(i).getX();
                int y1 = Plist.get(i).getY();
                int x2 = Plist.get(j).getX();
                int y2 = Plist.get(j).getY();
                int distance = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                
                if(distance == 1) return 0;
                else if(distance == 2){
                    if(x2 - x1 == 0) {
                        if(arr[x1].charAt(y1+1) != 'X') return 0;
                    }else if(y2 - y1 == 0){
                        if(arr[x1+1].charAt(y1) != 'X') return 0;
                    }else if((x1 + y1) == (x2 + y2)){
                        if(arr[x1].charAt(y2) != 'X' || arr[x2].charAt(y1) != 'X'){
                            return 0;
                        }      
                    }else{
                        if(arr[x1].charAt(y2) != 'X' || arr[x2].charAt(y1) != 'X'){
                            return 0;
                        }
                    }
                }
            }
        }
        return 1;
    }

    class node{
        int x, y;
        public node(int x, int y){
            this.x = x;
            this.y = y;
        }
        public int getX(){
            return x;
        }
        public int getY(){
            return y;
        }
    }
}
