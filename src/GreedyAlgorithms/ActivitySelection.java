package GreedyAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {
    public static void main(String[] args) {
        int start[] = {1,3,0,5,8,5};
        int end[] = {2,4,6,7,9,9};

        //sorting
        int activities[][] = new int[start.length][3];
        for (int i=0; i<start.length; i++){
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        //lamda function -> shortform  (=> to sort the 2d array)
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        //end time basis sorted
        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        //1st activity
        maxAct = 1;
        ans.add(0); //ans.add(activities[0][0]);
        int lastEnd = end[0]; //int lastEnd = activities[0][2];
        for (int i=1; i<start.length; i++){
            if (start[i] >= lastEnd){ //(activities[i][1] >= lastEnd)
                //activity select
                ans.add(i); //ans.add(activities[i][0]);
                maxAct++;
                lastEnd = end[i]; // lastEnd = end[activities[i][2]];
            }
        }
        System.out.println(maxAct);
        System.out.println(ans);
    }
}
