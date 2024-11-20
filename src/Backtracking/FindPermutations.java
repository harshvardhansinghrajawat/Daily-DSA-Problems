package Backtracking;

public class FindPermutations {
    public static void findPerutation(String str, String ans){
        //base case
        if (str.length() == 0){
            System.out.println(ans);
            return;
        }
        //recursiom
        for (int i=0; i<str.length(); i++){
            char curr = str.charAt(i);
            String NewStr = str.substring(0,i)+str.substring(i+1);
            findPerutation(NewStr,ans+curr);
        }
    }

    public static void main(String[] args) {
        String str = "abc";
        findPerutation(str,"");
    }
}
