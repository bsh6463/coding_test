package level1.phoneNumber;


import java.util.HashMap;


public class PhoneBook3 {

    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<String, Integer> map = new HashMap<>();

        for (String number : phone_book) {
            map.put(number, 0);
        }

        for (int i=0; i < phone_book.length; i++){
            for (int j=0; j<phone_book[i].length();j++){

                //현재 접두어가 다른 번호인지?
                if (map.containsKey(phone_book[i].substring(0, j))){
                    return false;
                }
            }

        }

        return answer;
    }

    public static void main(String[] args) {

        String[] phone_book = {"123", "456", "789"};

        PhoneBook3 phoneBook = new PhoneBook3();
        boolean answer = phoneBook.solution(phone_book);
        if (answer == true){
            System.out.println("정답");
        }else {
            System.out.println("오답");
        }
    }

}
