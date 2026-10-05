package loops;

/**
 * ====================================================================
 * KONU: Döngüler İçerisinde If - Else Karar Yapıları (Loops + If-Else)
 * ====================================================================
 * Programlamada en sık kullanılan desenlerden biri, bir veri kümesi veya
 * sayaç üzerinde döngüyle ilerlerken HER BİR ELEMAN İÇİN bir karar
 * (şart/koşul) mekanizması işletmektir.
 *
 * Bu sınıfta günlük hayattan 5 farklı ve anlaşılır senaryo işlenmiştir:
 * 1. Tek ve Çift Sayıları Ayrıştırma & Sayaç Mantığı
 * 2. Pozitif / Negatif Sayı Filtreleme ve Ayrı Toplama
 * 3. Öğrenci Başarı Durumu Sınıflandırma (if - else if - else)
 * 4. Kalan Hak / Güvenlik Kontrolü Simülasyonu (while + if-else + break)
 * 5. Alışveriş Sepetinde Kademeli İndirim Hesaplama
 * ====================================================================
 */
public class LoopsWithIfElse {

    public static void main(String[] args) {

        // -------------------------------------------------------------
        // ÖRNEK 1: TEK VE ÇİFT SAYILARI BULMA VE SAYMA
        // -------------------------------------------------------------
        System.out.println("=== 1. TEK VE ÇİFT SAYI AYRIŞTIRMA (FOR + IF-ELSE) ===");
        int tekSayac = 0;
        int ciftSayac = 0;

        System.out.println("1 ile 10 arasındaki sayıların analizi:");
        for (int i = 1; i <= 10; i++) {
            // Şart: Sayının 2'ye bölümünden kalan 0 ise çifttir, değilse tektir.
            if (i % 2 == 0) {
                System.out.println(" -> Sayı: " + i + " [ÇİFT]");
                ciftSayac++; // Çift sayacını 1 artırıyoruz
            } else {
                System.out.println(" -> Sayı: " + i + " [TEK]");
                tekSayac++; // Tek sayacını 1 artırıyoruz
            }
        }
        System.out.println("Toplam Çift Sayı: " + ciftSayac + " | Toplam Tek Sayı: " + tekSayac);

        // -------------------------------------------------------------
        // ÖRNEK 2: POZİTİF VE NEGATİF SAYILARI AYRI AYRI TOPLAMA
        // -------------------------------------------------------------
        System.out.println("\n=== 2. POZİTİF / NEGATİF SAYI TOPLAMA (FOR-EACH + IF-ELSE IF) ===");
        int[] sayilar = {12, -7, 0, 25, -14, 8, -3, 0, 19};

        int pozitifToplam = 0;
        int negatifToplam = 0;
        int sifirSayisi = 0;

        for (int sayi : sayilar) {
            if (sayi > 0) {
                pozitifToplam += sayi;
            } else if (sayi < 0) {
                negatifToplam += sayi;
            } else {
                sifirSayisi++;
            }
        }

        System.out.println("İncelenen dizi eleman sayısı: " + sayilar.length);
        System.out.println("Pozitif sayıların toplamı   : " + pozitifToplam);
        System.out.println("Negatif sayıların toplamı   : " + negatifToplam);
        System.out.println("Sıfır olan eleman sayısı    : " + sifirSayisi);

        // -------------------------------------------------------------
        // ÖRNEK 3: ÖĞRENCİ NOTLARI VE DERECELENDİRME (KADEMELİ IF-ELSE)
        // -------------------------------------------------------------
        System.out.println("\n=== 3. ÖĞRENCİ NOT ANALİZİ (KADEMELİ IF - ELSE IF - ELSE) ===");
        int[] notlar = {95, 42, 78, 88, 55, 30, 68, 100};

        int basariliOgrenci = 0;
        int kaldiOgrenci = 0;

        for (int index = 0; index < notlar.length; index++) {
            int ogrenciNotu = notlar[index];
            String sonuc;

            // Kademeli kontrol: En yüksek şarttan en düşüğe doğru sıralanmalıdır.
            if (ogrenciNotu >= 85) {
                sonuc = "ÜSTÜN BAŞARI (Onur Listesi)";
                basariliOgrenci++;
            } else if (ogrenciNotu >= 60) {
                sonuc = "BAŞARILI (Doğrudan Geçti)";
                basariliOgrenci++;
            } else if (ogrenciNotu >= 50) {
                sonuc = "ŞARTLI GEÇTİ (Sınırda)";
                basariliOgrenci++;
            } else {
                sonuc = "KALDI (Bütünlemeye Kaldı)";
                kaldiOgrenci++;
            }

            System.out.printf("Öğrenci #%d -> Not: %-3d => Durum: %s\n", (index + 1), ogrenciNotu, sonuc);
        }
        System.out.printf("Toplam Başarılı: %d | Toplam Kalan: %d\n", basariliOgrenci, kaldiOgrenci);

        // -------------------------------------------------------------
        // ÖRNEK 4: ŞİFRE DENEMESİ VE KALAN HAK KONTROLÜ (WHILE + IF-ELSE)
        // -------------------------------------------------------------
        System.out.println("\n=== 4. GÜVENLİK VE KALAN HAK KONTROLÜ (WHILE + IF-ELSE + BREAK) ===");
        int kalanHak = 3;
        String dogruSifre = "Java123";
        // Kullanıcının simüle edilen denemeleri
        String[] denenenSifreler = {"1111", "admin", "Java123"};

        int adim = 0;
        while (kalanHak > 0 && adim < denenenSifreler.length) {
            String girilen = denenenSifreler[adim];
            System.out.println("Kullanıcı şifre giriyor: '" + girilen + "'");

            if (girilen.equals(dogruSifre)) {
                System.out.println(">> [GİRİŞ BAŞARILI] Hoş geldiniz! Döngü sonlandırılıyor (break).");
                break; // Şifre doğruysa kalan hakları kontrol etmeye gerek yok, çıkıyoruz.
            } else {
                kalanHak--;
                if (kalanHak > 0) {
                    System.out.println(">> [HATALI ŞİFRE] Kalan deneme hakkınız: " + kalanHak);
                } else {
                    System.out.println(">> [HESAP KİLİTLENDİ] 3 kez hatalı şifre girdiniz!");
                }
            }
            adim++;
        }

        // -------------------------------------------------------------
        // ÖRNEK 5: ALIŞVERİŞ SEPETİNDE KADEMELİ İNDİRİM VE KARGO KONTROLÜ
        // -------------------------------------------------------------
        System.out.println("\n=== 5. SEPETTE ÜRÜN İNDİRİM VE KARGO HESAPLAMA ===");
        double[] urunFiyatlari = {450.0, 120.0, 850.0, 45.0, 250.0};
        double sepetGenelToplam = 0;

        for (int i = 0; i < urunFiyatlari.length; i++) {
            double hamFiyat = urunFiyatlari[i];
            double indirimliFiyat;

            // Kural:
            // 500 TL ve üstü ise %20 indirim
            // 200 - 500 TL arası ise %10 indirim
            // 200 TL altı ise indirim yok
            if (hamFiyat >= 500.0) {
                indirimliFiyat = hamFiyat - (hamFiyat * 0.20);
                System.out.printf("Ürün #%d: %.2f TL -> %%20 İndirim uygulandı => %.2f TL\n",
                        (i + 1), hamFiyat, indirimliFiyat);
            } else if (hamFiyat >= 200.0) {
                indirimliFiyat = hamFiyat - (hamFiyat * 0.10);
                System.out.printf("Ürün #%d: %.2f TL -> %%10 İndirim uygulandı => %.2f TL\n",
                        (i + 1), hamFiyat, indirimliFiyat);
            } else {
                indirimliFiyat = hamFiyat;
                System.out.printf("Ürün #%d: %.2f TL -> İndirim uygulanmadı   => %.2f TL\n",
                        (i + 1), hamFiyat, indirimliFiyat);
            }

            sepetGenelToplam += indirimliFiyat;
        }

        System.out.printf("\nİndirimler Sonrası Sepet Toplamı: %.2f TL\n", sepetGenelToplam);

        // Sepet toplamına göre ücretsiz kargo şartı
        double kargoUcreti = 40.0;
        if (sepetGenelToplam >= 1000.0) {
            System.out.println("[KAMPANYA] 1000 TL üzeri siparişlerde KARGO BEDAVA!");
        } else {
            sepetGenelToplam += kargoUcreti;
            System.out.printf("[BİLGİ] Kargo ücreti (%.2f TL) eklendi. Ödenecek Nihai Tutar: %.2f TL\n",
                    kargoUcreti, sepetGenelToplam);
        }
    }
}
