package exercises.easy;

import java.util.Arrays;

/**
 * ====================================================================
 * ALIŞTIRMA 3 [KOLAY] - Dizide Min, Max ve Aritmetik Ortalama Bulma
 * ====================================================================
 * Odaklanılan Konular:
 * - Diziler (Arrays) ve elemanlara erişim
 * - for-each döngüsü
 * - Temel istatistiksel hesaplamalar ve tip dönüşümü (type casting)
 *
 * PROBLEM TANIMI:
 * Verilen bir tamsayı dizisi içerisindeki:
 * 1. En küçük elemanı (Min)
 * 2. En büyük elemanı (Max)
 * 3. Elemanların toplamını
 * 4. Elemanların aritmetik ortalamasını
 * tek bir döngüde hesaplayan ve sonuçları ekrana düzenli bir şekilde yazdıran
 * programı yazınız.
 * ====================================================================
 */
public class Easy03_ArrayMinMaxAvg {

    public static void main(String[] args) {
        System.out.println("=== DİZİ MİN - MAX - ORTALAMA ANALİZİ ===");

        int[] sayilar = {34, 12, 89, 5, 67, 23, 91, 45, 18};

        analizEtVeYazdir(sayilar);
    }

    /**
     * ÇÖZÜM METODU:
     * Dizi elemanlarını tek geçişte inceleyerek en küçük, en büyük ve ortalamayı hesaplar.
     */
    public static void analizEtVeYazdir(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("Hata: Dizi boş veya tanımsız!");
            return;
        }

        // Başlangıç değerlerini dizinin ilk elemanına eşitliyoruz
        int min = arr[0];
        int max = arr[0];
        int toplam = 0;

        // Dizi üzerinde tek bir döngü ile gezinme
        for (int sayi : arr) {
            toplam += sayi;

            if (sayi < min) {
                min = sayi;
            }

            if (sayi > max) {
                max = sayi;
            }
        }

        // Ondalık kaybını önlemek için int toplamı double'a çeviriyoruz
        double ortalama = (double) toplam / arr.length;

        // Sonuçları raporlama
        System.out.println("İncelenen Dizi        : " + Arrays.toString(arr));
        System.out.println("Dizinin Eleman Sayısı : " + arr.length);
        System.out.println("En Küçük Sayı (Min)   : " + min);
        System.out.println("En Büyük Sayı (Max)   : " + max);
        System.out.println("Elemanların Toplamı   : " + toplam);
        System.out.printf("Aritmetik Ortalama    : %.2f\n", ortalama);
    }
}
