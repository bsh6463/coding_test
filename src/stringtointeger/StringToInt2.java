package stringtointeger;

public class StringToInt2 {

    public int solution(String s) {
        if (s.charAt(0) == '+'){
            return stringToInt(s.substring(1, s.length()));
        }else if(s.charAt(0) == '-') {
            return  -1*stringToInt(s.substring(1, s.length()));
        }else return Integer.parseInt(s);
    }


    private int stringToInt(String stringNumber){
        int result = 0;
        for (int i= stringNumber.length()-1; i>=0; i--){
            result += (int) ((stringNumber.charAt(i) - 48) * Math.pow(10, stringNumber.length() - 1 - i));
        }
        return  result;
    }


    public static void main(String[] args) {
        int zero = '0';
        int nine= '9';
        System.out.println(zero);
        System.out.println(nine);
    }
}
