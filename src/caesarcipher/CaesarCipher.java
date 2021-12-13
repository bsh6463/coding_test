package caesarcipher;

public class CaesarCipher {

    //'a' ~ 'z' : 26개, 'A'~'Z', ' '
    public String solution(String s, int n) {
        StringBuilder builder = new StringBuilder();

        for (int i=0; i<s.length(); i++ ){
            char cha = s.charAt(i);
            if (cha>='a' && cha <= 'z'){
                char c = (char) (((cha + n) > 'z') ? 'a'+ (cha+n - 'z'-1) : cha + n);
                builder.append(c);
            }else if (cha>='A' && s.charAt(i) <= 'Z'){
                char c = (char) (((cha + n) > 'Z') ? 'A'+(cha+n - 'Z'-1) : cha + n);
                builder.append(c);
            }else if (cha== ' '){
                builder.append(' ');
            }
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        String s = "Bc Za";
        int n=25;
        CaesarCipher caesarCipher = new CaesarCipher();
        String answer = caesarCipher.solution(s, n);
        System.out.println("===answer====");
        System.out.println(answer);
    }

}
