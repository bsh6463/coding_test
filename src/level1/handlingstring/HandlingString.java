package level1.handlingstring;

public class HandlingString {
    public boolean solution(String s) {

        if (s.length() == 4 || s.length() == 6){
            for (int i=0; i <s.length(); i++){
                if(s.charAt(i) > '9' || s.charAt(i) < '0') return false;
            }
            return true;
        }else return false;
    }

    public static void main(String[] args) {
        int nine = '9';
        System.out.println(nine);
        int zero = '0';
        System.out.println(zero);
    }
}
