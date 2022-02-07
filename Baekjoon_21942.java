import java.io.*;
import java.util.*;

public class Baekjoon_21942 {
	static int month[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	static int preMonth[];
	static int N,L,F;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		String tmpL = st.nextToken();
		F = Integer.parseInt(st.nextToken());
		preMonth = new int[13];
		int preSum = 0;
		/* �� ������ ��� */
		for(int i=0;i<13; i++) {
			preMonth[i] = preSum;
			preSum += month[i];
		}
		
		/* �뿩�Ⱓ ��� */
		L = Integer.parseInt(tmpL.substring(0, 3))*24*60 +
				Integer.parseInt(tmpL.substring(4,6))*60 +
				Integer.parseInt(tmpL.substring(7,9));
		
		HashMap<String, Long> rent = new HashMap<>();	// ��ǰ �뿩��
		TreeMap<String, Long> ans = new TreeMap<>();		// ����
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String str1 = st.nextToken();
			String str2 = st.nextToken();
			String P = st.nextToken();
			String M = st.nextToken();
			String PM = P+":"+M;
			long time = parseDate(str1,str2);
			
			if(rent.containsKey(PM)) {	// �뿩 ������ �ִٸ� -> ���� ���
				String[] tmp = PM.split(":");
				long lateFee = ( time -(long)rent.get(PM) - L )*F;
				if(lateFee > 0 ) {
					if(ans.containsKey(tmp[1])) {
						ans.put(tmp[1], ans.get(tmp[1])+lateFee );
					}else {
						ans.put(tmp[1],  lateFee );
					}
				}
				rent.remove(PM);	// �ݳ�
			}else {	// �뿩 ������ ���ٸ� -> �߰�
				rent.put(PM, time);
			}
		}
		
		if(ans.size() > 0) {
			for(String key : ans.keySet()) {
				System.out.println(key +" " + ans.get(key));
			}
		}else {
			System.out.println(-1);
		}
		
		
	}
	
	static long parseDate(String str1, String str2) {
		String[] md = str1.split("-");
		long MM = preMonth[Integer.parseInt(md[1])]*24*60 ;	// �����ϼ�*24*60
		long DD = (Integer.parseInt(md[2])-1)*24*60;
		String[] hm = str2.split(":");
		
		long hh = Integer.parseInt(hm[0])*60;
		long mm = Integer.parseInt(hm[1]);
		
		return MM+DD+hh+mm;
	}

}
