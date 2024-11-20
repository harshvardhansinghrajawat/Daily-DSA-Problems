package GreedyAlgorithms;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    public static int fractionalKnapsack(int value[],int weight[],int capacity){
        int maxValue = 0;

        double ratio[][] = new double[value.length][2];

        for (int i=0; i<value.length; i++){
            ratio[i][0] = i; //0th col => idx
            ratio[i][1] = value[i]/(double)weight[i]; //1st col => ratio
        }

        //sort ratio int ascending order
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        for (int i=ratio.length-1; i>=0; i--){
            int idx = (int)ratio[i][0];
            if (capacity >= weight[idx]){
                //include full item
                capacity -= weight[idx];
                maxValue += value[idx];
            }else {
                //include fractional item
                maxValue += (ratio[i][1]*capacity);
                capacity = 0;
                break;
            }
        }

        return maxValue;
    }
    public static void main(String[] args) {
        int value[] = {60,100,120};
        int weight[] = {10,20,30};

        System.out.println(fractionalKnapsack(value,weight,50));

    }
}
