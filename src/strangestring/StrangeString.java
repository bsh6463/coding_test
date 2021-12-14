package strangestring;

public class StrangeString {
    public String solution(String s) {
        StringBuilder builder = new StringBuilder();

        int index=0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) != ' '){
                if(index%2 != 0){
                    builder.append(toLowerCase(s.charAt(i)));

                }else{
                    builder.append(toUpperCase(s.charAt(i)));

                }
                index++;

            }else{
                index = 0;
                builder.append(' ');
            }

        }

        return builder.toString();
    }

    private char toUpperCase(char c){
        if(c >='a' && c<='z'){
            return (char) (c - ('a'-'A'));
        }else{
            return c;
        }
    }

    private char toLowerCase(char c){
        if(c >='A' && c<='Z'){
            return (char) (c + ('a'-'A'));
        }else{
            return c;
        }
    }
    public static void main(String[] args) {
        String s = "try hello world";
        StrangeString strangeString = new StrangeString();
        String solution = strangeString.solution(s);
        System.out.println("====answer===");
        System.out.println(solution);
    }
}
