package level2.jadencase;
import java.util.*;
public class JadenCase {

    public String solution(String s) {
        StringBuilder builder = new StringBuilder();

        //s = "  1Abc def";
        s = s.toLowerCase();

        String[] splited = s.split(" ");

        for(int i=0; i< splited.length; i++){
            if(splited[i].isEmpty()){
                builder.append(" ");
            }else{
                builder.append(splited[i].substring(0, 1).toUpperCase());
                builder.append(splited[i].substring(1, splited[i].length()) + " ");
            }

        }

        //마지막에 추가된 공백 제외하기 위해.
        return builder.toString().substring(0, s.length());
    }
}
