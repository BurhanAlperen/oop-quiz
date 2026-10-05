package exercises.easy;

import java.util.Scanner;

/**
 * ====================================================================
 * ALIŞTIRMA 1 [KOLAY] - Vücut Kitle İndeksi (VKİ / BMI) Hesaplayıcı
 * ====================================================================
 * Odaklanılan Konular:
 * - Scanner sınıfı ile kullanıcıdan veri alma
 * - Ondalıklı sayılarla (double) matematiksel formül hesaplama
 * - if - else if - else karar yapıları
 *
 * PROBLEM TANIMI:
 * Kullanıcıdan kilogram cinsinden ağırlığını (örn: 75.5) ve metre cinsinden
 * boyunu (örn: 1.78) alarak Vücut Kitle İndeksini (VKİ = kilo / (boy * boy))
 * hesaplayan ve aşağıdaki sınıflandırmaya göre durumunu ekrana yazdıran programı yazınız:
 *
 *  - VKİ < 18.5        : Zayıf
 *  - 18.5 <= VKİ < 25  : Normal Ağırlık
 *  - 25.0 <= VKİ < 30  : Fazla Kilolu
 *  - 30.0 ve üzeri     : Obez
 * ====================================================================
 */
public class Easy01_BMICalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== VÜCUT KİTLE İNDEKSİ (VKİ) HESAPLAMA ===");

        // Kullanıcıdan kilo bilgisini alma
        System.out.print("Kilonuzu giriniz (kg, örn: 72.5): ");
        double weight = scanner.nextDouble();

        // Kullanıcıdan boy bilgisini alma
        System.out.print("Boyunuzu giriniz (metre cinsinden, örn: 1.75): ");
        double height = scanner.nextDouble();

        // Çözüm fonksiyonunu çağırıp sonucu ekrana yazdırma
        hesaplaVeYazdir(weight, height);

        scanner.close();
    }

    /**
     * ÇÖZÜM METODU:
     * Kilo ve boy değerlerini alıp VKİ'yi ve durumunu hesaplar.
     */
    public static double hesaplaVeYazdir(double weight, double height) {
        if (height <= 0 || weight <= 0) {
            System.out.println("Hata: Boy veya kilo değeri 0 veya negatif olamaz!");
            return -1.0;
        }

        // VKİ Formülü: kilo / (boy * boy)
        double bmi = weight / (height * height);

        String kategori;
        if (bmi < 18.5) {
            kategori = "Zayıf";
        } else if (bmi < 25.0) {
            kategori = "Normal Ağırlık (İdeal)";
        } else if (bmi < 30.0) {
            kategori = "Fazla Kilolu";
        } else {
            kategori = "Obez";
        }

        System.out.println("\n----------------------------------");
        System.out.printf("Hesaplanan VKİ Değeriniz : %.2f\n", bmi);
        System.out.println("Sağlık Kategoriniz       : " + kategori);
        System.out.println("----------------------------------");

        return bmi;
    }
}
