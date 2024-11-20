package PlusLibrary.Amazon.Easy;

public class MergeSortedArray {
    public static void mergeSortedArray(int nums1[], int m, int nums2[], int n){
        int i = m-1;
        int j = n-1;
        int x = m+n-1;
        while (i>=0 && j>=0){
            if(nums1[i] > nums2[j]){
                nums1[x] = nums1[i];
                i--;
                x--;
            }else {
                nums1[x] = nums2[j];
                j--;
                x--;
            }
        }
        while (j>=0){
            nums1[x] = nums2[j];
            j--;
            x--;
        }
    }
    public static void main(String[] args) {
        int [] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int [] nums2 = {2,5,6};
        int n = 3;
        mergeSortedArray(nums1,m,nums2,n);
        for(int i = 0; i < m+n; i++ ){
            System.out.print(nums1[i]);
        }
    }
}
