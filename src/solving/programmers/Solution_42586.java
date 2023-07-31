package solving.programmers;


// while 돌면서 
// stack 이 비어 있으면 
	// days에서 빼서 그냥 넣어줌
// 비어있지 않다면 
	// stack.peek값 < days값 이라면 
			// stack size 저장 후 비워줌
	// 아니라면 
			// days에서 빼서 stack 에 넣어줌기


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


class Solution_42586 {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> result = new ArrayList<>(); //결과 반환용

        Queue <Integer> days = new LinkedList(); //소요 day

        for(int i=0; i<progresses.length; i++) { //소요 day 계산
            days.add((int) Math.ceil( (double)(100-progresses[i]) / speeds[i] ) );
        }


        //소요 날들을 돌면서
        System.out.println(days.toString());
        while(!days.isEmpty()) {
            int now = days.poll(); //현재꺼 반환 위해 poll
            int cnt = 1; //반환 개수

            while(!days.isEmpty() && days.peek() <=now) { //now에 등호 빼먹지 않기
                days.poll();
                cnt++;
            }

            result.add(cnt);
        }
        System.out.println(result);
        return result;

    }
}


