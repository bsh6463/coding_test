package level1.keypad;


public class KeyPad {

    public String solution(int[] numbers, String hand) {
        String answer = "";

        for (int i=0; i<numbers.length; i++){
            if (numbers[i] == 0){
                numbers[i] = 11;
            }
        }
        Hand left= new Hand();
        left.position = 10;
        Hand right = new Hand();
        right.position = 12;

        for (int i=0; i< numbers.length; i++){
            int number = numbers[i];
            if (i ==0){
                if (number == 10 || number == 2 || number == 5 || number == 8){
                    if (hand.equals("left")){
                        answer = left(answer, left, number);

                    }else {
                        answer = right(answer, right, number);
                    }
                }else {
                    answer = pressButton(hand, answer, left, right, number);
                }

            }else {
                answer = pressButton(hand, answer, left, right, number);
            }
        }

        return answer;
    }

    private String pressButton(String hand, String answer, Hand left, Hand right, int number) {
        if (number == 1 || number == 4 || number == 7){
            answer = left(answer, left, number);

        }else if (number == 3 || number == 6 || number == 9){
            answer = right(answer, right, number);

        }else { // 10,2, 5, 8인 경우
            int leftDistance = getDistance(number, left);
            int rightDistance = getDistance(number, right);

            if (leftDistance < rightDistance){
                answer = left(answer, left, number);

            }else if (leftDistance > rightDistance){
                answer = right(answer, right, number)
                ;
            }else {
                if (hand.equals("left")){
                    answer = left(answer, left, number);

                }else {
                    answer = right(answer, right, number);

                }

            }
        }
        return answer;
    }

    private String left(String answer, Hand left, int number) {
        left.position= number;
        answer +="L";
        return answer;
    }

    private String right(String answer, Hand right, int number) {
        right.position = number;
        answer += "R";
        return answer;
    }


    public int getDistance(int number, Hand hand){
        int subtract = Math.abs(number- hand.position);
        int y = subtract / 3; //세로 이동
        int x = subtract % 3; //가로 이동

        return x+y;
    }

    public static class Hand{
        int position;
    }


    public static void main(String[] args) {
        int[] nums = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        KeyPad keyPad = new KeyPad();

        String answer = keyPad.solution(nums, "left");
        System.out.println("====answer====");
        System.out.println(answer);
    }
}
