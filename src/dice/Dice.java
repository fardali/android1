/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.math.BigInteger;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Dice {

    public static int Exercice1(LinkedList<Integer> L) {
        LinkedList<Integer> R = new LinkedList();
        LinkedList<Integer> val = L;
        val.add(0);
        int compteur1 = 0;
        int compteur2 = 0;
        for (int i = 0; i < val.size(); i++) {

            if (val.get(i) == 6) {

                compteur1++;

            } else if (val.get(i) != 6) {
                if (compteur1 == 2) {
                    compteur2++;
                }
                compteur1 = 0;

            }
        }

        return compteur2;
    }

    public static int Exercice2(LinkedList<Integer> L) {
        LinkedList<Integer> R = new LinkedList();
        int compteur1 = 0;
        int compteur2 = 0;
        for (int i = 0; i < L.size(); i++) {

            if (L.get(i) != 6) {
                compteur1++;
            } else {

                R.add(compteur1);
                compteur1 = 0;

            }
        }
        for (int j = 0; j < R.size(); j++) {

            if (R.get(j) > compteur2) {
                compteur2 = R.get(j);
            }
        }

        return compteur2;
    }

    public static int Exercice3(LinkedList L) {
        LinkedList<Integer> val = L;
        LinkedList<Integer> ret = new LinkedList<>();
        val.add(0);
        int compteur1 = 0;
        for (int i = 0; i < val.size(); i++) {

            if (val.get(i) == 6 || val.get(i) == 5) {

                compteur1++;

            } else if (val.get(i) != 6 || val.get(i) != 5) {
                if (compteur1 > 0) {
                    ret.add(compteur1);

                }
                compteur1 = 0;

            }
        }
        /*  Collections.sort(ret, new Comparator<Integer>() {
     

         @Override
         public int compare(Integer o1, Integer o2) {
         return Collator.getInstance().compare(o1, o2);
         }
         });*/
        Collections.sort(ret);
        int el = 0;
        int compteur2 = 0;
        LinkedList<Integer> solution = new LinkedList<Integer>();
        for (int s = 0; s < ret.size(); s++) {
            solution.addFirst(ret.get(s));
        }

        for (int j = 0; j < solution.size(); j++) {
            //System.out.print(" "+solution.get(j));
            // |2|2|3|3|
            int tempEl = solution.get(j);//2,2,3
            int tempcompt = 0;
            for (int i = 0; i < solution.size(); i++) {
                if (solution.get(i) == tempEl) {
                    tempcompt++;
                }
                if (tempcompt > compteur2) {
                    el = tempEl; // el =2,2,3

                    compteur2 = tempcompt;//2,2

                }
            }
        }
//        System.out.println("");

        return el;
    }

    public static void main(String[] args) {
        File file = new File("input.txt");

        LinkedList<Integer> val = new LinkedList<>();
        int len;
        BigInteger values = null;

        BigInteger vv = new BigInteger("0");
        Scanner keyb = new Scanner(System.in);
        len = keyb.nextInt();
        values = keyb.nextBigInteger(); // this line is to read values from keyboard , to et data from file , comment this line and uncomment the block bellow 
        /* to imput values from text file uncomment this bloc 
         try {
           
         Scanner scanner = new Scanner(file);
         while (scanner.hasNextLine()) {
         values = scanner.nextBigInteger();
               
         }
         } catch (FileNotFoundException e) {
         e.printStackTrace();
         }
         */

        int scar = values.toString().length();
        for (int i = 0; i < scar; i++) {
            int vss = values.mod(BigInteger.TEN).intValue();
            val.addFirst(vss);
            values = values.divide(BigInteger.TEN);
        }

        System.out.println(Exercice1(val));
        System.out.println(Exercice2(val));
        System.out.println(Exercice3(val));

    }

}
