package diskcontroller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


public class DiskController2 {

    public int solution(int[][] jobs) {
        int sum = 0;
        int endTime = 0;

        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        ArrayList<Job> tempContainer = new ArrayList<>();
        PriorityQueue<Job> jobQueue = new PriorityQueue<>();
        Job prevJob = null;

        for (int i=0; i<jobs.length; i++){
            int[] job = jobs[i];
            if (i==0){
                prevJob = new Job(job[0], job[1]);
                prevJob.setStartTime(job[0]);
                endTime = prevJob.getEndTime();
                sum = prevJob.getTotalTime();
                System.out.println(prevJob);
            }else {
                jobQueue.add(new Job(job[0], job[1]));
            }
        }


      while (!jobQueue.isEmpty()){

          Job job = jobQueue.remove();

          if (job.getRequestTime() > prevJob.getEndTime()){
              tempContainer.add(job);
              job = jobQueue.remove();
          }
          job.setStartTime(endTime);
          sum += job.getTotalTime();
          endTime = job.getEndTime();
          prevJob = job;

          if(!tempContainer.isEmpty()){
              jobQueue.addAll(tempContainer);
              tempContainer.clear();
          }

          System.out.println(job);
      }

        return sum/ jobs.length;
    }


    private class Job implements Comparable<Job>{
        private int requestTime;
        private int startTime;
        private int workingTime;
        private int endTime;
        private int totalTime;

        public Job(int requestTime, int workingTime) {
            this.requestTime = requestTime;
            this.workingTime = workingTime;
        }

        public int getRequestTime() {
            return requestTime;
        }

        public int getTotalTime(){
            totalTime = this.startTime+  + this.workingTime - this.requestTime;
            return totalTime;
        }

        public int getEndTime() {
            endTime = startTime +workingTime;
            return endTime;
        }

        public void setStartTime(int startTime) {
            this.startTime = startTime;
        }

        @Override
        public int compareTo(Job o) {
            return this.workingTime - o.workingTime;
        }

        @Override
        public String toString() {
            return "Job{" +
                    "requestTime=" + requestTime +
                    ", startTime=" + startTime +
                    ", workingTime=" + workingTime +
                    ", endTime=" + endTime +
                    ", totalTime=" + totalTime +
                    '}';
        }
    }


    public static void main(String[] args) {
        DiskController2 controller = new DiskController2();

        int[][] jobs = {{1,9},{0,5}, {2,3}};

        int answer = controller.solution(jobs);

        System.out.println("average : " + answer);
    }

}
