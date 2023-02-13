package solving.baekjoon.n2164;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * FIFO -> Queue
 * 1~N 차례대로 queue.add
 * 맨 위 카드 버리기 (큐 맨 앞 카드)
 * -> queue.poll()
 * 그 다음 맨 위 카드 빼서 맨 밑에 넣기 
 * -> queue.add(queue.poll()) 
 * 
 * 1개 남았을 때 해당 값 접근 queue.peek()
 * */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i=1;i<=N;i++) {
			queue.add(i);
		}
		while(queue.size() > 1) {
			queue.poll(); //맨 위(큐에서 맨 앞) 카드 버림
			queue.add(queue.poll()); //그 다음 맨 위 카드 빼서 맨 밑으로 넣음
		}
		
		System.out.println(queue.peek());

	}

}
