package exercises.medium;

/**
 * ====================================================================
 * ALIŞTIRMA 5 [ORTA] - Öğrenci Not Yönetimi ve Metot Aşırı Yükleme (Overloading)
 * ====================================================================
 * Odaklanılan Konular:
 * - Metotlar, Dönüş Tipleri ve Parametre İletimi
 * - Metot Aşırı Yükleme (Method Overloading)
 * - İş Mantığı (Business Logic) & Karar Yapıları (Switch-Case / If-Else)
 *
 * PROBLEM TANIMI:
 * Üniversite not değerlendirme sistemi için:
 * 1. İki sınavlı dersler için: (Vize %40, Final %60) ortalaması hesaplayan,
 * 2. Üç sınavlı dersler için: (Vize %30, Proje %20, Final %50) ortalaması hesaplayan (Overloaded),
 * 3. Ortalamaya göre harf notu (AA, BA, BB, CB, CC, DC, DD, FF) ve geçme durumu üreten,
 * 4. Çoklu öğrenci ortalamasını hesaplayan
 * metotları yazınız.
 * ====================================================================
 */
public class Medium02_GradeManager {

    public static void main(String[] args) {
        System.out.println("\n=== ÖĞRENCİ NOT HESAPLAMA SİSTEMİ ===");

        // 1. İki sınavlı ders (Vize: 70, Final: 85)
        double ortalama1 = hesaplaOrtalama(70.0, 85.0);
        String harfNotu1 = harfNotuBelirle(ortalama1);
        System.out.printf("Ders 1 (Vize: 70, Final: 85) -> Ort: %.2f | Harf Notu: %s | Durum: %s\n",
                ortalama1, harfNotu1, (gectiMi(harfNotu1) ? "GEÇTİ" : "KALDI"));

        // 2. Üç sınavlı ders (Vize: 60, Proje: 90, Final: 45) - Overloaded metot
        double ortalama2 = hesaplaOrtalama(60.0, 90.0, 45.0);
        String harfNotu2 = harfNotuBelirle(ortalama2);
        System.out.printf("Ders 2 (Vize: 60, Proje: 90, Final: 45) -> Ort: %.2f | Harf Notu: %s | Durum: %s\n",
                ortalama2, harfNotu2, (gectiMi(harfNotu2) ? "GEÇTİ" : "KALDI"));

        // 3. Sınıf genel analizi (Dizi / Toplu Liste)
        double[] sinifOrtalamalari = {85.5, 42.0, 91.0, 58.5, 66.0, 35.0, 78.0};
        System.out.println("\n--- SINIF GENEL BAŞARI ANALİZİ ---");
        sinifRaporuYazdir(sinifOrtalamalari);
    }

    // --- OVERLOADED HESAPLAMA METOTLARI ---

    /**
     * İki bileşenli ortalama: Vize %40, Final %60
     */
    public static double hesaplaOrtalama(double vize, double fin) {
        return (vize * 0.40) + (fin * 0.60);
    }

    /**
     * Üç bileşenli ortalama (Overloading): Vize %30, Proje %20, Final %50
     */
    public static double hesaplaOrtalama(double vize, double proje, double fin) {
        return (vize * 0.30) + (proje * 0.20) + (fin * 0.50);
    }

    /**
     * Sayısal ortalamayı üniversite harf notuna çevirir.
     */
    public static String harfNotuBelirle(double ortalama) {
        if (ortalama >= 90) return "AA";
        if (ortalama >= 85) return "BA";
        if (ortalama >= 80) return "BB";
        if (ortalama >= 75) return "CB";
        if (ortalama >= 65) return "CC";
        if (ortalama >= 55) return "DC";
        if (ortalama >= 50) return "DD";
        return "FF";
    }

    /**
     * Öğrencinin harf notuna göre dersten geçip geçmediğini belirler.
     * FF ve DD başarısız kabul edilir (50 altı).
     */
    public static boolean gectiMi(String harfNotu) {
        return !harfNotu.equals("FF") && !harfNotu.equals("DD");
    }

    /**
     * Sınıftaki tüm öğrencilerin ortalamasını ve geçen/kalan istatistiğini yazdırır.
     */
    public static void sinifRaporuYazdir(double[] notlar) {
        int gecenSayisi = 0;
        int kalanSayisi = 0;
        double toplam = 0;

        for (double not : notlar) {
            toplam += not;
            String harf = harfNotuBelirle(not);
            if (gectiMi(harf)) {
                gecenSayisi++;
            } else {
                kalanSayisi++;
            }
        }

        double genelOrtalama = toplam / notlar.length;
        System.out.printf("Toplam Öğrenci: %d | Sınıf Ortalaması: %.2f\n", notlar.length, genelOrtalama);
        System.out.printf("Başarılı Öğrenci Sayısı: %d | Başarısız Öğrenci Sayısı: %d\n", gecenSayisi, kalanSayisi);
    }
}
