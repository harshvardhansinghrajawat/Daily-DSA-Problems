package GreedyAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class IndianCoins {
    public static void indianCoins(Integer coins[], int val){

        Arrays.sort(coins, Comparator.reverseOrder());
        int count = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i=0; i<coins.length; i++){
            if (coins[i] <= val){
                while (coins[i] <= val){
                    count++;
                    ans.add(coins[i]);
                    val -= coins[i];
                }
            }
        }
        System.out.println(count);
        System.out.println(ans);

    }
    public static void main(String[] args) {
        Integer coins[] = {1,2,5,10,20,50,100,500,2000};
        indianCoins(coins,555);
    }
}
