package level1.middlecharacter;

public class MiddleChar {

    public String solution(String s) {
        if(s.length() % 2 != 0){
            return  s.substring((s.length()-1) / 2, (s.length()-1)/2 + 1);

        }else {
            return  s.substring((s.length()-1) / 2, (s.length()-1)/2+ 2);
        }
    }

    public static void main(String[] args) {

        String s = "qwer";
        MiddleChar middleChar =new MiddleChar();
        String solution = middleChar.solution(s);

        System.out.println("===answer===");
        System.out.println(solution);
    }
}
