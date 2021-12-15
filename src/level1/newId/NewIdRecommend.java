package newId;


public class NewIdRecommend {

    public String solution(String new_id) {
        char[] cannotUse = {'~','!','@','#','$','%','^','&','*','(',')','=','+','[','{',']','}',':','?',',','<','>','/'};
        char[] newId = new_id.toCharArray();
        

        //1단계 : 대문자 -> 소문자.
        toLowerCase(newId);
        new_id = new String(newId);

        //2단계 특수문자 제거 - _ . 제외한 특수문자 제거
        new_id = removeSpecialChar(new_id, cannotUse);

        //3단계 .가 2개 이상인 경우 .으로 변환.
        new_id = changeDotsToDot(new_id);

        //4단계 .가 처음이나 끝에 있으며 삭제.
        new_id = removeFistOrLastDot(new_id);

        //5단계
        new_id = changeEmptyToA(new_id);

        //6단계
        new_id = noGreaterThan16(new_id);


        //7단계
        new_id = notShorterThan3(new_id);

        return new_id;
    }

    private void toLowerCase(char[] newId) {
        for (int i = 0; i< newId.length; i++){
            if ((int) newId[i] >= 65 && (int) newId[i] <= 90){
                newId[i] += 32;
            }
        }
    }

    private String removeSpecialChar(String new_id, char[] cannotUse) {
        for (char c : cannotUse) {
            new_id = new_id.replace(c, ' ');
        }

        //공백제거
        while (new_id.contains(" ")){
            new_id = new_id.replace(" ", "");
        }
        return new_id;
    }

    private String changeDotsToDot(String new_id) {
        while (new_id.contains("..")){
            new_id = new_id.replace("..", ".");
        }
        return new_id;
    }

    private String removeFistOrLastDot(String new_id) {
        if (new_id.startsWith(".")){
            new_id = new_id.substring(1, new_id.length());
        }
        if (new_id.endsWith(".")){
            new_id = new_id.substring(0, new_id.length() - 1);
        }
        return new_id;
    }

    private String changeEmptyToA(String new_id) {
        if (new_id.isBlank() || new_id.isEmpty()) {
            new_id = "a";
        }
        return new_id;
    }

    private String noGreaterThan16(String new_id) {
        if (new_id.length() >= 16){
            //15자만 짜르기
            new_id = new_id.substring(0, 15);
            if (new_id.endsWith(".")){
                new_id = new_id.substring(0, 14);
            }
        }
        return new_id;
    }

    private String notShorterThan3(String new_id) {
        if (new_id.length() <=2 ){
            while (new_id.length() < 3){
                int index = new_id.length()-1;
                char c = new_id.charAt(index);
                new_id = new_id + c;
            }
        }
        return new_id;
    }

    public static void main(String[] args) {
        String newId = "abcdefghijklmnpp";

        NewIdRecommend recommender = new NewIdRecommend();
        String answer = recommender.solution(newId);

        System.out.println("=====answer====");
        System.out.println(answer);
    }

}
