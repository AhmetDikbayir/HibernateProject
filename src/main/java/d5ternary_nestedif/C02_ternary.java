package d5ternary_nestedif;

import java.util.Scanner;

public class C02_ternary {
    public static void main(String[] args) {
        // Kullanıcıdan bir tamsayı isteyin tek mi çift mi kontrol edin.

        Scanner input = new Scanner(System.in);
        System.out.println("Lütfen bir sayı giriniz: ");
        int sayi = input.nextInt();

        System.out.println((sayi %2 == 0) ? "Sayi çifttir" : "sayı tektir.");
    }
}
