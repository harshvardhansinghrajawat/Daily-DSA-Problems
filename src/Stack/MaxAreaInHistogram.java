package Stack;

import java.util.Stack;

public class MaxAreaInHistogram {
    //NEXT SMALLER RIGHT
    public static void nextSmallerRight(int heights[], int nsR[]){
        Stack<Integer> s = new Stack<>();
        for (int i=heights.length-1; i>=0; i--){ //FOR RIGHT -> THE LOOP => i=arr.length - 1 TO arr>=0
            while (!s.isEmpty() && heights[i] <= heights[s.peek()]){  //FOR NEXT SMALLER ELEMENT => arr[i] < = arr[s.peek()]
                s.pop();
            }
            if (s.isEmpty()){
                nsR[i] = heights.length;
            }else {
                nsR[i] = s.peek();
            }
            s.push(i);
        }
    }
    //NEXT SMALLER LEFT
    public static void nextSmallerLeft(int heights[], int nsL[]){
        Stack<Integer> s = new Stack<>();
        for (int i=0; i<heights.length; i++){ //FOR LEFT -> REVERSE THE LOOP => i=0 to i<arr.length
            while (!s.isEmpty() && heights[i] <= heights[s.peek()]){  //FOR NEXT SMALLER ELEMENT => arr[i] < = arr[s.peek()]
                s.pop();
            }
            if (s.isEmpty()){
                nsL[i] = -1;
            }else {
                nsL[i] = s.peek();
            }
            s.push(i);
        }
    }

    public static int maxAreaInHistogram(int heights[]){
         int nsR[] = new int[heights.length];
         int nsL[] = new int[heights.length];
         int currArea = 0;
         int maxArea = Integer.MIN_VALUE;
         nextSmallerRight(heights,nsR);
         nextSmallerLeft(heights,nsL);
         for (int i=0; i<heights.length; i++){
             currArea = heights[i] * (nsR[i] - nsL[i] -1);
             if (currArea > maxArea) maxArea = currArea;
         }
         return maxArea;

         //OPTIMAL SOLUTION WITHOUT STACK
//        int n = heights.length;
//        int[] L = new int[n];
//        int[] R = new int[n];
//        L[0] = -1;
//        R[n - 1] = n;
//        for (int i = 0; i < n; i++) {
//            int Prev = i - 1;
//            while (Prev >= 0 && heights[Prev] >= heights[i]) {
//                Prev = L[Prev];
//            }
//            L[i] = Prev;
//        }
//        for (int j = n - 2; j >= 0; j--) {
//            int Prev = j + 1;
//            while (Prev < n && heights[Prev] >= heights[j]) {
//                Prev = R[Prev];
//            }
//            R[j] = Prev;
//        }
//        int maxArea = 0;
//        for (int k = 0; k < n; k++) {
//            maxArea = Math.max(maxArea, (heights[k] * (R[k] - L[k] - 1)));
//        }
//
//        return maxArea;
    }

    public static void main(String[] args) {
        int heights[] = {2,1,5,6,2,3};

        System.out.println("Maximum area in histogram = " + maxAreaInHistogram(heights));
    }
}
