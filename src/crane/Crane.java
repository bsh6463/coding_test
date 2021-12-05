package crane;

import java.util.ArrayList;
import java.util.Stack;

public class Crane {

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        //{{0,0,0,0,0},
        // {0,0,1,0,3},
        // {0,2,5,0,1},
        // {4,2,4,4,2},
        // {3,5,1,3,1}}
        ArrayList<Stack<Integer>> container = new ArrayList<>();

        //바구니는 Stack으로 구현
        Stack<Integer> bucket = new Stack<>();

        //인형뽑기 통?을 Stack의 배열로 변경함.
        int N = board.length;
        for (int i=0; i<N; i++){
            container.add(i, new Stack<Integer>());
            Stack<Integer> stack = container.get(i);
            for (int j=N-1; j >= 0; j--){
                int element = board[j][i];
                if (element == 0) continue;
                stack.push(element);
            }
        }

        //인형 뽑기
        int top = 0;
        int pop = 0;
        for (int move : moves) {
            int position = move-1;
            if (!container.get(position).isEmpty()){
                pop = container.get(position).pop();
            }else {
                continue;
            }

            //바구니에 넣을 때 터지는지 확인.
            if (!bucket.isEmpty()){
                top = bucket.peek();
            }else {
                top = 0;
            }

            if (top ==pop){
                //맨 위에 있는 인형과 같으면 맨 위의 인형을 날려버림.
                bucket.pop();
                answer++; //바구니에 있던 인형
                answer++; //뽑은 인형
            }else {
                //다르며 바구니에 넣음.
                bucket.push(pop);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},
                        {0,0,1,0,3},
                        {0,2,5,0,1},
                        {4,2,4,4,2},
                        {3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        Crane crane = new Crane();
        int answer = crane.solution(board, moves);

        System.out.println("=====answer=====");
        System.out.println(answer);
    }

}
