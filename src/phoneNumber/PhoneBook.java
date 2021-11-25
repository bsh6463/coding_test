package phoneNumber;


public class PhoneBook {

    public boolean solution(String[] phone_book) {
        boolean answer = true;

        for (int i = 0; i < phone_book.length-1; i++){
           String current = phone_book[i];

           for (int j=0; j < phone_book.length; j++){
               if (i!=j && phone_book[j].length() >= current.length()){
                   String head = phone_book[j].substring(0, current.length());

                   if (head.equals(current)){
                       return false;
                   }
               }

           }
        }
        return answer;
    }

    public static void main(String[] args) {

        String[] phone_book = {"123", "456", "789"};

        PhoneBook phoneBook = new PhoneBook();
        boolean answer = phoneBook.solution(phone_book);
        if (answer == false){
            System.out.println("정답");
        }else {
            System.out.println("오답");
        }
    }

}
