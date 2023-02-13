package solving.baekjoon.n10799;

/*
===============Test case 1 통해 문제 이해===============
입력값 인덱스 / [cut수...] / end / [now수...] 
( 0 / [2] / 0 / 0
( 2 / [1] / 0 / 1
( 3 / [1] / 0 / 2
( 4 / [1] / 0 / 3
( 5 6 ) / [2] / 0 / 3
( 7 8 ) / [3] / 0 / 3
) 9 / [3] / 3 / 2

( 10 / [4, 1] / 3 / [2, 1]
( 11 12 ) / [4, 2] / 3 / [2, 1]
) 13 / [4] / 5 / [2]
( 14 15 ) / [5] / 5 / [2]
) 16 / [5] / 10 / [1]
) 17 / [5] / 15 / [0]
( 18 / [1] / 15 / [1]
( 19 20 ) / [2] / 15 / [1]
) 21 / [] / 17 / [0] 

===============Stack===============
Stack<Integer> cut 
- 함께 잘리는 막대들의 cut수 -> 잘릴 때 마다 모든 원소++
- cut추가해나가고 있는 막대들이 있는데(cut.peek()!=1) 새로운 막대가 등장하면 cut 원소(1) 추가 

Stack<Integer> now 
- 함께 잘리는 막대들의 수 -> 마지막 원소만 ++ 
- cut추가해나가고 있는 막대들이 있는데(cut.peek()!=1) 새로운 막대가 등장하면 now 원소(1) 추가
- now = 0이면 cut이 소용 없기 때문에 cut 마지막 원소를 없애거나 초기화
 
===============Logic 설계===============
while 순회하며
	now = 0이면 cut이 소용 없기 때문에 cut 마지막 원소를 없애거나 초기화

	( 만났을 때 
	  		다음이 ) 라면 
	  				cut 모든 원소++
					i+=2
	  		
	  		아니라면
	  				cut.peak()이 1이 아닐때 -> now.push(1) cut.push(1)
	  				아니라면 -> now마지막원소++
	  				i++
	
	) 만났을 때
			finish += cut.peak() 		
			now 마지막 - 1 ==0 이라면 -> cut.pop() now.pop & 둘 다 비었다면 초기화 시키기
	 		아니라면 -> now마지막원소--
	  				
* */

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String args[]) throws Exception {
	
			Scanner sc = new Scanner(System.in);
	
			String str = sc.next();
			int i = 0; //while 순회 시 index
			int finish = 0; // cut finish  
			Stack<Integer> cut = new Stack<>();
			Stack<Integer> now = new Stack<>();
			cut.push(1); 
			now.push(0);
			
			while(i < str.length()) {
				if(now.peek() == 0) { 
					cut.pop();
					if(cut.isEmpty()) {
						cut.push(1);
					}
				}
				if(str.charAt(i) == '(') {
					if(str.charAt(i+1) == ')') { 
						for(int s=0; s<cut.size(); s++) { 
							cut.set(s, cut.elementAt(s)+1);
						}
						//System.out.println(str.charAt(i) + " "+ i + " / "+cut.peek() + "/"+finish+"/"+now.peek());
						i += 2;
					}
					else {
						if(cut.peek() != 1) {
							now.push(1);
							cut.push(1);
						}
						else {
							now.push(now.pop()+1);
						}
						//System.out.println(str.charAt(i) + " "+ i + " / "+cut.peek() + "/"+finish+"/"+now.peek());
						i++;
					}
				}
				else {
					finish += cut.peek();
					if(now.peek()-1==0) {
						cut.pop();
						if(cut.isEmpty()) {
							cut.push(1);
						}
						now.pop();
						if(now.isEmpty()) {
							now.push(0);
						}
					}
					else {
						now.push(now.pop()-1);
					}
					//System.out.println(str.charAt(i) + " "+ i + " / "+cut.peek() + "/"+finish+"/"+now.peek());
					i++;
				}
			}
			System.out.println(finish);
		}
	}




