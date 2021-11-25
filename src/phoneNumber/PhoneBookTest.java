package phoneNumber;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneBookTest {

    @Test
    void numberTest1(){
        String[] phone_book = {"12","123","1235","567","88"};

        PhoneBook3 phoneBook = new PhoneBook3();
        boolean answer = phoneBook.solution(phone_book);
        if (answer == false){
            System.out.println("정답");
        }else {
            System.out.println("오답");
        }
    }

    @Test
    void numberTest2(){
        String[] phone_book = {"123","456","789"};

        PhoneBook phoneBook = new PhoneBook();
        boolean answer = phoneBook.solution(phone_book);
        if (answer == true){
            System.out.println("정답");
        }else {
            System.out.println("오답");
        }
    }

    @Test
    void numberTest3(){
        String[] phone_book = {"12","123","1235","567","88"};

        PhoneBook phoneBook = new PhoneBook();
        boolean answer = phoneBook.solution(phone_book);
        if (answer == false){
            System.out.println("정답");
        }else {
            System.out.println("오답");
        }
    }

}