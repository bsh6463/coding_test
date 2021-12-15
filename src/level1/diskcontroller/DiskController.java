package diskcontroller;

import java.util.ArrayList;
import java.util.PriorityQueue;


public class DiskController {

    public int solution(int[][] jobs) {
        int sum = 0;
        int endTime = 0;
        ArrayList<Job> tempContainer = new ArrayList<>();

        Job prevJob = null;
        PriorityQueue<Job> jobQueue = new PriorityQueue<>();

        for (int i=0; i<jobs.length; i++){
            int[] job = jobs[i];
            if (i==0){
                prevJob = new Job(job[0], job[1]);
                prevJob.setStartTime(0);
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
        DiskController controller = new DiskController();

        int[][] jobs = {{0,3}, {1,9}, {5,6}};

        int answer = controller.solution(jobs);

        System.out.println("average : " + answer);
    }

}
