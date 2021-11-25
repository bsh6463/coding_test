package marathon;

import java.util.ArrayList;
import java.util.Arrays;

public class Marathon {

    public String solution(String[] participant, String[] completion) {

        ArrayList<String> participants = new ArrayList<>(Arrays.asList(participant));
        ArrayList<String> completions = new ArrayList<>(Arrays.asList(completion));

        for (String p : participants) {
            if (completions.contains(p)){
                completions.remove(p);
            }else {
                return  p;
            }
        }
        return "";
    }
}
