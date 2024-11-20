package GreedyAlgorithms;

import java.util.Arrays;
import java.util.Collections;

public class ChocolaProblem {
    public static void main(String[] args) {
        int n = 4, m = 6;
        Integer vCost[] = {2,1,3,1,4};
        Integer hCost[] = {4,1,2};

        Arrays.sort(vCost,Collections.reverseOrder());
        Arrays.sort(hCost,Collections.reverseOrder());

        int h = 0, v = 0;
        int hp = 1, vp = 1;
        int cost = 0;

        while (h < hCost.length && v < vCost.length){
            if (vCost[v] <= hCost[h]){//horizontal cut
                cost += (hCost[h] * vp);
                hp++;
                h++;
            }else {//vertical cut
                cost += (vCost[v] * hp);
                vp++;
                v++;
            }
        }

        while (h < hCost.length){
            //remaining horizontal cut
            cost += (hCost[h] * vp);
            hp++;
            h++;
        }

        while (v < vCost.length){
            //remaining vertical cut
            cost += (vCost[v] * hp);
            vp++;
            v++;
        }

        System.out.println(cost);
    }
}
