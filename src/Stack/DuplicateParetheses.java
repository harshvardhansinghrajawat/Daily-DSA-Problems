package Stack;

import java.util.Stack;

public class DuplicateParetheses {
    public static boolean duplicateParentheses(String str){//O(n)
        Stack<Character> s = new Stack<>();
        for (int i=0; i<str.length(); i++){
            //to check duplicate
            if (str.charAt(i) == ')'){
                int count = 0;
                while (s.peek() != '('){ //while( s.pop() != '(' ){ count++; }
                    s.pop();
                    count++;
                }
                if (count < 1) return true; //DUPLICATE
                s.pop();
            }else {
                //to push opening brackets & operators & variables
                s.push(str.charAt(i));
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "((a+b)+(c+d))";
        System.out.println(duplicateParentheses(str));
    }
}
