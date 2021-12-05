package keypad;

public class KeyPad2 {

    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();

        for (int i=0; i<numbers.length; i++){
            if (numbers[i] == 0){
                numbers[i] = 11;
            }
        }
        Hand left= new Hand(10);
        Hand right = new Hand(12);

        for (int i=0; i< numbers.length; i++){
            answer.append(pressButton(hand, left, right, numbers[i]));
        }
        return answer.toString();
    }

    private String pressButton(String hand, Hand left, Hand right, int number) {
        if (number == 1 || number == 4 || number == 7){
            left.position= number;
            return "L";

        }else if (number == 3 || number == 6 || number == 9){
            right.position= number;
            return "R";

        }else { // 10,2, 5, 8인 경우
            int leftDistance = getDistance(number, left);
            int rightDistance = getDistance(number, right);

            if (leftDistance < rightDistance){
                left.position= number;
                return "L";

            }else if (leftDistance > rightDistance){
                right.position= number;
                return "R";
            }else {
                if (hand.equals("left")){
                    left.position= number;
                    return "L";

                }else {
                    right.position= number;
                    return "R";
                }
            }
        }
    }


    public int getDistance(int number, Hand hand){
        int subtract = Math.abs(number- hand.position);
        int y = subtract / 3; //세로 이동
        int x = subtract % 3; //가로 이동

        return x+y;
    }

    public static class Hand{
        int position;

        public Hand(int position) {
            this.position = position;
        }
    }


    public static void main(String[] args) {
        int[] nums = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        KeyPad2 keyPad = new KeyPad2();

        String answer = keyPad.solution(nums, "left");
        System.out.println("====answer====");
        System.out.println(answer);
    }
}
