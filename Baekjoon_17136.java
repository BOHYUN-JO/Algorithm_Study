import java.io.*;
import java.util.*;

public class Baekjoon_17136 {
	static int map[][] = new int[10][10];
	static int paper[] = {0,5,5,5,5,5};
	static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		dfs(0,0,0);
		
		if(ans==Integer.MAX_VALUE) {
			System.out.println(-1);
		}else{
			System.out.println(ans);
		}
		
		
	}
	
	public static void dfs(int x, int y, int cnt) {
		
		if(x >= 9 && y >9) {
			ans = Math.min(ans, cnt);
			return;
		}
		
		if(ans <= cnt) {	// ans���� cnt�� ũ�� Ž���� �ʿ� ����
			return;
		}
		
		if(y>9) {	// ������ ���� ��. �Ʒ� �ٷ� �̵�
			dfs(x+1,0,cnt);
			return;
		}
		
		if(map[x][y] ==1) {
			for(int i=5; i>=1; i--) {
				if(paper[i] >0 && check(x,y,i)) {	// �����̰� �����ְ�, ���� �� �ִٸ�
					change(x,y,i,0);	// ������ ����
					paper[i]--;
					dfs(x,y+1,cnt+1);
					change(x,y,i,1);	// ������ ��
					paper[i]++;
				}
			}
		}else {	// ���������� �̵�
			dfs(x,y+1, cnt);
		}
	}
	
	/* ���¸� �ٲٴ� �Լ�. 0->1, 1->0 */
	public static void change(int x, int y, int size, int state) {
		for(int i=x; i<x+size; i++) {
			for(int j=y; j <y+size; j++) {
				map[i][j] = state;
			}
		}
	}
	
	/* �����̸� ���ϼ� �ִ��� üũ�ϴ� �Լ� */
	public static boolean check(int x, int y, int size) {
		for(int i=x; i<x +size; i++) {
			for(int j=y; j< y+size; j++) {
				if(i<0 || i>=10 || j<0 || j >=10) {	// ���� ���
					return false;
				}
				
				if(map[i][j] != 1) {	// 1�� �ƴ�
					return false;
				}
			}
		}
		return true;
	}
	
	
}
