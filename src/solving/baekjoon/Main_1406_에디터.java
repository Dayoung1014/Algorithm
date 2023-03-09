package solving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * 영어 소문자만을 기록할 수 있는 편집기
 * 
 * 커서 가능한 위치
 * - 문장의 맨 앞 (첫번째 문자의 왼쪽)
 * - 문장의 맨 뒤 (마지막 문자의 오른쪽)
 * - 문장 중간 임의의 곳 (모든 연속돈 두 문자 사이)
 * 
 * L : 왼쪽으로 한 칸 (맨앞이면 명령 무시)
 * D : 오른쪽으로 한 칸 (맨뒤면 명령 무시)
 * B : 커서 왼쪽의 문자 삭제 (맨앞이면 명령 무시)
 * P $ : 커서 왼쪽에 $라는 문자 추가
 * */

public class Main_1406_에디터 {
	static class Node {
		char data;
		Node next;
		public Node() {
			super();
			this.data = ' ';
			this.next = null;
		}
		
		public Node(char data) {
			super();
			this.data = data;
		}
		
		public Node(char data, Node next) {
			super();
			this.data = data;
			this.next = next;
		}
	}
	
	static class NodeList {
		Node head;

		public NodeList() {
			super();
			head = null;
		}
		
		public void insertFirst(char data) {
			Node newNode = new Node(data);
			newNode.next = head.next;
			head.next = newNode;
		}
		
		public void insertFinish(char data) {
			Node newNode = new Node(data);
			newNode.next = null;
			head.next = newNode;
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String str = br.readLine();
		int N = str.length();
		
		
		// 명령 수행 전 커서는 문장의 맨뒤에 위치함
		

		
		int M = Integer.parseInt(br.readLine());
		for (int m = 0; m < M; m++) {
			String[] line = br.readLine().split(" ");
			char order = line[0].charAt(0);
			if(order=='L') {
				
			}
			else if(order=='D') {
				
			}
			else if(order=='B') {
				
			}
			else if(order=='P') {
				char word = line[1].charAt(0);
				
			}
		}

	}

	private static void Node(Node node) {
		// TODO Auto-generated method stub
		
	}

}
