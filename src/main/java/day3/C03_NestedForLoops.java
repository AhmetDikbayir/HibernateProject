package day3;

import java.util.Scanner;

public class C03_NestedForLoops {
    public static void main(String[] args) {
        /*
             *
             * *
             * * *
             * * * *
             * * * * *
             * * * *
             * * *
             * *
             *
         */

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a number: ");
        int satir = input.nextInt();

        for(int i = 0; i<satir; i++){
            for(int j = 0; j<=i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        for(int i = 0; i<satir-1; i++){
            for(int j = satir-1; j>i; j--){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
