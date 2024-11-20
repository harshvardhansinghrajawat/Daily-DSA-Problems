package Backtracking;

public class ArrayBacktracking {
    public static void changArr(int arr[],int i , int val){
        //BASE CASE
        if(i == arr.length){
            printArr(arr);
            return;
        }
        //RECURSION (KAAM)
        arr[i] = val;
        changArr(arr,i+1,val+1);   //Fun Call
        arr[i] = arr[i]-2;  //Backtracking
    }
    public static void printArr(int arr[]){
        for (int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[] = new int[5];
        changArr(arr,0,1);
        printArr(arr);
    }
}
