package day3;

import java.util.Scanner;

public class C05_DoWhileLoops {
    public static void main(String[] args) {
        /*
                - Kullanıcıdan pozitif tamsayılar isteyin.

                - 0 girdisi alındığında döngüyü durdurun.

                - Döngü durdurulduğunda, toplam girilen sayı adedini ve sayıların toplamını print edin.

                - Kullanıcı negatif bir sayı girerse, bunun mümkün olmadığını belirtin.

                - Negatif sayı girilirse, bu sayıyı sayı adedine veya toplama eklemeyin.

                - --> Girilen x sayının toplamı: y

         */

        Scanner input = new Scanner(System.in);
        int counter = 0;
        int sum = 0;
        do{
            System.out.println("Please enter a positive number: ");
            int num = input.nextInt();
            if(num <0){
                System.out.println("This cannot be done!");
            }else if(num>0){
                sum += num;
                counter++;
            }else{
                break;
            }

        }while(true);
        System.out.println("You entered " + counter + " number and sum of them is " + sum);
    }
}
