package level1.caesarcipher;

public class CaesarCipher2 {

    //'a' ~ 'z' : 26개, 'A'~'Z', ' '
    public String solution(String s, int n) {
        StringBuilder builder = new StringBuilder();

        for (int i=0; i<s.length(); i++ ){
            char cha = s.charAt(i);
            if (cha>='a' && cha <= 'z'){
                builder.append((char) ((cha-'a'+n)%(26)+'a'));
            }else if (cha>='A' && s.charAt(i) <= 'Z'){
                builder.append((char) ((cha-'A'+n)%(26)+'A'));
            }else if (cha== ' '){
                builder.append(' ');
            }
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        String s = "Bc Za";
        int n=25;
        CaesarCipher2 caesarCipher = new CaesarCipher2();
        String answer = caesarCipher.solution(s, n);
        System.out.println("===answer====");
        System.out.println(answer);
    }

}
