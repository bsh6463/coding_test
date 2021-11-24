package hash1;

import org.junit.jupiter.api.Test;

class MarathonTest {

    Marathon2 marathon = new Marathon2();


    /**
     * answer = leo
     */
    @Test
    void solutionTest1(){
        String[] participants = {"leo", "kiki", "eden"};
        String[] completions = {"eden", "kiki"};

        String answer = marathon.solution(participants, completions);

        if (answer.equals("leo")){
            System.out.println("정답");
        }else {
            System.out.println("기댓값 'leo' 와 다릅니다.");
            System.out.println("your answer = " + answer);
        }

    }

    /**
     * answer = vinko
     */
    @Test
    void solutionTest2(){
        String[] participants = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completions = {"josipa", "filipa", "marina", "nikola"};

        String answer = marathon.solution(participants, completions);

        if (answer.equals("vinko")){
            System.out.println("정답");
        }else {
            System.out.println("기댓값 'vinko' 와 다릅니다.");
            System.out.println("your answer = " + answer);
        }

    }


    /**
     * answer = mislav
     */
    @Test
    void solutionTest3(){
        String[] participants = {"mislav", "stanko", "mislav", "ana"};
        String[] completions = {"stanko", "ana", "mislav"};

        String answer = marathon.solution(participants, completions);

        if (answer.equals("mislav")){
            System.out.println("정답");
        }else {
            System.out.println("기댓값 'mislav' 와 다릅니다.");
            System.out.println("your answer = " + answer);
        }

    }


}