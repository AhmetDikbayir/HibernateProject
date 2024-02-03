package d5ternary_nestedif;

public class C01_Ternary {
    public static void main(String[] args) {
        //   verilen sayi 100'den buyukse sayi'nin karesini  alip yazdiran
        //   100'den kucukse " sayi 100'den buyuk olmali" yazdiran
        //   bir ternary olusturalim

        int sayi = 120;

        System.out.println(sayi>100 ? sayi*sayi: "Sayi 100 den büyük olmalı!");
    }
}
