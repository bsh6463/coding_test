package newId;


public class NewIdRecommend {

    public String solution(String new_id) {
        char[] cannotUse = {'~','!','@','#','$','%','^','&','*','(',')','=','+','[','{',']','}',':','?',',','<','>','/'};
        char[] newId = new_id.toCharArray();

        //1단계 : 대문자 -> 소문자.
        for (int i=0; i< newId.length; i++){
            if ((int) newId[i] >= 65 && (int) newId[i] <= 90){
                newId[i] += 32;
            }
        }
        new_id = new String(newId);

        //2단계 특수문자 제거 - _ . 제외한 특수문자 제거
        for (char c : cannotUse) {
            new_id = new_id.replace(c, ' ');
        }

        //공백제거
        while (new_id.contains(" ")){
            new_id = new_id.replace(" ", "");
        }

        //3단계 .가 2개 이상인 경우 .으로 변환.
        while (new_id.contains("..")){
            new_id = new_id.replace("..", ".");
        }

        //4단계 .가 처음이나 끝에 있으며 삭제.
        if (new_id.startsWith(".")){
            new_id = new_id.substring(1, new_id.length());
        }
        if (new_id.endsWith(".")){
            new_id = new_id.substring(0, new_id.length() - 1);
        }

        //5단계
        if (new_id.isBlank() || new_id.isEmpty()){
            new_id = "a";
        }

        //6단계
        if (new_id.length() >= 16){
            //15자만 짜르기
            new_id = new_id.substring(0, 15);
            if (new_id.endsWith(".")){
                new_id = new_id.substring(0, 14);
            }
        }


        //7단계
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
