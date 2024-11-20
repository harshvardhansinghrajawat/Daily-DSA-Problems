package Backtracking;

public class Subsets {
    public static void findSubset(String s1,String ans,int i ){
        if(i == s1.length()){
            if(ans.length() == 0){
                System.out.println("Null");
            }else{
                System.out.println(ans);
            }
            return;
        }

        findSubset(s1, ans+s1.charAt(i), i+1);
        findSubset(s1, ans, i+1);
        
    }
    public static void main(String[] args) {
        String s1 = "eidbaooo";
        findSubset(s1,"",0);

    }
}
