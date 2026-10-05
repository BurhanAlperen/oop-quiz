package arrays;

import java.util.Arrays;

/**
 * ====================================================================
 * KONU: Java'da Diziler (Arrays) ve Çok Boyutlu Diziler (Matrices)
 * ====================================================================
 * Bu sınıf, Java'da sabit boyutlu dizilerin tanımlanmasını, bellekteki
 * yerleşimini, tek ve iki boyutlu dizilerde gezinmeyi ve Arrays yardımcı
 * sınıfının en önemli metotlarını öğretir.
 */
public class ArraysBasics {

    public static void main(String[] args) {

        // -------------------------------------------------------------
        // 1. TEK BOYUTLU DİZİ TANIMLAMA VE KULLANIMI
        // -------------------------------------------------------------
        System.out.println("=== 1. TEK BOYUTLU DİZİLER ===");

        // 1. Yöntem: Elemanları doğrudan süslü parantez ile atayarak
        String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
        System.out.println("İlk araba: " + cars[0]);
        System.out.println("Son araba: " + cars[cars.length - 1]);
        System.out.println("Dizinin uzunluğu: " + cars.length);

        // 2. Yöntem: Boyut belirterek tanımlama ve sonradan değer atama
        int[] scores = new int[5]; // 5 elemanlı int dizisi (varsayılan değerler 0'dır)
        scores[0] = 85;
        scores[1] = 92;
        scores[2] = 78;
        scores[3] = 64;
        scores[4] = 99;

        // Dizi elemanlarının toplamını ve ortalamasını hesaplama
        int sum = 0;
        int max = scores[0];
        int min = scores[0];

        for (int score : scores) {
            sum += score;
            if (score > max) {
                max = score;
            }
            if (score <= min) {
                min = score;
            }
        }
        double average = (double) sum / scores.length;

        System.out.println("Notlar: " + Arrays.toString(scores));
        System.out.println("Toplam: " + sum + " | Ortalama: " + average);
        System.out.println("En Yüksek Not: " + max + " | En Düşük Not: " + min);

        // -------------------------------------------------------------
        // 2. ÇOK BOYUTLU DİZİLER (2D Arrays / Matrisler)
        // -------------------------------------------------------------
        System.out.println("\n=== 2. ÇOK BOYUTLU DİZİLER (2D MATRİSLER) ===");

        // 3 satır, 3 sütunluk bir matris
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("Matris Elemanları:");
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + "\t");
            }
            System.out.println(); // Her satırdan sonra alt satıra geç
        }

        // -------------------------------------------------------------
        // 3. JAVA.UTIL.ARRAYS SINIFININ YARARLI METOTLARI
        // -------------------------------------------------------------
        System.out.println("\n=== 3. ARRAYS SINIFI YARDIMCI METOTLARI ===");

        int[] unorderedNumbers = {42, 12, 88, 5, 23, 16};
        System.out.println("Sıralanmadan önce : " + Arrays.toString(unorderedNumbers));

        // Diziyi küçükten büyüğe sıralama
        Arrays.sort(unorderedNumbers);
        System.out.println("Sıralandıktan sonra: " + Arrays.toString(unorderedNumbers));

        // İkili arama (Binary Search) - Dizi sıralı olmalıdır!
        int target = 23;
        int targetIndex = Arrays.binarySearch(unorderedNumbers, target);
        System.out.println(target + " elemanının indeksi: " + targetIndex);

        // Belirli bir değerle tüm diziyi doldurma (fill)
        int[] filledArray = new int[4];
        Arrays.fill(filledArray, 7);
        System.out.println("7 ile doldurulmuş dizi: " + Arrays.toString(filledArray));
    }
}
