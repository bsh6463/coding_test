package sortstring;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


public class SortString {
    public String[] solution(String[] strings, int n) {

        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.charAt(n) == o2.charAt(n)){
                   return  o1.compareTo(o2);
                }else {
                    return (int) o1.charAt(n) - (int) o2.charAt(n);
                }
            }
        });

        queue.addAll(Arrays.asList(strings));

        int cnt=0;
        String[] answer = new String[queue.size()];
        while (!queue.isEmpty()){
            answer[cnt++] = queue.remove();
        }
        return answer;
    }
}
