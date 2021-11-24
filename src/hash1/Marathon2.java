package hash1;

import java.util.HashMap;

public class Marathon2 {

    public String solution(String[] participant, String[] completion) {

        String answer = "";

        HashMap<String, Integer> participants = new HashMap<>();

        //중복이름 count
        for (String player : participant) {
            participants.put(player, participants.getOrDefault(player, 0)+1);
        }

        //참여자 명단에서, 완주 명단에 있는사람 count-1
        for (String c : completion) {
            if (participants.containsKey(c)){
                Integer cnt = participants.get(c);
                participants.put(c, cnt-1);
            }
        }

        //참여자 명단에서 count가 1 이상인 경우 미완주자.
        for (String p : participants.keySet()) {
            if (participants.get(p) > 0){
                answer =  p;
            }
        }

        return answer;
    }
}
