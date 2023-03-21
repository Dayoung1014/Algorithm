package solving.programmers.n42587;

import java.util.LinkedList;
import java.util.Queue;



class Solution {
	public static void main(String[] args) {
		Solution s = new Solution();
		s.solution(new int[] {1, 1, 9, 1, 1, 1}, 0);
		
	}
    public int solution(int[] priorities, int location) { //문서의 중요도, 내가 요청한 문서의 위치 (0~N-1)
        int answer = 0; //인쇄 완료된 문서 수
        
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> idx = new LinkedList<>();
        for(int i=0; i<priorities.length; i++) {
        	queue.add(priorities[i]);
        	idx.add(i);
        }
        
        /*
         * 1. 문서 제일 앞에서 꺼냄 (큐)
         * 2. 꺼낸 문서보다 중요도가 높은 문서가 존재하면 꺼낸 문서를 맨뒤로 넣음 (큐)
         * 3. 없다면 그냥 그 문서 인쇄 (버림) 
         * */
        
        breakout:
        while(!queue.isEmpty()) { //문서 제일 앞에서 꺼냄 (큐)
        	boolean finish = true;
        	int now = queue.poll();
        	int nowIdx = idx.poll();
        	System.out.println("now : "+now);
        	for(Integer q : queue) {
        		if(q>now) { // 꺼낸 문서보다 중요도가 높은 문서가 존재하면 꺼낸 문서를 맨뒤로 넣음 (큐)
        			queue.add(now);
        			idx.add(nowIdx);
        			//finish = false;
        			//break;
					continue breakout;
        		}
        	}
        	System.out.println(queue);
        	System.out.println(idx);
			answer++;
			System.out.println("answer : "+answer);
			System.out.println();
			if(nowIdx == location) {
				break breakout;
			}
//        	if(finish) {
//        		answer++;
//        		System.out.println("answer : "+answer);
//        		System.out.println();
//        		if(nowIdx == location) {
//            		break breakout;
//            	}
//        	}
        	
        }
        System.out.println(answer);
        return answer;
    }
}