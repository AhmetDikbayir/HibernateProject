package day3;

import java.util.Scanner;

public class C01_ForLoops {
    public static void main(String[] args) {
        /*
                Kullanıcıdan bir kelime girdisi isteyin.
                Loop, kelimede c harfine rastlanana kadar devam etsin
                Bu sırada a herflerinin sayısını hesaplasın.
         */
        Scanner input = new Scanner(System.in);
        System.out.println("Lütfen bir sözcük giriniz: ");
        String str = input.next();

        int counter = 0;

        //Büyük harfi önlemek için.
        String lowerStr = str.toLowerCase();

        /*
        for(int i =0; i< str.length(); i++){
            if(lowerStr.charAt(i) == 'a'){
                counter++;
            }
            if(lowerStr.charAt(i) == 'c'){
                break;
            }
        }

         */

        int k = 0;
        while(k< lowerStr.length()){
            char currentChar = lowerStr.charAt(k);
            if(currentChar == 'a'){
                counter++;
            }
            if(currentChar == 'c'){
                break;
            }
            k++;
        }
        System.out.println(counter);


    }
}
