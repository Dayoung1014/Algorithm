package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 소설을 여러장으로 나누어 쓰고 각 다른 파일에 저장
 * 다 쓴 뒤 각 장이 쓰여진 파일을 합쳐
 * 
 * 최종적인 한 파일을 완성하는데 필요한 최소비용
 * 
 * -> 로직이 이해가 잘 안됨
 * */

public class Main_13975_파일합치기3 {
	static class Book implements Comparable<Book>{
		int chapter;
		
		public Book(int chapter) {
			super();
			this.chapter = chapter;
		}

		@Override
		public int compareTo(Book o) {
			return this.chapter-o.chapter;
		}

		@Override
		public String toString() {
			return Integer.toString(chapter);
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		
		for (int t = 0; t < T; t++) {
			int K = Integer.parseInt(br.readLine());
			PriorityQueue<Book> pq = new PriorityQueue<>();
			
			st = new StringTokenizer(br.readLine());
			for (int k = 0; k < K; k++) {
				int input = Integer.parseInt(st.nextToken());
				pq.add(new Book(input));
			}
			
			int result = 0;
			// pq ArrayList로 만들어서 배열 한뭉치의 index 넘겨가면ㅅ ㅓ임시파일 추가, 확인
			while(true) {
				if(pq.size()==2) {
					
					break;
				}
				// 두개의 장 합쳐서 임시 파일 만들기
				int sum = pq.poll().chapter + pq.poll().chapter;
				
				
				if(pq.size()==1) {
					result += sum;
					int last = pq.poll().chapter;
					result += sum+last;
					System.out.println();
				}
				int min1 = pq.poll().chapter;
				int min2 = pq.poll().chapter;
				
				// 임시파일 + 제일 작은거
				int case1 = sum + min1;
				// 작은거 2가지 합치기
				int case2 = min1+min2;
				
				if(case1<case2) {  //임시파일+min1, min2 다시 넣어주기
					result += case1;
					pq.add(new Book(case1));
					pq.add(new Book(min2));
				}
				else { //임시파일, min1+min2 다시 넣어주기
					result += sum;
					result += case2;
					pq.add(new Book(sum));
					pq.add(new Book(case2));
				}
			}
			
		}
	}
}
