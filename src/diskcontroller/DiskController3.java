package diskcontroller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class DiskController3 {

    public int solution(int[][] jobs) {
    int sum = 0;
    ArrayList<int[]> container = new ArrayList<>();
    ArrayList<int[]> tempContainer = new ArrayList<>();

    //jobs를 요청 시간에 따라 정렬함.
    Arrays.sort(jobs, new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            if(o1[0] < o2[0]){
                return -1;
            }else if (o1[0] == o2[0]){
                return o1[1] - o2[1];
            } else {
                return 1;
            }

        }
     });

        int[] job = jobs[0];
        int endTime = job[0];
        for (int k=0; k < jobs.length; k++){

            container.add(job);
            endTime += job[1];
            sum += endTime - job[0];

            if (container.size() >= jobs.length) break;

            for (int l=k+1; l < jobs.length; l++){
                int[] temp = jobs[l];
                if (job[0] <= temp[0] && temp[0] < endTime){
                    tempContainer.add(temp);
                }
            }

            //다음 job
            if (!tempContainer.isEmpty()){
                job = tempContainer.stream().min(new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        return o1[1] - o2[1];
                    }
                }).get();
            }else if (k < jobs.length-1){
                job= jobs[k];
            }

            tempContainer.clear();
        }

    return sum/ jobs.length;
    }

    public static void main(String[] args) {
        DiskController3 controller = new DiskController3();

        int[][] jobs = {{24,10}, {28,39}, {43,20}, {37,5}, {47,22}, {20,47}, {15,34}, {15,2}, {35,43}, {26,1}};

        int answer = controller.solution(jobs);

        System.out.println("average : " + answer);
    }

}
