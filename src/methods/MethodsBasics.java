package methods;

/**
 * ====================================================================
 * KONU: Java'da Metotlar (Methods), Overloading ve Erişim Belirteçleri
 * ====================================================================
 * Bu sınıf; metot tanımlama, parametre ve dönüş tipleri, static vs instance
 * metot farkı, metot aşırı yükleme (Method Overloading) ve Varargs
 * (değişken sayıda parametre) yapılarını öğretir.
 */
public class MethodsBasics {

    public static void main(String[] args) {
        System.out.println("=== 1. DEĞER DÖNDÜRMEYEN (VOID) VE STATIC METOT ===");
        selamla("Ahmet");
        selamla("Zeynep");

        System.out.println("\n=== 2. DEĞER DÖNDÜREN (RETURN TYPE) METOT ===");
        int sonuc = topla(15, 25);
        System.out.println("15 + 25 = " + sonuc);

        double kdvDahil = kdvHesapla(100.0, 0.20);
        System.out.println("100 TL'nin %20 KDV dahil fiyatı: " + kdvDahil + " TL");

        System.out.println("\n=== 3. METOT AŞIRI YÜKLEME (METHOD OVERLOADING) ===");
        // Aynı isimli metodun farklı parametreler alabilmesi
        System.out.println("İki tamsayı toplamı   : " + carp(3, 4));
        System.out.println("Üç tamsayı toplamı    : " + carp(3, 4, 2));
        System.out.println("İki ondalıklı toplamı : " + carp(2.5, 4.0));

        System.out.println("\n=== 4. DEĞİŞKEN SAYIDA PARAMETRE (VARARGS) ===");
        // İstediğimiz kadar sayı gönderebiliriz
        System.out.println("Sayıların toplamı (3 sayı) : " + cokluTopla(10, 20, 30));
        System.out.println("Sayıların toplamı (5 sayı) : " + cokluTopla(1, 2, 3, 4, 5));

        System.out.println("\n=== 5. NON-STATIC (NESNE METODU) KULLANIMI ===");
        // Static olmayan metotları çağırmak için sınıfın bir örneği (nesnesi) oluşturulmalıdır.
        MethodsBasics demo = new MethodsBasics();
        double maas = 45000.0;
        double netMaas = demo.vergiKesintisiUygula(maas);
        System.out.println("Brüt Maaş: " + maas + " TL -> Net Maaş: " + netMaas + " TL");
    }

    // -------------------------------------------------------------
    // METOT TANIMLARI
    // -------------------------------------------------------------

    /**
     * Ekrana selamlama mesajı yazdıran void (değer döndürmeyen) metot.
     */
    public static void selamla(String isim) {
        System.out.println("Merhaba, " + isim + "! Java öğrenmeye hoş geldin.");
    }

    /**
     * İki tam sayıyı toplayıp sonucunu int olarak döndüren metot.
     */
    public static int topla(int a, int b) {
        return a + b;
    }

    /**
     * Verilen fiyata vergi oranını ekleyen metot.
     */
    public static double kdvHesapla(double fiyat, double kdvOrani) {
        return fiyat + (fiyat * kdvOrani);
    }

    // --- METHOD OVERLOADING ÖRNEKLERİ ---

    public static int carp(int a, int b) {
        return a * b;
    }

    public static int carp(int a, int b, int c) {
        return a * b * c;
    }

    public static double carp(double a, double b) {
        return a * b;
    }

    // --- VARARGS ÖRNEĞİ ---
    /**
     * 'int... sayilar' sözdizimi, arka planda bir dizi (array) gibi çalışır.
     */
    public static int cokluTopla(int... sayilar) {
        int toplam = 0;
        for (int sayi : sayilar) {
            toplam += sayi;
        }
        return toplam;
    }

    // --- NON-STATIC (INSTANCE) METOT ÖRNEĞİ ---
    /**
     * Non-static metot; nesne üzerinden çağrılır.
     */
    public double vergiKesintisiUygula(double brutMaas) {
        double vergiOrani = 0.15; // %15 gelir vergisi
        return brutMaas - (brutMaas * vergiOrani);
    }
}
