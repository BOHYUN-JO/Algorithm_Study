import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_17825 {
	static int[] dice, order; // �ֻ���, ��ġ����
	static Node[] horse; // 4���� ��
	static Node start; // ��������
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
		
		init(); // �������� ���� 
		permutation(1); // 10���� �ֻ��� ����� ���鿡�� �Ҵ�
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
		
		Arrays.fill(horse, start); // ������ ������������ ��ġ
		int score = 0;
		
		for(int i=1 ; i<=10 ; i++) {
			Node cur = horse[order[i]]; // ���� �Ҵ�� ������� �� ���� 
			cur.isEmpty = true;	// ���� ĭ ����
			// �ֻ����� ���� ��ġ��ŭ �̵�
			for(int j=1 ; j<=dice[i] ; j++) {
				if(j==1 && cur.fastPath != null) {	//�����ϴ� �����̸鼭 �������� �ִٸ�
					cur = cur.fastPath;// ������� �̵�
				} else {	// ������ �������� �̵�
					cur = cur.next;
				}
			}
			horse[order[i]] = cur; // �̵� ��, ��  ��ġ ���� 
			
			// �������� �ʾ����� �̹� ���� �ִ� ����� ��ȿó�� 
			if(!cur.isEmpty && !cur.isFinish) {
				score = 0;
				break;
			} 
			else {
				cur.isEmpty = false; // ���� �����ϴ� ������ ǥ��
				score += cur.val;
			}
		} // ��������
		
		// ���� ������ ���� �� ��ġ �ʱ�ȭ 
		for (int i=1; i<=4; i++) {
			horse[i].isEmpty = true;
		}
		return score;
	}
	
	private static void init() {
    	start = new Node(0); // ������ġ�� ����

    	Node temp = start;
    	for(int i = 2 ; i <= 40 ; i += 2) {	// �ٱ��� ��� ����
    		temp = temp.addNext(i);
    	}
    	
    	// ��������
    	Node end = temp.addNext(0);
    	end.isFinish = true;
    	end.next = end; // �ڱ� �ڽ� ����Ʈ -> NPE ����
    	
    	// ��� ������(val = 25)
    	Node crossroads = new Node(25);
		// ������(25) - 30 - 35 - 40
		temp = crossroads.addNext(30);
		temp = temp.addNext(35);
		temp.next = Node.getNode(start, 40);
		
		// 10 - 13 - 16 - 19 - 25(������)
		temp = Node.getNode(start, 10);
		temp = temp.fastPath = new Node(13);
		temp = temp.addNext(16);
		temp = temp.addNext(19);
		temp.next = crossroads;
		
		// 20 - 22 - 24 - 25(������)
		temp = Node.getNode(start, 20);
		temp = temp.fastPath = new Node(22);
		temp = temp.addNext(24);
		temp.next = crossroads;
		
		// 30 - 28 - 27 - 26 - 25(������)
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
	
	// ��� ����
	Node addNext(int value) {
		Node nextNode = new Node(value);
		this.next = nextNode;
		return nextNode;
	}
	
	// ������������ Ž���ذ��� Ư�� ��带 ã�� �޼���
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