package day3;

import java.util.Scanner;

public class C02_ForLoops {
    public static void main(String[] args) {
        /*
                - Kullanıcıdan 5 sayı girmesini isteyin.
                - Bu sayılardan birler basamağı 7 veya 9 olanlar hariç, sayıların toplamını hesaplayın.
         */

        Scanner input = new Scanner(System.in);
        int sum = 0;

        for(int i =0; i<5; i++){
            System.out.println("Please enter a number:");
            int sayi = input.nextInt();
            if(sayi %10 != 7 && sayi %10 != 9){
                sum += sayi;
            }

        }
        System.out.println(sum);

    }
}
