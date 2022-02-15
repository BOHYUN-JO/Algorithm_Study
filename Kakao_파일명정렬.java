import java.util.*;

class Kakao_���ϸ����� {
    public String[] solution(String[] files) {
        String[] answer;
        ArrayList<File> list = new ArrayList<>();
        
        for(int i=0; i<files.length; i++){
        	list.add(new File(files[i]));    
        }
        answer = new String[list.size()];
        
        Collections.sort(list);	// ����
        
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i).head + list.get(i).number + list.get(i).tail;
        }        
                
        return answer;
    }
    
    static class File implements Comparable<File>{
        int num;	// ���� ����
        String head="";
        String number="";
        String tail="";
        
        /* ������-parsing */
        File(String str){
            int idx=0;
            while(true){	// ���ڸ� ������ break
                if(str.charAt(idx)>='0' && str.charAt(idx) <='9') break;
                idx++;
            }
            this.head = str.substring(0,idx);
            
            String tmp = "";
            while(true){
                tmp += str.charAt(idx);
                idx++;
                if(idx >= str.length() || str.charAt(idx) < '0' || str.charAt(idx) >'9') break;
            }
            this.number = tmp;
            
            if(idx < str.length()){
                this.tail = str.substring(idx);
            }
            
        }
        
        @Override
        public int compareTo(File o){
            /* head �ҹ��ڷ� ���� */
            String str1 = this.head.toLowerCase();
            String str2 = o.head.toLowerCase();
            if(str1.equals(str2)) {	// head�� ���ٸ�
                int num1 = Integer.parseInt(this.number);
                int num2 = Integer.parseInt(o.number);
                if(num1 == num2){	// number�� ���ٸ�
                	return this.num - o.num; // ���� �������
                }
                return num1-num2;	// number �������
            }
            
            return str1.compareTo(str2);	// head �������
        }
    }
}