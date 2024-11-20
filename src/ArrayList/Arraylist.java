package ArrayList;

import java.util.ArrayList;

public class Arraylist {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();

        list1.add(1);  //add element in list
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(1,8);  //add element at index
        System.out.println(list1);
        System.out.println(list1.get(2));  //get element with index
        list1.remove(2); //remove or delete element at index
        list1.set(1,10); //set element at index
        System.out.println(list1);
        System.out.println(list1.contains(4)); //check the element in arraylist

        System.out.println(list1.size());  //return size of list
    }
}
