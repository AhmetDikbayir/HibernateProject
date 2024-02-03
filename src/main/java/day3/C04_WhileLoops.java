package day3;

import java.util.Scanner;

public class C04_WhileLoops {
    public static void main(String[] args) {
        /*
                - Kullanıcıdan bir sayı girdisi isteyin.

                - Girilen sayıdan başlayarak 10'un katına gelene kadar ardışık sayıları yazdırın.
         */
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a number: ");
        int num = input.nextInt();

        while (num %10 != 0) {
            System.out.println(num);
            num++;
        }
    }
}
