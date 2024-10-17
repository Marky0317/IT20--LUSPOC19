
package javaapplication27;

import java.util.LinkedList;


public class JavaApplication27 {

   
    public static void main(String[] args) {
        LinkedList<String> genggeng = new LinkedList<>();

// insertion
        genggeng.add("si clyde");
        genggeng.addFirst("si yanyan");
        genggeng.addLast("si james");
        genggeng.add(1, "si ading");

        System.out.println("Linked List Original: " + genggeng);
        System.out.println(genggeng.size());

//  Seraching  
        if (genggeng.contains("si clyde")) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

        boolean containslion = genggeng.contains("si clyde");
        System.out.println(containslion);

//        Deletion
//        animals.remove();
//        animals.removeFirst();
//        animals.removeLast();
//        animals.remove(2);
//        System.out.println("LinkedList After Deletion: " + animals);
//        Insertion:    add(); addFirst();  addLast();  add(index, data);
//         Deletion:    remove();   removeFirst();  removeLast(); remove(index);
//          Searching operation:        contains(element); size();
    }

}
   