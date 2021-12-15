package level1.stringdescent;

public class StringDescent {

    public String solution(String s) {
        StringBuilder builder = new StringBuilder();
        s.chars().sorted().forEach(c -> builder.append((char)c));
        return  builder.reverse().toString();
    }

    public static void main(String[] args) {

        String  s = "Zbcdefg";
        StringDescent descent = new StringDescent();
        String answer = descent.solution(s);
        System.out.println("answer  : " + answer);
    }

}
