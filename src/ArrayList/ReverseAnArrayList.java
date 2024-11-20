package ArrayList;

import java.util.ArrayList;
import java.util.Collections;

public class ReverseAnArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1; i<=5; i++){
             list.add(i);
        }

        /*for (int i=list.size()-1; i>=0; i--){
            System.out.print(list.get(i)+" ");
        }*/

        Collections.reverse(list);
        System.out.println(list);
    }
}
