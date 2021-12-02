package diskcontroller;

import java.util.*;


public class DiskController4 {

    public int solution(int[][] jobs) {
        int sum = 0;
        PriorityQueue<Job> jobQueue= new PriorityQueue<>();
        ArrayList<Job> container = new ArrayList<>();
        ArrayList<Job> tempContainer = new ArrayList<>();

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

        //jobQueue생성. 요청시간, 크기 순.
        for (int[] job : jobs) {
            jobQueue.add(new Job(job[0], job[1]));
        }


        //첫 번째 작업 처리.
        int prevEndTime=0;
        Job job = jobQueue.remove();
        job.startTime = job.requestTime;
        sum += job.getTotalTime();
        prevEndTime = job.getEndTime();

        //Queue가 바닥날 때 까지 반복.
        while (!jobQueue.isEmpty()){
            //다음 job 찾기
            for (Job tmpJob : jobQueue) {

                //현재 job이 끝나기 전에 요청이 들어온 job을 container에 넣어둠.
                if (tmpJob.requestTime <= job.endTime ){
                    container.add(tmpJob);
                }
            }


            //Container에서 작업시간이 가장 작은 job 찾기.
            //만약 container가 비었으면 nextJob = null;
            Job nextJobBeoreEnd = container.stream().min(new Comparator<Job>() {
                @Override
                public int compare(Job o1, Job o2) {
                    return o1.workingTime - o2.workingTime;
                }
            }).orElse(null);
            container.clear();

            //현재 작업이 끝나기 전에 호출될 작업이 있는 경우.
            if (null != nextJobBeoreEnd){
                int cnt = jobQueue.size();
                for (int i=0; i <cnt ; i++){
                    Job tmp = jobQueue.remove();
                    if (tmp.requestTime == nextJobBeoreEnd.requestTime && tmp.workingTime == nextJobBeoreEnd.workingTime){
                        job = tmp;
                        job.startTime = prevEndTime;
                        break;
                    }else {
                        tempContainer.add(tmp);
                    }
                }
            }else {
                //현재 작업이 끝난 후 호출될 작업인 경우.
                job = jobQueue.remove();
                job.startTime = job.requestTime;

            }

            sum += job.getTotalTime();
            prevEndTime = job.getEndTime();

            jobQueue.addAll(tempContainer);
            tempContainer.clear();

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

        public int getTotalTime(){
            totalTime = this.startTime+  + this.workingTime - this.requestTime;
            return totalTime;
        }

        public int getEndTime() {
            endTime = startTime +workingTime;
            return endTime;
        }

        @Override
        public int compareTo(Job o) {
            if(this.requestTime < o.requestTime){
                return -1;
            }else if (this.requestTime == o.requestTime){
                return this.workingTime - o.workingTime;
            }else {
                return 1;
            }
        }

    }


    public static void main(String[] args) {
        DiskController4 controller = new DiskController4();

        int[][] jobs = {{0,3},{1,9},{2,6}, {30,3}};

        int answer = controller.solution(jobs);

        System.out.println("average : " + answer);
    }

}
