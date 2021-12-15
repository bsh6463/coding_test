package level1.middlecharacter;

public class MiddleChar2 {

    public String solution(String s) {
        return s.substring((s.length() - 1) / 2, s.length()/2+1);
    }

    public static void main(String[] args) {

        String s = "qwer";
        MiddleChar2 middleChar =new MiddleChar2();
        String solution = middleChar.solution(s);

        System.out.println("===answer===");
        System.out.println(solution);
    }
}
