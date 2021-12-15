package level1.stringtointeger;

public class StringToInt {
    public int solution(String s) {
        if (s.charAt(0) == '+'){
            return Integer.parseInt(s.substring(1, s.length()));
        }else if(s.charAt(0) == '-') {
            return  -1*Integer.parseInt(s.substring(1, s.length()));
        }else return Integer.parseInt(s);
    }
}
