package algorithm.sort;

import java.util.Arrays;
/*
 * PriroityQueue를 위해 구현
 * 최대힙
 *            9
 *         8     7
 *       6   5  4  3
 *     2  1
 * 최소힙 
 *            1
 *          3   2
 *        5  4 7 6
 *       9 8
 * 삽입 : 끝에 추가하고 순서 바꿈
 * 삭제 : 끝에 있는거랑 삭제하는 거랑 자리바꾸고 순서 바꿈
 *           
 *      
 */
public class HeapSort {
	static int heap[] = { 7, 6, 5, 8, 3, 5, 9, 1, 6 };
	public static void main(String[] args) {
		// 힙을 구성한다
		for (int i = 1; i < heap.length; i++) {
			int c = i;
			do {
				int root = (c-1)/2;
				if(heap[root] < heap[c]) {
					int tmp = heap[root];
					heap[root]=heap[c];
					heap[c]=tmp;
				}
				c=root;
			}while(c != 0);
		}
		//System.out.println(Arrays.toString(heap));
		for (int i = heap.length-1; i >= 0; i--) {
			int tmp=heap[0];
			heap[0]=heap[i];
			heap[i]=tmp;
			int root = 0;
			int c = 1;
			do {
				c = 2*root+1;
				// 자식중에서 더 큰놈을 찾기
				if(c<i-1&&heap[c]<heap[c+1]) {
					c++;
				}
				// 루트보다 자식이 크다면 교환
				if(c<i&&heap[root]<heap[c]) {
					tmp=heap[root];
					heap[root]=heap[c];
					heap[c]=tmp;
				}
				root=c;
			}while(c<i);
			
		}
		System.out.println(Arrays.toString(heap));
	}

}
