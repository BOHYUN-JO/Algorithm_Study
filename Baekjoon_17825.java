import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_17825 {
	static int[] dice, order; // 주사위, 배치순서
	static Node[] horse; // 4개의 말
	static Node start; // 시작지점
	static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        dice = new int[11];
        order = new int[11];
        horse = new Node[5];
		for(int i = 1 ; i <= 10 ; i++) {
			dice[i] = Integer.parseInt(st.nextToken());
		}
		
		init(); // 윷놀이판 설정 
		permutation(1); // 10개의 주사위 결과를 말들에게 할당
        System.out.println(answer);
    }
     
	private static void permutation(int depth) {
		if (depth >= 11) {			
			answer = Math.max(answer, gameStart());
			return;
		}

    	for (int i = 1; i <= 4; i++) {
			order[depth] = i;
			permutation(depth + 1);
		}
	}

	private static int gameStart() {
		
		Arrays.fill(horse, start); // 말들을 시작지점으로 배치
		int score = 0;
		
		for(int i=1 ; i<=10 ; i++) {
			Node cur = horse[order[i]]; // 순열 할당된 순서대로 말 선택 
			cur.isEmpty = true;	// 현재 칸 비우기
			// 주사위에 나온 수치만큼 이동
			for(int j=1 ; j<=dice[i] ; j++) {
				if(j==1 && cur.fastPath != null) {	//시작하는 시점이면서 지름길이 있다면
					cur = cur.fastPath;// 지름길로 이동
				} else {	// 빨간색 방향으로 이동
					cur = cur.next;
				}
			}
			horse[order[i]] = cur; // 이동 후, 말  위치 설정 
			
			// 도착하지 않았으며 이미 말이 있는 노드라면 무효처리 
			if(!cur.isEmpty && !cur.isFinish) {
				score = 0;
				break;
			} 
			else {
				cur.isEmpty = false; // 말이 존재하는 것으로 표시
				score += cur.val;
			}
		} // 게임종료
		
		// 다음 게임을 위해 말 위치 초기화 
		for (int i=1; i<=4; i++) {
			horse[i].isEmpty = true;
		}
		return score;
	}
	
	private static void init() {
    	start = new Node(0); // 시작위치와 점수

    	Node temp = start;
    	for(int i = 2 ; i <= 40 ; i += 2) {	// 바깥쪽 경로 설정
    		temp = temp.addNext(i);
    	}
    	
    	// 도착지점
    	Node end = temp.addNext(0);
    	end.isFinish = true;
    	end.next = end; // 자기 자신 포인트 -> NPE 방지
    	
    	// 가운데 교차점(val = 25)
    	Node crossroads = new Node(25);
		// 교차점(25) - 30 - 35 - 40
		temp = crossroads.addNext(30);
		temp = temp.addNext(35);
		temp.next = Node.getNode(start, 40);
		
		// 10 - 13 - 16 - 19 - 25(교차점)
		temp = Node.getNode(start, 10);
		temp = temp.fastPath = new Node(13);
		temp = temp.addNext(16);
		temp = temp.addNext(19);
		temp.next = crossroads;
		
		// 20 - 22 - 24 - 25(교차점)
		temp = Node.getNode(start, 20);
		temp = temp.fastPath = new Node(22);
		temp = temp.addNext(24);
		temp.next = crossroads;
		
		// 30 - 28 - 27 - 26 - 25(교차점)
		temp = Node.getNode(start, 30);
		temp = temp.fastPath = new Node(28);
		temp = temp.addNext(27);
		temp = temp.addNext(26);
		temp.next = crossroads;
	}
}

class Node{
	int val;
	boolean isEmpty, isFinish;
	Node next, fastPath;
	
	Node(int val){
		this.val = val;
		this.isEmpty = true;
	}
	
	// 노드 연결
	Node addNext(int value) {
		Node nextNode = new Node(value);
		this.next = nextNode;
		return nextNode;
	}
	
	// 시작지점부터 탐색해가며 특정 노드를 찾는 메서드
	static Node getNode(Node start, int target) {
		Node temp = start;
		while(true) {
			if(temp == null) {
				return null;
			}
			if(temp.val == target) {
				return temp;
			}
			temp = temp.next;
		}
	}
}