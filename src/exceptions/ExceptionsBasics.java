package exceptions;

/**
 * ====================================================================
 * KONU: Java'da İstisna Yönetimi (Exception Handling)
 * ====================================================================
 * Bu sınıf; çalışma zamanı hatalarının (runtime errors) programı aniden
 * çökertmesini önlemek için try-catch-finally, çoklu catch (multi-catch),
 * throw, throws ve custom exception yapılarını öğretir.
 */
public class ExceptionsBasics {

    public static void main(String[] args) {

        // -------------------------------------------------------------
        // 1. TEMEL TRY - CATCH - FINALLY (Aritmetik Hata)
        // -------------------------------------------------------------
        System.out.println("=== 1. TEMEL TRY - CATCH - FINALLY ===");
        try {
            int pay = 10;
            int payda = 0; // Sıfıra bölme hatası oluşturur
            int sonuc = pay / payda;
            System.out.println("Sonuç: " + sonuc);
        } catch (ArithmeticException e) {
            System.out.println("[YAKALANDI] Sıfıra bölme hatası: " + e.getMessage());
        } finally {
            // Hata olsun ya da olmasın MUTLAKA çalışır (örn: dosya/veritabanı kapatma)
            System.out.println("[FINALLY] Finally bloğu her zaman çalışır.");
        }

        // -------------------------------------------------------------
        // 2. ÇOKLU VE OR'LU CATCH (MULTI-CATCH)
        // -------------------------------------------------------------
        System.out.println("\n=== 2. ÇOKLU CATCH VE MULTI-CATCH ===");
        try {
            String[] sayilar = {"10", "20", "otuz"};
            // Dizi sınır aşımı hatası veya format hatası
            int index = 2;
            int sayi = Integer.parseInt(sayilar[index]); // "otuz" parse edilemez!
            System.out.println("Okunan sayı: " + sayi);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("[YAKALANDI] Dizi sınırları aşıldı: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("[YAKALANDI] Sayı formatı geçersiz: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("[YAKALANDI] Beklenmedik genel hata: " + e.getMessage());
        }

        // -------------------------------------------------------------
        // 3. THROW VE THROWS İLE ÖZEL HATA (CUSTOM EXCEPTION) FIRLATMA
        // -------------------------------------------------------------
        System.out.println("\n=== 3. ÖZEL İSTİSNA (CUSTOM EXCEPTION) YÖNETİMİ ===");
        try {
            System.out.println("20 yaş kontrolü:");
            yasKontrol(20);

            System.out.println("\n-5 yaş kontrolü:");
            yasKontrol(-5); // Burada hata fırlatılacak ve alttaki satır çalışmayacak
        } catch (InvalidAgeException e) {
            System.out.println("[YAKALANDI - ÖZEL HATA] " + e.getMessage());
        }
    }

    /**
     * 'throws InvalidAgeException': Bu metodun çağrıldığı yerde bu hatanın
     * yakalanması (try-catch) veya yukarı iletilmesi zorunludur.
     */
    public static void yasKontrol(int age) throws InvalidAgeException {
        if (age < 0) {
            throw new InvalidAgeException("Yaş 0'dan küçük olamaz! Girilen yaş: " + age);
        } else if (age < 18) {
            throw new InvalidAgeException("Giriş için en az 18 yaşında olmalısınız! Girilen yaş: " + age);
        } else {
            System.out.println("[ONAYLANDI] Yaş kriteri sağlandı, giriş başarılı. Yaş: " + age);
        }
    }
}
