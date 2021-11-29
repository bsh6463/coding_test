package scoville;

import java.util.PriorityQueue;

public class Scoville {

    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> scovileQueue = new PriorityQueue<>();

        for (int s : scoville) {
            scovileQueue.add(s);
        }

        while (!scovileQueue.isEmpty()){
            answer++;
            int s1 = scovileQueue.remove();
            int s2= scovileQueue.remove();
            int s3 = s1 + (s2*2);
            scovileQueue.add(s3);

            if (scovileQueue.peek() >= K){
                break;
            }else if (scovileQueue.size()==1){
                return -1;
            }
        }

        System.out.println("====================");
        scovileQueue.stream().forEach(System.out::println);
        return answer;
    }

    public static void main(String[] args) {
        Scoville scoville = new Scoville();

        int[] scovilles ={1, 2, 3, 9, 10, 12};
        int K = 100000;

        int answer = scoville.solution(scovilles, K);

        System.out.println("answer : " + answer);
    }


}
