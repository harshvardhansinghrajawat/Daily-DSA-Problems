package ArrayList;

import java.util.ArrayList;

public class PairSum {
    public static boolean pairSum1(ArrayList<Integer> list, int target){
        //Brute Force Approach
//        for(int i=0; i<list.size(); i++){
//            for(int j=i+1; j<list.size(); j++){
//                if(list.get(i)+list.get(j) == target){
//                    return true;
//                }
//            }
//        }

        //2 Pointer Approach
        int lp = 0;
        int rp = list.size()-1;
        while(lp<rp){
            if(list.get(lp) + list.get(rp) == target){
                return true;
            } else if (list.get(lp) + list.get(rp) < target) {
                lp++;
            }else if (list.get(lp) + list.get(rp) > target) {
                rp--;
            }
        }

        return false;
    }


//    public int[] twoSum(int[] numbers, int target) {
//        int lp = 0;
//        int rp = numbers.length-1;
//        while(lp < rp){
//            if(numbers[lp] + numbers[rp] == target){
//                return new int []{lp+1,rp+1};
//            }else if(numbers[lp] + numbers[rp] < target){
//                lp++;
//            }else if(numbers[lp] + numbers[rp] > target){
//                rp--;
//            }
//        }
//        return new int[]{};
//    }


    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);


        System.out.println(pairSum1(list,5));

    }
}
