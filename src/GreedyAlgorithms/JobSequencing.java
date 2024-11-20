package GreedyAlgorithms;

import java.util.ArrayList;
import java.util.Collections;

public class JobSequencing {
    static class Job{
        int deadline;
        int profit;
        int id; //0(A),1(B),2(C)...

        public Job(int id,int deadline,int profit){
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }
    public static void main(String[] args) {
        int jobs[][] = {{4,20},{1,10},{1,40},{1,30}};

        ArrayList<Job> job = new ArrayList<>();

        for (int i=0; i<jobs.length; i++){
            job.add(new Job(i,jobs[i][0],jobs[i][1]));
        }

        //descending order
        // (a,b) -> a.profit-b.profit  => for ascending order
        Collections.sort(job,(a,b) -> b.profit-a.profit);

        ArrayList<Integer> seq = new ArrayList<>();
        int time = 0;
        for (int i=0; i<job.size();i++){
            Job curr = job.get(i);
            if (curr.deadline > time){
                seq.add(curr.id);
                time++;
            }
        }

        System.out.println("Max jobs = "+seq.size());
        System.out.println("Jobs = "+seq);
    }
}
