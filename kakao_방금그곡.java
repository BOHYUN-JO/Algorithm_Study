import java.util.* ;

class kakao_��ݱװ� {
    static HashMap<String, String> dict = new HashMap<>();

    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        
        dict.put("C#", "c"); dict.put("D#", "d"); dict.put("F#", "f");
        dict.put("G#", "g"); dict.put("A#", "a");
        m = change(m);
        
        int maxTime = 0;
        for(int i=0; i<musicinfos.length; i++){
            String[] temp = musicinfos[i].split(",");
            int time = getTime(temp[0], temp[1]);
            String music = change(temp[3]);
            while(music.length()<time){
                    music += music;
            }
            music = music.substring(0,time);
            
            if(music.contains(m)){
                if(maxTime < time){
                    maxTime = time;
                    answer = temp[2];
                }
            }
            
        }
        
                
        return answer;
    }
    
    static String change(String str){
        for(String key : dict.keySet()){
            str = str.replace(key, dict.get(key));
        }
        return str;
    }
    
    static int getTime(String str1, String str2){
        String[] time1 = str1.split(":");
        String[] time2 = str2.split(":");
        
        int h1 = Integer.parseInt(time1[0])*60;
        int h2 = Integer.parseInt(time2[0])*60;
        
        int m1 = Integer.parseInt(time1[1]);
        int m2 = Integer.parseInt(time2[1]);
        
        return (h2+m2)-(h1+m1);
        
    }
}