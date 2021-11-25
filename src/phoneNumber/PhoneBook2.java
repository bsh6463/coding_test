package phoneNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PhoneBook2 {

    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length-1; i++){
           String current = phone_book[i];

            if (phone_book[i+1].startsWith(current)){
                return false;
            }

        }
        return answer;
    }

    public static void main(String[] args) {

        String[] phone_book = {"123", "456", "789"};

        PhoneBook2 phoneBook = new PhoneBook2();
        boolean answer = phoneBook.solution(phone_book);
        if (answer == true){
            System.out.println("정답");
        }else {
            System.out.println("오답");
        }
    }

}
