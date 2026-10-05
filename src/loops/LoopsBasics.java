package loops;

import java.util.ArrayList;
import java.util.List;

/**
 * ====================================================================
 * KONU: Java'da Döngüler (Loops) ve Kontrol İfadeleri
 * ====================================================================
 * Bu sınıf, Java programlamadaki tüm temel döngü yapılarını (for, while,
 * do-while, for-each), iç içe döngüleri ve döngü kontrol mekanizmalarını
 * (break, continue) uygulamalı olarak öğretir.
 */
public class LoopsBasics {

    public static void main(String[] args) {

        // -------------------------------------------------------------
        // 1. KLASİK FOR DÖNGÜSÜ (Sayaç bazlı tekrarlar için)
        // -------------------------------------------------------------
        System.out.println("=== 1. FOR DÖNGÜSÜ ===");
        System.out.println("1'den 5'e kadar olan sayıların karesi:");
        for (int i = 1; i <= 5; i++) {
            System.out.println(i + " sayısının karesi: " + (i * i));
        }

        // -------------------------------------------------------------
        // 2. WHILE DÖNGÜSÜ (Koşul doğru olduğu sürece çalışır)
        // -------------------------------------------------------------
        System.out.println("\n=== 2. WHILE DÖNGÜSÜ ===");
        int countdown = 3;
        System.out.print("Geri sayım: ");
        while (countdown > 0) {
            System.out.print(countdown + "... ");
            countdown--;
        }
        System.out.println("Ateşlendi!");

        // -------------------------------------------------------------
        // 3. DO-WHILE DÖNGÜSÜ (Koşul yanlış olsa bile en az 1 kez çalışır)
        // -------------------------------------------------------------
        System.out.println("\n=== 3. DO-WHILE DÖNGÜSÜ ===");
        int balance = 0;
        do {
            System.out.println("Bakiyeniz kontrol ediliyor: " + balance + " TL. (En az 1 kez çalıştı)");
        } while (balance > 100);

        // -------------------------------------------------------------
        // 4. FOR-EACH DÖNGÜSÜ (Gelişmiş For - Diziler ve Listeler için)
        // -------------------------------------------------------------
        System.out.println("\n=== 4. FOR-EACH DÖNGÜSÜ ===");
        List<String> programmingLanguages = new ArrayList<>();
        programmingLanguages.add("Java");
        programmingLanguages.add("Python");
        programmingLanguages.add("Kotlin");
        programmingLanguages.add("C++");

        System.out.println("Öğrenilen Programlama Dilleri:");
        for (String lang : programmingLanguages) {
            System.out.println("-> " + lang);
        }

        // -------------------------------------------------------------
        // 5. İÇ İÇE DÖNGÜLER (Nested Loops) - Çarpım Tablosu Örneği
        // -------------------------------------------------------------
        System.out.println("\n=== 5. İÇ İÇE DÖNGÜLER (Çarpım Tablosu 1-3) ===");
        for (int row = 1; row <= 3; row++) {
            for (int col = 1; col <= 3; col++) {
                System.out.printf("%d x %d = %-2d   ", col, row, (row * col));
            }   /*Dipnot; Buradaki d = decimal integer, yani ondalık gösterimde tam sayı anlamına gelir.
                  şöyle düşünebilirsin:
                                              %d%d%d  %d%d%d  %d%d%d%d
                                              ↓ ↓ ↓    ↓ ↓ ↓  ↓ ↓ ↓ ↓
                                              1 2 3    4 5 6  7 8 9 0
                %-2d = integer'ı 2 karakterlik alana, sola yaslayarak yazdır.
                Buradaki 2, "2 basamak göster" demek değil; "en az 2 karakterlik alan kullan" demek. Bu ayrım önemli.


                */
            System.out.println();
        }



        // -------------------------------------------------------------
        // 6. BREAK ve CONTINUE KONTROL İFADELERİ
        // -------------------------------------------------------------
        System.out.println("\n=== 6. BREAK ve CONTINUE İFADELERİ ===");
        System.out.println("1'den 10'a kadar sayıları tara:");
        for (int num = 1; num <= 10; num++) {
            if (num % 2 == 0) {
                // Çift sayıları atla
                continue;
            }
            if (num > 7) {
                // 7'den büyük olunca döngüyü tamamen sonlandır
                System.out.println("7'den büyük sayıya ulaşıldı, döngü sonlandırılıyor (break).");
                break;
            }
            System.out.println("İşlenen tek sayı: " + num);
        }

        // -------------------------------------------------------------
        // 7. DÖNGÜ İÇİNDE ELEMAN ARAMA (LINEAR SEARCH + IF-ELSE MANTIĞI)
        // -------------------------------------------------------------
        System.out.println("\n=== 7. DÖNGÜ İÇİNDE ARAMA (LINEAR SEARCH) ===");
        int[] sayiListesi = {15, 42, 8, 99, 23, 74};
        int aranan = 99;
        boolean bulundu = false;
        int bulunanIndex = -1;

        for (int i = 0; i < sayiListesi.length; i++) {
            // Her adımda aranan sayıya eşit olup olmadığını if ile kontrol ediyoruz
            if (sayiListesi[i] == aranan) {
                bulundu = true;
                bulunanIndex = i;
                break; // Bulduğumuz anda diğer elemanları boşuna taramamak için döngüden çıkıyoruz
            }
        }

        // Döngü tamamlandıktan sonra sonucun değerlendirilmesi
        if (bulundu) {
            System.out.println("Aranan " + aranan + " sayısı dizide BULUNDU! (İndeks: " + bulunanIndex + ")");
        } else {
            System.out.println("Aranan " + aranan + " sayısı dizide BULUNAMADI!");
        }
    }
}

